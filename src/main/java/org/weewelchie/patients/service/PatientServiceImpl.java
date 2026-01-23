package org.weewelchie.patients.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.weewelchie.patients.data.entities.Patient;
import org.weewelchie.patients.repositories.PatientJPARepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientJPARepository patientJPARepository;

    public PatientServiceImpl(PatientJPARepository repo)
    {
        this.patientJPARepository = repo;
    }
    @Override
    public void save(Patient p) {
        patientJPARepository.save(p);
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return patientJPARepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        patientJPARepository.deleteById(id);

    }

    @Override
    public void addPatient(Patient patient) {
        patientJPARepository.save(patient);

    }

    @Override
    public List<Patient> getAll() {

        return patientJPARepository.findAll(Sort.by(Sort.Direction.ASC, "familyName"));
    }
}
