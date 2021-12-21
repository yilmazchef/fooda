package be.fooda.frontend.store.data.service;

import be.fooda.frontend.store.data.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import be.fooda.frontend.store.data.Role;
import javax.persistence.Lob;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}