package example;

import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Message.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Say {

	private static final Logger logger = LoggerFactory.getLogger("sample");

	private final String serverHost = "jabber.rp.seibert-media.net";

	private final String username = "bborbe";

	private final String passwort = "xxx";

	public void run() throws XMPPException, InterruptedException {
		final ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration(serverHost);
		connectionConfiguration.setCompressionEnabled(false);
		connectionConfiguration.setSASLAuthenticationEnabled(true);

		final XMPPConnection connection = new XMPPConnection(connectionConfiguration);
		connection.connect();
		System.err.println("isConnected: " + connection.isConnected());
		connection.login(username, passwort);
		System.err.println("isAuthenticated: " + connection.isAuthenticated());
		final ChatManager chatManager = connection.getChatManager();
		// AccountManager accountManager = connection.getAccountManager();
		final MessageListener messageListener = new MyMessageListener();
		chatManager.addChatListener(new MyChatManagerListener());

		final Chat chat = chatManager.createChat("bborbe@jabber.rp.seibert-media.net", messageListener);
		chat.sendMessage("hello ben!");

		final Roster roster = connection.getRoster();
		final Collection<RosterEntry> entries = roster.getEntries();
		for (final RosterEntry entry : entries) {
			System.out.println(String.format("Buddy:%1$s - Status:%2$s", entry.getName(), entry.getStatus()));
		}

		// wait 60 sec
		Thread.sleep(60 * 1000);
		connection.disconnect();
	}

	private final class MyChatManagerListener implements ChatManagerListener {

		@Override
		public void chatCreated(final Chat chat, final boolean createdLocally) {
			System.out.println("chat: " + chat.getParticipant() + " local: " + createdLocally);
		}
	}

	private final class MyMessageListener implements MessageListener {

		@Override
		public void processMessage(final Chat chat, final Message message) {
			// System.err.println("getBody: " + message.getBody());
			// System.err.println("getFrom: " + message.getFrom());
			// System.err.println("getLanguage: " + message.getLanguage());
			// System.err.println("getPacketID: " + message.getPacketID());
			// System.err.println("getSubject: " + message.getSubject());
			// System.err.println("getThread: " + message.getThread());
			// System.err.println("getTo: " + message.getTo());
			// System.err.println("getType: " + message.getType());
			final String from = message.getFrom();
			final String body = message.getBody();
			if (Type.chat.equals(message.getType()))
				System.out.println(String.format("Received message '%1$s' from %2$s", body, from));
		}

	}
}
