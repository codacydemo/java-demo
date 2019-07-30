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
import java.sql.Connection;

@Path("/hello-world-20192730032703")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld20192730032703 {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorld20192730032703(String template, String defaultName) {
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
        Connection connection = new Connect;
        try{
            String query = "SELECT * FROM users WHERE userid ='"+ userId.or(0) + "'" + " AND password='" + password.or("YAY") + "'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}