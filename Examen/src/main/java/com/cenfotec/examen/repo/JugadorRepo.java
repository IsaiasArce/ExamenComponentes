package com.cenfotec.examen.repo;

import com.cenfotec.examen.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JugadorRepo extends JpaRepository<Jugador, Long> {
    public List<Jugador> findByNombreContaining(String word);


}
