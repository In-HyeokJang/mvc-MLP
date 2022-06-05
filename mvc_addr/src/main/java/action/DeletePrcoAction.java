package action;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AddrDAO;

public class DeletePrcoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		int addressnum = Integer.parseInt(request.getParameter("addressnum"));
		// addressnum을 int로 형변환
		
		//mpa생성 해서 저장
		Map map = new HashMap();
		map.put("addressnum", addressnum);
		// map에 addressnum 넣음
		
		AddrDAO dao = new AddrDAO();// 객체 생성
		boolean flag = dao.delete(addressnum); // blooean 타입 사용 flag에 dao.delete(addressnum) 넣음
		
		//  결과값 request저장 flag
		request.setAttribute("flag", flag);
		// view 이동
		return "/view/deleteProc.jsp";
	}

}
