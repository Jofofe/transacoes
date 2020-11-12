package br.com.pismo.transacoes.controller;


import br.com.pismo.transacoes.dto.TransacaoFinanceiraDTO;
import br.com.pismo.transacoes.mapper.ObjectMapper;
import br.com.pismo.transacoes.service.TransacaoService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacao")
@Api(value = "Transacao")
public class TransacaoController {

    private final TransacaoService transacaoService;
    private final ObjectMapper mapper;

    public TransacaoController(TransacaoService transacaoService, ObjectMapper mapper) {
        this.transacaoService = transacaoService;
        this.mapper = mapper;
    }

    @PostMapping
    @ApiOperation(value = "Criar transação")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Transação salva com sucesso", response = Object.class),
            @ApiResponse(code = 404, message = "Alguma informação não foi encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity criarTransacao(@Valid @RequestBody TransacaoFinanceiraDTO transacaoFinanceiraDTO) {
        transacaoService.criarTransacao(transacaoFinanceiraDTO);
        return ResponseEntity.ok().build();
    }

}
