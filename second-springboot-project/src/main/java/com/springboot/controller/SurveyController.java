package com.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.model.Question;
import com.springboot.model.Survey;
import com.springboot.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	@RequestMapping(value = "surveys", method = RequestMethod.GET)
	public List<Survey> retrieveAllSurvey() {
		return surveyService.retrieveAllSurveys();
	}

	@RequestMapping(value = "surveys/{surveyID}/questions", method = RequestMethod.GET)
	// @GetMapping("surveys/{surveyID}/questions")
	public List<Question> retrieveQuestionForSurvey(@PathVariable String surveyID) {
		return surveyService.retrieveQuestions(surveyID);
	}

	@RequestMapping(value = "surveys/{surveyID}/questions", method = RequestMethod.POST)
	// @PostMapping("surveys/{surveyID}/questions")
	public ResponseEntity<?> addQuestionToSurvey(@PathVariable String surveyID, @RequestBody Question newQuestion) {

		Question createdTodo = surveyService.addQuestion(surveyID, newQuestion);

		if (createdTodo == null) {
			return ResponseEntity.noContent().build();
		}

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(createdTodo.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "surveys/{surveyID}/questions/{questionID}", method = RequestMethod.GET)
	public Question retrieveQuestion(@PathVariable String surveyID, @PathVariable String questionID) {
		return surveyService.retrieveQuestion(surveyID, questionID);
	}

}
