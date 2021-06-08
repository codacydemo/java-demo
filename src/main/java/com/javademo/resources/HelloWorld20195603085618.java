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
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.Map;


@Path("/hello-world-20195603085618")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorld20195603085618 {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorld20195603085618(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public void sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
    }

    public Connection generateConnection(){
        //TODO: implement a connection method
        return null;
    }

    public double add(int x, int y){
        return (double) x+y;
    }

    @GET
    public void TestSQLInjection(@QueryParam("userid") Optional<Integer> userId, @QueryParam("password") Optional<String> password){
       Connection connection = generateConnection();
       try{
           String query = "SELECT * FROM users WHERE userid ='"+ userId.or(0) + "'" + " AND password='" + password.or("YAY") + "'";
           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery(query);
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }


    @GET
    public void NewMethodForTestSQLInjection(@QueryParam("userid") Optional<Integer> userId, @QueryParam("password") Optional<String> password){
       Connection connection = generateConnection();
       try{
           String query = "SELECT * FROM users WHERE userid ='"+ userId.or(0) + "'" + " AND password='" + password.or("YAY") + "'";
           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery(query);
       }catch(Exception ex){
           ex.printStackTrace();
       }
    }

    public void method1() {
        method2("String", null);
    }

    public void method2(String param1, String param2) {
        String var1 = param1.trim();
        param2 = param2.trim();
        System.out.println(var1);
        System.out.println(param2);
    }
        
    private void method3(TestObject testobject){
        String var1=testobject.get("test");
        System.out.println(var1);
        if (testobject == null ){
            return;
        }
    }

    private class TestObject {
     public String get(String yay){
         return yay;
     }   
    }
}