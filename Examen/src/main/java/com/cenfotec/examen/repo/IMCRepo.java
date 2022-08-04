package com.cenfotec.examen.repo;

import com.cenfotec.examen.domain.IMC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMCRepo extends JpaRepository<IMC, Long> {
   // @Query(value = "Select * From IMC where jugador.id= id")
}
