package com.scheduler.schedule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.scheduler.model.B08Message;
import com.scheduler.repository.B08Repository;

@Component("myScheduledTask")
@EnableScheduling
public class MyScheduledTask {

	@Autowired
	B08Repository b08Repository;

	int transId = 1;
	int messageId = 200;

	@Scheduled(fixedRate = 5000)
	public void addB08Message() {
		System.out.println("executing job");
		System.out.println("Current Thread : {}" + Thread.currentThread().getName());
		List<B08Message> list = new ArrayList<B08Message>();
		for (int i = 0; i < 5; i++) {
			list.add(new B08Message(Integer.toString(transId++), "waiting", Integer.toString(messageId++), "raw xml",
					new Date(), false));
		}
		// b08Repository.saveAll(list);
	}

	

}
