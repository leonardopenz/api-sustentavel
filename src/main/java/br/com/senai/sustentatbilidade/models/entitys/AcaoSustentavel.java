package br.com.senai.sustentatbilidade.models.entitys;

import br.com.senai.sustentatbilidade.models.enums.CategoriaAcao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "acaosustentavel")
public class AcaoSustentavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column
    private String descricao;

    @Column
    @Enumerated(EnumType.STRING)
    private CategoriaAcao categoria;

    @Column
    @Temporal(value = TemporalType.DATE)
    private LocalDate dataRealizacao;

    @Column
    private String responsavel;
}
