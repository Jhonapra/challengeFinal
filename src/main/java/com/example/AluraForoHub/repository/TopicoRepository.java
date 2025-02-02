package com.example.AluraForoHub.repository;

import com.example.AluraForoHub.modelos.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findById(Long id);
//  Page<Topico> findByActivoTrue(Pageable paginacion);
}
