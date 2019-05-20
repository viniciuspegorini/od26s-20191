package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository<T extends AbstractModel> extends JpaRepository<T, Long> {
}
