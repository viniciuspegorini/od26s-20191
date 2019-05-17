package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import br.edu.utfpr.chemistsincontrol.service.impl.CrudServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public class ModeloServiceImpl extends CrudServiceImpl<Modelo, Integer> {

    @Override
    protected JpaRepository<Modelo, Integer> getRepository() {
        return null;
    }
}
