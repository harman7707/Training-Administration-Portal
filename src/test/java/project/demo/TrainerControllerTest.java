package project.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import project.demo.dao.TrainerDao;
import project.demo.entities.Trainer;

class TrainerControllerTest {

    @Mock
    private TrainerDao trainerDao;

    @Mock
    private Model model;

    @InjectMocks
    private TrainerController trainerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testOpenDashboard() {
        String viewName = trainerController.openDashboard();
        assertEquals("index", viewName);
    }

    @Test
    void testOpenAddTrainerPage() {
        String viewName = trainerController.openAddTrainerPage();
        assertEquals("trainerAddForm", viewName);
    }

    @Test
    void testAddTrainer() {
        String trainerName = "John Doe";
        String qualification = "Ph.D.";
        String trainerDescription = "Experienced trainer";
        int year_of_exp = 5;
        String phone="9876543210";

        when(trainerDao.insertTrainer(any(Trainer.class))).thenReturn(1);

        String viewName = trainerController.addTrainer(
                trainerName, qualification, trainerDescription, year_of_exp, phone,model);

        assertEquals("trainer_dashboard", viewName);
        verify(trainerDao).insertTrainer(any(Trainer.class));
        verify(model).addAttribute(eq("listOfTrainer"), anyList());
        verify(model).addAttribute(eq("message"), eq("trainer added successfully"));  
    }

    

}
 