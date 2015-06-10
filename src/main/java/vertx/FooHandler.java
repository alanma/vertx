package vertx;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;
import jodd.util.ThreadUtil;

public class FooHandler implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext event) {
		HttpServerRequest request = event.request();

		ThreadUtil.sleep(6000);

		request.response().setStatusCode(200).end("Hello VertX!\n");
	}
}