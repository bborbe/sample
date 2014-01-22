package example;

import org.xbill.DNS.ARecord;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TXTRecord;
import org.xbill.DNS.Type;

public class DnsSample {

	public static void main(final String[] args) {
		try {
			final Lookup lookup = new Lookup("www.benjamin-borbe.de", Type.ANY);
			lookup.setResolver(new SimpleResolver("ns.rocketnews.de"));
			lookup.run();
			if (lookup.getResult() == Lookup.SUCCESSFUL) {
				final Record[] records = lookup.run();
				for (final Record record : records) {
					if (record instanceof TXTRecord) {
						final TXTRecord txt = (TXTRecord) record;

						for (final Object o : txt.getStrings()) {
							System.out.println((String) o);
						}
					} else if (record instanceof ARecord) {
						System.out.println(((ARecord) record).getAddress().getHostAddress());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
