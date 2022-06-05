package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.MemoDAO;
import model.MemoDTO;
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
				
				// model사용
				Map map = new HashMap();
				map.put("col",col);
				map.put("word",word);

				//paging 관련
				map.put("sno",sno);
				map.put("eno",eno);
				
				MemoDAO dao = new MemoDAO();
				List<MemoDTO> list = dao.list(map);
				int total = dao.total(map);
				String paging = Utility.paging(total, nowPage, recordPerPage, col, word);
				
				request.setAttribute("list", list);
				request.setAttribute("paging", paging);
				request.setAttribute("col", col);
				request.setAttribute("word", word);
				request.setAttribute("nowPage", nowPage);
		return "/view/list.jsp";
	}

}
