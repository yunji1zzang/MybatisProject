package com.springbook.biz.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


// Mybatis를 이용하여 DAO를 구현하려면 SqlSession 객체가 필요하다. 그런데, 이 SqlSession 객체를
// 얻으려면 SqlSessionFactory 객체가 필요하다. 그래서, DAO 클래스를 구현하기에 앞서
// SqlSessionFactory 객체를 생성하는 SqlSessionFactoryBean 유틸리티 클래스를 작성해야 한다.
public class SqlSessionFactoryBean {

	private static SqlSessionFactory sessionFactory = null;
	
	static {
		try {
			if (sessionFactory == null) {
				// 여기서 중요한 내용은 우선적으로 Mybatis 메인 설정 파일인
				// sql-map-config.xm 파일로부터 설정 정보를 읽어 들이기 위한
				// 입력 스트림을 생성해야 한다. 그리고나서, 입력 스트림을 통해
				// sql-map-config.xm 파일을 읽어 SqlSessionFactory 객체를 생성한다.
				Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
				sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// getSqlSessionInstance() 메서드는 SqlSessionFactory 객체로부터
	// SqlSession 객체를 얻어내어 리턴하는 메서드이며, 이 메서드를 이용하여
	// SqlSession 객체가 필요한 DAO 클래스를 구현하면 된다.
	public static SqlSession getSqlSessionInstance() {
		return sessionFactory.openSession();
	}
	
	
}
