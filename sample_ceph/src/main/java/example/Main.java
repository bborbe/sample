package example;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.util.StringUtils;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("required args: [host] [accesskey] [secretkey]");
			System.exit(1);
		}

		final String endpoint = args[0];
		final String accessKey = args[1];
		final String secretKey = args[2];

		AmazonS3 conn = getConnection(endpoint, secretKey, accessKey);
		printBuckets(conn);
	}

	private static void printBuckets(final AmazonS3 conn) {
		List<Bucket> buckets = conn.listBuckets();
		for (Bucket bucket : buckets) {
			System.out.println(bucket.getName() + "\t" +
				StringUtils.fromDate(bucket.getCreationDate()));
		}
	}

	private static AmazonS3 getConnection(final String endpoint, final String secretKey, final String accessKey) {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);

		AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
		conn.setEndpoint(endpoint);
		return conn;
	}
}
