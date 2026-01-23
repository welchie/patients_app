package org.weewelchie.patients.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.weewelchie.patients.data.entities.Action;
import org.weewelchie.patients.repositories.ActionJpaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ActionServiceImpl implements ActionService{

    private final ActionJpaRepository actionJpaRepository;

    public ActionServiceImpl(ActionJpaRepository repo)
    {
        this.actionJpaRepository = repo;
    }
    @Override
    public void save(Action a) {
        actionJpaRepository.save(a);
    }

    @Override
    public Optional<Action> getById(Long id) {
        return actionJpaRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        actionJpaRepository.deleteById(id);
    }

    @Override
    public void addAction(Action action) {
        actionJpaRepository.save(action);
    }

    @Override
    public List<Action> getAllByPatientEntityId(Long id) {

        List<Action> actions = actionJpaRepository.findAllByPatientEntityId(id, Sort.by(Sort.Direction.ASC, "whenRecorded"));
        return actions;
    }

    @Override
    public List<Action> getAll() {

        return actionJpaRepository.findAll(Sort.by(Sort.Direction.ASC, "whenRecorded"));
    }
}
