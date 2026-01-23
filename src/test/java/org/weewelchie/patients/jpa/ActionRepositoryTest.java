package org.weewelchie.patients.jpa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.weewelchie.patients.data.entities.Action;
import org.weewelchie.patients.data.entities.Patient;
import org.weewelchie.patients.repositories.ActionJpaRepository;
import org.weewelchie.patients.repositories.PatientJPARepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest
public class ActionRepositoryTest {

    @Autowired
    private ActionJpaRepository actionJpaRepository;

    private Patient testPatient;

    private List<Action> actions;

    private static final String NHSNUMBER = "NHS112234345_";


    @BeforeEach
    public void setup()
    {
        //Create some Patient records.
        actions = new ArrayList<Action>();
        for(long i =0 ; i< 10; i++)
        {
            Action a = new Action();
            a.setActivity("TEST_" + i);
            a.setContext("TEST_CONTEXT_" + i);
            a.setPatientEntityId(i);
            a.setEntityVersion(1L);

            actions.add(a);
        }

        //Add testPatients to the DB
        for(Action a :actions)
        {
            actionJpaRepository.save(a);
        }
    }

    @Test
    public void findAll()
    {
        List<Action> results = actionJpaRepository.findAll();
        assertEquals(results.size(),10);
    }

    @Test
    public void addAction()
    {
        Action a = new Action();
        a.setActivity("TEST_9999");
        a.setContext("TEST_CONTEXT_9999" );
        a.setPatientEntityId(9999L);
        a.setEntityVersion(9999L);

        Action action = actionJpaRepository.save(a);
        assertEquals(a,action);
    }

    @Test
    public void findActionsByPatientEntitiy()
    {
        Long patientEntityId = 1L;
        List<Action> actions = actionJpaRepository.findAllByPatientEntityId(patientEntityId, Sort.by(Sort.Direction.ASC, "whenRecorded"));
        assertFalse(actions.isEmpty());
    }
}
