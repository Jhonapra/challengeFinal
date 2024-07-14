package com.example.AluraForoHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuarioDTO(@NotBlank
                                           String usuario,
                                           @NotBlank
                                           String contraseña) {
}
