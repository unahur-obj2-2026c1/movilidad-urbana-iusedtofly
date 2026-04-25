package ar.edu.unahur.obj2.uml;

public class Bicicleta extends Vehiculo {

    private int rodado;

    public Bicicleta (int rodado,boolean disponible){
        super(disponible); //llama al constructor de la clase padre ;  obligatorio cuando la clase padre tiene const. con parametros y siempre tiene que ser la primera linea del constructor del hijo
        this.rodado= rodado;
    }

    public int esRodado(){ //GETTER
        return this.rodado;
    }

    //asdasd
}
