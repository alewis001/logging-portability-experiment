package com.seekingbinary.logging;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.common.flogger.FluentLogger;

@Path("ping")
public class PingLogger {
  
  private static final FluentLogger LOG = FluentLogger.forEnclosingClass();
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    LOG.atConfig().log("Configuration message");
    LOG.atFine().log("A fine message");
    LOG.atFiner().log("A finer message");
    LOG.atFinest().log("The finest message"); 
    LOG.atInfo().log("An informational message"); // Appears to be missing on OL
    LOG.atSevere().log("A severe message");
    LOG.atWarning().log("A warning");
    LOG.atFine().log("A fine message with a paramer: %s", 42);
    return "pong";
  }
}
