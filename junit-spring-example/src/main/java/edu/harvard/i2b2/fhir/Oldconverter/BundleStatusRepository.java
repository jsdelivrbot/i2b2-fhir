package edu.harvard.i2b2.fhir.Oldconverter;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BundleStatusRepository extends CrudRepository<BundleStatus, Long> {

    List<BundleStatus> findByPatientId(String patientId);
}
