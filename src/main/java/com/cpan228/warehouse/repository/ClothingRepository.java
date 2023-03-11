//Clothing repository created. 
package com.cpan228.warehouse.repository;

import com.cpan228.warehouse.model.Clothing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// necessary imports 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// interface implments common database CRUD opeartions 

public interface ClothingRepository extends JpaRepository<Clothing, Long> {
  // Custom query method for filtering by brand and year
  @Query("SELECT c FROM Clothing c WHERE c.brand = :brand AND c.yearProduced = :year")
  List<Clothing> findByBrandAndYear(@Param("brand") Clothing.BrandingName brand, @Param("year") int year);

}