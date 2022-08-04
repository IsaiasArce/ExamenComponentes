package com.cenfotec.examen.services;

import com.cenfotec.examen.domain.IMC;
import com.cenfotec.examen.repo.IMCRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class IMCServiceImpl implements  IMCService{
    @Autowired
    IMCRepo imcRepo;
    @Override
    public void save(IMC imc) {
        imcRepo.save(imc);

    }

   /** @Override
    public List<IMC> findByJugadorID(Long id) {
        return imcRepo.findAllById(id);
    }**/
}
