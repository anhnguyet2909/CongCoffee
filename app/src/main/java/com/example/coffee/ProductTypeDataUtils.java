package com.example.coffee;

public class ProductTypeDataUtils {
    public static ProductType[] getProductType(){
        ProductType pt1=new ProductType(1,"Đặc biệt");
        ProductType pt2=new ProductType(2,"Cafe");
        ProductType pt3=new ProductType(3,"Trà");
        ProductType pt4=new ProductType(4,"Sữa chua");
        ProductType pt5=new ProductType(5,"Trái cây");
        ProductType pt6=new ProductType(6,"Đồ ăn vặt");
        return new ProductType[]{pt1, pt2, pt3, pt4, pt5, pt6};
    }
}
