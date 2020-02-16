package com.scheduler.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scheduler.schedule.MyScheduledTask;

@RestController
public class HomeController {

	private static final String SCHEDULED_TASKS = "myScheduledTask";

	@Autowired
	private ScheduledAnnotationBeanPostProcessor postProcessor;

	@Autowired
	private MyScheduledTask myScheduledTasks;

	@Autowired
	private ObjectMapper objectMapper;

	
	@GetMapping(value = "/stopScheduler")
	public String stopSchedule() {
		postProcessor.postProcessBeforeDestruction(myScheduledTasks, SCHEDULED_TASKS);
		return "OK";
	}

	@GetMapping(value = "/startScheduler")
	public String startSchedule() {
		postProcessor.postProcessAfterInitialization(myScheduledTasks, SCHEDULED_TASKS);
		return "OK";
	}

	@GetMapping(value = "/listScheduler")
	public String listSchedules() throws JsonProcessingException {
		Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
		if (!setTasks.isEmpty()) {
			return objectMapper.writeValueAsString(setTasks);
		} else {
			return "No running tasks !";
		}
	}
}
