package main.Clases;

public class Mascota {
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    // Default constructor
    public Mascota() {
        this.nombre = "";
        this.especie = "";
        this.raza = "";
        this.color = "";
    }

    public Mascota(String nombre){

        this.nombre = nombre;

    }

    // Parameterized constructor
    public Mascota(String nombre, String especie, String raza, String color) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public String getColor() {
        return color;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // toString method
    @Override
    public String toString() {
        return  "Nombre: " + nombre +
                "\nEspecie: " + especie +
                "\nRaza: " + raza +
                "\nColor: " + color;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        // if objs have the same serie in me memory return true
        if (this == obj){
            return true;
        }
        
        if (obj.getClass() != this.getClass()) {
            return false;   
        }
        
        //  aux obj to compare
        Mascota aux = (Mascota) obj;
        //  if the object "codigo" are the same, return true
        return this.nombre == aux.nombre;
        
    }

}