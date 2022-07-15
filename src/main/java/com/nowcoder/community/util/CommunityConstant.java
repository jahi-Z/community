package com.nowcoder.community.util;

/**
 * @author zjh
 * @version 1.0
 * @date 2022/7/16 18:43
 */
public interface CommunityConstant {

    //激活成功
    int ACTIVATION_SUCCESS = 0;
    //重复激活
    int ACTIVATION_REPEAT = 1;
    //激活失败
    int ACTIVATION_FAILURE = 2;

    //默认状态的登录凭证的超时时间
    int DEFAULT_EXPIRED_SECONDS = 3600 * 12;
    //记住账号密码情况下的登录凭证超时时间
    int REMEMBER_EXPIRED_SECONDS = 3600 * 24 * 10;

    //实体类型 : 帖子
    int ENTITY_TYPE_POST = 1;

    //实体类型 : 评论
    int ENTITY_TYPE_COMMENT = 2;

}
