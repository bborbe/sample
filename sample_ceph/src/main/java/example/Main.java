package example;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.util.StringUtils;

import java.util.List;

public class Main {

	public static void main(final String[] args) {
		if (args.length != 3) {
			System.err.println("required args: [host] [accesskey] [secretkey]");
			System.exit(1);
		}

		final String endpoint = args[0];
		final String accessKey = args[1];
		final String secretKey = args[2];

		final AmazonS3 conn = getConnection(endpoint, secretKey, accessKey);
		printBuckets(conn);
	}

	private static void printBuckets(final AmazonS3 conn) {
		final List<Bucket> buckets = conn.listBuckets();
		for (final Bucket bucket : buckets) {
			System.out.println(bucket.getName() + "\t" +
				StringUtils.fromDate(bucket.getCreationDate()));
		}
	}

	private static AmazonS3 getConnection(final String endpoint, final String secretKey, final String accessKey) {
		final AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		final ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);

		final S3ClientOptions s3ClientOptions = new S3ClientOptions();
		s3ClientOptions.setPathStyleAccess(true);

		final AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
		conn.setEndpoint(endpoint);
		conn.setS3ClientOptions(s3ClientOptions);

		return conn;
	}
}
