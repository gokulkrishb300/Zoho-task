function generate() {
var count = document.getElementById("rows").value;

for(var i=0 ; i < count; i++) {
var divTag = document.createElement("div");
 document.body.appendChild(divTag);
    var fatherName = document.createElement("label");
    divTag.appendChild(fatherName);
    fatherName.textContent = "Father's Name";

    var fatherInput = document.createElement("input");
    fatherInput.type = "text";
    fatherInput.id = "father" + i;
    divTag.appendChild(fatherInput);

    var sonName = document.createElement("label");
    divTag.appendChild(sonName);
    sonName.textContent = "Son's Name";

    var sonInput = document.createElement("input");
    sonInput.type = "text";
    sonInput.id = "son" +i;
    divTag.appendChild(sonInput);
   
}

    var buttonTag = document.createElement("button");
     buttonTag.onclick= function() {
    inputbox()
    };
    divTag.appendChild(buttonTag);
   
    buttonTag.innerText = "submit";
  
    
}

function inputbox(){
    var grandFather = document.createElement("label");
    document.body.appendChild(grandFather);
    grandFather.textContent("GrandFather's Name");
    
    var grandFatherInput = document.createElement("input");
    grandFatherInput.type = "text";
    grandFatherInput.id = "grandFather";
    document.body.appendChild(grandFatherInput);

    
}


