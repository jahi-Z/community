package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

/**
 * @author zjh
 * @version 1.0
 * @date 2022/7/15 18:02
 */

@Repository("alphaHibernate")
public class AlphaDaoHibernateImpl implements AlphaDao{

    @Override
    public String select() {
        return "Hibernate";
    }
}
