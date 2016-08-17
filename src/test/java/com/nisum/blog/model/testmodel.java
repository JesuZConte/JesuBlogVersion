package com.nisum.blog.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class testmodel {
	
	@Test
	public void checkInstance(){
		//arrange
		Author author;
		
		//act
		author = new Author();
		
		//assert
		assertNotNull(author);
	}
}
