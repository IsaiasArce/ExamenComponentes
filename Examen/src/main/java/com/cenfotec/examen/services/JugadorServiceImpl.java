package com.cenfotec.examen.services;

import com.cenfotec.examen.domain.IMC;
import com.cenfotec.examen.domain.Jugador;
import com.cenfotec.examen.repo.JugadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class JugadorServiceImpl implements JugadorService{
    @Autowired
    JugadorRepo repo;
    IMCServiceImpl imcService;

    @Override
    public void save(Jugador Jugador) {
        repo.save(Jugador);
    }

    @Override
    public Optional<Jugador> get(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<Jugador> getAll() {
        return repo.findAll();
    }
    @Override
    public void update(Jugador jugador) {
        Jugador j= repo.getById(jugador.getId());
        if(!(jugador.getDireccion()==null)){
        j.setDireccion(jugador.getDireccion());
        }
        if(jugador.getProvincia()!=null){
        j.setProvincia(jugador.getProvincia());}
        if(jugador.getCanton()!=null){
        j.setCanton(jugador.getCanton());}
        if(jugador.getDistrito()!=null){
        j.setDistrito(jugador.getDistrito());}
        if(jugador.getTelefono()!=null){
        j.setTelefono(jugador.getTelefono());}
        if(jugador.getEmail()!=null){
        j.setEmail(jugador.getEmail());}
        if((j.getPeso()!=j.getPeso()) && jugador.getPeso()!=0){
            IMC imc = new IMC();
            imc.setValue(imc.calculateIMC(jugador.getPeso(), jugador.getEstatura()));
            ZoneId defaultZoneId = ZoneId.systemDefault();
            LocalDate localDate= LocalDate.now(defaultZoneId);
            Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
            imc.setDate(date);
            imc.setJugador(j);
            j.addIMC(imc);
            imcService.save(imc);

        }
        repo.save(j);

        /**SOLO PUEDO CAMBIAR la dirección, provincia, cantón o distrito,
         teléfono o email y SU PESO**/

    }

    @Override
    public List<Jugador> find(String nombre) {
        return repo.findByNombreContaining(nombre);
    }
}
