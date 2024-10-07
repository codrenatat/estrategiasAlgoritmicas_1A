import java.util.Random;

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

        Random rand = new Random();

        for (int n = 1000; n <= 5000; n += 10) {
            int numArreglos = n / 10;
            long totalComparaciones = 0;
            long totalMovimientos = 0;

            for (int i = 0; i < numArreglos; i++) {
                Borrego[] myBorregos = new Borrego[n];

                for (int j = 0; j < n; j++) {
                    int kilos = rand.nextInt(100) + 1;
                    myBorregos[j] = new Borrego(kilos, "Borreguito");
                }

                Heapsort.resetCounters();

                Heapsort.heapsort(myBorregos);

                totalComparaciones += Heapsort.getComparaciones();
                totalMovimientos += Heapsort.getMovimientos();
            }

            double promedioComparaciones = (double) totalComparaciones / numArreglos;
            double promedioMovimientos = (double) totalMovimientos / numArreglos;

            System.out.printf("%d\t%.1f\t%d\t%.1f\n", n, promedioMovimientos, n, promedioComparaciones);
        }
    }
}