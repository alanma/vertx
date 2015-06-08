package vertx;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;

public class AdminHandler implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext event) {
		HttpServerRequest request = event.request();
		request.response().setStatusCode(200).end("Hello!");
	}
}