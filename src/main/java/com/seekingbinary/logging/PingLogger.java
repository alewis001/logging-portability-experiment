package com.seekingbinary.logging;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("ping")
public class PingLogger {
  
  private final Logger LOG = LoggerFactory.getLogger(this.getClass());
  
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    LOG.debug("pong: Debug");
    LOG.warn("pong: Warn");
    LOG.error("pong: Error");
    LOG.trace("pong: Trace");
    LOG.info("pong: Info");
    return "pong";
  }
}
