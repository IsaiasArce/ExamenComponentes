package com.cenfotec.examen.services;

import com.cenfotec.examen.domain.IMC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMCService {
    public void save(IMC imc);
    //public List<IMC> findByJugadorID(Long id);
}
