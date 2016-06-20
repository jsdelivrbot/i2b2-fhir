package edu.harvard.i2b2.fhir.converter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

public interface ConversionRepository extends CrudRepository<Conversion, String> {
    List<Conversion> findByCategory(String categoryName);
    
    List<Conversion> findByResourceNames(String resourceNames);
}