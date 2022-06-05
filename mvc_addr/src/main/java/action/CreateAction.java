package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
	
		// view 사용 createForm.jsp로 이동 시킴 
		return "/view/createForm.jsp";
		
	}

}
