package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.BbsDAO;
import model.BbsDTO;
import utility.Utility;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		//검색 관련 내용 -----------------
		String col = Utility.checkNull(request.getParameter("col")); // Null포인트 오류 나지 않게 Utility.checkNull 사용
		String word = Utility.checkNull(request.getParameter("word"));

		if(col.equals("total"))word = "";

		//페이징 관련 ---------------------
		int nowPage = 1;
		if(request.getParameter("nowPage") != null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}

		int recordPerPage = 5;

		int sno = ((nowPage -1) * recordPerPage); //sno 시작 페이지 의미 
		int eno = recordPerPage;// 몇개를 가져올지 정하는거

		
		// 1. model사용
		Map map = new HashMap(); //map은 interface니까 hashmap으로 생성
		//검색 관련
		map.put("col",col);
		map.put("word",word);

		//paging 관련
		map.put("sno",sno);
		map.put("eno",eno);
		
		BbsDAO dao = new BbsDAO();//객체생성
		List<BbsDTO> list = dao.list(map); 
		int total = dao.total(map);
		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);

		// 2. model사용 결과를 request저장 (view페이지에서 사용할 내용을 저장한다.) 
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("col", col);
		request.setAttribute("word",word);
		request.setAttribute("nowPage", nowPage);
		// 3. view 선택(리턴)
		return "/view/list.jsp";
	}

}
