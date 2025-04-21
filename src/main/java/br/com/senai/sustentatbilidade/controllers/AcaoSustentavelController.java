package br.com.senai.sustentatbilidade.controllers;

import br.com.senai.sustentatbilidade.models.dtos.AcaoSustentavelRequest;
import br.com.senai.sustentatbilidade.models.dtos.AcaoSustentavelResponse;
import br.com.senai.sustentatbilidade.models.entitys.AcaoSustentavel;
import br.com.senai.sustentatbilidade.models.enums.CategoriaAcao;
import br.com.senai.sustentatbilidade.services.AcaoSustentavelService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
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

    @GetMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> listOne(@PathVariable Long id){
        Optional<AcaoSustentavel> optionalAcao = Optional.ofNullable(acaoSustentavelService.findAcaoById(id));

        if(optionalAcao.isPresent()){
            AcaoSustentavelResponse response = modelMapper.map(optionalAcao.get(), AcaoSustentavelResponse.class);
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<AcaoSustentavelResponse>> listarPorCategoria(@RequestParam("tipo") String tipo) {
        try {
            CategoriaAcao categoria = CategoriaAcao.valueOf(tipo.toUpperCase());
            List<AcaoSustentavel> acoes = acaoSustentavelService.findByCategoria(categoria);

            List<AcaoSustentavelResponse> response = acoes.stream()
                    .map(acao -> modelMapper.map(acao, AcaoSustentavelResponse.class))
                    .collect(Collectors.toList());

            return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @PostMapping
    public ResponseEntity<AcaoSustentavelResponse> create(@RequestBody @Valid AcaoSustentavelRequest acaoDTO) throws Exception {
        AcaoSustentavel acao = modelMapper.map(acaoDTO, AcaoSustentavel.class);
        AcaoSustentavel createdAcao = this.acaoSustentavelService.create(acao);
        AcaoSustentavelResponse createdAcaoDTO = modelMapper.map(createdAcao, AcaoSustentavelResponse.class);
        return ResponseEntity.ok(createdAcaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcaoSustentavelResponse> update(@PathVariable Long id, @RequestBody AcaoSustentavelRequest acaoDTO) throws Exception {
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

