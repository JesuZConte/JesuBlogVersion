package com.nisum.blog.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.nisum.blog.model.Author;
import com.nisum.blog.model.Comment;
import com.nisum.blog.model.News;
import com.nisum.blog.persistance.INewsRepository;

@RunWith(MockitoJUnitRunner.class)
public class NewsServiceUnitTest {

	@Mock
	private INewsRepository  newsPersistence;
	
	@InjectMocks
	private NewsServiceImpl  newsService;
	
	
	@Test
	public void  checkCreate(){
		
		News noticia= new  News();
		String titulo="titulo";
		noticia.setTitle(titulo);
		when(newsPersistence.create(any(News.class))).thenReturn(noticia);
		
		News  nuevaNoticia=newsService.create(noticia);
		
		assertTrue(nuevaNoticia instanceof News);
		assertEquals(titulo, nuevaNoticia.getTitle());
		
		
	}
	
	@Test
    public void checkRead(){
        News noticia = new News();
        int id = 123;
        noticia.setId(id);
        when(newsPersistence.read(anyInt())).thenReturn(noticia);
       
        News noticiaLeida = newsService.read(id);
       
        assertTrue(noticiaLeida instanceof News);
        assertEquals(id, noticiaLeida.getId());
    }
   
    @Test
    public void checkReadAll(){
        News noticia = new News();
        ArrayList<News> listaNoticias = new ArrayList<>();
        listaNoticias.add(noticia);
        when(newsPersistence.readAll()).thenReturn(listaNoticias);
       
        ArrayList<News> nuevaLista = newsService.readAll();
       
        assertEquals(listaNoticias.size(), nuevaLista.size());
    }
   
    @Test (expected = RuntimeException.class)
    public void checkReadAll2(){
        when(newsPersistence.readAll()).thenThrow(new RuntimeException());
       
        ArrayList<News> nuevaLista = newsService.readAll();
    }
 
    @Test
    public void checkDelete(){
        News noticia=new News();
        String titulo="titulo";
        noticia.setId(1);
        noticia.setTitle(titulo);
        //Mockeando
        when(newsPersistence.delete(anyInt())).thenReturn(noticia);
       
        News noticiaBorrada= newsService.delete(noticia.getId());
       
        assertNotNull(noticiaBorrada);
        }
	
    @Test (expected = RuntimeException.class)
    public void checkDeleteException(){
        News noticia=new News();
        String titulo="titulo";
        noticia.setId(1);
        noticia.setTitle(titulo);
        //Mockeando
        when(newsPersistence.delete(anyInt())).thenThrow(new RuntimeException());
       
        News noticiaBorrada= newsService.delete(noticia.getId());
    }
	
    @Test
    public void checkAddComment(){
       
        Comment comentario = new Comment();
        comentario.setMessage("Hola Mundo");
       
        when(newsPersistence.addComment(anyInt(), any(Comment.class))).thenReturn(comentario);
       
        Comment nuevoComentario = newsService.addComment(3, comentario);
        assertTrue(nuevoComentario instanceof Comment);
       
        assertEquals("Hola Mundo", comentario.getMessage());
    }
   
    @Test (expected = RuntimeException.class)
    public void checkAddComment2(){

        when(newsPersistence.addComment(anyInt(), null)).thenThrow(new RuntimeException());

    }
}
