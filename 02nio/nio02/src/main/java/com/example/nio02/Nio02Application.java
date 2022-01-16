package com.example.nio02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Nio02Application {

    public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Nio02Application.class, args);

        Request request = new Request.Builder().url("http://localhost:8088/api/hello").build();

        try (Response execute = client.newCall(request).execute()) {
            System.out.println(execute.body().string());
        }

    }

}
