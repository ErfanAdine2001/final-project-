package com.example.erfan_adine_p1_2.service;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService_Service<T,ID> {

    private JpaRepository<T,ID> jpaRepository;


    /**
     * Implemented the Set jpaRepository By method : "setJpaRepository()"
     * @param jpaRepository
     */

    public void setJpaRepository(JpaRepository<T,ID> jpaRepository){
        this.jpaRepository = jpaRepository;
    }

    /**
     * Implemented the save By method :"save()"
     * @param entity
     * @return
     */

    public T save(T entity){
        return jpaRepository.save(entity);
    }

    /**
     * Implemented the find By method :"delete()"
     * @param id
     * @return T
     */
    public T findById(ID id){
        return (T) jpaRepository.findById(id);
    }

    /**
     * Implemented the delete By method :"delete()"
     * @param id
     */
    public void removeById(ID id){
        jpaRepository.delete(findById(id));
    }
}
