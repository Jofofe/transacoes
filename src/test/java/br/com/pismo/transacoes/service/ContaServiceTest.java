package br.com.pismo.transacoes.service;

import br.com.pismo.transacoes.TransacoesApplication;
import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.exception.ContaNaoEncontradaException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {TransacoesApplication.class, ContaService.class})
public class ContaServiceTest {

    @Autowired
    private ContaService contaService;

    @Test
    public void testarBuscarConta() {
        Conta conta = contaService.buscarConta(1);
        Assert.assertNotNull(conta);
    }

    @Test
    public void testarIncluirConta() {
        contaService.incluirConta(Conta.builder().numDocumento("1313").build());
    }

    @Test(expected = ContaNaoEncontradaException.class)
    public void testarBuscarContaNaoEncontrada() {
        contaService.buscarConta(13);
    }

}
