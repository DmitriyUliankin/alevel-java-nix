package com.alevel.java.todolist.service;

import com.alevel.java.todolist.entity.Role;
import com.alevel.java.todolist.entity.User;
import com.alevel.java.todolist.entity.request.SaveUserRequest;
import com.alevel.java.todolist.exception.RoleNotFoundException;
import com.alevel.java.todolist.exception.UserAlreadyExistsException;
import com.alevel.java.todolist.exception.UserNotFoundException;
import com.alevel.java.todolist.repository.RoleRepository;
import com.alevel.java.todolist.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserService implements UserOperations {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User create(SaveUserRequest request) {
        String username = request.getUsername();
        if (userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException(username);
        }

        Set<Role> roles = getRolesByNames(request.getRoles());

        var user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Override
    public void update(Integer id, SaveUserRequest request) {
        var existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        String username = request.getUsername();

        if (!existingUser.getUsername().equals(username)
                && userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException(request.getUsername());
        }

        Set<Role> roles = getRolesByNames(request.getRoles());

        existingUser.setUsername(username);
        existingUser.setPassword(passwordEncoder.encode(request.getPassword()));
        existingUser.setRoles(roles);

        userRepository.save(existingUser);
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    private Set<Role> getRolesByNames(Set<String> roleNames) {
        Set<Role> roles = new HashSet<>(roleNames.size());

        for (String roleName : roleNames) {
            var role = roleRepository
                    .findByName(roleName)
                    .orElseThrow(() -> new RoleNotFoundException(roleName));
            roles.add(role);
        }
        return roles;
    }

}
