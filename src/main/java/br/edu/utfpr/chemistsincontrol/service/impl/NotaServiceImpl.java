package br.edu.utfpr.chemistsincontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.chemistsincontrol.model.Nota;
import br.edu.utfpr.chemistsincontrol.repository.NotaRepository;
import br.edu.utfpr.chemistsincontrol.service.NotaService;

@Service
public class NotaServiceImpl extends CrudServiceImpl<Nota, Long> implements NotaService {

    private NotaRepository repository;
    @Autowired
    public NotaServiceImpl(NotaRepository repository) {
        this.repository = repository;
    }

    @Override
    protected NotaRepository getRepository() {
        return this.repository;
    }

}
