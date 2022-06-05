package action;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BbsDAO;
import model.BbsDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		BbsDAO dao = new BbsDAO();
		BbsDTO dto = new BbsDTO();
		dto.setWname(request.getParameter("wname"));
		dto.setTitle(request.getParameter("title"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setBbsno(Integer.parseInt(request.getParameter("bbsno")));
		
		Map map = new HashMap();
		map.put("bbsno", dto.getBbsno());
		map.put("passwd", dto.getPasswd());
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		if(pflag) {  //올바른 비밀번호
			flag = dao.update(dto);  //수정처리
		}
		
		request.setAttribute("pflag", pflag);
		request.setAttribute("flag", flag);
		
		return "/view/updateProc.jsp";
	}

}
