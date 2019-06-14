package org.alex.entity;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class TestMyBatis {
	public static void main(String args[]) throws IOException {
		//����Mybatis�����ļ���Ϊ�˷������ݿ⣩
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//�൱��connection
		SqlSession session = sessionFactory.openSession();
//		�õ�sql���
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
			System.out.println("users����û������");
		}else {
			Logins logins = new Logins();
			logins.setLoginid("alex");
			logins.setPassword("123");
			logins.setUserid("2");
			String st_addLogins = "org.alex.entity.loginsMapper.loginsInsert";
			session.insert(st_addLogins, logins);
			session.commit();
			System.out.println("������������");
		}
		session.close();
		
		System.out.println("ִ�����");
	}

}
