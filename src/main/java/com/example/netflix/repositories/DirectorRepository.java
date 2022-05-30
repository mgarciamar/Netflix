package com.example.netflix.repositories;

import com.example.netflix.models.Director;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "directors", path = "director")
public interface DirectorRepository extends PagingAndSortingRepository<Director, Long> {


}
