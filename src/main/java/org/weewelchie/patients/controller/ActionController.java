package org.weewelchie.patients.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.weewelchie.patients.data.entities.Action;
import org.weewelchie.patients.service.ActionService;

import java.util.List;

@RestController
public class ActionController {

    private final ActionService actionService;

    public ActionController(ActionService actionService)
    {
        this.actionService = actionService;
    }

    @GetMapping("action/byPatientEntityID/{id}")
    public List<Action> getActionsByPatientEntityId(@PathVariable("id") Long id)
    {
        return actionService.getAllByPatientEntityId(id);
    }

    @GetMapping("/action/all")
    public List<Action> getAllActions()
    {
        return actionService.getAll();
    }

}
