
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <script src="./js/jquery.min.js"></script>
    <script>
        window.onload = function(){
            //动态的往select里面添加option(JS方式添加)
            var select = document.createElement("select");
            select.setAttribute('id','sc');
            select.setAttribute('onchange','change()');
            document.body.appendChild(select);
            for(var n = 1;n<10;n++){
                select.options.add(new Option('添加option'+n,n+""));
            }

            //Jquery动态添加option
            for(var m = 1;m<10;m++){
                $('#selectid').append("<option value="+m+">option"+m+"</option>");
            }
            change();
        }

        function change(){
            //js方式获取当前选中项
            //拿到select的对象
            var sel1 = document.getElementById('selectid');
            //获取当前选中项的索引
            var index = sel1.selectedIndex;
            //拿到选中的option的value
            console.log(sel1.options[index].value);
            //拿到选中的option的text
            console.log(sel1.options[index].text);

            //Jquery方式获取当前选中项
            var sel2 = $('#selectid option:selected');
            //拿到选中的option的value
            console.log(sel2.val());
            //拿到选中的option的text
            console.log(sel2.text());
        }
    </script>
</head>
<body>
<select id='selectid' οnchange="change()"  ></select>
</body>
</html>