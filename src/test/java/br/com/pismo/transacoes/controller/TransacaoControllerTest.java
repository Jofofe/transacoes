package br.com.pismo.transacoes.controller;

import br.com.pismo.transacoes.TransacoesApplication;
import br.com.pismo.transacoes.dto.ContaDTO;
import br.com.pismo.transacoes.dto.TransacaoFinanceiraDTO;
import br.com.pismo.transacoes.exception.ContaNaoEncontradaException;
import br.com.pismo.transacoes.exception.NenhumaOperacaoEncontradaException;
import br.com.pismo.transacoes.util.Util;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TransacoesApplication.class})
public class TransacaoControllerTest extends AbstractBaseControllerTest  {

    @Test
    public void testarCriarTransacao() throws Exception {
        mockMvc.perform(post("/transacao")
                .content(new Gson().toJson(TransacaoFinanceiraDTO.builder()
                        .idConta(1)
                        .idOperacao(4)
                        .valorTransacao(BigDecimal.valueOf(2000))
                        .build())
                        .getBytes())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testarCriarTransacaoComContaNaoEncontrada() throws Exception {
        mockMvc.perform(post("/transacao")
                .content(new Gson().toJson(TransacaoFinanceiraDTO.builder()
                        .idConta(13)
                        .idOperacao(4)
                        .valorTransacao(BigDecimal.valueOf(2000))
                        .build())
                        .getBytes())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testarCriarTransacaoComNenhumaOperacaoEncontrada() throws Exception {
        mockMvc.perform(post("/transacao")
                .content(new Gson().toJson(TransacaoFinanceiraDTO.builder()
                        .idConta(1)
                        .idOperacao(5)
                        .valorTransacao(BigDecimal.valueOf(2000))
                        .build())
                        .getBytes())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
        )
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

}
