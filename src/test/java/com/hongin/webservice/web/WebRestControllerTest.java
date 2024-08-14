package com.hongin.webservice.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class WebRestControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void profile확인() throws Exception {
        //when
        String profile = testRestTemplate.getForObject("/profile", String.class);

        //then
        assertThat(profile).isEqualTo("local");
     }
}