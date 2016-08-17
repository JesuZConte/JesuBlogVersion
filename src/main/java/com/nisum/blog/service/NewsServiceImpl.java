package com.nisum.blog.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.blog.model.Comment;
import com.nisum.blog.model.News;
import com.nisum.blog.persistance.INewsRepository;

@Service
public class NewsServiceImpl implements INewsService {

	
	@Autowired
	private INewsRepository newsPersistence;
	
	@Override
	public News create(News miNoticiaAGuardar) throws RuntimeException {
		return newsPersistence.create(miNoticiaAGuardar);
	}

	@Override
	public News delete(int i) throws RuntimeException {
		return newsPersistence.delete(i);
	}

	@Override
	public boolean isEmpty() {
		return newsPersistence.isEmpty();
	}

	@Override
	public News read(int i) throws RuntimeException {
		return newsPersistence.read(i);
	}

	@Override
	public ArrayList<News> readAll() {
		return newsPersistence.readAll();
	}

	@Override
	public Comment addComment(int id, Comment nuevoComentario) throws RuntimeException {
		return newsPersistence.addComment(id, nuevoComentario);
	}

	@Override
	public News searchNewsbyTag(int id, String tag) {
		return newsPersistence.searchNewsbyTag(id, tag);
	}

}
