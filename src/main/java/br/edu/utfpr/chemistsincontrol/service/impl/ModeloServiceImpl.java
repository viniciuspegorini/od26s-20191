package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import br.edu.utfpr.chemistsincontrol.repository.ModeloRepository;
import br.edu.utfpr.chemistsincontrol.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloServiceImpl extends CrudServiceImpl<Modelo, Long> implements ModeloService {

    private ModeloRepository repository;
    @Autowired
    public ModeloServiceImpl(ModeloRepository repository) {
        this.repository = repository;
    }

    @Override
    protected ModeloRepository getRepository() {
        return this.repository;
    }

    @Override
    public Modelo findByPrecoEquipamentoId(long id){
        return repository.findByPrecoEquipamentoId(id);
    }
}
