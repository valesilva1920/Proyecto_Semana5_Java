import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    public static void main(String[] args) {

        try {
            FileWriter ventas = new FileWriter("ventas.txt");

            Random rand = new Random();

            for (int i = 0; i < 20; i++) {
                int vendedor = rand.nextInt(5);
                int producto = rand.nextInt(5);
                int cantidad = rand.nextInt(10) + 1;

                ventas.write(vendedor + "," + producto + "," + cantidad + "\n");
            }

            ventas.close();

            System.out.println("Archivos generados correctamente");

        } catch (IOException e) {
            System.out.println("Error al generar archivos");
        }
    }
}
