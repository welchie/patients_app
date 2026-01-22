package org.weewelchie.patients.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.weewelchie.patients.data.entities.Patient;
import org.weewelchie.patients.service.ActionService;
import org.weewelchie.patients.service.PatientService;

@Controller
public class ViewController {

    private final PatientService patientService;
    private final ActionService actionService;

    public ViewController(PatientService ps, ActionService actionService)
    {
        this.patientService = ps;
        this.actionService = actionService;
    }


    /**
     * Get all patients to be displayed on initial page.
     * @param model
     * @return - returns navigation to patients.html page.
     */
    @GetMapping("/")
    public String listPatients(Model model) {
        model.addAttribute("patients", patientService.getAll());
        return "patients";
    }

    /**
     * Controller to server the individual patient details. This will include retrieving the list of actions for the patient.
     * @param id - Patient Entity ID
     * @param model - Model to be used by Thymeleaf for rendering the data
     * @return - navigates to the patient details page.
     */
    @GetMapping("/patientdetail/{id}")
    public String patientDetail(@PathVariable("id") Long id, Model model) {
        Patient patient = patientService.getById(id).get();
        model.addAttribute("patient",patient );
        model.addAttribute("actions",actionService.getAllByPatientEntityId(patient.getEntityId()));


        return "patient_detail";
    }
}
