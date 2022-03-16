<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trapping Sequence</title>
<link rel="stylesheet" href="trap.css">
<link rel="icon" href="data:;base64,iVBORw0KGgo=">

<script>
let map = new Map();

function sumOfDigits(a){

	let sum=0,digit=0;
	while(a>0){
		digit = a%10;
		sum += digit;
		a=Math.floor(a/10);
	}
	return sum;
	}
	

function trap(x,n,y){
	
	let a=x,b=y;

	while(a<=n){
	if(a==b){
		map.set(a,b);
		b+=2;
	}
	else if((a%b)==0 || (b%a)==0){
		map.set(a,b);
	
		b+=2;	
	}
	else if((sumOfDigits(a))%b==0 || (b%(sumOfDigits(a))==0)){
		map.set(a,b);
		b+=2;
	}
	else{
	
		b--;
		if(b<3) {
			b=3;
		}
	}
	a++;
	}
	console.log(map.size);	
	map.forEach(displayMap);
}



function displayMap(values,key){
	
	document.getElementById("count").innerHTML ="No.of Traps: "+map.size;
	document.getElementById("result").innerHTML +="("+ key+","+values+")<br>";
	console.log(key+" "+values);
}

</script>
</head>
<body>

<div class="container">
<div class="buttoncenter">
<button onclick="trap(2,8,3)">Generate</button>
</div>
<div class="values">
<h2 id="count"></h2>
<h2 id="result"></h2>
</div>
</div>


</body>
</html>