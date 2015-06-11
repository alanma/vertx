package vertx;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;

public class Foo2Handler implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext routingContext) {
		System.out.println("Foo2Handler.handle");

		HttpServerRequest request = routingContext.request();

		routingContext.vertx().createHttpClient().get(8080, "127.0.0.1", "/bar",
			response -> {
				System.out.println("Foo2Handler.response");

				response.bodyHandler(
					body -> {
						System.out.println("Foo2Handler.response.body");

						request.response().setStatusCode(200).end("FOO\n" + body.toString());
					});
			}
		).end();
	}
}