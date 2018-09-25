package com.sk;

import com.sk.dao.CountryDao;
import com.sk.entity.CountryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController
public class ApiController {

    @Autowired
    private CountryDao countryDao;

    @RequestMapping(value = "/get_token")
    public String getToken() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return Verifier.calcSHA1("123");
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public String sendMessage(HttpServletRequest request) {
        String testId = request.getParameter("test_id");
        int sum = 0;
        for (CountryEntity entity : countryDao.getAll()) {
            sum += entity.getId();
        }
        return String.valueOf(Integer.parseInt(testId) * 2) + " " + String.valueOf(sum);
    }
}