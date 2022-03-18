function trap(start,end,until)
{    
   var map=new Map();
   for(var n1=start;n1<=end;n1++)
   {
      var a=n1;
         while(true)
         {
          
            if((a%until)==0 || (until%a)==0)
            {
               map.set(n1,until);
               until=until+2;
               break;
            }
            else
            {
               var sod=0;
               var temp=a;
               while(temp>0)
               {
                 var digits=temp%10;
                 sod=sod+digits;
                 temp=Math.floor(temp/10);
               }
               if(a<10)
               {
                  if(until>3)
                  {
                     until--;
                  }
                    break;
               }
                  a=sod;
            }
         
        }
   }
   for(var ans of map)
   {
      document.getElementById("result").innerHTML +=ans+"<br>";
   }
   document.getElementById("count").innerHTML +="trap size: " +map.size+"<br>";
  } 

  


