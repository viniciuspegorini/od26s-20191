package br.edu.utfpr.chemistsincontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.edu.utfpr.chemistsincontrol.model.Equipamento;
import br.edu.utfpr.chemistsincontrol.repository.EquipamentoRepository;
import br.edu.utfpr.chemistsincontrol.service.EquipamentoService;

@Service
public class EquipamentoServiceImpl extends CrudServiceImpl<Equipamento, Long>
implements EquipamentoService{

	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@Override
	protected JpaRepository<Equipamento, Long> getRepository() {
		return equipamentoRepository;
	}
}
