package org.weewelchie.patients.service;

import org.weewelchie.patients.data.entities.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {


    public void save(Patient p);

    public Optional<Patient> getById(Long id);

    public void delete(Long id);

    public void addPatient(Patient patient);

    public List<Patient> getAll();


}
