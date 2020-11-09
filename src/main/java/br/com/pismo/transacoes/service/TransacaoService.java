package br.com.pismo.transacoes.service;

import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.domain.TipoOperacao;
import br.com.pismo.transacoes.domain.Transacao;
import br.com.pismo.transacoes.dto.TransacaoFinanceiraDTO;
import br.com.pismo.transacoes.enums.Operacao;
import br.com.pismo.transacoes.exception.ContaNaoEncontradaException;
import br.com.pismo.transacoes.repository.ContaRepository;
import br.com.pismo.transacoes.repository.TransacaoRepository;

import java.util.Date;

public class TransacaoService extends AbstractService<Transacao, Integer, TransacaoRepository> {

    private final ContaRepository contaRepository;

    TransacaoService(TransacaoRepository repository, ContaRepository contaRepository) {
        super(repository);
        this.contaRepository = contaRepository;
    }

    public void criarTransacao(TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        Conta conta = contaRepository.findById(transacaoFinanceiraDTO.getIdConta())
                .orElseThrow(ContaNaoEncontradaException::new);
        criarTransacaoConta(transacaoFinanceiraDTO, conta);
        contaRepository.save(conta);
    }

    private void criarTransacaoConta(TransacaoFinanceiraDTO transacaoFinanceiraDTO, Conta conta) {
        conta.addTransacao(Transacao.builder()
                .dataTransacao(new Date())
                .valorTransacao(transacaoFinanceiraDTO.getValorTransacao())
                .tipoOperacao(new TipoOperacao(Operacao.valueOfById(transacaoFinanceiraDTO.getIdOperacao())))
                .build());
    }
}
