<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Introspective Tool</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
body {
	background-image:
		url("https://images.unsplash.com/photo-1593640408182-31c70c8268f5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=842&q=80");
	background-repeat: no-repeat;
	background-size: cover;
	text-align: center;
	margin-top: 15vw;
	color: white;
}

span{
border: 1px solid black;
}
</style>
</head>
<body>

	<h1>Welcome to Introspective Tool</h1>
	<form action="data" method="post">
		<table align=center>
			<tr>
				<th>Class Name</th>
				<td><input style="/* color:white; */background: white;" type=text name=name class="form-control-plaintext"
					placeholder="package.class"></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type=submit
					class="btn btn-secondary active" style="margin-top: 1vh;" value=Check></td>
			</tr>
			<tr>
				<td colspan=2 align=center style="color: yellow;">*Note:- If your
					class is abc inside package xyz</td>
			</tr>
			<tr>
				<td colspan=2 align=center style="color: yellow;">Then please
					enter xyz.abc</td>
			</tr>
		</table>
	</form>



</body>
</html>