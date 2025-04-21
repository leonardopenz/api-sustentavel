package br.com.senai.sustentatbilidade.controllers;

import br.com.senai.sustentatbilidade.models.dtos.AcaoSustentavelResponse;
import br.com.senai.sustentatbilidade.models.entitys.AcaoSustentavel;
import br.com.senai.sustentatbilidade.services.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/acoes")
public class AcaoSustentavelController {

    @Autowired
    private AcaoSustentavelService acaoSustentavelService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<AcaoSustentavelResponse>> listAll(){
        List<AcaoSustentavelResponse> acoes = this.acaoSustentavelService.findAllAcaoSustentavel().stream()
                .map( acao -> modelMapper.map(acao, AcaoSustentavelResponse.class)).collect(Collectors.toList());
        return acoes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(acoes);
    }

    @PostMapping
    public ResponseEntity<AcaoSustentavelResponse> create(@RequestBody @Valid AcaoSustentavelResponse acaoDTO) throws Exception {
        AcaoSustentavel acao = modelMapper.map(acaoDTO, AcaoSustentavel.class);
        AcaoSustentavel createdAcao = this.acaoSustentavelService.create(acao);
        AcaoSustentavelResponse createdAcaoDTO = modelMapper.map(createdAcao, AcaoSustentavelResponse.class);
        return ResponseEntity.ok(createdAcaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> update(@PathVariable Long id, @RequestBody AcaoSustentavelResponse acaoDTO) throws Exception {
        AcaoSustentavel acao = modelMapper.map(acaoDTO, AcaoSustentavel.class);
        AcaoSustentavel updateAcao = this.acaoSustentavelService.update(id, acao);
        AcaoSustentavelResponse updateAcaoDTO = modelMapper.map(updateAcao, AcaoSustentavelResponse.class);
        return ResponseEntity.ok(updateAcaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        this.acaoSustentavelService.delete(id);
        return ResponseEntity.ok("Ação Sustentável removida com suceso!");
    }
}

