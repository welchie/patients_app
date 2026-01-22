package org.weewelchie.patients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.weewelchie.patients.data.entities.Patient;
import org.weewelchie.patients.service.PatientService;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }


    /**
     * Lists all Patients
     */
    @GetMapping("/patients")
    public List<Patient> getPatients()
    {
        return patientService.getAll();
    }

    @GetMapping("patients/{id}")
    public Patient getPatient(@PathVariable("id") Long id)
    {
        Optional<Patient> patient = patientService.getById(id);
        if (patient.isPresent())
        {
            return  patient.get();
        }
        else
        {
            return null;
        }
    }

    @GetMapping("patients/filter/{sortCriteria}")
    public List<Patient> getPatientsBy(@PathVariable("sortCriteria") String sortCriteria)
    {
        List<Patient> patients = new ArrayList<Patient>();
        return patients;
    }

}
