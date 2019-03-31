package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.beans.Lecture;
import com.example.beans.LectureOne;
import com.example.beans.Student;

@Configuration
public class IoCConfigByAnnotationfile {
	@Bean
	public Student getStudentEmpty() {
		return new Student();
	}
	
	@Bean
	public Student getStudent() {
		return new Student("Le Thi Na", 12);
	}
	
	@Bean
	public Lecture getLecture() {
		return new LectureOne();
	}
}
