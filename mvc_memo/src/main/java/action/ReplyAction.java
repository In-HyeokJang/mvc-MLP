package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemoDAO;
import model.MemoDTO;

public class ReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		
		int memono = Integer.parseInt(request.getParameter("memono"));
		MemoDAO dao = new MemoDAO();
		MemoDTO dto = dao.readReply(memono); // 부모의 grpno, indent, ansnum
		
		request.setAttribute("dto", dto);
		
		return "/view/replyForm.jsp";
	}

}
