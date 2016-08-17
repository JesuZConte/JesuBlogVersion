package com.nisum.blog.rest;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.nisum.blog.model.Comment;
import com.nisum.blog.model.News;
import com.nisum.blog.service.INewsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlogControllerTest {

    @Mock
    private INewsService newsService;

    @InjectMocks
    private BlogController blogController;

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(blogController);
    }

    @Test
    public void checkCreateIReceiveAStatus200() throws Exception {
        News noticia = new News();
        String titulo = "titulo";
        noticia.setTitle(titulo);

        when(newsService.create(new News())).thenReturn(noticia);

        given().
                contentType(ContentType.JSON).
                body(noticia).
                when().
                post("/api/create").
                then().
                statusCode(HttpStatus.OK.value());
    }

    @Test
    public void checkDelete() throws Exception {
        News noticiaABorrar = new News();
        noticiaABorrar.setId(1);
        noticiaABorrar.setContent("pokemon go!");

        when(newsService.delete(noticiaABorrar.getId())).thenReturn(noticiaABorrar);

        given().
                contentType(ContentType.JSON).
                when().
                delete("/api/delete/{id}", 1).
                then().
                statusCode(HttpStatus.OK.value());
    }

    @Test
    public void checkRead() throws Exception {
        News noticiaObtenida = new News();
        noticiaObtenida.setId(1);
        noticiaObtenida.setContent("pokemon go!");

        when(newsService.read(anyInt())).thenReturn(noticiaObtenida);


        given().
                contentType(ContentType.JSON).
                when().
                get("/api/read/{id}", 1).
                then().
                statusCode(HttpStatus.OK.value());
    }

    @Test
    public void checkReadAll() {
        ArrayList<News> noticias = new ArrayList();

        when(newsService.readAll()).thenReturn(noticias);

        given().
                contentType(ContentType.JSON).body(noticias).
        when().
                get("/api/readAll").
        then().
                statusCode(HttpStatus.OK.value());
    }

    @Test
    public void checkAddComment() throws Exception {
        Comment miComentario = new Comment();
        miComentario.setMessage("dfsdfdfsd");
        miComentario.setId(1);
        News miNoticia = new News();
        miNoticia.setId(1);

        when(newsService.addComment(1,miComentario)).thenReturn(miComentario);

        given().
                contentType(ContentType.JSON).
                body(miComentario).
        when().
                put("/api/addComment/{id}",1).
        then().
                statusCode(HttpStatus.OK.value());
    }
}