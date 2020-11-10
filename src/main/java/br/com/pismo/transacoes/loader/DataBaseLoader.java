package br.com.pismo.transacoes.loader;

import br.com.pismo.transacoes.domain.TipoOperacao;
import br.com.pismo.transacoes.enums.EnumOperacaoMatematica;
import br.com.pismo.transacoes.repository.TipoOperacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final TipoOperacaoRepository tipoOperacaoRepository;

	private static final Short OPERACAO_POSIVITA = 1;
	private static final Short OPERACAO_NEGATIVA = -1;


	public DataBaseLoader(TipoOperacaoRepository tipoOperacaoRepository) {
		this.tipoOperacaoRepository = tipoOperacaoRepository;
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
	}
}