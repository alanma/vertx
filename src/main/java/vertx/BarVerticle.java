package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;

public class BarVerticle extends AbstractVerticle {

	@Override
	public void start() throws Exception {
		Router router = Router.router(vertx);

		router
			.route(HttpMethod.GET, "/bar/hello")
			.handler(new BarHandler());
	}
}