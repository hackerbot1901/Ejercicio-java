public class Cliente {
    private String nombreCliente;
    private boolean adoptado;


    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.adoptado = false;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void adoptar(Animal animal) {
        setAdoptado(true);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", adoptado=" + adoptado +
                '}';
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }
}
