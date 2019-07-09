package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoService extends JpaRepository<Arquivo, Long> {
}
