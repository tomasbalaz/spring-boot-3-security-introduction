package sk.balaz.springboot3securityintroduction.dao;

import java.util.Collections;
import java.util.List;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

  private static final List<UserDetails> APPLICATION_USERS =
      List.of(
          new User(
              "admin@email.com",
              "$2a$12$ynvun4drpNC0wRAuTkmWjuROlsN5DvkngAq9bOp6lX3e2prnRZ/be",
              Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
          ),
          new User(
              "user@email.com",
              "$2a$12$ynvun4drpNC0wRAuTkmWjuROlsN5DvkngAq9bOp6lX3e2prnRZ/be",
              Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
          )
      );

  public UserDetails findUserByEmail(String email) {
    return APPLICATION_USERS.stream()
        .filter(userDetails -> userDetails.getUsername().equals(email))
        .findFirst()
        .orElseThrow(() -> new UsernameNotFoundException("No user was found"));
  }

}
