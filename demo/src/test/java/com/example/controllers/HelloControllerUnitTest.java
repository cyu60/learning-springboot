package com.example.controllers;

//import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

//import static org.junit.Assert.*;

public class HelloControllerUnitTest {

    @Test
    public void sayHello() {
        HelloController controller = new HelloController();
        Model model = new BindingAwareModelMap();
        String result = controller.sayHello("World", model);
        if (result.equals("hello")) {
            System.out.println("hello returned!");
        } else {
            System.out.println("no hello returned!");
        }
        if (model.asMap().get("user").equals("World")){
            System.out.println("world returned!");
        } else {
            System.out.println("no world returned!");
        }

//        Assert.
//        assertEquals;
    }
}
