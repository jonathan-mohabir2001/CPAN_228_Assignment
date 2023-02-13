package com.cpan228.warehouse.model;

import lombok.Data;

import java.util.Arrays;

import lombok.Builder;

@Builder
@Data
public class Clothing {

  private int id;
  private String name;
  private int yearProduced;
  private double price;
  private BrandingName brand;

  public Clothing(int id, String name, int yearProduced, double price, BrandingName brand) {
    if (price <= 1000) {
      throw new IllegalArgumentException("Price must be more than 1000");
    }
    if (yearProduced <= 2021) {
      throw new IllegalArgumentException("Year of production must be more than 2021");
    }
    if (!Arrays.asList(BrandingName.values()).contains(brand)) {
      throw new IllegalArgumentException("Invalid brand name, must be one of: " + Arrays.asList(BrandingName.values()));
    }
    this.id = id;
    this.name = name;
    this.yearProduced = yearProduced;
    this.price = price;
    this.brand = brand;
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
