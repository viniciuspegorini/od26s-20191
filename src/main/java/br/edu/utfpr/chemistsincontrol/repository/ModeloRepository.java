package br.edu.utfpr.chemistsincontrol.repository;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ModeloRepository extends JpaRepository<Modelo, Long> {

    @Query(value = "SELECT * FROM modelo " +
            "Join preco as p on p.id = modelo.preco_id " +
            "JOIN equipamento as e on e.id = p.equipamento_id " +
            "Where modelo.id = :id",
            nativeQuery = true)
    Modelo findByPrecoEquipamentoId(@Param("id") Long Id);
}
