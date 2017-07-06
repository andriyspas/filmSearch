package filmsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by Stas on 25.11.2015.
 */

@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }



}
