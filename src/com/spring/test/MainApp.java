package com.spring.test;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ApplicationContext;
//导入类
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//Import log4j classes.
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entity.UserEntity;
import com.ibatis.mapper.UserMapper;

public class MainApp {
	// 获取以当前类为参数的日志对象
	// private static Log log = LogFactory.getLog(MainApp.class);
	// Logger instance named "MyApp".
	public String tempName = MainApp.class.getName();
	private static final Logger logger = LogManager.getLogger(MainApp.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Beans.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		obj.getMessage();

		// 输出4种不同级别的日志
		// log.debug("111");
		// log.info("222");
		// log.warn("333");
		// log.error("444");

		logger.trace("Entering application.");
		logger.info("Didn't do it info.");
		logger.warn("Didn't do it warn.");
		logger.error("Didn't do it.");
		logger.trace("Exiting application.");

		String resource = "com/ibatis/mapper/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);

			SqlSession session = sqlSessionFactory.openSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			UserEntity user = mapper.selectUser(1);
			System.out.println("select user: " + user.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
