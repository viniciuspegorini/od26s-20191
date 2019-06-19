package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Resultado;
import br.edu.utfpr.chemistsincontrol.repository.ResultadoRepository;
import br.edu.utfpr.chemistsincontrol.service.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class ResultadoServiceImpl extends CrudServiceImpl<Resultado, Long>
        implements ResultadoService {

    @Autowired
    private ResultadoRepository resultadoRepository;

    @Override
    protected JpaRepository<Resultado, Long> getRepository() {
        return resultadoRepository;
    }
}