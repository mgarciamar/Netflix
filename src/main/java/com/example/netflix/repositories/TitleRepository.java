package com.example.netflix.repositories;

import com.example.netflix.models.Title;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "titles", path = "titles")
public interface TitleRepository extends PagingAndSortingRepository<Title, Long> {

}
