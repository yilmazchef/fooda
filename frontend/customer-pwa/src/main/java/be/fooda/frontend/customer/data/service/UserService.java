package be.fooda.frontend.customer.data.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import be.fooda.frontend.customer.data.Role;
import be.fooda.frontend.customer.data.entity.User;

@Service
public class UserService extends CrudService<User, Integer> {

    private UserRepository repository;
    private PasswordEncoder passwordEncoder;

    public UserService(@Autowired UserRepository repository, @Autowired PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected UserRepository getRepository() {
        return repository;
    }

    public void createPhoneUser(final String phone, final String validation){
        User user = new User();
        user.setName("Fooda Customer via SMS Login");
        user.setUsername(phone);
        user.setHashedPassword(passwordEncoder.encode(validation));
        user.setProfilePictureUrl(
                "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
        user.setRoles(Collections.singleton(Role.USER));
        repository.save(user);
    }

    public void createEmailUser(final String email, final String password){
        User user = new User();
        user.setName("Fooda Customer via Email");
        user.setUsername(email);
        user.setHashedPassword(passwordEncoder.encode(password));
        user.setProfilePictureUrl(
                "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=128&h=128&q=80");
        user.setRoles(Collections.singleton(Role.USER));
        repository.save(user);
    }

    public Optional<User> findByEmail(final String email){
        return Optional.ofNullable(repository.findByUsername(email));
    }

    public Optional<User> findByPhone(final String phone){
        return Optional.ofNullable(repository.findByUsername(phone));
    }

}
