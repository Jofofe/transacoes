package br.com.pismo.transacoes.service;

import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.dto.InformacaoContaDTO;
import br.com.pismo.transacoes.exception.ContaExistenteException;
import br.com.pismo.transacoes.exception.ContaNaoEncontradaException;
import br.com.pismo.transacoes.exception.LimiteNegativoException;
import br.com.pismo.transacoes.repository.ContaRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
public class ContaService extends AbstractService<Conta, Integer, ContaRepository> {

    ContaService(ContaRepository repository) {
        super(repository);
    }

    @Transactional
    public void incluirConta(InformacaoContaDTO informacaoConta) {
        if(informacaoConta.getValorCredito().compareTo(BigDecimal.ZERO) < 0) {
            throw new LimiteNegativoException();
        }
        if(!repository.findByNumDocumento(informacaoConta.getNumDocumento()).isPresent()) {
            repository.save(Conta.builder().numDocumento(informacaoConta.getNumDocumento())
                    .creditoDisponivel(informacaoConta.getValorCredito()).build());
        } else {
            throw new ContaExistenteException();
        }
    }

    @Transactional
    public Conta buscarConta(Integer id) {
        Conta conta = repository.findById(id).orElseThrow(ContaNaoEncontradaException::new);
        Hibernate.initialize(conta.getTransacoes());
        return conta;
    }

}
