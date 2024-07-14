package com.example.AluraForoHub.dto;
import jakarta.validation.constraints.NotNull;

public record ActualizacionTopico(@NotNull
                                  Long id,
                                  String usuario,
                                  String mensaje,
                                  String curso,
                                  String titulo) {
}
