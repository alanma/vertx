# Reproduce

## Server

This is gradle project, so all you have to do is:

	> gradlew clean run

## Client

While server is up, open another terminal and:

	> gradlew client1
 
The following exception should appear:

```
SEVERE: Unhandled exception
java.lang.IllegalStateException: Response has already been written
	at io.vertx.core.http.impl.HttpServerResponseImpl.checkWritten(HttpServerResponseImpl.java:522)
	at io.vertx.core.http.impl.HttpServerResponseImpl.end0(HttpServerResponseImpl.java:367)
	at io.vertx.core.http.impl.HttpServerResponseImpl.end(HttpServerResponseImpl.java:299)
	at io.vertx.core.http.impl.HttpServerResponseImpl.end(HttpServerResponseImpl.java:284)
	at io.vertx.ext.web.impl.RoutingContextImplBase.unhandledFailure(RoutingContextImplBase.java:92)
	at io.vertx.ext.web.impl.RoutingContextImpl.checkHandleNoMatch(RoutingContextImpl.java:105)
	at io.vertx.ext.web.impl.RoutingContextImpl.next(RoutingContextImpl.java:97)
	at io.vertx.ext.web.impl.RoutingContextImpl.doFail(RoutingContextImpl.java:323)
	at io.vertx.ext.web.impl.RoutingContextImpl.fail(RoutingContextImpl.java:122)
	at io.vertx.ext.web.impl.BlockingHandlerDecorator.lambda$handle$72(BlockingHandlerDecorator.java:36)
	at io.vertx.ext.web.impl.BlockingHandlerDecorator$$Lambda$25/2022530402.handle(Unknown Source)
	at io.vertx.core.impl.FutureImpl.checkCallHandler(FutureImpl.java:135)
	at io.vertx.core.impl.FutureImpl.setHandler(FutureImpl.java:100)
	at io.vertx.core.impl.ContextImpl.lambda$null$1(ContextImpl.java:275)
	at io.vertx.core.impl.ContextImpl$$Lambda$33/1609649202.handle(Unknown Source)
	at io.vertx.core.impl.ContextImpl.lambda$wrapTask$3(ContextImpl.java:312)
	at io.vertx.core.impl.ContextImpl$$Lambda$4/205125520.run(Unknown Source)
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:357)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:357)
	at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:111)
	at java.lang.Thread.run(Thread.java:745)
```
