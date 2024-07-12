package com.example.AluraForoHub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InformacionRegistrosTopicosDTO(@NotBlank
                                             String idUsuario,
                                             @NotNull
                                             String mensaje,
                                             @NotBlank
                                             String nombreCurso,
                                             @NotBlank
                                             String titulo) {
}
