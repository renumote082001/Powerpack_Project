package cc.altius.machineSales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MachineSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MachineSalesApplication.class, args);
                
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                System.out.println(encoder.encode("password"));
	}

}
