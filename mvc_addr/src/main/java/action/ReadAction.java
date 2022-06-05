package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AddrDAO;
import model.AddrDTO;

public class ReadAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		int addressnum = Integer.parseInt(request.getParameter("addressnum")); // addressnum 을 int로 형변환
		//번호 읽어오기
		AddrDAO dao = new AddrDAO();// 객체생성
		AddrDTO dto = dao.read(addressnum); // 한건의 레코드(데이터) 조회
		
		//request에 저장 위에서 받아온 dto
		request.setAttribute("dto", dto);
		// view 이동
		return "/view/read.jsp";
	}

}
