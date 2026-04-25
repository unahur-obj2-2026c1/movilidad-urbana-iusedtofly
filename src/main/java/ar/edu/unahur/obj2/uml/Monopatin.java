package ar.edu.unahur.obj2.uml;

public class Monopatin extends Vehiculo{

    private String marca; //String va con mayuscula en Java

    public Monopatin (String marca,boolean disponible){
        super(disponible); //llama al constructor de la clase padre ;  obligatorio cuando la clase padre tiene const. con parametros y siempre tiene que ser la primera linea del constructor del hijo
        this.marca = marca;
    }

    public String esMarca(){ //GETTER
        return this.marca;
    }
}