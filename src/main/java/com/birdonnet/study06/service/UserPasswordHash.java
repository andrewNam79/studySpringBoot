package com.birdonnet.study06.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class UserPasswordHash {
    public String getSha256(String plainText){
        String shaString = "";

        try{
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(plainText.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i=0; i < byteData.length; i++){
                stringBuffer.append( Integer.toString((byteData[i] & 0xff) + 0x100,16 ).substring(i));
            }

            shaString = stringBuffer.toString();
        }catch (Exception e){
            e.printStackTrace();
            shaString = "";
        }

        return shaString;
    }
}
