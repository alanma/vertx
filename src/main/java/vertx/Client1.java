package vertx;

import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class Client1 {

	public static void main(String[] args) {
		HttpRequest httpRequest = HttpRequest.get("http://localhost:8080/foo");

		HttpResponse httpResponse = httpRequest.send();

		System.out.println(httpResponse);
	}
}