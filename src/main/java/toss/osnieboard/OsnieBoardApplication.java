package toss.osnieboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="toss.osnieboard")
public class OsnieBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(OsnieBoardApplication.class, args);
	}

}
