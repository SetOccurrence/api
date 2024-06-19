package br.com.occurrence.api.app.api.controller;

import br.com.occurrence.api.app.api.dto.organization.TeamDto;
import br.com.occurrence.api.app.api.dto.organization.UserDto;
import br.com.occurrence.api.app.api.dto.organization.UserFormDto;
import br.com.occurrence.api.domain.mapper.TeamMapper;
import br.com.occurrence.api.domain.mapper.UserMapper;
import br.com.occurrence.api.domain.model.organization.Team;
import br.com.occurrence.api.domain.model.organization.User;
import br.com.occurrence.api.domain.service.UserCommandService;
import br.com.occurrence.api.domain.service.UserReadService;
import br.com.occurrence.api.domain.util.filter.TeamFilter;
import br.com.occurrence.api.domain.util.filter.UserFilter;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserReadService userReadService;
    private final UserCommandService userCommandService;

    @GetMapping
    public ResponseEntity<Page<UserDto>> findAll(@PageableDefault Pageable page,
                                                 @RequestParam(required = false) UserFilter filter) {
        Page<User> users = userReadService.findAll(page, filter);
        Page<UserDto> usersDto = users.map(UserMapper::toUserDTO);
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll(@RequestParam(required = false) UserFilter filter) {
        List<User> users = userReadService.findAll(filter);
        List<UserDto> usersDto = users.stream()
                .map(UserMapper::toUserDTO)
                .toList();
        return ResponseEntity.ok(usersDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable UUID id) {
        User user = userReadService.findById(id);
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDto> me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody @Valid UserFormDto form) {
        User user = userCommandService.create(form);
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.created(URI.create("/api/v1/users/" + dto.id())).body(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable UUID id, @RequestBody UserFormDto form) {
        User user = userCommandService.update(id, form);
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/activate/{id}")
    public ResponseEntity<UserDto> activate(@PathVariable UUID id) {
        User user = userCommandService.activate(id);
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/inactivate/{id}")
    public ResponseEntity<UserDto> inactivate(@PathVariable UUID id) {
        User user = userCommandService.inactivate(id);
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/block/{id}")
    public ResponseEntity<UserDto> block(@PathVariable UUID id) {
        User user = userCommandService.block(id);
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/delete/{id}")
    public ResponseEntity<UserDto> logicallyDelete(@PathVariable UUID id) {
        User user = userCommandService.logicallyDelete(id);
        UserDto dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userCommandService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
