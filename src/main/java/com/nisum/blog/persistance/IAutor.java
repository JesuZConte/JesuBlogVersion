package com.nisum.blog.persistance;

import com.nisum.blog.model.Author;

public interface IAutor {

    public void create(Author author);
    public Author read(int id);
    public boolean update(Author author);
    public void delete();
}
