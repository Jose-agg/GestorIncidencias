package asw;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@SpringBootApplication
//@EnableScheduling
public class Application {
	public static final Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
    	SpringApplication.run(Application.class, args);
    }

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
    
   
    
}