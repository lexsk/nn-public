package com.sk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
public class ApiController {

    @RequestMapping(value = "/get_token")
    public String getToken() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return Verifier.calcSHA1("123");
    }

}