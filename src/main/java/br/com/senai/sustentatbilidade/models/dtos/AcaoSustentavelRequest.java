package br.com.senai.sustentatbilidade.models.dtos;

import br.com.senai.sustentatbilidade.models.enums.CategoriaAcao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcaoSustentavelRequest {

    @NotBlank(message = "O título é obrigatório no preenchimento!")
    @Size(max = 100)
    private String titulo;

    @NotBlank
    @Size(max = 500)
    private String descricao;

    @NotNull
    private CategoriaAcao categoria;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate dataRealizacao;

    @NotBlank(message = "É necessário ter um responsável cadastrado!")
    private String responsavel;
}
