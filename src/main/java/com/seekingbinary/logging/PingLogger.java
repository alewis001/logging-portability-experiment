package com.seekingbinary.logging;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("ping")
public class PingLogger {
  
  private static final Logger LOG = LogManager.getLogger();
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    LOG.debug("pong: Debug");
    LOG.error("pong: Error");
    LOG.fatal("pong: Fatal");
    LOG.info("pong: Info");
    LOG.trace("pong: Trace");
    LOG.warn("pong: Warn");
    return "pong";
  }
}
