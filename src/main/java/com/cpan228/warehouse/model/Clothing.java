//UPDATED Model Clothing.Java file 

package com.cpan228.warehouse.model;

// lombok for saving time on boilerplate code 
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

// Jakarta Persistence API for ensuring that the data is stored in the database
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // annotate this class as a JPA entity
@Table(name = "clothing") // specify the table name for this entity
@Data
@Builder
public class Clothing {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "year_produced")
  private int yearProduced;

  @Column(name = "price")
  private double price;

  @Enumerated(EnumType.STRING) // specify that this field should be stored as a string in the database
  @Column(name = "brand")
  private BrandingName brand;

  // Method to create a clothing object with the builder pattern
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
