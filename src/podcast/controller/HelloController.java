package podcast.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String userName=request.getParameter("userName");
		
		Map<String,String> errors=new HashMap<String,String>();
		request.setAttribute("err", errors);
		
		if(userName==null||userName.length()==0) {
			errors.put("name","name is required");
		}
		
		if(errors!=null&&!errors.isEmpty()) {
			return new ModelAndView("form");
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("name", userName);
		session.setAttribute("msg", "Welcome!");
		
		return new ModelAndView("success");
	}

}
