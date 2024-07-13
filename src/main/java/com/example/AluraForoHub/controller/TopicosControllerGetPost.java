package com.example.AluraForoHub.controller;

import com.example.AluraForoHub.dto.InformacionRegistrosTopicosDTO;
import com.example.AluraForoHub.dto.ObtenerTopicosPublicoDTO;
import com.example.AluraForoHub.modelos.Topico;
import com.example.AluraForoHub.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/topicos")
public class TopicosControllerGetPost {
    @Autowired
    private TopicoRepository topicoRepository2;

    @PostMapping
    private void registrarTopicos(@RequestBody @Valid InformacionRegistrosTopicosDTO datosTopico){
        LocalDate fechaActual = LocalDate.now();
        topicoRepository2.save(new Topico(datosTopico, fechaActual));
    }

    @GetMapping
    private ResponseEntity<Page<ObtenerTopicosPublicoDTO>> obtenerTopicos(@PageableDefault(size = 5) Pageable paginacion){
//      return topicoRepository.findAll(paginacion).map(ObtenerTopicosPublicoDTO::new);
        return ResponseEntity.ok(topicoRepository2.findAll(paginacion).map(ObtenerTopicosPublicoDTO::new));
    }
}
