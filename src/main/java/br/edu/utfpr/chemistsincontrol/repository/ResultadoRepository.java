package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {

    Optional<Resultado> findByFormularioId(Long idFormulario);

}
