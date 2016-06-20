package edu.harvard.i2b2.fhir.fetcher.fetchstatus;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.converter.Conversion;


public interface FetchStatusRespository extends CrudRepository<FetchStatus, String> {
    List<Conversion> findById(String id);
}