package vertx;

import io.vertx.core.Handler;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.RoutingContext;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

public class FooHandler implements Handler<RoutingContext> {
	@Override
	public void handle(RoutingContext routingContext) {
		HttpServerRequest request = routingContext.request();

		HttpRequest httpRequest = HttpRequest.get("http://localhost:8080/bar");

		HttpResponse httpResponse = httpRequest.send();

		request.response().setStatusCode(200).end("FOO\n" + httpResponse.body());
	}
}