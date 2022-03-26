var value1 = 0;
var value2 = 0;
var result = 0;
var arithmetic ='';
var arr = [];
var display;
var flag = true;

function input(values){



display = document.getElementById("display");

if(!flag){
display.value = '';
flag=true;
}

display.value += values;


if(value1!=0 && arithmetic!='') {
value2 = display.value;
console.log("value2 : " +value2);
}

else{
value1 = display.value;
console.log("value1 : " + value1);
}
}

function symbol(sign){
 arr.push(sign);
 console.log("arr sign's: " +arr);
 arithmetic += sign;
  
 if(value1!=0 && value2!=0 && arithmetic.length==2 && (sign=='+' || sign=='-' || sign=='*' || sign=='/')){
   arithmetic = sign;
   glow();
   arithmetic = arr.shift();
   value1 = equalizer();
   console.log("new value1 : " +value1);
   console.log("value2 : " + value2);
   console.log("arr symbol : " +arithmetic);
 }

 else if(value1==0  && sign == '-'){
   document.getElementById("display").value = sign;
 }
 
 else if(value1 ==0 && (sign == '+'||sign == '*' || sign == '/')){
   document.getElementById("display").value  = '';
   arr.pop();
   console.log(arr);
}
  
 else if(value1!=0 && arithmetic.length>1 && (arithmetic =='+-' || arithmetic =='--' || arithmetic =='*-' || arithmetic == '/-')){
   arithmetic = arithmetic.substring(0);
   display.value = '-';
   console.log("arithmetic: " +arithmetic);
   arr.pop();
   console.log(arr);
}
  
 else if((value1!=0 || value2!=0) && arithmetic.length>0){
 arithmetic = sign;
 glow();
 console.log("arithmetic: " +arithmetic);
 }
 
 
}



function glow(){

display.value = ' ';
if(arithmetic == '+'){

document.getElementById("add").style.background = "#ff8000";
document.getElementById("sub").style.background = "white";
document.getElementById("mul").style.background = "white";
document.getElementById("div").style.background = "white";
}

else if(arithmetic == '-'){

document.getElementById("sub").style.background = "#ff8000";
document.getElementById("add").style.background = "white";
document.getElementById("mul").style.background = "white";
document.getElementById("div").style.background = "white";
}

else if(arithmetic == '*'){

document.getElementById("mul").style.background = "#ff8000";
document.getElementById("add").style.background = "white";
document.getElementById("sub").style.background = "white";
document.getElementById("div").style.background = "white";
}
else if(arithmetic == '/'){

document.getElementById("div").style.background = "#ff8000";
document.getElementById("add").style.background = "white";
document.getElementById("sub").style.background = "white";
document.getElementById("mul").style.background = "white";
}
}
       
function equalizer() {


flag = false;

if(arithmetic == '+'){
result = Number(value1) + Number(value2);

console.log("equalizer: " + result);
}

else if(arithmetic == '-'){
result = value1 - value2;
console.log("equalizer: " + result);
}

else if(arithmetic == '*'){
result = value1 * value2;
console.log("equalizer: " + result);
}

else if(arithmetic == '/'){
result = value1 / value2;
console.log("equalizer: " + result);
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

console.log("arithmetic equalizer : " + arithmetic);
display.value = result;
console.log("result : " + result);
return result;
document.getElementById("add").style.background = "white";
document.getElementById("sub").style.background = "white";
document.getElementById("mul").style.background = "white";
document.getElementById("div").style.background = "white";
}

function reloadC(){
equalizer();
display.value = '';
value1 = 0;
console.log("value1 : "+value1);
value2 = 0;
console.log("value2 : "+value2);
arithmetic ='';
console.log("arithmetic : "+arithmetic);

}
