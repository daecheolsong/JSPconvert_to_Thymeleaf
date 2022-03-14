package jspbook.jspbook.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.io.Serializable;



@Getter @Setter @ToString
public class Product implements Serializable {

    private static final long serialVersionUID = -23423423234l;


    @Pattern(regexp = "/^P[0-9]{4,11}$/",message = "[상품코드]\nP와 숫자를 조합하여 5~12자까지 입력하세요\n첫 글자는 반드시 P로 시작하세요")
    private String productId;


    @Size(min = 4, max = 12, message = "4 ~ 12 사이의 문자를 입력해주세요")
    private String pname;


    @PositiveOrZero(message = "0이상의 숫자만 입력해주세요")
    private Integer unitPrice;

    private String description;
    private String manufacturer;

    private String category;
    @PositiveOrZero(message = "0 이상의 숫자만 입력해주세요")
    private Integer unitsInStock;
    private String condition;
    private String filename;
    public Product() {
    }



    public Product(String productId, String pname, Integer unitPrice) {
        this.productId = productId;
        this.pname = pname;
        this.unitPrice = unitPrice;
    }
}
