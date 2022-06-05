package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BbsDAO;
import model.BbsDTO;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		// model사용
		BbsDTO dto = new BbsDTO();
		//request.setCharacterEncoding("utf-8");
		dto.setWname(request.getParameter("wname"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		
		BbsDAO dao = new BbsDAO();
		boolean flag = dao.create(dto);
		// request 저장
		
		request.setAttribute("flag", flag);
		// view 사용
		return "/view/createProc.jsp";
	}

}
