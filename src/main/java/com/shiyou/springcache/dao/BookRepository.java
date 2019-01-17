package com.shiyou.springcache.dao;

import com.shiyou.springcache.pojo.Book;

/**
 * @Author sya
 * @Date 2019/1/17
 */
public interface BookRepository {

    Book getByIsbn(String isbn);
}
