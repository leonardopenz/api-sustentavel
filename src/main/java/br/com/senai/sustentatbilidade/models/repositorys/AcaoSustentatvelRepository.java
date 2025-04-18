package br.com.senai.sustentatbilidade.models.repositorys;

import br.com.senai.sustentatbilidade.models.entitys.AcaoSustentavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoSustentatvelRepository extends JpaRepository<AcaoSustentavel, Long> {
}
