package br.com.pismo.transacoes.loader;

import br.com.pismo.transacoes.domain.TipoOperacao;
import br.com.pismo.transacoes.repository.TipoOperacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseLoader implements CommandLineRunner {

	private final TipoOperacaoRepository tipoOperacaoRepository;

	public DataBaseLoader(TipoOperacaoRepository tipoOperacaoRepository) {
		this.tipoOperacaoRepository = tipoOperacaoRepository;
	}

	@Override
	public void run(String... strings) {
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(1).descricao("COMPRA A VISTA").build());
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(2).descricao("COMPRA PARCELADA").build());
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(3).descricao("SAQUE").build());
		this.tipoOperacaoRepository.save(TipoOperacao.builder().id(4).descricao("PAGAMENTO").build());
	}
}