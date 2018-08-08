package vn.binhhq.fun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vn.binhhq.fun.service.gen_procedure.GenService;

@SpringBootApplication
public class FunApplication { 

	public static void main(String[] args) {
		
		SpringApplication.run(FunApplication.class, args);
		
	}
}
