package com.example.AluraForoHub.modelos;

import com.example.AluraForoHub.dto.InformacionRegistrosTopicosDTO;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String mensaje;
    private String curso;
    private String titulo;
    private LocalDate fecha;

    //Constructor sin parametros
    public Topico() {
    }

    //Constructo con datos del tipo InformacionRegistrosTopicosDTO
    //Esto se hace para poder guardar la informacion en la base de datos ya obteniendo la informacion com un objeto java Topico
    //En la V2 se añadio la fecha de creacion
    public Topico(InformacionRegistrosTopicosDTO informacionRegistrosTopicosDTO, LocalDate localDate){
        this.usuario =informacionRegistrosTopicosDTO.idUsuario();
        this.mensaje = informacionRegistrosTopicosDTO.mensaje();
        this.curso = informacionRegistrosTopicosDTO.nombreCurso();
        this.titulo = informacionRegistrosTopicosDTO.titulo();
        this.fecha = localDate;
    }

    //Constructor con todos los parametros
    public Topico(Long id, String usuario, String mensaje, String curso, String titulo) {
        this.id = id;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.curso = curso;
        this.titulo = titulo;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getCurso() {
        return curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    //Equals and HashCode del id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topico topico = (Topico) o;
        return Objects.equals(id, topico.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
