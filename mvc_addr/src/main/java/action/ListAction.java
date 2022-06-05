package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AddrDAO;
import model.AddrDTO;
import utility.Utility;

public class ListAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse respons) {
		//검색 관련 내용 ----------------
		String col = Utility.checkNull(request.getParameter("col"));
		String word = Utility.checkNull(request.getParameter("word"));
		if(col.equals("total"))word = "";
		//페이징 관련
		int nowPage =1;
		if(request.getParameter("nowPage")!=null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}

		int recordPerPage = 5;
		int sno = ((nowPage -1) * recordPerPage);//sno 시작 페이지 의미
		int eno = recordPerPage;// 몇개를 가져올지 정하는거
		
		
		//1. model 사용
		Map map = new HashMap(); //map 객체 생성하고 map에 저장
		map.put("col",col);
		map.put("word",word);
		map.put("sno", sno);
		map.put("eno",eno);
		
		AddrDAO dao = new AddrDAO(); // dao 객체 생성
		List<AddrDTO> list = dao.list(map); // list 객체 생성 하고 거기다가 mpa 받아온거 넣고 dao.list에 넣고 list에 넣고
		int total=dao.total(map); // totlal int 선언 하고 넣고
		String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
		
		// 2 request에 저장
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		request.setAttribute("col", col);
		request.setAttribute("word", word);
		request.setAttribute("nowPage", nowPage);
		// 3. view 연결
		return "/view/list.jsp";
	}

}
