import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateInfoFiles {

    public static void main(String[] args) {
        try {
            generateSales("SalesMenData.txt");
            generateProducts("ProductsData.txt");
            generateSalesmen("SalesManInfoData.txt");

            System.out.println("Archivos generados correctamente.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void generateSales(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            int salesmanId = 1000 + i;

            for (int j = 1; j <= 3; j++) {
                int quantity = random.nextInt(5) + 1;
                writer.write(salesmanId + ";Product" + j + ";" + quantity + "\n");
            }
        }

        writer.close();
    }

    public static void generateProducts(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        writer.write("Product1;Laptop;1000\n");
        writer.write("Product2;Mouse;50\n");
        writer.write("Product3;Teclado;80\n");

        writer.close();
    }

    public static void generateSalesmen(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        writer.write("1001;Juan Perez\n");
        writer.write("1002;Maria Gomez\n");
        writer.write("1003;Carlos Lopez\n");
        writer.write("1004;Ana Torres\n");

        writer.close();
    }
}

Agregando clase GenerateInfoFiles
