public class Animal {
    protected String nombre;
    protected int edad;
    protected double peso;
    protected Raza raza;

    public Animal(String nombre, int edad, double peso, Raza raza) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", raza=" + raza +
                '}';
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
}
