package com.example.AluraForoHub.controller;

import com.example.AluraForoHub.dto.ActualizacionTopico;
import com.example.AluraForoHub.dto.InformacionRegistrosTopicosDTO;
import com.example.AluraForoHub.dto.ObtenerTopicosDTO;
import com.example.AluraForoHub.dto.ObtenerTopicosPublicoDTO;
import com.example.AluraForoHub.modelos.Topico;
import com.example.AluraForoHub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicosControllerGetPost {
    @Autowired
    private TopicoRepository topicoRepository2;

    @PostMapping
    private ResponseEntity<ObtenerTopicosDTO> registrarTopicos(@RequestBody @Valid InformacionRegistrosTopicosDTO datosTopico,
                                            UriComponentsBuilder uriComponent){
        LocalDate fechaActual = LocalDate.now();
        Topico topico = topicoRepository2.save(new Topico(datosTopico, fechaActual));
        ObtenerTopicosDTO obtenerTopicos = new ObtenerTopicosDTO(topico);
        URI url = uriComponent.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(obtenerTopicos);

    }

    @GetMapping
    private ResponseEntity<Page<ObtenerTopicosDTO>> obtenerTopicos(@PageableDefault(size = 5) Pageable paginacion){
//      return topicoRepository.findAll(paginacion).map(ObtenerTopicosPublicoDTO::new);
        return ResponseEntity.ok(topicoRepository2.findAll(paginacion).map(ObtenerTopicosDTO::new));
    }
}
