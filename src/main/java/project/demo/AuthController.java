package project.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import project.demo.dao.UserDao;
import project.demo.entities.User;

@Controller
public class AuthController {

	@Autowired
	UserDao userDao;

	@PostMapping("/adminlogin")
	public String login(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {

		System.out.println(user);

		try {
			User registeredUser = userDao.isUserRegistered(user.getUsername(), user.getPassword());

			if (registeredUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", registeredUser);

				System.out.println(session.getAttribute("user"));

				return "index";
			} else {

				model.addAttribute("result", "Can't find credentials");
				return "login";
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
			model.addAttribute("result", "Can't find credentials");
			return "login";
		}
	}

	@GetMapping("/logout")
	public String processLogout(HttpSession session, Model attr) {

		System.out.println(session.getAttribute("user"));
		session.invalidate();
		attr.addAttribute("result", "Logged out successfully");
		return "login";
	}
}

//ab
//abcd
