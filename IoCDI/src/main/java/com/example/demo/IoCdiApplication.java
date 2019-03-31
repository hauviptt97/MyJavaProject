package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.beans.LectureObj;
import com.example.beans.LectureOne;
import com.example.beans.Student;
import com.example.config.IoCConfigByAnnotationfile;

public class IoCdiApplication {

	private static ApplicationContext context2;
	private static ApplicationContext context1;

	public static void main(String[] args) {
		context1 = new AnnotationConfigApplicationContext(IoCConfigByAnnotationfile.class);
		context2 = new ClassPathXmlApplicationContext("com/example/config/IoCConfigByXMLfile.xml");

		// config by Annotationfile
		Student student1 = (Student) context1.getBean("getStudent");
		System.out.println(student1);
		
		Student studentEmpty1 = (Student) context1.getBean("getStudentEmpty");
		System.out.println(studentEmpty1);
		
		LectureOne lecture1 = (LectureOne) context1.getBean("getLecture");
		lecture1.content();
		
		// config by XML file
		// inject object
		Student student2 = (Student) context2.getBean("student1Bean");
		System.out.println(student2);
		Student studentEmpty2 = (Student) context2.getBean("student2Bean");
		System.out.println(studentEmpty2);

		// inject interface
		LectureObj lecture2 = (LectureObj) context2.getBean("lectureObjBean");
		lecture2.content();
	}

}
