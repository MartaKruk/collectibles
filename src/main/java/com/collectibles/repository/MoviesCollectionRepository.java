package com.collectibles.repository;

import com.collectibles.domain.MoviesCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MoviesCollectionRepository extends CrudRepository<MoviesCollection, Long> {
    @Override
    List<MoviesCollection> findAll();

    @Override
    MoviesCollection save(MoviesCollection moviesCollection);
}
