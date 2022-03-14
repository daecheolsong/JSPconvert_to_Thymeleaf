package jspbook.jspbook.bundles;

import java.util.ListResourceBundle;

public class Message extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"title", "상품 등록"},
            {"productId", "상품 코드"},
            {"pname" , "상품명"},
            {"unitPrice" , "가격"},
            {"description" , "상세 설명"},
            {"manufacturer" , "제조사"},
            {"category" , "분류"},
            {"unitsInStock" , "재고 수"},
            {"condition" , "상태"},
            {"productImage" , "이미지"},
            {"condition_New" , "신규 제품"},
            {"condition_Old" , "중고 제품"},
            {"condition_Refurbished" , "재생 제품"},
            {"button" , "등록"}

    };
}
