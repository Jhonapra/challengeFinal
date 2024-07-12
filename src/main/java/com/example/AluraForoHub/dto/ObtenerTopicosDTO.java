package com.example.AluraForoHub.dto;

import com.example.AluraForoHub.modelos.Topico;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ObtenerTopicosDTO(@NotNull
                                Long id,
                                String idUsuario,
                                String mensaje,
                                String nombreCurso,
                                String titulo,
                                LocalDate fecha) {

    //Constructor para convertir el ObtenerTopicosDTO en datos de tipo Topico
    public ObtenerTopicosDTO(Topico topico){
        this(topico.getId(),
                topico.getUsuario(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getTitulo(),
                topico.getFecha());
    }
}
