package org.evertones;

import org.evertones.model.Authorities;
import org.evertones.model.Users;
import org.evertones.persistence.authentication.AuthoritiesRepository;
import org.evertones.persistence.authentication.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringDemoApplication implements CommandLineRunner {

    private UsersService usersService;
    private AuthoritiesRepository authorityRepository;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setAuthorityRepository(AuthoritiesRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public static void main(String[] args) {
		SpringApplication.
				run(SpringDemoApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        Users admin = new Users()
                .setUsername("admin")
                .setPassword("password")
                .setEnabled(true)
                .setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true);
        Users user  = new Users()
                .setUsername("user")
                .setPassword("password")
                .setEnabled(true)
                .setAccountNonExpired(true)
                .setAccountNonLocked(true)
                .setCredentialsNonExpired(true);

        usersService.save(admin);
        usersService.save(user);

        Authorities userUser = new Authorities("user", "ROLE_USER");
        Authorities adminAdmin = new Authorities("admin", "ROLE_ADMIN");
        Authorities adminUser = new Authorities("admin", "ROLE_USER");

        authorityRepository.save(userUser);
        authorityRepository.save(adminAdmin);
        authorityRepository.save(adminUser);
    }
}
