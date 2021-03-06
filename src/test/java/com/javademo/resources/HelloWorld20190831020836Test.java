package com.javademo.resources;


import com.google.common.base.Optional;



import org.junit.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloWorld20190831020836Test {
    private HelloWorld20190831020836 resource;

    public void setup() {
        System.out.println("YAY");
    }

    @Test
    public void testDumb() {
        resource = new HelloWorld20190831020836("Hello, %s", "Stranger");
        Optional<String> empty = Optional.absent();
        resource.sayHello(empty);
    }

    @Test
    public void testAdd() {
        resource = new HelloWorld20190831020836("Hello, %s", "Stranger");

        double result = resource.add(7,9);
        //assertThat("y").isEqualTo("y");
        assertThat(result).isEqualTo((double) 7+9);
    }

}