package jspbook.jspbook.bundles;

import java.util.ListResourceBundle;

public class Message_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    static final Object[][] contents = {
            {"title", "Product Addition"},
            {"productId", "Product ID"},
            {"pname" , "Name"},
            {"unitPrice" , "Unit Price"},
            {"description" , "Description"},
            {"manufacturer" , "Manufacturer"},
            {"category" , "Category"},
            {"unitsInStock" , "Units in Stock"},
            {"condition" , "Condition"},
            {"productImage" , "Image"},
            {"condition_New" , "New"},
            {"condition_Old" , "Old"},
            {"condition_Refurbished" , "Refurbished"},
            {"button" , "Insert"}

    };
}
