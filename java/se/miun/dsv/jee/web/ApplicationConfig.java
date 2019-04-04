package se.miun.dsv.jee.web;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/*")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return Stream.of(WebFacade.class).collect(Collectors.toSet());
	}
}
