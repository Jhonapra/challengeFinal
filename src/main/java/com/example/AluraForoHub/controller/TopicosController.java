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

import java.time.LocalDate;
import java.util.Optional;


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
    private ResponseEntity<Page<ObtenerTopicosPublicoDTO>> obtenerTopicos(@PageableDefault(size = 5) Pageable paginacion){
//      return topicoRepository.findAll(paginacion).map(ObtenerTopicosPublicoDTO::new);
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(ObtenerTopicosPublicoDTO::new));
    }

    //Aqui se obtienen metodos especificos por el id
    @GetMapping("/{id}")
    public ResponseEntity<ObtenerTopicosDTO> obtnerDatosMedico(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        //No se deben retornar las entidades del programa siempre usa dto
        var topicoRetorno=new ObtenerTopicosDTO(topico.getId(), topico.getUsuario(), topico.getMensaje(), topico.getCurso(),
                topico.getTitulo(), topico.getFecha());
        return  ResponseEntity.ok(topicoRetorno);
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopicos(@RequestBody @Valid ActualizacionTopico actualizacionTopico){
        Optional<Topico> topicoEncontrado = topicoRepository.findById(actualizacionTopico.id());
        if (topicoEncontrado.isPresent()){
            Topico topico = topicoRepository.getReferenceById(actualizacionTopico.id());
            topico.actualizarDatos(actualizacionTopico);
            return ResponseEntity.ok(topico);
        }else {
            System.out.println("Id no registrada");
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Optional<Topico> topicoEncontrado = topicoRepository.findById(id);
        if (topicoEncontrado.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            System.out.println("Id no registrada");
            return ResponseEntity.notFound().build();
        }
    }
}
