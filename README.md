# Reproduce

## Server

This is gradle project, so all you have to do is:

	> gradlew clean run
	
Then run the following URL in browser:

	http://localhost:8080/foo

## Scenario 1

	/foo = handler()
	/bar = handler()

Error:

	Connected to the target VM, address: '127.0.0.1:55694', transport: 'socket'
	Server is up
	Jun 11, 2015 12:52:55 AM io.vertx.core.impl.BlockedThreadChecker
	WARNING: Thread Thread[vert.x-eventloop-thread-4,5,main] has been blocked for 2995 ms, time limit is 2000
	Jun 11, 2015 12:52:56 AM io.vertx.core.impl.BlockedThreadChecker
	WARNING: Thread Thread[vert.x-eventloop-thread-4,5,main] has been blocked for 4000 ms, time limit is 2000
	Jun 11, 2015 12:52:57 AM io.vertx.core.impl.BlockedThreadChecker
	WARNING: Thread Thread[vert.x-eventloop-thread-4,5,main] has been blocked for 5004 ms, time limit is 2000
	io.vertx.core.VertxException: Thread blocked

## Scenario 2

	/foo = blockingHandler()
	/bar = handler()

No error.

## Scenario 3

	/foo = blockingHandler()
	/bar = blockingHandler()

Error:

	java.lang.IllegalStateException: Response has already been written
	Jun 11, 2015 12:57:58 AM io.vertx.core.impl.ContextImpl
	SEVERE: Unhandled exception
	java.lang.IllegalStateException: Response has already been written
		at io.vertx.core.http.impl.HttpServerResponseImpl.checkWritten(HttpServerResponseImpl.java:522)
		at io.vertx.core.http.impl.HttpServerResponseImpl.end0(HttpServerResponseImpl.java:367)
		at io.vertx.core.http.impl.HttpServerResponseImpl.end(HttpServerResponseImpl.java:299)
		at io.vertx.core.http.impl.HttpServerResponseImpl.end(HttpServerResponseImpl.java:284)
		at io.vertx.ext.web.impl.RoutingContextImplBase.unhandledFailure(RoutingContextImplBase.java:92)
		at io.vertx.ext.web.impl.RoutingContextImpl.checkHandleNoMatch(RoutingContextImpl.java:105)

