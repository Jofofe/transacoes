package br.com.pismo.transacoes.repository;

import br.com.pismo.transacoes.domain.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
}
