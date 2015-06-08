package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class ServerVerticle extends AbstractVerticle {

	@Override
	public void start() {
		HttpServerOptions httpServerOptions = new HttpServerOptions();

		httpServerOptions.setCompressionSupported(true);

		server = vertx.createHttpServer(httpServerOptions);

		setupRouter();

		server.requestHandler(this::onHttpServerRequest);

		server.listen(8080, event -> {
			if (!event.succeeded()) {
				System.out.println("Error starting server " + event.cause());
			}
		});
	}

	protected Handler<RoutingContext> failureRoutingContext() {
		return failureRoutingContext -> {
			int statusCode = failureRoutingContext.statusCode();

			if (statusCode == -1) {
				statusCode = 500;
			}

			String message = "Error: " + statusCode;

			Throwable throwable = failureRoutingContext.failure();

			if (throwable != null) {
				String addOnMessage = throwable.getMessage();

				if (message.isEmpty()) {
					addOnMessage = throwable.toString();
				}

				message += ": " + addOnMessage;
			}

			HttpServerResponse response = failureRoutingContext.response();

			response.setStatusCode(statusCode).end(message);
		};
	}

	protected void onHttpServerRequest(HttpServerRequest request) {
		router.accept(request);
	}

	/**
	 * Setup routers, based on configuration.
	 */
	protected Router setupRouter() {
		router = Router.router(vertx);

		router
			.route(HttpMethod.GET, "/admin")
			.blockingHandler(new AdminHandler())
			.failureHandler(failureRoutingContext());

		return router;
	}

	protected Router router;
	protected HttpServer server;

}