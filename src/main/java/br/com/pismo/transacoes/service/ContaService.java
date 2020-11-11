package br.com.pismo.transacoes.service;

import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.exception.ContaExistenteException;
import br.com.pismo.transacoes.exception.ContaNaoEncontradaException;
import br.com.pismo.transacoes.repository.ContaRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ContaService extends AbstractService<Conta, Integer, ContaRepository> {

    ContaService(ContaRepository repository) {
        super(repository);
    }

    @Transactional
    public void incluirConta(Conta conta) {
        if(!repository.findByNumDocumento(conta.getNumDocumento()).isPresent()) {
            repository.save(conta);
        } else {
            throw new ContaExistenteException();
        }
    }

    public Conta buscarConta(Integer id) {
        Conta conta = repository.findById(id).orElseThrow(ContaNaoEncontradaException::new);
        Hibernate.initialize(conta.getTransacoes());
        return conta;
    }

}
