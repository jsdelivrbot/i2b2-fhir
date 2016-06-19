package edu.harvard.i2b2.fhir.Fetcher.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import edu.harvard.i2b2.fhir.Fetcher.entity.Conversion;
import edu.harvard.i2b2.fhir.Fetcher.entity.FetchStatus;


public interface FetchStatusRespository extends CrudRepository<FetchStatus, String> {
    List<Conversion> findById(String id);
}