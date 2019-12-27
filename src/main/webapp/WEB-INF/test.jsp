<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title></title>
    <script src="./js/jquery.min.js"></script>
</head>
<body>
<form action="SearchBookServlet" method="post">
    <input type='hidden' name='csrfmiddlewaretoken'
           value='LkYIEOiULz1W5oDCFmaRRWL1fnniL0YAAPJ577ioIWitoo4zd5AL2BMCFOgUkkEj'/>
    <div>
        <div>
            <div class="glyphicon glyphicon-chevron-right"></div>
            <span>检索</span>
        </div>

        <div style="display: inline">
                <%
                    for(int i=0;i<3;i++) {
                        %>
                <tr>
                <%
                        for(int j=0;j<3;j++){
                %>
                    <td>
                        <input class="form-control" type="text" placeholder="证件号" maxlength="30">
                    </td>
                <tr>
                    <%
                        }
                    }
                %>

        </div>

    </div>
</form>

</body>
</html>