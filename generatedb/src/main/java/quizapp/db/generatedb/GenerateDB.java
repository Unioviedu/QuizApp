package quizapp.db.generatedb;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.uniovi.quizapp.dataacess.model.Level;
import com.uniovi.quizapp.dataacess.model.LevelRank;
import com.uniovi.quizapp.dataacess.model.Section;
import com.uniovi.quizapp.dataacess.model.challange.Challange;
import com.uniovi.quizapp.dataacess.model.challange.ChallangeSection;
import com.uniovi.quizapp.dataacess.model.challange.ChallangeTrophy;
import com.uniovi.quizapp.dataacess.model.question.Option;
import com.uniovi.quizapp.dataacess.model.question.QuestionCodeBlock;
import com.uniovi.quizapp.dataacess.model.question.QuestionOptions;
import com.uniovi.quizapp.dataacess.model.user.ResultChallange;
import com.uniovi.quizapp.dataacess.model.user.ResultSection;
import com.uniovi.quizapp.dataacess.model.user.User;
import com.uniovi.quizapp.logic.general.ChallangeFunction;
import com.uniovi.quizapp.logic.general.TrophyFunction;

public class GenerateDB {
	
	List<Challange> challanges = new ArrayList<>();
	List<LevelRank> levelsRank = new ArrayList<>();
	List<Section> sections = new ArrayList<>();
	User user;
	
	public void create() {
		Morphia morphia = new Morphia();
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		
		mongoClient.dropDatabase("prueba");

        Datastore datastore = morphia.createDatastore(mongoClient, "prueba");
        
		createChallanges();
		createLevelRanks();
		
		Option o1 = new Option("Option1", true);
		Option o2 = new Option("Option2", false);
		Option o3 = new Option("Option3", true);
		Option o4 = new Option("Option4", false);
		Option o5 = new Option("Option5", false);
		Option o6 = new Option("Option6", false);
		
		QuestionOptions question1 = new QuestionOptions("Question 1", "Primera pregunta");
		question1.addOptions(o1, o2, o3, o4);
		
		QuestionOptions question2 = new QuestionOptions("Question 2", "Segunda pregunta");
		question2.addOptions(o1, o2, o3, o4, o5, o6);
		
		QuestionCodeBlock question3 = new QuestionCodeBlock("Question 3", "Forma un elemento de encabezado correcto");
		question3.setCodeBlocksOptions(new String [] { "<h1>", "<h2>", "<p>", "</h1>" });
		question3.setCodeBlocksCorrect(new String[] { "<h1>", "</h1>" });
		
		Level l11 = new Level("1_1", true, "Level 1", 100);
		l11.addQuestions(question1, question2);
		Level l12 = new Level("1_2", true, "Level 2", 200);
		l12.addQuestions(question1, question3);
		Level l13 = new Level("1_3", false, "Level 3", 150);
		l13.addQuestions(question1);
		
		l11.addNextLevels(l12, l13);
		
		Section s1 = new Section("1", "Introducción", "Esta es una sección de introducción");
		s1.addLevels(l11, l12, l13);
		
		Level l21 = new Level("2_1", true, "Level 1", 100);
		Level l22 = new Level("2_2", true, "Level 2", 200);
		Level l23 = new Level("2_3", false, "Level 3", 150);
		
		Section s2 = new Section("2", "Principios básicos", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
		s2.addLevels(l21, l22, l23);
		s1.addNextSection(s2);
		
		Level l31 = new Level("3_1", true, "Level 1", 100);
		Level l32 = new Level("3_2", true, "Level 2", 100);
		Level l33 = new Level("3_3", true, "Level 3", 100);
		Level l34 = new Level("3_4", true, "Level 4", 100);
		Level l35 = new Level("3_5", false, "Level 5", 100);
		Level l36 = new Level("3_6", false, "Level 6", 100);
		
		Section s3 = new Section("3", "Principios intermedios", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
		s3.addLevels(l31, l32, l33, l34, l35, l36);
		
		Level l41 = new Level("4_1", true, "Level 1", 170);
		
		Section s4 = new Section("4", "Principios avanzados", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
		s4.addLevels(l41);
		
		ResultSection rs1 = new ResultSection(s1, challanges);
		rs1.setUnlocked(true);
		
		User user = new User("edu", "edu");
		user.addResultSection(rs1);
		
		this.user = user;
		sections.add(s1);
		sections.add(s2);
		sections.add(s3);
		sections.add(s4);
		
		createTrophies();
		
		datastore.save(challanges);
		datastore.save(levelsRank);
		datastore.save(sections);
		datastore.save(user);
	}

	private void createLevelRanks() {
		LevelRank lr1 = new LevelRank("Noob", 0);
		LevelRank lr2 = new LevelRank("Intermediate", 100);
		LevelRank lr3 = new LevelRank("Pro", 300);
		
		levelsRank.add(lr1);
		levelsRank.add(lr2);
		levelsRank.add(lr3);
	
	}

	private void createChallanges() {
		
		Challange c1 = new ChallangeSection(
				ChallangeFunction.ALL_CORRECT_TO_FIRST, 
				"Completa un nivel sin fallos a la primera");
		Challange c2 = new ChallangeSection(
				ChallangeFunction.ALL_LEVELS_ALL_CORRECT, 
				"Completa todos los niveles sin ningun fallo");
		Challange c3 = new ChallangeSection(
				ChallangeFunction.ALL_LEVELS_UNLOCK, 
				"Desbloquea todos los niveles");
		
		challanges.add(c1);
		challanges.add(c2);
		challanges.add(c3);
	}
	
	private void createTrophies() {
		
		Challange c1 = new ChallangeTrophy(
				TrophyFunction.FIRST_SECTION_COMPLETE, 
				"Completa tu primera sección del modo historia",
				"Un pequeño paso...");
		
		ResultChallange rc = new ResultChallange(c1);
		
		user.getResultTrophies().add(rc);
	}

}
