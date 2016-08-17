package com.nisum.blog.persistance;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.nisum.blog.model.Author;
import com.nisum.blog.model.Comment;
import com.nisum.blog.model.News;


@RunWith(JUnit4.class)
public class NewsRepositoryUnitTest {

    @Test
    public void checkIntance() throws Exception {
        INewsRepository noticia;

        noticia = new NewsRepositoryImpl();

        Assert.assertNotNull(noticia);
    }

    @Test 
    public void createNew() throws Exception {
        INewsRepository noticia = new NewsRepositoryImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
    	autor.setName("juan");

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);

        Assert.assertNotNull(miNoticia);
    }

    @Test 
    public void checkFields() throws Exception {
        INewsRepository noticia = new NewsRepositoryImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
    	autor.setName("juan");

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);

        Assert.assertNotNull(miNoticia);
        Assert.assertNotNull(miNoticia.getAuthor());
        Assert.assertNotNull(miNoticia.getTitle());
        Assert.assertNotNull(miNoticia.getContent());
    }

    @Test (expected = RuntimeException.class)
    public void checkCaminoInfeliz() throws Exception {
        INewsRepository noticia = new NewsRepositoryImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = noticia.create(miNoticiaAGuardar);
    }

    @Test 
    public void checkDelete() throws Exception {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");

    	autor.setName("juan");
    	
        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticiaBorrada = listaDeNoticias.delete(miNoticia.getId());

        assertNotNull(miNoticiaBorrada);
        assertTrue(listaDeNoticias.isEmpty());
    }

    @Test (expected = RuntimeException.class)
    public void checkDelete2() throws Exception {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(new Author());
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");

        News miNoticia = listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticiaBorrada = listaDeNoticias.delete(54746857);
    }


    @Test 
    public void checkRead() throws Exception {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
        
        
    	autor.setName("juan");

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);      
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");

        listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticia = listaDeNoticias.read(miNoticiaAGuardar.getId());

        assertNotNull(miNoticia);
        assertTrue(!listaDeNoticias.isEmpty());
    }

    @Test (expected = RuntimeException.class)
    public void checkRead2() throws Exception {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
        Author autor = new Author();
    	autor.setName("juan");

        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setId(11232343);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");

        listaDeNoticias.create(miNoticiaAGuardar);
        News miNoticia = listaDeNoticias.read(11233);
    }
    
    @Test
    public void checkReadAllCreate() {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
 
        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");
 
        listaDeNoticias.create(miNoticiaAGuardar);
        ArrayList<News> listado = listaDeNoticias.readAll();
        listaDeNoticias.create(miNoticiaAGuardar);
 
        assertEquals(2, listado.size());
    }
 
    @Test
    public void checkReadAllDelete() {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
        Author autor = new Author();
        autor.setName("Marco Antonio");
 
        News miNoticiaAGuardar = new News();
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");
 
        listaDeNoticias.create(miNoticiaAGuardar);
        ArrayList<News> listado = listaDeNoticias.readAll();
        listaDeNoticias.create(miNoticiaAGuardar);
        listaDeNoticias.delete(miNoticiaAGuardar.getId());
 
        assertEquals(1, listado.size());
    }
 
    @Test
    public void checkReadAllNull() {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
 
        ArrayList<News> listado = listaDeNoticias.readAll();
 
        assertTrue(listado.isEmpty());
        assertEquals(0, listado.size());
    }
    
    @Test
    public void checkAuthorNotNull() throws Exception{
        News miNoticia = new News();
        Author autor = new Author();
        autor.setName("juan");
       
       
        miNoticia.setContent("mi contenido");
        miNoticia.setTitle("Esto es un titulo");
        miNoticia.setAuthor(autor);
    }
    
    @Test
    public void checkAddComment() throws Exception {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
 
        News miNoticiaAGuardar = new News();
        Author autor = new Author();
        autor.setName("juan");
        miNoticiaAGuardar.setAuthor(autor);
        miNoticiaAGuardar.setTitle("mi titulo");
        miNoticiaAGuardar.setContent("mis comentarios");
        miNoticiaAGuardar = listaDeNoticias.create(miNoticiaAGuardar);
       
        Comment nuevoComentario = new Comment();
        listaDeNoticias.addComment(miNoticiaAGuardar.getId(),nuevoComentario);
       
        assertEquals(1, miNoticiaAGuardar.getComments().size());
    }
   
    @Test (expected = RuntimeException.class)
    public void checkAddComment2() throws Exception {
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
        Comment nuevoComentario = new Comment();
        listaDeNoticias.addComment(1234,nuevoComentario);
    }
    
    @Test
    public void checkAddTag(){
        INewsRepository listaDeNoticias = new NewsRepositoryImpl();
       
        News noticia = new News();
        Author autor = new Author();
        autor.setName("Marco Antonio");
        noticia.setAuthor(autor);
        noticia.setTitle("mi título");
        noticia.setContent("mis comentarios");
        noticia.getTags().add("Deporte");
       
       
        listaDeNoticias.create(noticia);
        News returnNews = listaDeNoticias.searchNewsbyTag(noticia.getId(), "Deporte");
        assertNotNull(returnNews);

     }
}
