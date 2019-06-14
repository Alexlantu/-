package org.alex.entity;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestUniversity {

	public static void main(String[] args) throws IOException {
		
		Reader reader = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		String st_queryUniversity = "org.alex.entity.universityMapper."+"queryUniversity";
		List<University> universityList = session.selectList(st_queryUniversity);
		for(int i=0;i<universityList.size();i++) {
			System.out.println(universityList.get(i).getName()+"---"+universityList.get(i).getCity());
		}
		

		
		

	}

}
