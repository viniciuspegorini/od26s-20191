package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import br.edu.utfpr.chemistsincontrol.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ModeloServiceImpl extends CrudServiceImpl<Modelo> {

    private ModeloRepository repository;
    @Autowired
    public ModeloServiceImpl(ModeloRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ModeloRepository getRepository() {
        return this.repository;
    }
}
