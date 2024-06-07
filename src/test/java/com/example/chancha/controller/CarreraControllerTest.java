package com.example.chancha.controller;

import com.example.chancha.domain.Carrera;
import com.example.chancha.service.CarreraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CarreraControllerTest {
    private final String URL_CARRERA = "";
    private final String apiGetAll = ""; //aca es donde pega para traer todas las carreras
    private static final List<Carrera> EMPTY_LIST = new ArrayList<>();
    private MockMvc mockMvc;

    @InjectMocks// (tengo que usar la anotacion para decir que lo que quiero testear)
    private CarreraController carreraController;
    @Mock //(la clase que vamos a mockear para ver su funcionalidad, al haber capas tenemos que crear un mock para evitar todos los new())
    private CarreraService carreraService;

    @BeforeEach
    void SetUp(){
        initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(carreraController).build();
    }

    @Test
    void given_no_get_method_endpoint_carreras_should_return_status_method_not_allowed(){
        //a nuestro atributo le decimos q metodo y la url y esperamos que devuelva not allowed
        this.mockMvc.perform(put(URL_CARRERA).andExpect(status().isMethodNotAllowed()));
        this.mockMvc.perform(delete(URL_CARRERA).andExpect(status().isMethodNotAllowed()));

    }

    @Test
    void endpoint_should_return_200_and_list_of_carreras(){
        when(carreraService.findAll()).thenReturn(EMPTY_LIST);
        MockHttpServletResponse response = this.mockMvc.perform(get(URL_CARRERAS).accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

        assertThat(response.getStatus).isEqualTo(HttpStatus.Ok);
        assertThat(response.getContentAsString()).isEqualTo(asJsonString(carreras));
    }


}