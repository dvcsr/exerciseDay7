import javax.xml.namespace.QName;
import java.math.BigDecimal;

public class Product {
//field
    private String name;
    private double price;
    private int sold;

    //method
    //1 constructor
    public Product(){

    }
    public Product(String name, long price, int sold){
        this.name = name;
        this.price = price;
        this.sold = sold;
    }



    //2 getters
    public BigDecimal getSales(){
        BigDecimal sales = BigDecimal.valueOf(price).multiply(BigDecimal.valueOf(sold));
        return sales;
    }
    //getters
    public int getSold(){
        return sold;
    }
    public double getPrice(){
        return price;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }

    public void setSold(int sold){
        if(sold < 0){
            throw new IllegalArgumentException("Sold can't be negative");
        }
        this.sold = sold;
    }

    //show/report
    public String toString(){
        return "Product [name= " + name + ", price= " + price + ", sold=" + sold + " ]";
    }


}
