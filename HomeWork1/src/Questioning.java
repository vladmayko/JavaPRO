import java.io.IOException;
import javax.servlet.http.*;

/**
 * Created by MacUser on 20.05.19.
 */
public class Questioning extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Answer answer = new Answer();

        if(request.getParameter("cPlus") != null){
            answer.setcPlus(answer.getcPlus() + 1);
        }
        if(request.getParameter("cSharp") != null){
            answer.setcSharp(answer.getcSharp() + 1);
        }
        if(request.getParameter("java") != null){
            answer.setJava(answer.getJava() + 1);
        }
        if(request.getParameter("js") != null){
            answer.setJs(answer.getJs() + 1);
        }

        HttpSession session = request.getSession(true);
        answer.statistic();
        session.setAttribute("cPlus",  answer.getVal()[0]);
        session.setAttribute("java", answer.getVal()[1]);
        session.setAttribute("cSharp", answer.getVal()[2]);
        session.setAttribute("js", answer.getVal()[3]);
        response.sendRedirect("statistic.jsp");
    }
}
