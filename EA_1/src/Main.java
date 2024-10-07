public class Main {
    public static void main(String[] args) {

        Borrego[] borregos = {
                new Borrego(50, "Adolfo"),
                new Borrego(50, "Benito"),
                new Borrego(45, "Camilo"),
                new Borrego(40, "Daniel"),
                new Borrego(50, "Ferchi"),
                new Borrego(55, "Adolfo")
        };

        Heapsort.heapsort(borregos);

        for (Borrego b : borregos) {
            System.out.println(b);
        }

    }
}