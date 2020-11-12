package br.com.pismo.transacoes.controller;

import br.com.pismo.transacoes.dto.ContaDTO;
import br.com.pismo.transacoes.dto.InformacaoContaDTO;
import br.com.pismo.transacoes.mapper.ObjectMapper;
import br.com.pismo.transacoes.service.ContaService;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/conta")
@Api(value = "Conta")
public class ContaController {

    private final ContaService contaService;
    private final ObjectMapper mapper;

    public ContaController(ContaService contaService, ObjectMapper mapper) {
        this.contaService = contaService;
        this.mapper = mapper;
    }

    @PostMapping
    @ApiOperation(value = "Incluir conta")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conta salva com sucesso", response = Object.class),
            @ApiResponse(code = 400, message = "Conta já existente"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity incluirConta(@Valid @RequestBody InformacaoContaDTO informacaoConta) {
        contaService.incluirConta(informacaoConta);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idConta}")
    @ApiOperation(value = "Buscar conta", response = ContaDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Conta retornada"),
            @ApiResponse(code = 404, message = "Alguma informação não foi encontrada"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity buscarConta(@PathVariable("idConta") Integer idConta) {
        ContaDTO conta = mapper.convert(contaService.buscarConta(idConta), ContaDTO.class);
        return ResponseEntity.ok(conta);
    }

}
