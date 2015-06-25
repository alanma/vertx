package vertx;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;
import jodd.util.ThreadUtil;

public class BarHandler implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext routingContext) {
		System.out.println("BarHandler.handle " + this + " on "
			+ Thread.currentThread().getId() +" [" + Thread.currentThread().getName() + "]");

		ThreadUtil.sleep(300);

		HttpServerRequest request = routingContext.request();

		request.response().setStatusCode(200).end("BAR!\n");
	}
}