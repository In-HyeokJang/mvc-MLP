package action;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AddrDAO;
import model.AddrDTO;

public class UpdateProcAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		AddrDAO dao = new AddrDAO(); // 객체 생성
		AddrDTO dto = new AddrDTO(); // 객체생성
		//dto에 저장
		dto.setAddressnum(Integer.parseInt(request.getParameter("addressnum")));
		// addressnum은 int라 형변환 하고 addressnum으로 받아와서 이것도 코드 작성해야함 
		dto.setName(request.getParameter("name"));
		dto.setHandphone(request.getParameter("handphone"));
		dto.setAddress(request.getParameter("address"));
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddress2(request.getParameter("address2"));
		
		// boolean으로 받아주고
		// map은 key값을 가지고 있는 데이터를 저장한다
//		Map map = new HashMap();
//		map.put("addressnum", dto.getAddressnum());
//		boolean pflag = false;
		boolean flag = dao.update(dto);
//		if(pflag) {
//			flag=dao.update(dto);
//		}
//		
		
		// request에 저장
		request.setAttribute("flag", flag);
//		request.setAttribute("pflag", pflag);
		
		// 리턴
		return "/view/updateProc.jsp";
	}

}
