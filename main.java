import java.util.ArrayList;


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

    interface defendible {
        void defenderse();
    }

    interface curable {
        void curar(int cantidad);
    }

    interface movilizable {
        void moverse();
    }
    interface ocultable {
        void ocultar();
    }

    class hechicero extends personajemagico implements defendible{
        public hechicero(String nombre, int salud, int nivel, int magia) {
        super(nombre, salud, nivel, magia);
        }

        @Override
        void atacar() {
        lanzar_hechizo();
        }

        @Override
        public void defenderse() {
        System.out.println(nombre + " Usa un hechizo de proteccion sobre si mismo");
        }
    }

    class asesino extends personajefisico implements movilizable, ocultable {
        public asesino(String nombre, int salud, int nivel, int fuerza) {
        super(nombre, salud, nivel, fuerza);
        }

        @Override
        void atacar() {
        golpear();
        }  
        @Override
        public void ocultar() {
        System.out.println(nombre + " se esconde en las sombras");
        }


        @Override
        public void moverse() {
        System.out.println(nombre + " se mueve con sigilo");
        }
    }

    class guerrero extends personajefisico implements defendible {
        public int armadura;
        public int escudo;
    
        public guerrero(String nombre, int nivel, int salud, int fuerza, int armadura, int escudo) {
            super(nombre, nivel, salud, fuerza);
            this.armadura = armadura;
            this.escudo = escudo;
        }
    
        @Override
        public void atacar() {
            System.out.println(nombre + " ataca con su espada causando " + fuerza + " de daño");
        }
    
        @Override
        public void defenderse() {
            System.out.println(nombre + " levanta su escudo para defenderse");
        }
    
        public void cargarAtaque() {
            System.out.println(nombre + " carga su próximo ataque");
        }
    }

    class mago extends personajemagico implements curable {
        public int sabiduria;
    
        public mago(String nombre, int nivel, int salud, int mana, int sabiduria) {
            super(nombre, nivel, salud, mana);
            this.sabiduria = sabiduria;
        }
    
    
        @Override
        public void atacar() {
            lanzar_hechizo();
        }
    
        @Override
        public void curar(int cantidad) {
            System.out.println(nombre + " se cura a sí mismo " + cantidad + " puntos de salud");
            salud += cantidad;
        }
    
    }
    class Juego {
        private ArrayList<personaje> personaje;
    
        public Juego() {
            personaje = new ArrayList<>();
        }
    
        public void añadirPersonaje(personaje personaje) {
            this.personaje.add(personaje);
        }
    
        public void mostrarAcciones() {
            for (personaje p : personaje) {
                if (p instanceof defendible) {
                    ((defendible) p).defenderse();
                }
                if (p instanceof curable) {
                    ((curable) p).curar(10);
                }
                if (p instanceof movilizable) {
                    ((movilizable) p).moverse();
                }
                if (p instanceof ocultable) {
                    ((ocultable) p).ocultar();
                }
                if (p instanceof personajefisico) {
                    ((personajefisico) p).golpear();
                }
                if (p instanceof personajemagico) {
                    ((personajemagico) p).lanzar_hechizo();
                }
                if (p instanceof guerrero) {
                    ((guerrero) p).cargarAtaque();
                }
            }
        }
    }

    public class main {
        public static void main(String[] args) {
            Juego juego = new Juego();
    
            guerrero guerrero = new guerrero("Guerrero", 1, 100, 20, 10, 5);
            mago mago = new mago("Mago", 1, 80, 30, 15);
            hechicero hechicero = new hechicero("Hechicero", 1, 70, 25);
            asesino asesino = new asesino("Asesino", 1, 90, 15);

            juego.añadirPersonaje(guerrero);
            juego.añadirPersonaje(mago);
            juego.añadirPersonaje(hechicero);
            juego.añadirPersonaje(asesino);
    
            juego.mostrarAcciones();
        }
    }
