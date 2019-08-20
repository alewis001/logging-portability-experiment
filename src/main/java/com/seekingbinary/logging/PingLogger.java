package com.seekingbinary.logging;

import io.opentracing.Scope;
import io.opentracing.Tracer;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.logging.MicroProfileLogger;

import static org.eclipse.microprofile.logging.MicroProfileLevel.SPAN;

@Path("ping")
public class PingLogger {
  
  MicroProfileLogger LOG = MicroProfileLogger.forEnclosingClass();

  @Inject
  Tracer tracer;
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String ping(@QueryParam("input") String input) {
    LOG.atConfig().log("Configuration message");
    LOG.atFine().log("A fine message");
    LOG.atFiner().log("A finer message");
    LOG.atFinest().log("The finest message");
    LOG.atInfo().log("An informational message"); // Appears to be missing on OL
    LOG.atSevere().log("A severe message");
    LOG.atWarning().log("A warning");
    LOG.atFine().log("A fine message with a paramer: %s", 42);
    
    LOG.atSpan().log("An opentracing log message");
    return getResponse(input);
  }
  
  String getResponse(String input) {
    LOG.atFine().log("getResponse: ENTRY [%s]", input);
    final String response = getResponseStringInChildSpan(input);
    LOG.atSpan().log("getResponse: EXIT [%s]", response);
    return response;
  }
  
  private String getResponseStringInChildSpan(String input) {
    if (tracer != null) {
      try (Scope childScope = tracer.buildSpan("alewis-child").startActive(true)) {
        String response = input + "-pong"; 
        LOG.at(SPAN).log("getResponseStringInChildSpan [%s]", response);
        return response;
      }
    } else {
      LOG.atWarning().log("Tracer not available");
      return "notracer";
    }
  }
}
