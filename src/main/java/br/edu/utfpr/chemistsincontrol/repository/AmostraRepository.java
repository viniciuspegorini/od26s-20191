package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.Amostra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmostraRepository extends JpaRepository<Amostra, Long> {
}
