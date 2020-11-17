package br.com.pismo.transacoes.service;

import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.domain.TipoOperacao;
import br.com.pismo.transacoes.domain.Transacao;
import br.com.pismo.transacoes.dto.TransacaoFinanceiraDTO;
import br.com.pismo.transacoes.enums.EnumOperacaoMatematica;
import br.com.pismo.transacoes.exception.ContaNaoEncontradaException;
import br.com.pismo.transacoes.exception.CreditoNaoDisponivelException;
import br.com.pismo.transacoes.exception.NenhumaOperacaoEncontradaException;
import br.com.pismo.transacoes.repository.ContaRepository;
import br.com.pismo.transacoes.repository.TipoOperacaoRepository;
import br.com.pismo.transacoes.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Slf4j
@Service
public class TransacaoService extends AbstractService<Transacao, Integer, TransacaoRepository> {

    private final ContaRepository contaRepository;
    private final TipoOperacaoRepository tipoOperacaoRepository;


    TransacaoService(TransacaoRepository repository, ContaRepository contaRepository, TipoOperacaoRepository tipoOperacaoRepository) {
        super(repository);
        this.contaRepository = contaRepository;
        this.tipoOperacaoRepository = tipoOperacaoRepository;
    }

    @Transactional
    public void criarTransacao(TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        Conta conta = contaRepository.findById(transacaoFinanceiraDTO.getIdConta())
                .orElseThrow(ContaNaoEncontradaException::new);
        criarTransacaoConta(transacaoFinanceiraDTO, conta);
        contaRepository.save(conta);
    }

    private void criarTransacaoConta(TransacaoFinanceiraDTO transacaoFinanceiraDTO, Conta conta) {
        TipoOperacao tipoOperacao = tipoOperacaoRepository.findById(transacaoFinanceiraDTO.getIdOperacao())
                .orElseThrow(NenhumaOperacaoEncontradaException::new);
        if(tipoOperacao.getOperacaoMatematica() == EnumOperacaoMatematica.SUBTRACAO
                && conta.getCreditoDisponivel().compareTo(transacaoFinanceiraDTO.getValorTransacao()) == -1) {
            throw new CreditoNaoDisponivelException();
        }
        conta.addTransacao(Transacao.builder()
                .dataTransacao(new Date())
                .valorTransacao(transacaoFinanceiraDTO.getValorTransacao()
                        .multiply(BigDecimal.valueOf(tipoOperacao.getOperacaoMatematica().getNumeroOperacao())))

                .tipoOperacao(tipoOperacao)
                .build());
        if(tipoOperacao.getOperacaoMatematica() == EnumOperacaoMatematica.ADICAO) {
            conta.setCreditoDisponivel(conta.getCreditoDisponivel().add(transacaoFinanceiraDTO.getValorTransacao()));
        } else {
            conta.setCreditoDisponivel(conta.getCreditoDisponivel().subtract(transacaoFinanceiraDTO.getValorTransacao()));
        }
    }
}
