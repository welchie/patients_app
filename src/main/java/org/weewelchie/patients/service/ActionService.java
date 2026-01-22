package org.weewelchie.patients.service;

import org.weewelchie.patients.data.entities.Action;

import java.util.Optional;
import java.util.List;

public interface ActionService {

    public void save(Action a);

    public Optional<Action> getById(Long id);

    public void delete(Long id);

    public void addAction(Action action);

    public List<Action> getAllByPatientEntityId(Long id);

    public List<Action> getAll();

}
