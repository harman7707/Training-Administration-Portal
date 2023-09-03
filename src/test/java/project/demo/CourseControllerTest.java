package project.demo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import project.demo.CourseController;
import project.demo.dao.CourseDao;
import project.demo.entities.Course;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
 
public class CourseControllerTest {
 
    @InjectMocks
    private CourseController courseController;
 
    @Mock
    private CourseDao courseDao;
 
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
 
    @Test
    public void testOpenCourseDashBoardPage() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course());
        when(courseDao.getListOfCourse()).thenReturn(courses);
 
        Model model = mock(Model.class);
        String result = courseController.openCourseDashBoardPage(model);
 
        assertEquals("course_dashboard", result);
        verify(courseDao, times(1)).getListOfCourse();
        verify(model, times(1)).addAttribute(eq("listOfCourse"), anyList());
    }
 
    @Test
    public void testAddCourseRequest() {
        Course course = new Course();
        when(courseDao.insertCourse(any(Course.class))).thenReturn(1);
 
        Model model = mock(Model.class);
        String result = courseController.addCourseRequest("Course Name", "Description", "Category", "Audience", "Benefits", model);
 
        assertEquals("course_dashboard", result);
        verify(courseDao, times(1)).insertCourse(any(Course.class));
        verify(model, times(1)).addAttribute(eq("message"), eq("Course Added Successfully"));
    }
 
    
}