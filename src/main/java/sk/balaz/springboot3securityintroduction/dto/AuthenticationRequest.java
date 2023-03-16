package sk.balaz.springboot3securityintroduction.dto;

public record AuthenticationRequest(
    String email,
    String password
) { }
