package com.tchokoapps.apache.wicket.springbootwicketpro.repositories;

import com.tchokoapps.apache.wicket.springbootwicketpro.entities.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findBookByCategoryId(Long categoryId);
    List<Book> findBookByCategoryIdAndCategoryNameLike(Long categoryId, String name);

}
