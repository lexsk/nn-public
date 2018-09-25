package com.sk;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Verifier {

    private final static String salt = "h2h";

    public static boolean checkCode(String clientId, String code) {
        try {
            return calcSHA1(clientId).equals(code);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String calcSHA1(String clientId) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        return HexBin.encode((md.digest((salt + getCurrentDate() + clientId).getBytes("UTF-8"))));
    }

    private static String getCurrentDate() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyyMMdd");
        return formatForDateNow.format(dateNow);
    }

}