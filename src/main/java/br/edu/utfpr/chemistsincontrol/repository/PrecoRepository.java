package br.edu.utfpr.chemistsincontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.chemistsincontrol.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Integer>{

}