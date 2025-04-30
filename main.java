
abstract class personaje {
    protected String nombre;
    protected int salud;
    protected int nivel;
    
    personaje(String nombre, int salud, int nivel) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
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


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    abstract class personajefisico extends personaje {
        protected int fuerza;

        public personajefisico(String nombre, int salud, int nivel, int fuerza) {
            super(nombre, salud, nivel);
            this.fuerza = fuerza;
        }

        public void golpear() {
            System.out.println(nombre + " golpea con fuerza " + fuerza);
        }
    }
        
    abstract class personajemagico extends personaje {
        protected int magia;

        public personajemagico(String nombre, int salud, int nivel, int magia) {
            super(nombre, salud, nivel);
            this.magia = magia;
        }

        public void lanzar_hechizo() {
            System.out.println(nombre + " lanza un hechizo con magia " + magia);
        }
    }


}