package br.com.pismo.transacoes.controller;

import br.com.pismo.transacoes.domain.Conta;
import br.com.pismo.transacoes.dto.ContaDTO;
import br.com.pismo.transacoes.mapper.ObjectMapper;
import br.com.pismo.transacoes.service.ContaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private final ContaService contaService;
    private final ObjectMapper mapper;

    public ContaController(ContaService contaService, ObjectMapper mapper) {
        this.contaService = contaService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity incluirConta(@RequestBody ContaDTO conta) {
        contaService.incluirConta(mapper.convert(conta, Conta.class));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{accountId}")
    public ResponseEntity buscarConta(@PathVariable("accountId") Integer idConta) {
        ContaDTO conta = mapper.convert(contaService.buscarConta(idConta), ContaDTO.class);
        return ResponseEntity.ok(conta);
    }

}
