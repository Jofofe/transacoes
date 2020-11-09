package br.com.pismo.transacoes.repository;

import br.com.pismo.transacoes.domain.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Integer> {
}
