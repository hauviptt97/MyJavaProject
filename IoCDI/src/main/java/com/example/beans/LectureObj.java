package com.example.beans;

public class LectureObj {
	LectureOne lectureOne;

	public LectureObj(LectureOne lectureOne) {
		this.lectureOne = lectureOne;
	}

	public void content() {
		lectureOne.content();
	}
}
