package br.com.pismo.transacoes.service;

import br.com.pismo.transacoes.domain.BaseDomain;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public abstract class AbstractService<E extends BaseDomain, I extends Serializable, R extends CrudRepository<E, I>> {

    protected final R repository;

    AbstractService(R repository) {
        super();
        this.repository = repository;
    }

}
