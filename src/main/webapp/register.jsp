
<html>

<head>
<title>Spring Boot Normal Web Application</title>

<style>
body {
   font-family: Arial, Helvetica, sans-serif;
   background-color: rgb(135, 192, 212);
}
* {
	margin:0px;
	padding:0px;
   box-sizing: border-box;
}
form {
   align-items: center;
}
form label {
   margin: 5px 10px 5px 0;
}
form input{
	margin: 5px 10px 5px 0;
   padding: 10px;
}
.input {
   margin: 5px 10px 5px 0;
   width: 100%;
   padding: 10px;
}
#subject{
	margin: 5px 10px 5px 0;
   padding: 10px;
}
.bgimage{
	width:60%;
	position:absolute;
	height:117%;
	right:0px;
}
.container{
	padding:20px;
	width:500px;
	position:absolute;
}
.button {
   padding: 10px 20px;
   font-size: 20px;
   background-color: rgb(109, 110, 106);
   border: 1px solid #ddd;
   color: white;
   cursor: pointer;
   font-weight: bolder;
   border-radius: 4px;
}
.button:hover {
   background-color: black;
}
@media (max-width: 800px) {
   form input {
      margin: 10px 0;
   }
   form {
      flex-direction: column;
      align-items: stretch;
   }
}
</style>
</head>

<body>
		<img class="bgimage" src="register2.png" alt="register">
		<form class= "container" method="post" action="/register" modelAttribute="user">
			<label>email:</label><br> 
			<input class="input" type="email" id="email" name="email"><br>
			
			<label>phone:</label><br> 
			<input class="input" type="text" id="phone" name="phone"><br>
			
			<label>name:</label><br> 
			<input class="input" type="text" id="name" name="name"><br> 
			
			
			<input class = "button" type="submit" value="register">
		</form>
	
</body>