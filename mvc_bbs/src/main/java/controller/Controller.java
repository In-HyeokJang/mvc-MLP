package controller; 
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import action.Action;
import action.NullAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
 
public class Controller extends HttpServlet { //servlet
    private boolean usingTemplate = false; 
    private String templatePage = null; 
    
    //명령어=명령처리Action객체
    private Map map = new java.util.HashMap(); 
     
    public void init(ServletConfig config) throws ServletException { 
    	//init메소드, init은 명령어와 명령 핸들러 선언
        String configFile = config.getInitParameter("configFile"); 
         
        Properties prop = new Properties(); 
        FileInputStream fis = null; 
        try { 
            fis = new FileInputStream(configFile); 
            prop.load(fis); 
        } catch (IOException e) { 
            throw new ServletException(e); 
        } finally { 
            if (fis != null) try { fis.close(); } catch(IOException ex) {} 
        } 
         
        Iterator keyIter = prop.keySet().iterator(); 
        while( keyIter.hasNext() ) { 
            String command = (String)keyIter.next(); 
            System.out.println("command: " + command); 
 
            // 명령어, 명령어 핸들러
            // config.properties => Properties =>Action객체 생성
            //	(파일)				(string key, string value)
            // => Action객체 Map에 저장
            String handlerClassName = prop.getProperty(command).trim();  
            System.out.println("handlerClassName: " + handlerClassName); 
             
            try { 
                //클래스를 JVM으로 로딩합니다. 
                Class handlerClass = Class.forName(handlerClassName); 
                //class.forname을 통해 저장 어느게 올지 몰라서 class.forname으로 사용
                 
                //읽어들인 클래의 객체를 생성합니다. 
                Object handlerInstance = handlerClass.newInstance(); 
                 
                //MAP에 키와 각 클래스별 객체가 저장합니다. 
                map.put(command, handlerInstance); 
                
            } catch (ClassNotFoundException e) { 
                throw new ServletException(e); 
            } catch (InstantiationException e) { 
                throw new ServletException(e); 
            } catch (IllegalAccessException e) { 
                throw new ServletException(e); 
            } 
        } 
      
        templatePage = config.getInitParameter("templatePage"); //template 설정
        
        if (templatePage != null && !templatePage.equals("")) { 
            usingTemplate = true; // 템플릿 페이지 존재 
        } 
    } 
    // 1. http 요청받음 여기서 부터 끝까지 다!
    // 요청 명령을 분석 ->action 객체 사용 ->
    			// (model 사용 -> 결과를 request에 저장-> view선택) ->forward
    public void doGet( 
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
 
    protected void doPost( 
        HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException { 
        process(request, response); 
    } 
     //service가 요청 했을때 작동, 사용자 정의 메소드
    private void process( 
        HttpServletRequest request, HttpServletResponse response)  
    throws ServletException, IOException { 
    	
    	
    	// 2. 클라이언트 요청 기능 분석 부분 ~ nullAction 까지
        String command = request.getRequestURI(); // URI 값 분석
        System.out.println("RequestURI: " + request.getRequestURI()); // URI 출력
        
        //URI:/mvc_bbs/bbs/list.do
        if (command.indexOf(request.getContextPath()) == 0) { 
            command = command.substring(request.getContextPath().length()); 
            System.out.println("command: " + command); // /mvc/list.do나옴
        } 
         
 
        Action action =  
            (Action)map.get(command); //다운캐스팅해서 받음
         
        // 핸들러가 없는 경우 
        if (action == null) { 
            action = new NullAction(); 
        } 
         
        String viewPage = null; 
        try { 
        	// "/view/hello.jsp" =>viewPage에 들어감
        	//3,4,5 . execute가  3. model사용, 4. request 결과저장, 5. view선택(리턴)
            viewPage = action.execute(request, response); 
        } catch(Throwable e) { 
            throw new ServletException(e); 
        } 
         
        if (usingTemplate) { // false -> true (web.xml에서 templatePage가 있냐 없냐에 해서 true로 바뀜)
            request.setAttribute("CONTENT_PAGE", viewPage); // request에 저장
        } 
        //6. forward 처리
        // jsp에서 사용했던 forward를 controller에서는 이렇게 사용함
        // <jsp:forward page=""/> 이거를 이렇게 바뀜
        RequestDispatcher dispatcher = 
           request.getRequestDispatcher( 
                   usingTemplate ? templatePage : viewPage); 
        dispatcher.forward(request, response); 
    } 
} 
