package jspbook.jspbook.dto;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;



@Getter @Setter
public class Product implements Serializable {

    private static final long serialVersionUID = -23423423234l;

    private String productId;
    private String pname;
    private Integer unitPrice;
    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private String condition;

    public Product() {
    }



    public Product(String productId, String pname, Integer unitPrice) {
        this.productId = productId;
        this.pname = pname;
        this.unitPrice = unitPrice;
    }
}
