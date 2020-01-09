<%@ page import="javafx.util.Pair" %>
<%@ page import="java.util.*" %>
<%@ page import="com.group.javaee.Pojo.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: wan14
  Date: 2020/1/1
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    Student student=new Student();
%>
<form action="/test">
    <input type="text" name="card" value="<%=student.getStudentId()%>"/>

    <button type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
</form>

</body>
</html>


<%
/*    Vector<Pair<Integer,Integer> >ans = new Vector<>();
    ans.add(new Pair<>(1,1));
    ans.add(new Pair<>(1,2));
    ans.add(new Pair<>(1,3));

    for(Pair x:ans){
        System.out.println(x);
    }*/

    Map<Integer, Integer> map = new IdentityHashMap<>();
    map.put(new Integer(1),6);
    map.put(new Integer(1),9);

    System.out.println(map);

    for(Integer a:map.keySet()){
        System.out.println(a);
        Integer y= map.get(a);
        System.out.println(y);
    }
%>
