package project.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import project.demo.dao.CourseDao;
import project.demo.dao.TrainerDao;
import project.demo.dao.TrainingDao;
import project.demo.entities.Course;
import project.demo.entities.Trainer;
import project.demo.entities.Training;

@Controller
public class TrainingController {

	@Autowired
	TrainingDao trainingDao;

	@Autowired
	TrainerDao trainerDao;

	@Autowired
	CourseDao courseDao;

	@RequestMapping("/openAddTrainingPage")
	public String openAddTrainerPage(Model model) {
		List<Training> listOfTraining = trainingDao.getListOfTraining();
		List<Trainer> listOfTrainer = trainerDao.getListOfTrainer();
		List<Course> listOfCourse = courseDao.getListOfCourse();
		// model.addAttribute("listOfTraining",listOfTraining);
		model.addAttribute("listOfCourse", listOfCourse);
		model.addAttribute("listOfTrainer", listOfTrainer);
		return "trainingAddForm";
	}

	@RequestMapping("/openDashboardTraining")
	public String openIndexTrainingPage() {
		return "index";
	}

	@RequestMapping(path = "/addTraining", method = RequestMethod.POST)
	public String addTraining(@RequestParam("courseId") int courseId, @RequestParam("trainerId") int trainerId,
			@RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date,
			@RequestParam("fees") double fees, @RequestParam("discount") double discount,
			@RequestParam("batchSize") int batchSize, Model model

	) {
		Training training = new Training();

		training.setCourseId(courseId);
		training.setTrainerId(trainerId);
		training.setStart_date(LocalDate.parse(start_date));
		training.setEnd_date(LocalDate.parse(end_date));
		training.setFees(fees);
		training.setDiscount(discount);
		training.setBatchSize(batchSize);

		int result = trainingDao.insertTraining(training);
		List<Training> listOfTraining = trainingDao.getListOfTraining();
		List<Trainer> listOfTrainer = new ArrayList();
		List<Course> listOfCourse = new ArrayList();
		int size = listOfTraining.size();
		System.out.println("courseId: " + courseId);
		System.out.println("trainerId: " + trainerId);
		for (Training train : listOfTraining) {
			listOfTrainer.add(trainerDao.getTrainer(train.getTrainerId()));
			listOfCourse.add(courseDao.getCourse(train.getCourseId()));
		}

//		System.out.println("result="+result);
		if (result > 0) {
			System.out.println("Added");
			model.addAttribute("message", "training added successfully");
			model.addAttribute("listOfTraining", listOfTraining);
			model.addAttribute("listOfCourse", listOfCourse);
			model.addAttribute("listOfTrainer", listOfTrainer);

			return "training_dashboard";

		}
		if (result >= -1) {
			model.addAttribute("message", "training not available");
			model.addAttribute("listOfTraining", listOfTraining);
			model.addAttribute("listOfCourse", listOfCourse);
			model.addAttribute("listOfTrainer", listOfTrainer);
			System.out.println("check input");
			return "training_dashboard";

		} else {
			model.addAttribute("message ", "training can not be added");
			System.out.println("inside else method");
			return "training_dashboard";
		}

	}

	@RequestMapping(value = { "/viewTraining", "/openTrainingDashBoardPage" })
	public String openTrainingViewPage(Model model) {
		List<Training> listOfTraining = trainingDao.getListOfTraining();
		List<Trainer> listOfTrainer = new ArrayList();
		List<Course> listOfCourse = new ArrayList();
		int size = listOfTraining.size();
		for (Training training : listOfTraining) {
			listOfTrainer.add(trainerDao.getTrainer(training.getTrainerId()));
			listOfCourse.add(courseDao.getCourse(training.getCourseId()));
		}
		model.addAttribute("listOfTraining", listOfTraining);
		model.addAttribute("listOfCourse", listOfCourse);
		model.addAttribute("listOfTrainer", listOfTrainer);

		return "training_dashboard";
	}

	@RequestMapping("/Update_Training/{trainingId}")
	public ModelAndView updateTraining(

			@PathVariable("trainingId") int trainingId, Model model) {
		System.out.println("error coming");
		Training training = trainingDao.getTraining(trainingId);
		model.addAttribute("trainingToupdate", training);
		return new ModelAndView("updateTraining");

	}

	@PostMapping("/UpdateTraining/{trainingId}")
	public ModelAndView updateTrainerRequest(@PathVariable("trainingId") int trainingId,

			@RequestParam("courseId") int courseId, @RequestParam("trainerId") int trainerId,
			@RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date,
			@RequestParam("fees") double fees, @RequestParam("discount") double discount,
			@RequestParam("batchSize") int batchSize

	) {
		ModelAndView modelAndView = new ModelAndView();
		Training training = new Training();
		training.setTrainingId(trainingId);
		training.setCourseId(courseId);
		training.setTrainerId(trainerId);
		training.setStart_date(LocalDate.parse(start_date));
		training.setEnd_date(LocalDate.parse(end_date));
		training.setFees(fees);
		training.setDiscount(discount);
		training.setBatchSize(batchSize);
		System.out.println("error");

		int result = trainingDao.updateTraining(training);
		List<Training> listOfTraining = trainingDao.getListOfTraining();
		modelAndView.addObject("listOfTraining", listOfTraining);
		System.out.println("result" + result);
		List<Trainer> listOfTrainer = new ArrayList();
		List<Course> listOfCourse = new ArrayList();
		int size = listOfTraining.size();
		for (Training train : listOfTraining) {
			listOfTrainer.add(trainerDao.getTrainer(train.getTrainerId()));
			listOfCourse.add(courseDao.getCourse(train.getCourseId()));
		}

		if (result > 0) {
			System.out.println("updated");
			modelAndView.addObject("message", "training updated Successfully");
			modelAndView.addObject("listOfCourse", listOfCourse);
			modelAndView.addObject("listOfTrainer", listOfTrainer);
			modelAndView.setViewName("training_dashboard");

		} else {
			System.out.println("updated training not available");
			modelAndView.addObject("message", "updated training not available");
			modelAndView.addObject("listOfCourse", listOfCourse);
			modelAndView.addObject("listOfTrainer", listOfTrainer);
			modelAndView.setViewName("training_dashboard");
		}
		return modelAndView;

	}

	@RequestMapping("/deletetraining/{trainingId}")
	public ModelAndView deletetraining(@PathVariable("trainingId") int trainingId, Model model) {
		Training training = trainingDao.getTraining(trainingId);
		model.addAttribute("trainingToupdate", training);
		return new ModelAndView("trainer_dashboard");

	}

	@RequestMapping("/delete_training/{trainingId}")
	public String deleteTrainer(@PathVariable("trainingId") int trainingId, Model model) {
		int result = trainingDao.deleteTraining(trainingId);
		List<Training> listOfTraining = trainingDao.getListOfTraining();
		List<Trainer> listOfTrainer = new ArrayList();
		List<Course> listOfCourse = new ArrayList();
		int size = listOfTraining.size();
		for (Training training : listOfTraining) {
			listOfTrainer.add(trainerDao.getTrainer(training.getTrainerId()));
			listOfCourse.add(courseDao.getCourse(training.getCourseId()));
		}
		model.addAttribute("listOfTraining", listOfTraining);
		model.addAttribute("listOfCourse", listOfCourse);
		model.addAttribute("listOfTrainer", listOfTrainer);

		if (result > 0) {
			model.addAttribute("message", "training deleted succesfully");
		} else {
			model.addAttribute("message", "training can't be deleted");

		}
		return "training_dashboard";

	}

}
