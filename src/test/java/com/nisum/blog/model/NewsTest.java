package com.nisum.blog.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class NewsTest {
	
	@Test
	public void checkInstance(){
		News noticia;
		noticia = new News();
		
		assertNotNull(noticia);
	}	
}
