This is gradle project, so all you have to do is:

	> gradlew clean run

On Ubuntu:

Create archive:

	> gradlew assemble

Upload tar to amazon, extract and simply run:

	> bin/vertx
	
Errors.

```                                            
curl -g -v http://127.0.0.1:8080/admin
* Hostname was NOT found in DNS cache
*   Trying 127.0.0.1...
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /admin HTTP/1.1
> User-Agent: curl/7.35.0
> Host: 127.0.0.1:8080
> Accept: */*
>
< HTTP/1.1 200 OK
< Content-Length: 6
<
* Connection #0 to host 127.0.0.1 left intact

curl -g -v http://127.0.0.1:8080/admin
* Hostname was NOT found in DNS cache
*   Trying 127.0.0.1...
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /admin HTTP/1.1
> User-Agent: curl/7.35.0
> Host: 127.0.0.1:8080
> Accept: */*
>
< HTTP/1.1 200 OK
< Content-Length: 6
<
* Connection #0 to host 127.0.0.1 left intact
Jun 08, 2015 5:46:25 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 2440 ms, time limit is 2000
Jun 08, 2015 5:46:26 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 3440 ms, time limit is 2000
Jun 08, 2015 5:46:27 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 4440 ms, time limit is 2000
Jun 08, 2015 5:46:28 PM io.vertx.core.impl.BlockedThreadChecker
WARNING: Thread Thread[vert.x-eventloop-thread-0,5,main] has been blocked for 5440 ms, time limit is 2000
io.vertx.core.VertxException: Thread blocked
	at io.vertx.core.http.impl.HttpServerResponseImpl.handleClosed(HttpServerResponseImpl.java:459)
	at io.vertx.core.http.impl.ServerConnection.handleClosed(ServerConnection.java:336)
	at io.vertx.core.net.impl.VertxHandler$$Lambda$24/574370275.run(Unknown Source)
	at io.vertx.core.impl.ContextImpl.lambda$wrapTask$3(ContextImpl.java:310)
	at io.vertx.core.impl.ContextImpl$$Lambda$4/2012232625.run(Unknown Source)
	at io.vertx.core.impl.ContextImpl.executeFromIO(ContextImpl.java:204)
	at io.vertx.core.net.impl.VertxHandler.channelInactive(VertxHandler.java:106)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:208)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:194)
	at io.netty.handler.stream.ChunkedWriteHandler.channelInactive(ChunkedWriteHandler.java:148)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:208)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:194)
	at io.netty.channel.ChannelInboundHandlerAdapter.channelInactive(ChannelInboundHandlerAdapter.java:75)
	at io.netty.handler.codec.http.HttpContentEncoder.channelInactive(HttpContentEncoder.java:252)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:208)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:194)
	at io.netty.handler.codec.ByteToMessageDecoder.channelInactive(ByteToMessageDecoder.java:306)
	at io.netty.channel.AbstractChannelHandlerContext.invokeChannelInactive(AbstractChannelHandlerContext.java:208)
	at io.netty.channel.AbstractChannelHandlerContext.fireChannelInactive(AbstractChannelHandlerContext.java:194)
	at io.netty.channel.DefaultChannelPipeline.fireChannelInactive(DefaultChannelPipeline.java:828)
	at io.netty.channel.AbstractChannel$AbstractUnsafe$7.run(AbstractChannel.java:621)
	at io.netty.util.concurrent.SingleThreadEventExecutor.runAllTasks(SingleThreadEventExecutor.java:357)
	at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:357)
	at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:111)
	at java.lang.Thread.run(Thread.java:745)
```