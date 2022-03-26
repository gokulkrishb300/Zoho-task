var inputString="";
var arithmetic="";
var status=true;
var dot=0;
var paransCount=0;

function input(value)
{	
	opStore();
	
	var displayElement=document.getElementById("display");
	
	if(dot!=0&&value==".")
	{
		value="";
	}
	inputString+=value;
	
	displayElement.value=inputString;
	
	dot=value=="."?++dot:dot;
	
	status=true;
}

function symbol(value)
{
	dot=0;
	

	
	if(status && value=="-")
	{	
		if(inputString!=""&&arithmetic=="")
		{
			arithmetic=value;
		}
		else
		{
			opStore();
			
			arithmetic="";
			
			inputString+=value;
			
			status=false;
			
			arithmetic="";
		}
	}
	else if(status && opCheck())
	{
		arithmetic=value;
	}
	else
	{
		value="";
		
		opStore();
	}
	
	document.getElementById("display").value=inputString+""+arithmetic;
}

function backspace()
{	
	inputString=inputString.substr(0,inputString.length-1);
	
	document.getElementById("display").value=inputString;
}


function bodmasFunc()
{
	if(paransCount==0)
	{
		var dataArray=inputString.split(" ");
		
		dataArray=dataArray.filter(e=>e);
		
		document.getElementById("display").value=recurse(dataArray);
		
		inputString="";
		
		arithmetic="";
		
		status=true;
	}
}

function recurse(dataArray)
{
	
	let result=0;
	
	let flag=true;
	/*if(dataArray.length==1)
	{
		return dataArray[0];
	}*/
	
	while(flag)
	{
		let temp="";
		if(dataArray.length==1)
		{
			result=dataArray[0];
			
			break;
		}
		else
		if(dataArray.includes("("))
		{
			var start=dataArray.indexOf("(");
			
			var end=dataArray.indexOf(")");
			
			var sub=dataArray.slice(start+1,end);
			
			while(sub.includes("("))
			{
				let temp=sub.indexOf("(");
				
				let len=sub.length;
				
				sub=sub.slice(temp+1,len);
				
				start=dataArray.indexOf("(",temp+1);
			}
			dataArray.splice(start,end-start+1,recurse(sub));
			
			recurse(dataArray);
		}
		
		else
		if(dataArray.includes('/'))
		{
			temp="/";
		}
		
		else
		if(dataArray.includes('*'))
		{
			temp="*";
		}
		
		else
		if(dataArray.includes('%'))
		{
			temp="%";
		}
		
		else
		if(dataArray.includes('+'))
		{
			temp="+";
		}
		
		else
		if(dataArray.includes('-'))
		{
			temp="-";
		}
		
		if(temp!="")
		{
			let pos=dataArray.indexOf(temp);
			
			let data1=dataArray[pos-1];
			
			let data2=dataArray[pos+1];
			
			var res=equalAction(data1,temp,data2).toString();
			
			dataArray.splice(pos-1,3,res);
		}
	}

	return result;
}

function parans(value)
{	
	paransCount=value=="("?++paransCount:paransCount;
	
	value==")"?paransCount!=0?--paransCount:value="":"";
	
	opStore();
	
	arithmetic=value;
	
	inputString+=" "+value+" ";
	
	document.getElementById("display").value=inputString;
}

function equalAction(data1,temp,data2)
{	
	var result=0;
	switch(temp)
		{
			case "+":
				result=parseFloat(data1)+parseFloat(data2);
				break;
				
			case "-":
				result=parseFloat(data1)-parseFloat(data2);
				break;
						
			case "*":
				result=parseFloat(data1) * parseFloat(data2);
				break;
					
			case "/":
				result=parseFloat(data1)/parseFloat(data2);
				break;
				
			case "%":
				result=parseFloat(data1)%parseFloat(data2);
				break;
						
			default:
				console.log("default :"+arithmetic);
		}	
	return result;
}

function opCheck()
{
	let temp=inputString.charAt(inputString.length-2);
	if(inputString==""||temp=="(")
	{
		return false;
	}
	return true;
}

function opStore()
{
	if(arithmetic!="")
	{
		if(arithmetic!="("&&arithmetic!=")")
		{	
			inputString+=" "+arithmetic+" ";
		}
		arithmetic="";
	}
}

function clearValue()
{
	document.getElementById("display").value="";
	inputString="";
	arithmetic="";
	status=true;
	dot=0;
	paransCount=0;
}

function neutralizer()
{
	document.getElementById("+").style.backgroundColor="white";
	
	document.getElementById("-").style.backgroundColor="white";
	
	document.getElementById("/").style.backgroundColor="white";
	
	document.getElementById("*").style.backgroundColor="white";
}

