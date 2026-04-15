import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            processData("SalesMenData.txt", "ProductsData.txt", "SalesManInfoData.txt");
            System.out.println("Reportes generados correctamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void processData(String salesFile, String productsFile, String salesmenFile) throws IOException {

        Map<String, Integer> salesBySeller = new HashMap<>();
        Map<String, Integer> productQuantity = new HashMap<>();
        Map<String, Integer> productPrice = new HashMap<>();
        Map<String, String> productName = new HashMap<>();
        Map<String, String> sellerName = new HashMap<>();

        BufferedReader br;
        String line;

        // Leer productos
        br = new BufferedReader(new FileReader(productsFile));
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            productName.put(parts[0], parts[1]);
            productPrice.put(parts[0], Integer.parseInt(parts[2]));
        }
        br.close();

        // Leer vendedores
        br = new BufferedReader(new FileReader(salesmenFile));
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            sellerName.put(parts[0], parts[1]);
        }
        br.close();

        // Leer ventas
        br = new BufferedReader(new FileReader(salesFile));
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");

            String sellerId = parts[0];
            String productId = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            int totalSale = quantity * productPrice.get(productId);

            salesBySeller.put(sellerId,
                salesBySeller.getOrDefault(sellerId, 0) + totalSale);

            productQuantity.put(productId,
                productQuantity.getOrDefault(productId, 0) + quantity);
        }
        br.close();

        // Reporte vendedores
        List<Map.Entry<String, Integer>> sellers = new ArrayList<>(salesBySeller.entrySet());
        sellers.sort((a, b) -> b.getValue() - a.getValue());

        PrintWriter writer = new PrintWriter("SalesReport.csv");
        for (Map.Entry<String, Integer> entry : sellers) {
            writer.println(sellerName.get(entry.getKey()) + ";" + entry.getValue());
        }
        writer.close();

        // Reporte productos
        List<Map.Entry<String, Integer>> products = new ArrayList<>(productQuantity.entrySet());
        products.sort((a, b) -> b.getValue() - a.getValue());

        writer = new PrintWriter("ProductSales.csv");
        for (Map.Entry<String, Integer> entry : products) {
            writer.println(productName.get(entry.getKey()) + ";" + entry.getValue());
        }
        writer.close();
    }
}
Agregando clase Main
