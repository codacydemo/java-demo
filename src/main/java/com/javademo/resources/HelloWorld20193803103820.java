package com.javademo.resources;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

import java.sql.*;

@Path("/hello-world-20193803103820")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld20193803103820 {
    private transient final String template;
    private transient final String defaultName;

    public HelloWorld20193803103820(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    @Timed
    public void sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
    }

    public double add(int x, int y){
            return (double) x+y;
        }

    public Connection generateConnection(){
        //TODO: implement a connection method
        return null;
    }

    @GET
    public void TestSQLInjection(@QueryParam("userid") Optional<Integer> userId, @QueryParam("password") Optional<String> password){
       return;
    }
}