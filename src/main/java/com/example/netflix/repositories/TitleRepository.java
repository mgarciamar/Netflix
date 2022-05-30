package com.example.netflix.repositories;

import com.example.netflix.models.Title;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "titles", path = "titles")
public interface TitleRepository extends PagingAndSortingRepository<Title, Long> {
    @Query(value = "SELECT * FROM title  t ORDER BY t.user_rating DESC", nativeQuery = true)
    List<Title> findTopRating(PageRequest pageRequest);

    @Query(value = "select t.*, c.name\n" +
            "from title t\n" +
            "inner join title_category tc on t.id = tc.title_id\n" +
            "inner join category c on tc.category_id = c.id\n" +
            "where c.id=?1\n" +
            "order by t.user_rating desc;", nativeQuery = true)
    List<Title> findTopRatingCategory(PageRequest pageRequest, Integer id);

}
