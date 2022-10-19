package com.example.cookbookproject.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderMain {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("hasło"));

        System.out.println(encoder.matches("hasło", "$2a$10$8XkkydzyP5/TINMlGR80cu3tbDDLVRAGl/JWp8EFkEE4K3ksA.Y.6"));

    }

}
