package com.example.hackathon_team12;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HackathonTeam12ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void jasypt() {
        String a ="AV";
        String b="jdbc:mysql://springboot-database.c0tg3iklfpiz.ap-northeast-2.rds.amazonaws.com:3306/mydatabase";


        System.out.println("안뇽");
        System.out.println(jasyptEncoding(a));
        System.out.println(jasyptEncoding(b));
    }

    public String jasyptEncoding(String value) {

        String key = "my_jasypt_key";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);
    }
}
