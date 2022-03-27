package com.collectibles.repository;

import com.collectibles.domain.BooksCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BooksCollectionRepository extends CrudRepository<BooksCollection, Long> {
    @Override
    List<BooksCollection> findAll();

    @Override
    BooksCollection save(BooksCollection booksCollection);
}
