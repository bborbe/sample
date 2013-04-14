package example;

import org.xbill.DNS.ARecord;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TXTRecord;
import org.xbill.DNS.Type;

import java.util.Iterator;

public class DnsSample {

	public static void main(String[] args) {
		try {
			Lookup lookup = new Lookup("www.benjamin-borbe.de", Type.ANY);
			lookup.setResolver(new SimpleResolver("ns.rocketnews.de"));
			lookup.run();
			if (lookup.getResult() == Lookup.SUCCESSFUL) {
				Record[] records = lookup.run();
				for (Record record : records) {
					if (record instanceof TXTRecord) {
						TXTRecord txt = (TXTRecord) record;

						for (Iterator j = txt.getStrings().iterator(); j.hasNext(); ) {
							System.out.println((String) j.next());
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
