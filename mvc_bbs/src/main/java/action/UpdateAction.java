package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BbsDAO;
import model.BbsDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		BbsDAO dao = new BbsDAO();
		BbsDTO dto = dao.read(bbsno);
		
		request.setAttribute("dto", dto);
		
		
		return "/view/updateForm.jsp";
	}

}
