package com.example.netflix.repositories;

import com.example.netflix.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "categories", path = "category")
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {


}
