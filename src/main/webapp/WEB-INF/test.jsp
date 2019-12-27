
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <script src="./js/jquery.min.js"></script>
</head>
<body>
<form action="SearchBookServlet" method="post">
    <input type='hidden' name='csrfmiddlewaretoken' value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj' />
    <div>
        <div>
            <div class="glyphicon glyphicon-chevron-right"></div>
            <span >检索</span>
        </div>

        <div style="display: inline">
            <label style="vertical-align: top">检阅途径：</label>
            <select name="searchway" style="width:100px;height: 20px;overflow: hidden;" >
                <%
                    int n=3;
                    while(n--!=0){
                %>
                <tr>
                    <td><option value="<%=1+1%>" selected="selected" ></option></td>
                </tr>

                <%
                    }
                %>
            </select>

        </div>
        <div style="display: inline; vertical-align: bottom">
            <label>检索词：</label>
            <input name="searchname" style="width: 130px;height: 20px; vertical-align: top" type="tex" size="30">
            <input type="submit" style="width:50px;height: 20px; line-height: 20px;padding: 0;margin: 0" value="检索"/>
        </div>
    </div>
</form>

</body>
</html>