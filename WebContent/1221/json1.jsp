<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON 테스트</title>
  <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(function() {
        $("#checkJson").click(function() {
        var jsonStr  = '{"name": ["홍길동", "이순신", "임꺽정"] }'; 
        /* Json은 데이터를 표시하는 포멧이다. (독립적,키벨류쌍) */
        var jsonInfo = JSON.parse(jsonStr);
        /* JSON.parse() 메서드는 JSON 문자열의 구문을 분석하고, 그 결과에서 JavaScript 값이나 객체를 생성한다.
                        선택적으로, reviver 함수를 인수로 전달할 경우, 결과를 반환하기 전에 변형 할 수 있다.*/
         
        var output ="회원 이름<br>";
        output += "=======<br>";
        for(var i in jsonInfo.name) {
        /* 향상된 반복문을 수행하면서 name을 키로 해서 벨류들을 하나씩 output으로 출력 해준다.  */
            output += jsonInfo.name[i]+"<br>";
        }
        $("#output").html(output);
      });
    });
        
</script>
  </head>
  <body>
    <a id="checkJson" style="cursor:pointer">출력</a><br><br>
    <div id="output"></div>
  </body>
</html>
