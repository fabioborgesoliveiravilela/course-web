package pt.com.hpc.nttdata.technical.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CourseWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseWebApplication.class, args);
	}

}
