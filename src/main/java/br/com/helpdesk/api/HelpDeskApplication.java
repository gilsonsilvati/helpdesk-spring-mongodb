package br.com.helpdesk.api;

import br.com.helpdesk.api.entity.User;
import br.com.helpdesk.api.entity.enums.Profile;
import br.com.helpdesk.api.repository.Users;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class HelpDeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskApplication.class, args);
	}

	@Bean
	CommandLineRunner init(Users users, PasswordEncoder passwordEncoder) {
		return args -> initUser(users, passwordEncoder);
	}

	private void initUser(Users users, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("admin@helpdesk.com");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setProfile(Profile.ROLE_ADMIN);

		Optional<User> userOptional = users.findByEmail(admin.getEmail());

		if (userOptional.isEmpty())
			users.save(admin);
	}

}
