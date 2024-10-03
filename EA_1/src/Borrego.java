public class Borrego implements Comparable<Borrego>{
    private int kilos;
    private String nombre;

    public Borrego(int kilos, String nombre){
        this.kilos = kilos;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return String.format("%d kilos: borrego %s. ¡Mbaaah!", kilos, nombre);
    }

    @Override
    public int compareTo(Borrego borreguito){
        return Integer.compare(this.kilos, borreguito.kilos);
    }
}
