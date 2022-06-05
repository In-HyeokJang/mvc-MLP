package action;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemoDAO;
import model.MemoDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		MemoDAO dao = new MemoDAO();
		MemoDTO dto = new MemoDTO();
		
		dto.setWname(request.getParameter("wname"));
		dto.setContent(request.getParameter("content"));
		dto.setTitle(request.getParameter("title"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setMemono(Integer.parseInt(request.getParameter("memono")));
		
		Map map = new HashMap();
		map.put("memono", dto.getMemono());
		map.put("passwd", dto.getPasswd());
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		if(pflag){
			flag = dao.update(dto);
		}
		
		request.setAttribute("pflag", pflag);
		request.setAttribute("flag", flag);
		
		return "/view/updateProc.jsp";
	}

}
