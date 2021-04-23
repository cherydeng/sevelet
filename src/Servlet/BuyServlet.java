package Servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.MyTools;
import entity.ShopCar;
import entity.GoodsSingle;

public class BuyServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doPost(request,response);

    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        if(action.equals("buy")){
            buy(request,response);
        }
        if(action.equals("remove")){
            remove(request,response);
        }
        if(action.equals("clear")){
            clear(request,response);
        }
    }
    protected void buy(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        HttpSession session = request.getSession();
        String strId = request.getParameter("id");

        int id = MyTools.strToint(strId);
        ArrayList goodslist = (ArrayList)session.getAttribute("goodslist");
        GoodsSingle single = (GoodsSingle)goodslist.get(id);
        ArrayList buylist = (ArrayList)session.getAttribute("buylist");
        if(buylist == null){
            buylist = new ArrayList();
        }
        ShopCar myCar = new ShopCar();
        myCar.setBuyList(buylist);
        myCar.addItem(single);
        session.setAttribute("buylist",buylist);
        response.sendRedirect("show.jsp");
    }
    protected void remove(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        HttpSession session = request.getSession();
        ArrayList buylist = (ArrayList)session.getAttribute("buylist");
        String name = request.getParameter("name");
        ShopCar myCar = new ShopCar();
        myCar.setBuyList(buylist);
        myCar.removeItem(MyTools.toChinese(name));

        response.sendRedirect("shopcar.jsp");
    }

    protected void clear(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        HttpSession session = request.getSession();
        ArrayList buylist = (ArrayList)session.getAttribute("buylist");
        buylist.clear();
        response.sendRedirect("shopcar.jsp");
    }
}
