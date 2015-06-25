package vertx;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import java.util.concurrent.CompletableFuture;

public class Foo3Handler implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext routingContext) {
		System.out.println("Foo3Handler.handle on "
			+ Thread.currentThread().getId() + " [" + Thread.currentThread().getName() + "]");

		CompletableFuture.runAsync(() -> {
			HttpServerRequest request = routingContext.request();

			HttpRequest httpRequest = HttpRequest.get("http://localhost:8080/bar");

			HttpResponse httpResponse = httpRequest.send();

			request.response().setStatusCode(200).end("FOO3\n" + httpResponse.body());
		});
	}
}