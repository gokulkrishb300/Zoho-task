<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trapping Sequence</title>
<link rel="stylesheet" href="trap.css">
<script>
function trap(){
	var a=3,b=5,count=0;
	while(a<14){
	let display;
	if(a==b){
		document.getElementById("demo").innerHTML += "<ul><li>("+myFunction(a,b)+")</li></ul>"
		display =a;	
		b+=2;
		
	}
	
	else if((a%b)==0 || (b%a)==0){
		document.getElementById("demo").innerHTML += "<ul><li>("+myFunction(a,b)+")</li></ul>"
		display = a;
		b+=2;
		
	}
	
	else if((sumOfDigits(a))%b==0 || (b%(sumOfDigits(a))==0)){
		document.getElementById("demo").innerHTML += "<ul><li>("+ myFunction(a,b)+")</li></ul>"
		display =a;
		b+=2;
	}
	
	else{
		b--;
		if(b<3) {
			b=3;
		}
	}
	a++;
	count++;
	
	}
}

function sumOfDigits(a){
	let sum=0,digit=0;
	while(a>0){
		digit = a%10;
		sum += digit;
		a/=10;
	}
	return sum;
}



function myFunction(a,b) {
  return a +","+ b;
}



</script>
</head>
<body>
<div class="container">
<div class="vertical">
<button onclick="trap()">Generate</button>
<p id ="result"></p>
<p id = "count"></p>
<p id="demo"></p>
</div>
</div>
</body>
</html>