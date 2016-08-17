package com.nisum.blog.persistance;


import com.nisum.blog.model.Author;
import com.nisum.blog.model.Comment;
import com.nisum.blog.model.News;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

@Repository
public class NewsRepositoryImpl implements INewsRepository {
	
	private final AtomicInteger counter = new AtomicInteger();

    ArrayList <News> misNoticias;

    public NewsRepositoryImpl() {
        misNoticias = new ArrayList<>();
    }

    /**
     * Gets  the new id 
     * @return
     */
    private int newIdNews(){
    	
    	return counter.getAndIncrement();
    }
    
    /* (non-Javadoc)
	 * @see com.nisum.blog.persistance.INews#create(com.nisum.blog.model.News)
	 */
    @Override
	public News create(News miNoticiaAGuardar) throws RuntimeException{
        if (!nullValidation(miNoticiaAGuardar)||(!authorValidation(miNoticiaAGuardar.getAuthor()))) {
            throw new RuntimeException();
        }
        miNoticiaAGuardar.setId(newIdNews());
        misNoticias.add(miNoticiaAGuardar);
        return miNoticiaAGuardar;
    }
    
    /*antiguo
    public News create(News miNoticiaAGuardar) throws RuntimeException{
        if (!nullValidation(miNoticiaAGuardar)) {
            throw new RuntimeException();
        }
        miNoticiaAGuardar.setId(newIdNews());
        misNoticias.add(miNoticiaAGuardar);
        return miNoticiaAGuardar;
    }**/
    
    /**
     * Validates nulls 
     * @param miNoticiaAGuardar
     * @return
     */
    private  boolean nullValidation( News miNoticiaAGuardar){
    	
    	if(miNoticiaAGuardar.getAuthor() == null || miNoticiaAGuardar.getTitle() == null || miNoticiaAGuardar.getContent() == null){
    		return false;
    	}else{
    		return true;
    	}
    	
    	
    }
    
    private boolean authorValidation(Author author){
        if(author == null || author.getName().trim().equals("")){
            return false;
        } else {
            return true;
        }

    }

    /* (non-Javadoc)
	 * @see com.nisum.blog.persistance.INews#delete(int)
	 */
    @Override
	public News delete(int i) throws RuntimeException{
        for (int j = 0; j<misNoticias.size(); j++) {
            if ( misNoticias.get(j).getId() == i) {
                return misNoticias.remove(j);
            }
        }
        throw new RuntimeException();
    }

    /* (non-Javadoc)
	 * @see com.nisum.blog.persistance.INews#isEmpty()
	 */
    @Override
	public boolean isEmpty() {
        return misNoticias.isEmpty();
    }

    /* (non-Javadoc)
	 * @see com.nisum.blog.persistance.INews#read(int)
	 */
    @Override
	public News read(int i) throws RuntimeException{
        for (int j = 0; j<misNoticias.size(); j++) {
            if ( misNoticias.get(j).getId() == i) {
                return misNoticias.get(j);
            }
        }
        throw new RuntimeException();
    }
    
    /* (non-Javadoc)
	 * @see com.nisum.blog.persistance.INews#readAll()
	 */
    @Override
	public ArrayList<News> readAll() {
        return misNoticias;
    }
    
    /* (non-Javadoc)
	 * @see com.nisum.blog.persistance.INews#addComment(int, com.nisum.blog.model.Comment)
	 */
    @Override
	public Comment addComment(int id, Comment nuevoComentario) throws RuntimeException{
        for (int j = 0; j<misNoticias.size(); j++) {
            if ( misNoticias.get(j).getId() == id) {
                ArrayList<Comment> comentarios = misNoticias.get(j).getComments();
                comentarios.add(nuevoComentario);
                misNoticias.get(j).setComments(comentarios);
                return nuevoComentario;
            }
        }
        throw new RuntimeException();
    }
    
    /* (non-Javadoc)
	 * @see com.nisum.blog.persistance.INews#searchNewsbyTag(int, java.lang.String)
	 */
    @Override
	public News searchNewsbyTag(int id, String tag) {
        News miNoticia = null;
        boolean found = false;
        for(News news : misNoticias){
            if(news.getId() == id){
                for(String tags : news.getTags()){
                    if(tag.equals(tags)){
                        miNoticia = news;
                        found = true;
                        break;
                    }
                }
                if(found){
                    break;
                }
            }
        }
        return miNoticia;
       
    }
    
}
