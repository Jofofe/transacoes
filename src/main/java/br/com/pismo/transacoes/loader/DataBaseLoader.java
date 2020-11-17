package br.com.pismo.transacoes.loader;

import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.domain.TipoOperacao;
import br.com.pismo.transacoes.domain.Transacao;
import br.com.pismo.transacoes.enums.EnumOperacaoMatematica;
import br.com.pismo.transacoes.repository.ContaRepository;
import br.com.pismo.transacoes.repository.TipoOperacaoRepository;
import br.com.pismo.transacoes.repository.TransacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final TipoOperacaoRepository tipoOperacaoRepository;
	private final ContaRepository contaRepository;

	public DataBaseLoader(TipoOperacaoRepository tipoOperacaoRepository,
						  ContaRepository contaRepository) {
		this.tipoOperacaoRepository = tipoOperacaoRepository;
		this.contaRepository = contaRepository;
	}

	@Override
	public void run(String... strings) {
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(1).descricao("COMPRA A VISTA")
				.operacaoMatematica(EnumOperacaoMatematica.SUBTRACAO).build());
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(2).descricao("COMPRA PARCELADA")
				.operacaoMatematica(EnumOperacaoMatematica.SUBTRACAO).build());
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(3).descricao("SAQUE")
				.operacaoMatematica(EnumOperacaoMatematica.SUBTRACAO).build());
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(4).descricao("PAGAMENTO")
				.operacaoMatematica(EnumOperacaoMatematica.ADICAO).build());

		Conta conta = Conta.builder().numDocumento("16031880").creditoDisponivel(BigDecimal.valueOf(2000)).build();
		conta.addTransacao(Transacao.builder()
				.tipoOperacao(this.tipoOperacaoRepository.findById(4).get())
				.valorTransacao(new BigDecimal(2000))
				.dataTransacao(new Date())
				.build());
		this.contaRepository.save(conta);

	}
}