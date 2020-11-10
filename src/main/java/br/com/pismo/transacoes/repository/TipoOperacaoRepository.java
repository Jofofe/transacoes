package br.com.pismo.transacoes.repository;

import br.com.pismo.transacoes.domain.TipoOperacao;
import org.springframework.data.repository.CrudRepository;

public interface TipoOperacaoRepository extends CrudRepository<TipoOperacao, Integer> {
}
