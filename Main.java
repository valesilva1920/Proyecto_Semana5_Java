import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader ventas = new BufferedReader(new FileReader("ventas.txt"));

            String linea;
            HashMap<Integer, Integer> ventasPorVendedor = new HashMap<>();
            HashMap<Integer, Integer> ventasPorProducto = new HashMap<>();

            while ((linea = ventas.readLine()) != null) {
                String[] datos = linea.split(",");

                int vendedor = Integer.parseInt(datos[0]);
                int producto = Integer.parseInt(datos[1]);
                int cantidad = Integer.parseInt(datos[2]);

                ventasPorVendedor.put(vendedor,
                        ventasPorVendedor.getOrDefault(vendedor, 0) + cantidad);

                ventasPorProducto.put(producto,
                        ventasPorProducto.getOrDefault(producto, 0) + cantidad);
            }

            ventas.close();

            // Reporte vendedores
            FileWriter reporteVentas = new FileWriter("SalesReport.csv");

            for (Integer v : ventasPorVendedor.keySet()) {
                reporteVentas.write("Vendedor " + v + "," + ventasPorVendedor.get(v) + "\n");
            }

            reporteVentas.close();

            // Reporte productos
            FileWriter reporteProductos = new FileWriter("ProductSales.csv");

            for (Integer p : ventasPorProducto.keySet()) {
                reporteProductos.write("Producto " + p + "," + ventasPorProducto.get(p) + "\n");
            }

            reporteProductos.close();

            System.out.println("Proceso finalizado correctamente");

        } catch (Exception e) {
            System.out.println("Error en el procesamiento de archivos");
        }
    }
}
