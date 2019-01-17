package com.shiyou.springcache.dao;

import com.shiyou.springcache.pojo.Book;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Author sya
 * @Date 2019/1/17
 */
@Component
public class SimpleBookRepository implements BookRepository {

    /**
     * 在需要缓存的地方加入@Cacheable注解，比如在getByIsbn（）方法上加入@Cacheable(“books”)，
     * 这个方法就开启了缓存策略，当缓存有这个数据的时候，会直接返回数据，不会等待去查询数据库。
     * @param isbn
     * @return
     */
    @Override
    @Cacheable("books")
    public Book getByIsbn(String isbn) {
        simulateSlowService();
        //这时再启动程序，你会发现程序打印,只有打印前面2个数据，程序等了3s，之后的数据瞬间打印在控制台上了，这说明缓存起了作用。
        return new Book(isbn, "Some book");
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
