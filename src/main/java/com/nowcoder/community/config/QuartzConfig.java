package com.nowcoder.community.config;

import com.nowcoder.community.quartz.AlphaJob;
import com.nowcoder.community.quartz.PostScoreRefreshJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * @author zjh
 * @version 1.0
 * @date 2022/8/2 16:52
 */

// 配置 -> (将配置初始化到)数据库 -> 访问数据库调用该任务
@Configuration
public class QuartzConfig {

    /* FactoryBean 可简化Bean 的实例化过程
     1.Spring 通过FactoryBean 封装了 某些 Bean 的实例化过程
     2.将FactoryBean 装配到容器里
     3.然后将 FactoryBean 注入给其他的 Bean
     4.那么该 Bean 得到的是 FactoryBean 所管理的对象实例
     */

    // 配置 JobDetail
    //@Bean
    public JobDetailFactoryBean alphaJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(AlphaJob.class);
        factoryBean.setName("alphaJob");
        factoryBean.setGroup("alphaJobGroup");
        // 声明该任务是否长久保存
        factoryBean.setDurability(true);
        // 声明该任务是否为可恢复的
        factoryBean.setRequestsRecovery(true);
        return factoryBean;
    }

    // 配置 Trigger
    // 两种方法：
    // 1.SimpleTriggerFactoryBean，简单的Trigger
    // 2.CronTriggerFactoryBean，复杂的Trigger
    //@Bean
    public SimpleTriggerFactoryBean alphaTrigger(JobDetail alphaJobDetail){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(alphaJobDetail);
        factoryBean.setName("alphaTrigger");
        factoryBean.setGroup("alphaTriggerGroup");
        // 间隔多长时间执行一次该任务
        factoryBean.setRepeatInterval(3000);
        // 存取Job的状态
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }

    //刷新帖子分数的任务
    @Bean
    public JobDetailFactoryBean postScoreRefreshJobDetail(){
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(PostScoreRefreshJob.class);
        factoryBean.setName("postScoreRefreshJob");
        factoryBean.setGroup("communityJobGroup");
        // 声明该任务是否长久保存
        factoryBean.setDurability(true);
        // 声明该任务是否为可恢复的
        factoryBean.setRequestsRecovery(true);
        return factoryBean;
    }

    @Bean
    public SimpleTriggerFactoryBean postScoreRefreshTrigger(JobDetail postScoreRefreshJobDetail){
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(postScoreRefreshJobDetail);
        factoryBean.setName("postScoreRefreshTrigger");
        factoryBean.setGroup("communityTriggerGroup");
        // 间隔多长时间执行一次该任务
        factoryBean.setRepeatInterval(1000 * 60 * 5);
        // 存取Job的状态
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }
}
