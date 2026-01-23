package org.weewelchie.patients.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.weewelchie.patients.data.entities.Action;
import org.weewelchie.patients.service.ActionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ActionController.class)
public class ActionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private Action action;

    @MockitoBean
    private ActionService actionService;

    private List<Action> actions = new ArrayList<Action>();

    @Test
    public void getAllActions() throws Exception
    {
        when(actionService.getAll()).thenReturn(actions);
        mockMvc.perform(get("/action/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetActionsByPatientID() throws Exception
    {
        when(actionService.getAllByPatientEntityId(1L)).thenReturn(actions);
        mockMvc.perform(get("/action/byPatientEntityID/{id}","1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetActionsByPatientID_NotFound() throws Exception
    {
        when(actionService.getAllByPatientEntityId(1L)).thenReturn(actions);
        MvcResult p = mockMvc.perform(get("/action/byPatientEntityID/{id}","99")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String result = p.getResponse().getContentAsString();
        assertTrue(result.equals("[]"));
    }

}
