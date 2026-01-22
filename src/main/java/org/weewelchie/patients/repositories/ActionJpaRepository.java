package org.weewelchie.patients.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.weewelchie.patients.data.entities.Action;

import java.util.List;
import java.util.Optional;

public interface ActionJpaRepository extends JpaRepository<Action, Long> {


    public List<Action> findAllByPatientEntityId(Long patientEntityId);
}
