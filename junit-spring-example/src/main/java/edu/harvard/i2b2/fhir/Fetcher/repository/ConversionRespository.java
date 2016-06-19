package edu.harvard.i2b2.fhir.Fetcher.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.Fetcher.entity.Conversion;

public interface ConversionRespository extends CrudRepository<Conversion, String> {
    List<Conversion> findByCategory(String categoryName);
}