var value1="";
var value2="";
var arithmetic="";
var arithmeticStatus=false;

function input(value)
{	
	var displayElement=document.getElementById("display");
	
	if(arithmetic.length==0 && value2=="")
	{
		value1 += value;
		
		displayElement.value=value1;
	}
	else
	{
		value2+=value;
		
		displayElement.value=value2;
	}
}

function symbol(value)
{
	document.getElementById("display").value="";
	
	var length=arithmetic.length;
	
	if(!arithmeticStatus)
	{
		if(value2!="")
		{
			equalizer(false);
			
			arithmetic=value;
			
			neutralizer();
			
			document.getElementById(value).style.backgroundColor="#ff8000";
		}
		else if(value=="-")
		{
			if(length==0&&value1=="")
			{
				value1=value;
				
				document.getElementById("display").value="-";
				
				value="";
			}
			else if(length>=1)
			{
				value2=value;
				
				document.getElementById("display").value="-";
				
				arithmeticStatus=true;
				
				value="";
			}
			else if(value1!="-")
			{
				arithmetic=value;
				
				neutralizer();
				
				document.getElementById(value).style.backgroundColor="#ff8000";
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
		}
		else
		{
			value1="0";
			
			arithmetic=value;
			
			document.getElementById("display").value=value1;
		}
	}
	else
	{
		value="";
	}
}

function neutralizer()
{
	document.getElementById("+").style.backgroundColor="white";
	
	document.getElementById("-").style.backgroundColor="white";
	
	document.getElementById("*").style.backgroundColor="white";
	
	document.getElementById("/").style.backgroundColor="white";
}

function equalizer(flag)
{
	var result=0;
	switch(arithmetic)
	{
		case "+":
			result=Number(value1)+Number(value2);
			break;
		
		case "-":
			result=Number(value1)-Number(value2);
			break;
			
		case "*":
			result=Number(value1) * Number(value2);
			break;
		
		case "/":
			result=Number(value1)/Number(value2);
			break;
			
		default:
			console.log("default :"+arithmetic);
	}
	if(flag)
	{
		document.getElementById("display").value=result;
	}
	value1=result;
	
	arithmetic="";
	
	arithmeticStatus=false;
	
	value2="";
	
	neutralizer();
}



function clearValue()
{
	document.getElementById("display").value="";
	value1="";
	value2="";
	result=0;
	arithmetic="";
	neutralizer();
	arithmeticStatus=false;
}
