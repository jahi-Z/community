package com.nowcoder.community;

import com.nowcoder.community.service.DiscussPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author zjh
 * @version 1.0
 * @date 2022/8/4 19:44
 */

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class CaffeineTests {

    @Autowired
    private DiscussPostService postService;

    @Test
    public void testCache(){
        System.out.println(postService.findDiscussPosts(0,0,10,1));
        System.out.println(postService.findDiscussPosts(0,0,10,1));
        System.out.println(postService.findDiscussPosts(0,0,10,1));
        System.out.println(postService.findDiscussPosts(0,0,10,0));
    }
}
