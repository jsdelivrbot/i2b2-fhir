package edu.harvard.i2b2.fhirServerApi.jba.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Role,Integer>{

}