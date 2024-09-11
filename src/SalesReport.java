import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SalesReport {
    private static final String FILE_PATH = "/Users/macadmin/Downloads/IntelliJ/Day7/resources/product_sales_data.csv";
    private static final String DELIMITER = ",";
    private static final String DATA_HEADER = "Product Name,Total Sold,Item Price";

    public static List<Product> readProductFromCsV() throws IOException {
        List<Product> products = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));

        try{
            String header = br.readLine();
            if(header == null || !header.equalsIgnoreCase(DATA_HEADER)){
                throw new IllegalArgumentException(" Invalid CSV file format");
            }

        String line;
        while((line = br.readLine()) != null){
            String data[] = line.split(DELIMITER);
            if (data.length != 3){
                throw new IllegalArgumentException("Invalid CSV format. Expected 3 columns but got" + data.length);
            }
            products.add(createProduct(data));
            }}
        catch(IOException e){
            System.out.println("io exception" + e.getMessage());
        }
            catch (Exception e){
            System.out.println("Something went wrong" + e.getMessage());
        }
        return products;
    }


    private static Product createProduct(String[] values) {
            Product product = new Product();
            product.setName(values[0].trim());

            try {
                product.setPrice(Double.parseDouble(values[2]));
                product.setSold(Integer.parseInt(values[1]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("invalid product value. it should be " + values[1].trim());
            }
            return product;
        }

    private static void printSummary(List<Product> products){
        int totalSold = 0;
        BigDecimal totalSales = BigDecimal.ZERO;

        Product mostBought = null;
        Product leastBought = null;

        for(Product p: products){
        totalSales = totalSales.add(p.getSales());
        totalSold += p.getSold();

        if(mostBought == null || p.getSold() > mostBought.getSold()){
        mostBought = p;
        }

        if(leastBought == null || p.getSold() > mostBought.getSold()){
            leastBought = p;
        }}
            System.out.println("total sold: " + totalSold);
            System.out.println("total sales: " + totalSales);
            System.out.println("Most bought product: " + mostBought);
            System.out.println("Least bought product: " + leastBought);
        }


    public static void main(String[] args) throws IOException {
        List<Product> products = readProductFromCsV();
        for (Product p : products){
            System.out.println(p);
        }
        printSummary(products);
        long total = products.stream().count();
        System.out.println("total number of product in the list: " + total);

    }
}





