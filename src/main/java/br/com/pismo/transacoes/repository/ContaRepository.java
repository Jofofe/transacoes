package br.com.pismo.transacoes.repository;

import br.com.pismo.transacoes.domain.Conta;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

    Optional<Conta> findByNumDocumento(String numDocumento);

}
