package com.example.AluraForoHub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ActualizacionTopico(@NotNull
                                  Long id,
                                  String usuario,
                                  String mensaje,
                                  String curso,
                                  String titulo) {
}
