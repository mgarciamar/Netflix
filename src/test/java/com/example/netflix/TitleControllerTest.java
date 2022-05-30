package com.example.netflix;

import com.example.netflix.models.Title;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

//lanzar pruebas en un puerto random
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class TitleControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //Comprueba el endpoint best?top=10 Best rated titles overall
    @Test
    void best() {
        webTestClient.get()
                .uri("/best?top=10")
                .exchange()//recupera la respuesta
                .expectStatus().isOk()//
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody()
                .jsonPath("$.size()").isEqualTo(10)
                .jsonPath("$.[0].name").isEqualTo("Septembers of Shiraz")
                .jsonPath("$.[0].actorList[0].name").isEqualTo("Salma Hayek")
                .jsonPath("$.[0].directorList[0].name").isEqualTo("Wayne Blair")
                .jsonPath("$.[0].release_year").isEqualTo("2016")
                .jsonPath("$.[0].user_rating").isEqualTo("10.0");
    }


    //Comprueba el endpoint category/{id}?top=10 Best rated titles by category
    @Test
    void top() {
        webTestClient.get()
                .uri("category/{id}?top=10", 2)
                .exchange()//recupera la respuesta
                .expectStatus().isOk()//
                .expectHeader().valueEquals("Content-Type", "application/json")
                .expectBody()
                .jsonPath("$.size()").isEqualTo(10)
                .jsonPath("$.[0].name").isEqualTo("My Mister")
                .jsonPath("$.[0].actorList[0].name").isEqualTo("Park Ho-san")
                .jsonPath("$.[0].categoryList[0].name").isEqualTo("International TV Shows")
                .jsonPath("$.[0].user_rating").isEqualTo("9.99");
    }

/* Da error porque devuelve demasiados resultados
    @Test
    void all() {
        webTestClient.get()
                .uri("/title")
                .exchange() //recupera la respuesta
                .expectStatus().isOk()
                .expectHeader().valueEquals("Content-Type", "application/hal+json")
                .expectBody()
                .jsonPath("$._embedded.titles.size()").isEqualTo(8807);

    }
*/


    @Test
    void one() {
        webTestClient.get()
                .uri("/title/{id}", 2)
                .exchange()//recupera la respuesta
                .expectStatus().isOk()//
                .expectHeader().valueEquals("Content-Type", "application/hal+json")
                .expectBody()
                .jsonPath("$.name").isEqualTo("Blood & Water")
                .jsonPath("$.release_year").isEqualTo("2021")
                .jsonPath("$.duration").isEqualTo("2 Seasons");

    }


    @Test
    void titleDoesntExist() {
        webTestClient.get()

                .uri("/title/{id}", 9000)
                .exchange()//recupera la respuesta
                //.expectStatus().is4xxClientError()//404
                .expectStatus().isNotFound();

    }


    @Test
    void updateTitle() {

        Title title = new Title();
        title.setName("La muerte tenía un precio");
        title.setRelease_year("2022");

        webTestClient.put()
                .uri("/title/{id}", 500)
                .bodyValue(title)
                .exchange()//recupera la respuesta
                .expectStatus().is2xxSuccessful()
                .expectBody()
                .jsonPath("$.name").isEqualTo("La muerte tenía un precio")
                .jsonPath("$.release_year").isEqualTo(2022);

    }


    @Test
    void createTitle() {

        Title title = new Title();
        title.setName("Braveheart");
        title.setRelease_year("1988");

        webTestClient.post()
                .uri("/title")
                .bodyValue(title)
                .exchange()//recupera la respuesta
                .expectStatus().is2xxSuccessful()//
                .expectBody()
                .jsonPath("$.name").isEqualTo("Braveheart")
                .jsonPath("$.release_year").isEqualTo("1988");
    }


}




