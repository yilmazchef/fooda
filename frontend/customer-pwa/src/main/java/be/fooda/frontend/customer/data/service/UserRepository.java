package be.fooda.frontend.customer.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import be.fooda.frontend.customer.data.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}