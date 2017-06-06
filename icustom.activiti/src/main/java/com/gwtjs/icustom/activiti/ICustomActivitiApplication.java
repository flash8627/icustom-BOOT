package com.gwtjs.icustom.activiti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gwtjs.core.log.ICustomLogger;
import com.gwtjs.core.log.ICustomLoggerFactory;
import com.gwtjs.icustom.activiti.dao.CompRepository;
import com.gwtjs.icustom.activiti.dao.PersonRepository;
import com.gwtjs.icustom.activiti.model.Comp;
import com.gwtjs.icustom.activiti.model.Person;
import com.gwtjs.icustom.activiti.service.ActivitiService;

@SpringBootApplication
@ComponentScan("com.gwtjs.icustom.activiti")
@EnableJpaRepositories("com.gwtjs.icustom.activiti.dao")
@EntityScan("com.gwtjs.icustom.activiti.model")
public class ICustomActivitiApplication {
	
	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(ICustomActivitiApplication.class);
	
	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CompRepository compRepository;

	// 初始化模拟数据
	@Bean
	public CommandLineRunner init(final ActivitiService myService) {

		return new CommandLineRunner() {

			public void run(String... strings) throws Exception {
				if (personRepository.findAll().size() == 0) {
					personRepository.save(new Person("wtr"));
					personRepository.save(new Person("wyf"));
					personRepository.save(new Person("admin"));
				}

				if (compRepository.findAll().size() == 0) {
					Comp group = new Comp("great company");
					compRepository.save(group);
					Person admin = personRepository.findByPersonName("admin");
					Person wtr = personRepository.findByPersonName("wtr");
					admin.setComp(group);
					wtr.setComp(group);
					personRepository.save(admin);
					personRepository.save(wtr);
				}
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ICustomActivitiApplication.class, args);
		log.info("Running with Spring successfull------");
	}
}
