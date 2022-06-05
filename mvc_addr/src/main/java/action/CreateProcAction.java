package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AddrDAO;
import model.AddrDTO;

public class CreateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		AddrDTO dto = new AddrDTO();// 객체 생성
		
		// dto 객체에다가 set, get Parameter 사용해선 넣기
		dto.setName(request.getParameter("name"));
		dto.setHandphone(request.getParameter("handphone"));
		dto.setAddress(request.getParameter("address"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddress2(request.getParameter("address2"));
		
		AddrDAO dao = new AddrDAO(); // 객체 생성
		boolean flag = dao.create(dto); // boolean 변수 flag 생성 후 dao에 create받아 넣기
		
		// 2 request에 flag 받아온거 저장
		request.setAttribute("flag", flag);
		// 3 view로 보냄
		return "/view/createProc.jsp";
	}

}
