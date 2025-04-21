package br.com.senai.sustentatbilidade.services;

import br.com.senai.sustentatbilidade.models.entitys.AcaoSustentavel;
import br.com.senai.sustentatbilidade.models.enums.CategoriaAcao;
import br.com.senai.sustentatbilidade.repositorys.AcaoSustentatvelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcaoSustentavelService {

    @Autowired
    AcaoSustentatvelRepository acaoSustentavelRepository;

    public List<AcaoSustentavel> findAllAcaoSustentavel(){
        return acaoSustentavelRepository.findAll();
    }

    public AcaoSustentavel findAcaoById(Long id){
        return acaoSustentavelRepository.findById(id).orElseThrow();
    }

    public List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria) {
        return acaoSustentavelRepository.findByCategoria(categoria);
    }


    public AcaoSustentavel create(AcaoSustentavel acaoSustentavel){
        return acaoSustentavelRepository.save(acaoSustentavel);
    }

    public void delete(Long id){
        AcaoSustentavel acaoSustentavel = findAcaoById(id);
        acaoSustentavelRepository.delete(acaoSustentavel);
    }

    public AcaoSustentavel update(Long id, AcaoSustentavel updatedAcao) throws Exception{
        AcaoSustentavel existingAcao = findAcaoById(id);
        existingAcao.setTitulo(updatedAcao.getTitulo());
        existingAcao.setDescricao(updatedAcao.getDescricao());
        existingAcao.setCategoria(updatedAcao.getCategoria());
        existingAcao.setDataRealizacao(updatedAcao.getDataRealizacao());
        existingAcao.setResponsavel(updatedAcao.getResponsavel());
        return acaoSustentavelRepository.save(existingAcao);
    }
}
