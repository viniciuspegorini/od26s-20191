package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.Formulario;
import br.edu.utfpr.chemistsincontrol.repository.FormularioRepository;
import br.edu.utfpr.chemistsincontrol.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioServiceImpl extends CrudServiceImpl<Formulario, Long>
        implements FormularioService {

    @Autowired
    private FormularioRepository formularioRepository;

    @Override
    protected FormularioRepository getRepository() {
        return formularioRepository;
    }

    @Override
    public List<Formulario> getForm() {
        List<Formulario> forms = formularioRepository.findAllByOrderByStatus();

        return forms;
    }

    @Override
    public List<Formulario> findByNotaId(Long id) {
        List<Formulario> forms = formularioRepository.findByNotaId(id);
        return forms;
    }
}
