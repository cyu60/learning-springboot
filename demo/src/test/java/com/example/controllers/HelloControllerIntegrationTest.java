package com.example.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;
    private final String TEST_NAME = "nice";

    @Test
    void autoWiringWorked() {
        assertNotNull(mvc);
    }

    @Test
    public void testHelloWorldWithoutName() throws Exception {
        mvc.perform(get("/hello").accept(MediaType.TEXT_HTML))
                .andExpect((status().isOk()))
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user","World"));
    }

    @Test
    public void testHelloWorldWithName() throws Exception {
        mvc.perform(get("/hello").param("name", TEST_NAME).accept(MediaType.TEXT_HTML))
                .andExpect((status().isOk()))
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user",TEST_NAME));
    }

}
