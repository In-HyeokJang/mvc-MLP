package action;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BbsDAO;

public class DelectProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		int bbsno = Integer.parseInt(request.getParameter("bbsno"));
		String passwd = request.getParameter("passwd");
		
		Map map = new HashMap();
		map.put("bbsno", bbsno);
		map.put("passwd", passwd);
		
		BbsDAO dao = new BbsDAO();
		boolean pflag = dao.passCheck(map);
		boolean flag = false;
		
		if(pflag) {
			flag = dao.delete(bbsno);
		}
		
		request.setAttribute("pflag", pflag);
		request.setAttribute("flag", flag);
		
		return "/view/deleteProc.jsp";
	}

}
