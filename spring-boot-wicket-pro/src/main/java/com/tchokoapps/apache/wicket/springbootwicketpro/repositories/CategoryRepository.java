package com.tchokoapps.apache.wicket.springbootwicketpro.repositories;

import com.tchokoapps.apache.wicket.springbootwicketpro.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
