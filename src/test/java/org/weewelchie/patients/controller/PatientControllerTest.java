package org.weewelchie.patients.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.autoconfigure.JacksonProperties;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.weewelchie.patients.data.entities.Patient;
import org.weewelchie.patients.service.PatientService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PatientController.class)
public class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private Patient patient;

    @MockitoBean
    private PatientService patientService;

    private List<Patient> patients;
    private Patient testPatient;

    private static final String NHSNUMBER = "NHS123456_";

    @BeforeEach
    public void setUp()
    {
        //Create a fresh set of test data
        patients = new ArrayList<Patient>();
        for(int i =0 ; i< 10; i++)
        {
            Patient p = new Patient();
            p.setDateOfBirth(new Date("01/01/2020"));
            p.setFamilyName("Smith");
            p.setGivenName("John" + i);
            p.setGender("MALE");
            p.setHospitalID("EDI_ROYAL");
            p.setNhsNumber(NHSNUMBER + i);

            patients.add(p);
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
    public void getPatients() throws Exception {

        when(patientService.getAll()).thenReturn(patients);
        mockMvc.perform(get("/patients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getPatientByID() throws Exception
    {
        when(patientService.getById(1L)).thenReturn(Optional.ofNullable(testPatient));
        MvcResult p = mockMvc.perform(get("/patients/{id}","1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultContents = p.getResponse().getContentAsString();
        assertTrue(resultContents.contains(testPatient.getFamilyName()));
        assertTrue(resultContents.contains(testPatient.getGivenName()));
        assertTrue(resultContents.contains(testPatient.getGender()));
        assertTrue(resultContents.contains(testPatient.getHospitalID()));
        assertTrue(resultContents.contains(testPatient.getNhsNumber()));
    }

    @Test
    public void getPatientByID_NotFound() throws Exception
    {
        when(patientService.getById(1L)).thenReturn(Optional.ofNullable(testPatient));
        MvcResult p = mockMvc.perform(get("/patients/{id}","99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String result = p.getResponse().getContentAsString();
        assertTrue(result.isEmpty());
    }

}
