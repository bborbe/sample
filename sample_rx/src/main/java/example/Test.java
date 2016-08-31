package example;

import rx.Observable;
import rx.Observer;

public class Test {

	public static void main(String[] args) {
		getUsernames().subscribe(new Observer<String>() {

			@Override
			public void onNext(final String s) {
				System.out.println("get: " + s);
			}

			@Override
			public void onCompleted() {
				System.out.println("completed");
			}

			@Override
			public void onError(final Throwable e) {
				System.err.println("error: " + e);
			}

		});
	}

	private static Observable<String> getUsernames() {
		return Observable.create(subscriber -> {
			subscriber.onNext("asf");
			subscriber.onCompleted();
		});
	}
}
