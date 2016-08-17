package com.nisum.blog.rest;


import com.nisum.blog.model.Comment;
import com.nisum.blog.model.News;
import com.nisum.blog.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class BlogController {

    @Autowired
    private INewsService newsService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public News create(@RequestBody News news) {
        News noticia = newsService.create(news);
        System.out.println("created object with title: "+ noticia.getId());
        return noticia;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public News delete(@PathVariable int id) {
        System.out.println("deleting object with id: " + id);
        News noticia = newsService.delete(id);
        return noticia;
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public News read(@PathVariable int id) {
        System.out.println("get news with id: " + id);
        News noticia = newsService.read(id);
        return noticia;
    }

        @RequestMapping(value = "/readAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<News> readAll() {
        System.out.println("get'em all.........");
        ArrayList<News> lista = newsService.readAll();
        return lista;
    }

    @RequestMapping(value = "/addComment/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment addComment(@PathVariable int id, @RequestBody Comment comment) {
        System.out.println("add comment.........");
        Comment comment1 = newsService.addComment(id,comment);
        return comment1;
    }
}
