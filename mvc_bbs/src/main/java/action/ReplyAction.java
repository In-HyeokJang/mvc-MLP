package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BbsDAO;
import model.BbsDTO;

public class ReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		//request.getParameter() 맥의 변수가 String로 받아오니까 Int형으로 형변환 해주어야 함
		int bbsno=Integer.parseInt(request.getParameter("bbsno"));
		
		BbsDAO dao = new BbsDAO();
		BbsDTO dto = dao.readReply(bbsno);
		
		request.setAttribute("dto", dto);
		
		return "/view/replyForm.jsp";
	}

}
