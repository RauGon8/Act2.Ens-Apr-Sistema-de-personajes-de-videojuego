
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", salud=" + salud +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof personaje)) return false;
        personaje p = (personaje) o;
        return nombre.equals(p.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }





    
}