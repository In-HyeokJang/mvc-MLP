package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NullAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		// TODO Auto-generated method stub
		return "/view/nullCommand.jsp";
	}

}
