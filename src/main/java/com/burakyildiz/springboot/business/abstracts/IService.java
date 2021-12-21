package com.burakyildiz.springboot.business.abstracts;

import com.burakyildiz.springboot.entities.concretes.IEntity;

import java.util.List;

public interface IService<IEntity> {

    List<IEntity> findAll();

    IEntity findById(Long id);

    public <Object> IEntity save(IEntity entity);

    void delete(IEntity entity);

    void deleteById(Long id);

    long count();
}
