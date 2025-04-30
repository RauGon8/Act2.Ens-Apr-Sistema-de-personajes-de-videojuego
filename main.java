
abstract class personaje {
    String nombre;
    int salud;
    int vida;
    
    personaje(String nombre, int salud, int vida) {
        this.nombre = nombre;
        this.salud = salud;
        this.vida = vida;
    }

    abstract void atacar();




    
}