package com.LatexWriter;

import com.LatexWriter.domain.Journal;
import com.LatexWriter.repository.JournalRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
//@Value("${data.server}")
//private String server;
@SpringBootApplication
public class SimpleWebApp {
    @Bean
    InitializingBean saveData(JournalRepository repo) {
        return () -> {
            repo.save(new Journal("Get to know Spring Boot", "Today I will learn SpringBoot", "01/01/2016"));
            repo.save(new Journal("Simple Spring Boot Project", "I will do my first SpringBoot Project", "01/02/2016"));
            repo.save(new Journal("Spring Boot Reading", "Read more about SpringBoot", "02/01/2016"));
            repo.save(new Journal("Spring Boot in the Cloud", "Spring Boot using CloudFoundry", "03/01/2016"));
        };
    }

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(SimpleWebApp.class);
        app.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass,
                                    PrintStream out) {
                out.print("\n" +
                        " _______  _______ _________ _______  _______  _______  _       \n" +
                        "(  ____ )(  ____ \\\\__   __/(  ____ \\(       )(  ___  )( (    /|\n" +
                        "| (    )|| (    \\/   ) (   | (    \\/| () () || (   ) ||  \\  ( |\n" +
                        "| (____)|| (__       | |   | (_____ | || || || (___) ||   \\ | |\n" +
                        "|     __)|  __)      | |   (_____  )| |(_)| ||  ___  || (\\ \\) |\n" +
                        "| (\\ (   | (         | |         ) || |   | || (   ) || | \\   |\n" +
                        "| ) \\ \\__| (____/\\___) (___/\\____) || )   ( || )   ( || )  \\  |\n" +
                        "|/   \\__/(_______/\\_______/\\_______)|/     \\||/     \\||/    )_)\n" +
                        "                                                               \n".toUpperCase());
            }
        });
        app.run(args);

    }
}