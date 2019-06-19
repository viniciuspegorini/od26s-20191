package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Preco;
import br.edu.utfpr.chemistsincontrol.repository.PrecoRepository;
import br.edu.utfpr.chemistsincontrol.service.PrecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PrecoServiceImpl extends CrudServiceImpl<Preco, Long>
        implements PrecoService {

    @Autowired
    private PrecoRepository precoRepository;

    @Override
    protected JpaRepository<Preco, Long> getRepository() {
        return precoRepository;
    }
}