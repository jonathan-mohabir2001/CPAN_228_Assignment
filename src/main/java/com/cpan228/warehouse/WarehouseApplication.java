//ASSIGNMENT 02 UPDATED WarehouseApplication.java file - The commandLine Runner is configured here 
package com.cpan228.warehouse;

//NECESSARY IMPORTS 
import com.cpan228.warehouse.model.Clothing;
import com.cpan228.warehouse.repository.ClothingRepository;
import org.springframework.boot.CommandLineRunner;
// command line runner import
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// bean annotation import

@SpringBootApplication
public class WarehouseApplication {

  public static void main(String[] args) {
    SpringApplication.run(WarehouseApplication.class, args);
  }

  // command line runner method to populate the database with some data
  @Bean
  public CommandLineRunner loadData(ClothingRepository repository) {
    return args -> {
      Clothing c1 = Clothing.createClothing("Nike", 2022, 10.0, Clothing.BrandingName.NIKE);
      Clothing c2 = Clothing.createClothing("Adidas", 2021, 5.0, Clothing.BrandingName.ADIDAS);
      repository.save(c1);
      repository.save(c2);
    };
  }

}
