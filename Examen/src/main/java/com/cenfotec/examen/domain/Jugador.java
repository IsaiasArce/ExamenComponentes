package com.cenfotec.examen.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    @OneToMany(fetch= FetchType.LAZY, mappedBy="jugador")
    private Set<IMC> imcs;


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    private String apellido;
    private Date fechaNacimiento;
    private String posicion;
    private  double estatura;
    private double peso;
    private char categoria;
    private double imc;
    private  String direccion;
    private  String provincia;
    private  String canton;
    private  String distrito;

    public Set<IMC> getImcs() {
        return imcs;
    }

    public void setImcs(Set<IMC> imcs) {
        this.imcs = imcs;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
    public void setImc(){
        this.imc=  this.peso/(this.estatura*this.estatura);
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void addIMC(IMC imc) {
        imcs.add(imc);
    }


}
/**Requerimientos funcionales:
 - El sistema debe tener una página de inicio con las opciones:
 o Registrar Fubolista: es una página donde se registra el nombre (nombre completo, primer
 apellido, segundo apellido, fecha de nacimiento, posición (portero, defensa, delantero,
 mediocampista.. al menos), estatura, peso, si compite en la rama masculina o femenina.
 El programa a partir de la altura y peso calcula el INDICE DE MASA MUSCULAR y lo
 almacena en la BD junto con la fecha de ese cálculo. También se almacena dirección (texto
 clásico de la dirección), provincia, cantón y distrito, teléfono e email. (10%)
 o Listar Futbolistas: aparece la lista de futbolistas. (10%)
 ▪ Cada futbolista tiene la opción de “Ver detalle” que nos lleva a una página donde
 se carga la información de ese atleta en particular. (10%)
 ▪ Actualizar información: me lleva a una pantalla donde puedo actualizar la
 información: SOLO PUEDO CAMBIAR la dirección, provincia, cantón o distrito,
 teléfono o email y SU PESO. Si cambia su peso, debe registrar el nuevo índice de
 masa muscular. (10%)
 ▪ Ver histórico de Indice de Masa muscular. Me lleva a una pantalla donde veo la
 historia de medidas calculadas del IMC. (10%)
 o Buscar Futbolista por aproximación sobre el nombre o apellido: una página donde me
 lista todos los atletas por aproximación sobre el nombre o apellido (ambos). Es decir, si
 un atleta se llama Alvaro y otro tiene apellido Alvarado, y buscan el texto “ALV”, ambos
 deben aparecer en el resultado. (10%)
 o Arquitectura (15%).
 o Navegabilidad (5%)→ por favor que desde todas las páginas se pueda volver a la inicial.
 DEBE ENTREGAR:
 - Subir el link a un repositorio de GITHUB donde pondrá su programa.
 - DEBE USAR THYMELEAF, SPRINGBOOT, Spring web, Java 8, Spring Data (apropiado para la BD que
 use).
 - DEBE USAR H2.
 - NO SE CALIFICARÁ INTERFAZ DE USUARIO, NO PIERDA TIEMPO EN ESO. **/