public class Raza {
    private String nombreRaza;
    public Raza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    @Override
    public String toString() {
        return "Raza{" +
                "nombreRaza='" + nombreRaza + '\'' +
                '}';
    }
}
