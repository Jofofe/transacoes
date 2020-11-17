package br.com.pismo.transacoes.service;

import br.com.pismo.transacoes.TransacoesApplication;
import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.dto.TransacaoFinanceiraDTO;
import br.com.pismo.transacoes.exception.ContaNaoEncontradaException;
import br.com.pismo.transacoes.exception.CreditoNaoDisponivelException;
import br.com.pismo.transacoes.exception.NenhumaOperacaoEncontradaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TransacoesApplication.class, TransacaoService.class})
public class TransacaoServiceTest {

    @Autowired
    private TransacaoService transacaoService;

    @Test
    public void testarCriarTransacao() {
        transacaoService.criarTransacao(TransacaoFinanceiraDTO.builder()
                .idConta(1)
                .idOperacao(4)
                .valorTransacao(BigDecimal.valueOf(2000))
                .build());
    }

    @Test(expected = ContaNaoEncontradaException.class)
    public void testarCriarTransacaoComContaNaoEncontrada() {
        transacaoService.criarTransacao(TransacaoFinanceiraDTO.builder()
                .idConta(13)
                .idOperacao(4)
                .valorTransacao(BigDecimal.valueOf(2000))
                .build());
    }

    @Test(expected = NenhumaOperacaoEncontradaException.class)
    public void testarCriarTransacaoComNenhumaOperacaoEncontrada() {
        transacaoService.criarTransacao(TransacaoFinanceiraDTO.builder()
                .idConta(1)
                .idOperacao(5)
                .valorTransacao(BigDecimal.valueOf(2000))
                .build());
    }

    @Test(expected = CreditoNaoDisponivelException.class)
    public void testarCriarTransacaoComCreditoNaoDisponivel() {
        transacaoService.criarTransacao(TransacaoFinanceiraDTO.builder()
                .idConta(1)
                .idOperacao(1)
                .valorTransacao(BigDecimal.valueOf(3000))
                .build());
    }

}
