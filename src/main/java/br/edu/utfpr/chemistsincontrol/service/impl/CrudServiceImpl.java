package br.edu.utfpr.chemistsincontrol.service.impl;

import br.edu.utfpr.chemistsincontrol.model.AbstractModel;
import br.edu.utfpr.chemistsincontrol.repository.IRepository;
import br.edu.utfpr.chemistsincontrol.service.CrudService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class CrudServiceImpl<T extends AbstractModel> implements CrudService<T> {

    protected abstract IRepository<T> getRepository();


    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T saveAndFlush(T entity) {
        return getRepository().saveAndFlush(entity);
    }

    @Override
    public Iterable<T> save(Iterable iterable) {
        return getRepository().saveAll(iterable);
    }

    @Override
    public void flush() {
        getRepository().flush();
    }

    @Override
    public T findOne(Long id) {
        return getRepository().getOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return getRepository().existsById(id);
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void delete(Iterable iterable) {
        getRepository().deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }
}
