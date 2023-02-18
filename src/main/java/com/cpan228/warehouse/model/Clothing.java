package com.cpan228.warehouse.model;
import lombok.Data;
import lombok.Builder;
@Builder
@Data
public class Clothing {
  private int id;
  private String name;
  private int yearProduced;
  private double price;
  private BrandingName brand;

  public static Clothing createClothing(String name, int yearProduced, double price, BrandingName brand) {
    return Clothing.builder()
      .name(name)
      .yearProduced(yearProduced)
      .price(price)
      .brand(brand)
      .build();
  }
  public enum BrandingName {
    NIKE("Nike"),
    ADIDAS("Adidas"),
    PUMA("Puma"),
    REEBOK("Reebok"),
    UNDER_ARMOUR("Under Armour"),
    NEW_BALANCE("New Balance");

    private String title;

    BrandingName(String title) {
      this.title = title;
    }

    public String getTitle() {
      return title;
    }
  }
}
