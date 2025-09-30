package dev.gustavo.cadastrodecoroinhas.Repository;

import dev.gustavo.cadastrodecoroinhas.Model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {
}
