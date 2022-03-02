package jspbook.jspbook.repository;

import jspbook.jspbook.dto.Product;

import java.util.ArrayList;

public class ProductRepository {

    private ArrayList<Product> listOfProducts = new ArrayList<>();

    public ProductRepository() {

        Product phone = new Product("P1234", "iPhone6s", 800000);
        phone.setDescription("4-7 inch, HD display , Camera");
        phone.setCategory("Smart Phone");
        phone.setManufacturer("Apple");
        phone.setUnitsInStock(1000);
        phone.setCondition("new");

        Product noteBook = new Product("P1235", "LG PC Gram", 1500000);
        noteBook.setDescription("13-3 inch, LED Display, 5rd Generation");
        noteBook.setCondition("Refurbished");
        noteBook.setCategory("NoteBook");
        noteBook.setManufacturer("LG");
        noteBook.setUnitsInStock(1000);

        Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
        tablet.setDescription("Big inch Super AMOLED display Octa-Processor");
        tablet.setCategory("Tablet");
        tablet.setManufacturer("Samsung");
        tablet.setUnitsInStock(1000);
        tablet.setCondition("Old");

        listOfProducts.add(phone);
        listOfProducts.add(noteBook);
        listOfProducts.add(tablet);



    }

    public ArrayList<Product> getAllProducts() {
        return listOfProducts;
    }
}
