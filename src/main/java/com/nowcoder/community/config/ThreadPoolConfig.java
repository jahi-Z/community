package com.nowcoder.community.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zjh
 * @version 1.0
 * @date 2022/8/2 11:11
 */

@Configuration
@EnableScheduling
@EnableAsync
public class ThreadPoolConfig {
}
