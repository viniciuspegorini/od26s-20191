package br.edu.utfpr.chemistsincontrol.service;

import br.edu.utfpr.chemistsincontrol.model.Modelo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class ModeloService implements CrudService<Modelo, Integer>{


    @Override
    public List<Modelo> findAll() {
        return null;
    }

    @Override
    public List<Modelo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Modelo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Modelo save(Modelo entity) {
        return null;
    }

    @Override
    public Modelo saveAndFlush(Modelo entity) {
        return null;
    }

    @Override
    public Iterable<Modelo> save(Iterable<Modelo> iterable) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public Modelo findOne(Integer integer) {
        return null;
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public void delete(Modelo entity) {

    }

    @Override
    public void delete(Iterable<? extends Modelo> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
