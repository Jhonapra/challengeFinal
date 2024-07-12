package com.example.AluraForoHub.controller;


import com.example.AluraForoHub.dto.InformacionRegistrosTopicosDTO;
import com.example.AluraForoHub.modelos.Topico;
import com.example.AluraForoHub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    private void registrarTopicos(@RequestBody @Valid InformacionRegistrosTopicosDTO datosTopico){
        LocalDate fechaActual = LocalDate.now();
        topicoRepository.save(new Topico(datosTopico, fechaActual));
    }

    @GetMapping
    private List<Topico>obtenerTopicos(){
        return topicoRepository.findAll();
    }
}
