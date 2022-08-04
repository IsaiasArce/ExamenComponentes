package com.cenfotec.examen.services;

import com.cenfotec.examen.domain.Jugador;

import java.util.List;
import java.util.Optional;

public interface JugadorService {
    public void save(Jugador jugador);
    public Optional<Jugador> get(Long id);
    public List<Jugador> getAll();
    public List<Jugador> find(String nombre);
    public  void  update(Jugador jugador);
}
