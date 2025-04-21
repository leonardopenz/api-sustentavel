package br.com.senai.sustentatbilidade.repositorys;

import br.com.senai.sustentatbilidade.models.entitys.AcaoSustentavel;
import br.com.senai.sustentatbilidade.models.enums.CategoriaAcao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcaoSustentatvelRepository extends JpaRepository<AcaoSustentavel, Long> {
    List<AcaoSustentavel> findByCategoria(CategoriaAcao categoria);
}
