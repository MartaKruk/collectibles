package com.collectibles.repository;

import com.collectibles.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Override
    List<Movie> findAll();

    @Override
    Movie save(Movie movie);

    @Override
    Optional<Movie> findById(Long id);
}
