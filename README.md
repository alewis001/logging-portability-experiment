# Introduction
A simple REST application that responds to GET requests to
the path /logging-test/ping with the text "pong". 

This simple application does not include any logging. The
application will be modified on different branches to include
different logging libraries then deployed to the different
application servers below.

This is in order to test how portable the application is when
the expectation is that the logging format is consistent with
the output from the application server and whether the logging
configuration of both the server and the application is
centralised.

# Application Servers
## OpenLiberty
```
> docker build -t <tag> -f docker/openliberty/Dockerfile .
> docker run -p 8080:8080 -t <tag>
```

## Wildfly
```
> docker build -t <tag> -f docker/wildfly/Dockerfile .
> docker run -p 8080:8080 -t <tag>
```

## Payara
```
> docker build -t <tag> -f docker/payara/Dockerfile .
> docker run -p 8080:8080 -t <tag>
```

# Test
Run the following in a terminal:
```
> curl http://localhost:8080/logging-test/ping
> pong
```
