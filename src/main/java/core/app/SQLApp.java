package core.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Marcin on 2016-03-09.
 */

@SpringBootApplication
@ComponentScan(value = "core")
public class SQLApp {

    public static void main(String[] args) {
        SpringApplication.run(SQLApp.class,args);
    }

}
