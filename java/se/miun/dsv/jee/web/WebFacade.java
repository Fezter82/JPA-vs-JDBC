package se.miun.dsv.jee.web;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@ApplicationScoped
@Path("/")
public class WebFacade {

	
}