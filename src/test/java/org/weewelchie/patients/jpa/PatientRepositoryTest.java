package org.weewelchie.patients.jpa;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.weewelchie.patients.data.entities.Patient;
import org.weewelchie.patients.repositories.PatientJPARepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private PatientJPARepository patientJPARepository;

    private Patient testPatient;

    private List<Patient> testPatients;

    private static final String NHSNUMBER = "NHS112234345_";

    @BeforeEach
    public void setup()
    {
        //Create some Patient records.
        testPatients = new ArrayList<Patient>();
        for(int i =0 ; i< 10; i++)
        {
            Patient p = new Patient();
            p.setDateOfBirth(new Date("01/01/2020"));
            p.setFamilyName("Smith");
            p.setGivenName("John" + i);
            p.setGender("MALE");
            p.setHospitalID("EDI_ROYAL");
            p.setNhsNumber(NHSNUMBER + i);

            testPatients.add(p);
        }

        //Add testPatients to the DB
        for(Patient p :testPatients)
        {
            patientJPARepository.save(p);
        }

        testPatient = new Patient();
        testPatient.setDateOfBirth(new Date("21/08/1969"));
        testPatient.setFamilyName("Jones");
        testPatient.setGivenName("Jenny");
        testPatient.setGender("FEMALE");
        testPatient.setHospitalID("GLA_INFIRMARY");
        testPatient.setNhsNumber(NHSNUMBER + "987654321");
    }

    @Test
    public void createNewPatient()
    {
        Patient p = patientJPARepository.save(testPatient);
        assertEquals(p,testPatient);
    }

    @Test
    public void getAll()
    {
        List<Patient> patients = patientJPARepository.findAll();
        assertEquals(patients.size(), testPatients.size());
    }

    @Test
    public void updatePatient() {
        testPatient = patientJPARepository.save(testPatient);
        Optional<Patient> patient = patientJPARepository.findById(testPatient.getEntityId());

        if(patient.isPresent()) {
            Patient p = patient.get();

            p.setGender("MALE");
            p.setGivenName("Joe");
            p.setFamilyName("Bloggs");
            p.setDateOfBirth(new Date("01/01/2025"));
            p.setHospitalID("TEST");
            p.setNhsNumber(NHSNUMBER + "9999");

            p = patientJPARepository.save(p);

            //Check that updates have been stored.
            assertEquals(p.getFamilyName(), "Bloggs");
            assertEquals(p.getGivenName(), "Joe");
            assertEquals(p.getGender(), "MALE");
            assertEquals(p.getDateOfBirth(), new Date("01/01/2025"));
            assertEquals(p.getHospitalID(), "TEST");
            assertEquals(p.getNhsNumber(), NHSNUMBER + "9999");
        }
    }



}
