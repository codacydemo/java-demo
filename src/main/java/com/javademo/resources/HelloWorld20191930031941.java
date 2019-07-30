package com.javademo.resources;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

import java.sql.ResultSet;
import java.sql.Statement;

@Path("/hello-world-20191930031941")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld20191930031941 {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorld20191930031941(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public void sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
    }

    @GET
    public void TestSQLInjection(@QueryParam("userid") Optional<Integer> userId, @QueryParam("password") Optional<String> password){
        String query = "SELECT * FROM users WHERE userid ='"+ userId.or(0) + "'" + " AND password='" + password.or("YAY") + "'";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
    }
}