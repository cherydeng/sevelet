<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 2021-04-23
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.GoodsSingle" %>
<%@ page import="entity.ShopCar" %>
<%
    ArrayList buylist = (ArrayList)session.getAttribute("buylist");
    float total = 0;
%>
<table border="1" width="450" rules="none" cellpadding="0" cellspacing="0">
    <tr height="50">
        <td colspan="5" align="center">购买的商品如下</td>
    </tr>
    <tr align="center" height="30" bgcolor="#d3d3d3">
        <td width="25%">名称</td>
        <td>价格(元/斤)</td>
        <td>数量</td>
        <td>总价(元)</td>
        <td>移动(-1/次)</td>
    </tr>
<% if(buylist == null || buylist.size()==0){  %>
    <tr height="100">
        <td colspan="5" align="center">您的购物车为空！</td>
    </tr>
<%
}
else{

    for(int i=0;i < buylist.size();i++){
        GoodsSingle single=(GoodsSingle)buylist.get(i);
        String name = single.getName();
        float price=single.getPrice();
        int num=single.getNum();
        float money=((int)((price*num+0.05f)*10)/10f);
        total+=money;
%>
    <tr align="center" height="50">
        <td><%=name%></td>
        <td><%=price%>%></td>
        <td><%=num%></td>
        <td><%=money%></td>
        <td><a href="doCar?action=remove&name =<%=single.getName()%>">移除</a></td>
    </tr>
<%
        }
    }
%>
    <tr height="50" align="center">
        <td colspan="5">应付金额：<%=total%>></td>
    </tr>
    <tr height="50" align="center">
        <td colspan="2"><a href="show.jsp">继续购物</a></td>
        <td colspan="3"><a href="doCar?action=clear">清空购物车</a></td>
    </tr>
</table>
