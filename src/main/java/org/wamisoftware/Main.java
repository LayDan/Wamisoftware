package org.wamisoftware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Map<String, String> envs = System.getenv();
        envs.forEach((k, v) -> System.out.println(k + "=" + v));
        SpringApplication.run(Main.class, args);
    }
}