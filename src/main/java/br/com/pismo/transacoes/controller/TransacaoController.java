package br.com.pismo.transacoes.controller;


import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.dto.TransacaoDTO;
import br.com.pismo.transacoes.dto.TransacaoFinanceiraDTO;
import br.com.pismo.transacoes.mapper.ObjectMapper;
import br.com.pismo.transacoes.service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final ObjectMapper mapper;

    public TransacaoController(TransacaoService transacaoService, ObjectMapper mapper) {
        this.transacaoService = transacaoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity criarTransacao(@Valid @RequestBody TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        transacaoService.criarTransacao(transacaoFinanceiraDTO);
        return ResponseEntity.ok().build();
    }

}
