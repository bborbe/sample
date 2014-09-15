package example;

import java.io.File;
import java.io.FileInputStream;

public class Main {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Main.class);

	public static void main(final String[] args) {
		try {
			final ImagePHash imagePHash = new ImagePHash();
			final String hash1 = getHash(imagePHash, "/Users/bborbe/Downloads/test/1.jpg");
			System.out.println("hash1: " + hash1);
			final String hash2 = getHash(imagePHash, "/Users/bborbe/Downloads/test/2.jpg");
			System.out.println("hash2: " + hash2);
			System.out.println("distance: " + imagePHash.distance(hash1, hash2));
		} catch (Exception e) {
			logger.error(e.getClass().getName(), e);
		}
	}

	private static String getHash(final ImagePHash imagePHash, final String filename) throws Exception {
		final File file = new File(filename);
		final FileInputStream fileInputStream = new FileInputStream(file);
		return imagePHash.getHash(fileInputStream);
	}
}
