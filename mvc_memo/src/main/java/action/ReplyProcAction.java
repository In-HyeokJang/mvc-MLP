package action;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemoDAO;
import model.MemoDTO;

public class ReplyProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		
		
		MemoDTO dto = new MemoDTO();
		dto.setWname(request.getParameter("wname"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		
		dto.setMemono(Integer.parseInt(request.getParameter("memono")));
		dto.setGrpno(Integer.parseInt(request.getParameter("grpno")));
		dto.setIndent(Integer.parseInt(request.getParameter("indent")));
		dto.setAnsnum(Integer.parseInt(request.getParameter("ansnum")));
		
		Map map = new HashMap();
		map.put("grpno", dto.getGrpno());
		map.put("ansnum", dto.getAnsnum());
		
		MemoDAO dao = new MemoDAO();
		
		dao.upAnsnum(map);
		boolean flag = dao.createReply(dto);
		
		request.setAttribute("flag",flag);
		
		return "/view/replyProc.jsp";
	}

}
