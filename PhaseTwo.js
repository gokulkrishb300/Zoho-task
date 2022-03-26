var value1="";
var value2="";
var arithmetic="";
var arithmeticStatus=true;
var displayVariable="";
var displayCondition=false;
var condition=true;

function input(value)
{	
	if(displayCondition)
	{
		displayVariable=value1;
		
		document.getElementById("subDisplay").value=displayVariable;
		
		displayCondition=false;
	}
	if(condition)
	{
		displayVariable+=arithmetic;
		
		condition=false;
	}
	
	var displayElement=document.getElementById("display");
	
	if(arithmetic.length==0 && value2=="")
	{
		value1 += value;
		
		displayElement.value=commaSeparator(value1);
	}
	else
	{
		value2+=value;
		
		displayElement.value=commaSeparator(value2);
	}
	arithmeticStatus=true;
	
	displayCondition=false;
	
	displayVariable+=value;
	
	document.getElementById("subDisplay").value=displayVariable;
}

function symbol(value)
{
	if(displayCondition)
	{
		displayVariable=value1;
		
		document.getElementById("subDisplay").value=displayVariable;
		
		displayCondition=false;
	}
	var length=arithmetic.length;
	
	if(arithmeticStatus)
	{
		if(value2!="")
		{
			equalizer(false);
			
			arithmetic=value;
			
			neutralizer();
			
			condition=true;
			
			document.getElementById(value).style.backgroundColor="#ff8000";
		}
		else
		if(value=="-")
		{
			if(length==0&&value1=="")
			{
				value1=value;
				
				displayVariable=value1;
				
				document.getElementById("display").value="-";
				
				arithmeticStatus=false;
				
				condition=false;
				
				value="";
			}
			else if(length>=1)
			{
				value2=value;
				
				displayVariable+=arithmetic+value2;
				
				document.getElementById("display").value="-";
				
				arithmeticStatus=false;
				
				condition=false;
				
				value="";
			}
			else if(value1!="-")
			{
				arithmetic=value;
				
				neutralizer();
				
				document.getElementById(value).style.backgroundColor="#ff8000";
				
				condition=true;
			}
			else
			{
				value="";
			}
		}
		else if(value1!="")
		{
			arithmetic=value;
			
			neutralizer();
			
			document.getElementById(value).style.backgroundColor="#ff8000";
			
			condition=true;
		}
		else
		{
			value1="0";
			
			document.getElementById(value).style.backgroundColor="#ff8000";
			
			displayVariable=value1;
			
			arithmetic=value;
		}
	}
	else
	{
		value="";
	}
	document.getElementById("subDisplay").value=displayVariable+value;
}

function equalizer(flag)
{
	var result=0;
	switch(arithmetic)
	{
		case "+":
			result=parseFloat(value1)+parseFloat(value2);
			break;
		
		case "-":
			result=parseFloat(value1)-parseFloat(value2);
			break;
			
		case "*":
			result=parseFloat(value1) * parseFloat(value2);
			break;
		
		case "/":
			result=parseFloat(value1)/parseFloat(value2);
			result=result?result:undefined;
			break;
			
		default:
			console.log("default :"+arithmetic);
	}
	document.getElementById("display").value=commaSeparator(result.toString());
	if(flag)
	{
		displayCondition=true;
	}
	value1=result;
	
	arithmetic="";
	
	value2="";
	
	condition=true;
	
	neutralizer();
}

function neutralizer()
{
	document.getElementById("+").style.backgroundColor="white";
	
	document.getElementById("-").style.backgroundColor="white";
	
	document.getElementById("/").style.backgroundColor="white";
	
	document.getElementById("*").style.backgroundColor="white";
}

function commaSeparator(value)
{
	var arr=value.split(".");
	
	var commaTemp=arr[0];
	
	var res="";
	
	var len=commaTemp.length-1;
	
	let last=commaTemp.charAt(len);
	
	var count=0;
	
	for(var iter=len-1;iter>=0;iter--)
	{
		res=commaTemp.charAt(iter)+res;
		
		++count;
		
		if(count%2==0 && iter>0)
		{
			res=","+res;
		}
	}
	if(arr[1]||arr[1]=="")
	{
		res=res+last+"."+arr[1];
	}
	else
	{
		res+=last;
	}
	return res;
}

function clearValue()
{
	document.getElementById("display").value="";
	
	document.getElementById("subDisplay").value="";
	
	value1="";
	
	value2="";
	
	arithmetic="";
	
	arithmeticStatus=true;
	
	result=0;
	
	displayVariable="";
	
	displayCondition=false;
	
	condition=true;
	
	neutralizer();
}



