var value1 = 0;
var value2 = 0;
var result = 0;
var arithmetic ='';
var temp = 0;

function input(values){
document.getElementById("display").value += values;

if(value1!=0 && (arithmetic =='+' || arithmetic =='-' || arithmetic =='*' || arithmetic == '/' || arithmetic =='+-' || arithmetic =='--' || arithmetic =='*-' || arithmetic == '/-')) {
value2 = document.getElementById("display").value;
console.log("value2 : " +value2);
}


else{
value1 = document.getElementById("display").value;
console.log("value1 : " + value1);
}


}




function symbol(sign){
 
 arithmetic += sign;
 
 if(value1==0  && (sign == '+' || sign == '-')){
 document.getElementById("display").value = sign;
 }
 
 else if(value1 ==0 && (sign == '*' || sign == '/')){
 document.getElementById("display").value = '';
 }
 
 else if(value1!=0 && arithmetic.length==1){
 arithmetic = arithmetic;
 glow();
 console.log("arithmetic: " +arithmetic);
 }

 
 else if(value1!=0 && arithmetic.length==2 && (arithmetic =='+-' || arithmetic =='--' ||   arithmetic =='*-' || arithmetic == '/-')){
 arithmetic = arithmetic.substring(0);
 document.getElementById("display").value = '-';
 glow();
 console.log("arithmetic: " +arithmetic);
 }
  
  
  
 else if(value2!=0 && ( sign=='+' || sign=='-' || sign=='*' ||sign=='/')){
 arithmetic = sign;

 value1 = equalizer();
  document.getElementById("display").value = result;

 console.log("arithmetic: " +arithmetic);
 console.log("value1: "+value1);
 console.log("value2: "+value2);
 console.log("result: "+result);
 }
 
 
 
 
 else if(value1!=0 && arithmetic.length>1){
 arithmetic = sign;
 glow();
 console.log("arithmetic: " +arithmetic);
 }

}



function glow(){
if(arithmetic == '+'){
document.getElementById("display").value = ' ';
document.getElementById("add").style.background = "#ff8000";
document.getElementById("sub").style.background = "white";
document.getElementById("mul").style.background = "white";
document.getElementById("div").style.background = "white";
}

else if(arithmetic == '-'){
document.getElementById("display").value = ' ';
document.getElementById("sub").style.background = "#ff8000";
document.getElementById("add").style.background = "white";
document.getElementById("mul").style.background = "white";
document.getElementById("div").style.background = "white";
}

else if(arithmetic == '*'){
document.getElementById("display").value = ' ';
document.getElementById("mul").style.background = "#ff8000";
document.getElementById("add").style.background = "white";
document.getElementById("sub").style.background = "white";
document.getElementById("div").style.background = "white";
}
else if(arithmetic == '/'){
document.getElementById("display").value = ' ';
document.getElementById("div").style.background = "#ff8000";
document.getElementById("add").style.background = "white";
document.getElementById("sub").style.background = "white";
document.getElementById("mul").style.background = "white";
}
}

function equalizer() {

if(arithmetic == '+'){
result = Number(value1) + Number(value2);
console.log("equalizer: " + result);
return result;
}

else if(arithmetic == '-'){
result = value1 - value2;

}

else if(arithmetic == '*'){
result = value1 * value2;

}

else if(arithmetic == '/'){
result = value1 / value2;
}

else if(arithmetic == '+-'){
result = Number(value1) + -Number(value2.substring(1));
console.log(result);
}

else if(arithmetic == '--'){
result = Number(value1) + Number(value2.substring(1));
console.log(result);
}

else if(arithmetic == '*-'){
result = Number(value1) * -Number(value2.substring(1));
console.log(result);
}

else if(arithmetic == '/-'){
result = Number(value1) / -Number(value2.substring(1));
console.log(result);
}



document.getElementById("display").value = ' ';
document.getElementById("display").value = result;
document.getElementById("add").style.background = "white";
document.getElementById("sub").style.background = "white";
document.getElementById("mul").style.background = "white";
document.getElementById("div").style.background = "white";

}

function reloadC(){
equalizer();
document.getElementById("display").value = '';
value1 = 0;
console.log("value1 : "+value1);
value2 = 0;
console.log("value2 : "+value2);
arithmetic ='';
console.log("arithmetic : "+arithmetic);

}
