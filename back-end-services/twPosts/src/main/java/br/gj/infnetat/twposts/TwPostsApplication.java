package br.gj.infnetat.twposts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TwPostsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwPostsApplication.class, args);
    }

}
