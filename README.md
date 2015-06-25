# Reproducer

## Server

This is gradle project, so all you have to do is:

	> gradlew clean run
	
## Steps
 
Just quickly repeat the request call to:

	http://localhost:8080/bar/hello

The console:

	BarHandler.handle vertx.BarHandler@4bf52917 on 29 [vert.x-eventloop-thread-14]
	BarHandler.handle vertx.BarHandler@4bf52917 on 17 [vert.x-eventloop-thread-2]

This means:

+ only one instance of handler is used.
