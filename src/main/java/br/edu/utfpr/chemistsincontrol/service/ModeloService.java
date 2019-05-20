package br.edu.utfpr.chemistsincontrol.service;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import br.edu.utfpr.chemistsincontrol.repository.IRepository;
import br.edu.utfpr.chemistsincontrol.repository.ModeloRepository;
import br.edu.utfpr.chemistsincontrol.service.impl.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ModeloService extends CrudService<Modelo> {


}
