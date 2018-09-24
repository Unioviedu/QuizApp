package com.prueba.demo;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniovi.quizapp.logic.api.ISectionManagement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SectionManagementTest {
	
	@Autowired
	private ISectionManagement sectionManagement;

}
