package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AddrDAO;
import model.AddrDTO;

public class UpdateAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		int addressnum = Integer.parseInt(request.getParameter("addressnum")); 
		// addressnum을 받와야 하기 때문에 Parameter로 가져와서 int로 형변환
		
		AddrDAO dao = new AddrDAO(); // 객체 생성
		AddrDTO dto = dao.read(addressnum); // dto에 dao.read랑 addressnum 받아옴
		
		//request에 저장
		request.setAttribute("dto", dto);
		
		// view로 이동
		return "/view/updateForm.jsp";
	}

}
