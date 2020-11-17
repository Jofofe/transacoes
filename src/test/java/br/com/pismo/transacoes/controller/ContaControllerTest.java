package br.com.pismo.transacoes.controller;

import br.com.pismo.transacoes.TransacoesApplication;
import br.com.pismo.transacoes.dto.ContaDTO;
import br.com.pismo.transacoes.util.Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.gson.Gson;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TransacoesApplication.class})
public class ContaControllerTest extends AbstractBaseControllerTest {

    @Test
    public void testarBuscarConta() throws Exception {
        mockMvc.perform(get("/conta/" + 1).accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testarBuscarContaNaoEncontrada() throws Exception {
        mockMvc.perform(get("/conta/" + 13).accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testarIncluirConta() throws Exception {
        mockMvc.perform(post("/conta")
                .content(new Gson().toJson(ContaDTO.builder().numDocumento("131313").build()).getBytes())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(Util.statusMatcher);
    }

    @Test
    public void testarIncluirContaComCreditoNegativo() throws Exception {
        mockMvc.perform(post("/conta")
                .content(new Gson().toJson(ContaDTO.builder().numDocumento("131313")
                        .creditoDisponivel(BigDecimal.valueOf(-2000)).build()).getBytes())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
