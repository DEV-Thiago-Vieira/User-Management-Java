package com.francisco_thiago.user_management.infrastructure.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {super ("O recurso não foi encontrado."); }
    public ResourceNotFoundException(String message) { super(message); }
}