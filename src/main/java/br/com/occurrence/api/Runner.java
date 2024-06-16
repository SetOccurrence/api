package br.com.occurrence.api;

import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.repository.UserRepository;
import br.com.occurrence.api.domain.service.UserReadService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class Runner implements ApplicationRunner {

    private UserReadService userReadService;
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHH222222222");
        checkUserAdminExits();
    }

    public void checkUserAdminExits() {
        boolean exits = userReadService.exitsByLogin("admin");
        if (exits) {
            return;
        }
        User admin = new User();
        admin.setName("Administrador");
        admin.setEmail("");
        admin.setLogin("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setContact(null);
        admin.setTeam(null);
        admin.setStatus(User.Status.ACTIVE);
        admin.setCreatedBy("");
        admin.setCreatedAt(LocalDateTime.now());
        admin.setUpdatedBy("");
        admin.setUpdatedAt(null);
        admin = userRepository.create(admin);
        System.out.println(admin.getId());
    }

}
