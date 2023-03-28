package com.example.blogenspringmvc.service;

import com.example.blogenspringmvc.dao.CategoryDao;
import com.example.blogenspringmvc.dao.PostDao;
import com.example.blogenspringmvc.dao.UserDao;
import com.example.blogenspringmvc.entity.Category;
import com.example.blogenspringmvc.entity.Post;
import com.example.blogenspringmvc.entity.Users;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private UserDao userDao;

    @Transactional
    public void savePost(Post post){
        Category category = categoryDao.findById(post.getCategory().getId())
                             .orElseThrow(EntityNotFoundException::new);
        Users users = userDao.findById(post.getUsers().getId())
                             .orElseThrow(EntityNotFoundException::new);
        category.addPost(post);     // post is still  Transist state , so we need @Transactional
        users.addPostUser(post);
        postDao.save(post);
    }

    public List<Post> findAllPosts(){
        return postDao.findAll();
    }
}
