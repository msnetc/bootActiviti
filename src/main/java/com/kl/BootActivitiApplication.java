package com.kl;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BootActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootActivitiApplication.class, args);
	}
	@Bean
	InitializingBean usersAndGroupsInitializer() {

		return new InitializingBean() {
			@Autowired
			private RuntimeService runtimeService;
			@Autowired
			IdentityService identityService;
			public void afterPropertiesSet() throws Exception {

//
//				Group group = identityService.newGroup("user");
//				group.setName("users");
//				group.setType("security-role");
//				identityService.saveGroup(group);
//				User admin = identityService.newUser("kl");
//				admin.setPassword("kl");
//				identityService.saveUser(admin);

				Map<String, Object> variables = new HashMap<String, Object>();
				variables.put("kl","ckl");
				ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("hireProcessWithJpa", variables);			}
		};
	}
}
