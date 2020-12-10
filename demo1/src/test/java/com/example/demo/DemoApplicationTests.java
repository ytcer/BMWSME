package com.example.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.glassfish.jersey.server.model.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    DataSource dataSource;
    @Test
public void test() throws IOException {

      /*  InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<String> objects = sqlSession.selectList("testMapper.findAll");
        sqlSession.insert("testMapper.insert");
        sqlSession.commit();
        System.out.println(objects);*/

                /*authorizationTest authorizationTest = new authorizationTest();
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(authorizationTest);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken admin = new UsernamePasswordToken("admin", "123456");
        subject.login(admin);

        subject.checkRole("admin");
        subject.checkPermission("user:add");
        Session session = subject.getSession(true);
        System.out.println(session.getId());
        System.out.println(session.getTimeout());

        System.out.println(Arrays.toString(subject.isPermitted()));

*/
    }

}
