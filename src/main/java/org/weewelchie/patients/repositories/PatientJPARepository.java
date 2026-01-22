package org.weewelchie.patients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.weewelchie.patients.data.entities.Patient;

public interface PatientJPARepository extends JpaRepository<Patient, Long> {
}
