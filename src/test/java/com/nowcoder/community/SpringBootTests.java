package com.nowcoder.community;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.service.DiscussPostService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;

/**
 * @author zjh
 * @version 1.0
 * @date 2022/8/4 20:57
 */

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SpringBootTests {
    @Autowired
    private DiscussPostService discussPostService;
    private DiscussPost data;

    // 类加载前执行一次
    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }
    // 类销毁前执行一次
    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }
    // 每个测试方法执行前执行一次
    @BeforeEach
    public void before(){
        System.out.println("before");

        //初始化测试数据
        data = new DiscussPost();
        data.setUserId(111);
        data.setTitle("Test Title");
        data.setContent("Test Content");
        data.setCreateTime(new Date());
        discussPostService.addDiscussPost(data);
    }
    // 每个测试方法执行后执行一次
    @AfterEach
    public void after(){
        System.out.println("after");

        //删除测试数据
        discussPostService.updateStatus(data.getId(),2);
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void testFindById(){
        DiscussPost post = discussPostService.findDiscussPostById(data.getId());
        Assertions.assertNotNull(post);
        Assertions.assertEquals(data.getTitle(),post.getTitle());
        Assertions.assertEquals(data.getContent(),post.getContent());
    }

    @Test
    public void testUpdateScore(){
        int rows = discussPostService.updateScore(data.getId(), 2000.00);
        Assertions.assertEquals(1,rows);

        DiscussPost post = discussPostService.findDiscussPostById(data.getId());
        Assertions.assertEquals(2000.00,post.getScore(),2);
    }
}
