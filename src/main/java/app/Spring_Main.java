package app;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Spring_Main {
	
	public static void main(String[] args) {
		var context = SpringApplication.run(Spring_Main.class, args);
		context.getBean("idk");
	}
	
	@GetMapping("/")
	public String root() {
		return "Hello World!";
	}

}
