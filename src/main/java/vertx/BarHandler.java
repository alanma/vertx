package vertx;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;

public class BarHandler implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext routingContext) {
		System.out.println("BarHandler.handle");

		HttpServerRequest request = routingContext.request();

		request.response().setStatusCode(200).end("BAR!\n");
	}
}