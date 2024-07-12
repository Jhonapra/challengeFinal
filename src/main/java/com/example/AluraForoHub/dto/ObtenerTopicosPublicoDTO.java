package com.example.AluraForoHub.dto;

import com.example.AluraForoHub.modelos.Topico;

import java.time.LocalDate;

public record ObtenerTopicosPublicoDTO(String idUsuario,
                                       String mensaje,
                                       String nombreCurso,
                                       String titulo,
                                       LocalDate fecha) {
    //Constructor para convertir el ObtenerTopicosDTO en datos de tipo Topico
    public ObtenerTopicosPublicoDTO(Topico topico){
        this(topico.getUsuario(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getTitulo(),
                topico.getFecha());
    }
}
