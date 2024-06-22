package br.com.occurrence.api;

import br.com.occurrence.api.domain.model.organization.Unit;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.model.organization.commons.Address;
import br.com.occurrence.api.domain.model.organization.commons.Contact;
import br.com.occurrence.api.domain.repository.UnitRepository;
import br.com.occurrence.api.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@AllArgsConstructor
public class Runner implements ApplicationRunner {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private UnitRepository unitRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User admin = obtainUser("Administrador", "admin");
        User user = obtainUser("Jonatan", "jonatan_birck");
    }

    private User obtainUser(String name, String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return user.orElseGet(() -> createUser(name, login));
    }

    private User createUser(String name, String login) {
        User user = new User();
        user.setName(name);
        user.setEmail(login + "@setoccurrence.com");
        user.setLogin(login);
        user.setPassword(passwordEncoder.encode("teste123"));
        user.setContact(null);
        user.setTeam(null);
        user.setStatus(User.Status.ACTIVE);
        user.setCreatedBy("");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedBy("");
        user.setUpdatedAt(null);
        return userRepository.create(user);
    }

    private Unit createUnit(String name, User responsible) {
        Unit unit = new Unit();
        unit.setName(name);
        unit.setDescription("descrição da unidade " + name);
        unit.setCreatedAt(LocalDateTime.now());
        unit.setCreatedBy(responsible.getLogin());
        unit.setResponsible(responsible);
        unit.setStatus(Unit.Status.ACTIVE);
        unit.setUpdatedAt(LocalDateTime.now());
        unit.setUpdatedBy(responsible.getLogin());
        unit.setAddress(new Address("", 0, "", "", "", "", "", ""));
        unit.setContact(new Contact("","51-95363100", ""));
        return unitRepository.create(unit);
    }

}
