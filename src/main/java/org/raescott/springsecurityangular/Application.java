package org.raescott.springsecurityangular;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Richard Scott Smith <pilbender@gmail.com>
 */
@SpringBootApplication
@RestController
public class Application {
  @RequestMapping("resource")
  public String home() {
    return "Hello World";
  }

	public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
	}
}
