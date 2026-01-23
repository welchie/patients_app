package org.weewelchie.patients.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.weewelchie.patients.data.entities.Action;

import java.util.List;

public interface ActionJpaRepository extends JpaRepository<Action, Long> {


    public List<Action> findAllByPatientEntityId(Long id, Sort whenRecorded);
}
