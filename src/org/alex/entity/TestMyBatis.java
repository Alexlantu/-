package org.alex.entity;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class TestMyBatis {
	public static void main(String args[]) throws IOException {
		//加载Mybatis配置文件（为了访问数据库）
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//相当于connection
		SqlSession session = sessionFactory.openSession();
//		拿到sql语句
//		String statement = "org.alex.entity.loginsMapper.queryLoginsById";
//		logins logins = session.selectOne(statement,"root");
//		System.out.println(logins);
		
		
		String st_queryUserid = "org.alex.entity.loginsMapper."+"queryUserid";
		Users users1 = session.selectOne(st_queryUserid, "2");
		System.out.println(users1);
		if(users1 == null) {
			String st_addUsers = "org.alex.entity.loginsMapper."+"addUsers";
			Users users2 = new Users();
			users2.setUserID("2");
			users2.setUserName("lifei");
			users2.setPhoneNumber("15857163720");
			users2.setEmail("lifei2015good@163.com");
			session.insert(st_addUsers, users2);
			session.commit();
			System.out.println("users表中没有数据");
		}else {
			Logins logins = new Logins();
			logins.setLoginid("alex");
			logins.setPassword("123");
			logins.setUserid("2");
			String st_addLogins = "org.alex.entity.loginsMapper.loginsInsert";
			session.insert(st_addLogins, logins);
			session.commit();
			System.out.println("现在有数据了");
		}
		session.close();
		
		System.out.println("执行完毕");
	}

}
