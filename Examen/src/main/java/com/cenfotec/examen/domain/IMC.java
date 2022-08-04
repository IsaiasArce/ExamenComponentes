package com.cenfotec.examen.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class IMC {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private double value;
    private Date date;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Jugador jugador;
    public double getValue() {
        return value;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }



    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public double calculateIMC( double peso, double estatura) {
        return peso/(estatura*estatura);

    }
}
