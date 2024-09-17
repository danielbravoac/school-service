package com.danielbravoac.schoolservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface IGenericRepo<T, ID, P> extends JpaRepository<T, ID> {
    List<P> findAllBy();
}
