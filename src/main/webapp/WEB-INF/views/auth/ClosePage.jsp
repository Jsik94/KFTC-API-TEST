<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		입력 아무거나 : <input type="text" id="inputData" name="inputData" value="${param.code}">
		<br/>
		<input type="button" value="종료해버렷" onclick="sendDataNClosed()"/>
</body>
</html>

<script>
	function sendDataNClosed(){
		opener.document.getElementById("getTestResult").value = document.getElementById("inputData").value
		window.close()
	}

</script>