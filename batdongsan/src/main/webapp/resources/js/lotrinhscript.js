var chooseBtn = document.getElementsByClassName("route-choose");
var so;
for (let i = 0; i < chooseBtn.length; i++) {
    chooseBtn[i].addEventListener("click", function () {
        var mapSeat = document.getElementsByClassName("tft97");
        for (var j = 0; j < mapSeat.length; j++) {
            if (j == i) {
                mapSeat[j].classList.toggle("hide");
				so=j;
                //break;
            }
			else{
				mapSeat[j].classList.add("hide");
			}
        }
    });
}
var input=[];
var chgColor = document.getElementsByClassName("seat-num");
var chgNum = document.getElementsByClassName("seat-number");
//document.getElementsByClassName('total-ghe')[so].innerHTML="";
for (let h = 0; h < chgColor.length; h++) {
    chgColor[h].addEventListener("click", function () {
        this.style.background = this.style.background == 'yellowgreen' ? 'white' : 'yellowgreen';
		//document.getElementsByClassName('total-ghe')[so].innerHTML="";
		
		document.getElementsByClassName('total-ghe')[so].value="";		
		if(so==0){
			for (let tt = 0; tt < 24; tt++){
				if(chgColor[tt].style.background == 'yellowgreen'){
					document.getElementsByClassName('total-ghe')[so].innerHTML=document.getElementsByClassName('total-ghe')[so].innerHTML+" "+chgColor[tt].textContent;
					document.getElementsByClassName('total-ghe')[so].value=document.getElementsByClassName('total-ghe')[so].value+chgNum[tt].innerHTML+" ";
				//document.getElementsByClassName('total-ghe')[so].value =chgColor[tt].textContent;
				}
			}
			
			//
		}else{
			for (let tt = so*24; tt < (so+1)*24; tt++){
				if(chgColor[tt].style.background == 'yellowgreen'){
					document.getElementsByClassName('total-ghe')[so].innerHTML=document.getElementsByClassName('total-ghe')[so].innerHTML+" "+chgColor[tt].textContent;
					document.getElementsByClassName('total-ghe')[so].value=document.getElementsByClassName('total-ghe')[so].value+chgNum[tt].innerHTML+" ";
				}
			}
		}
		//alert(document.getElementsByClassName('total-ghe')[so].value);
    });
}
var tinhtien = document.getElementsByClassName("seat-num");
// dung vong for im map nao dang k co hide => tim dc index , add vao index 
for(let j=0;j< tinhtien.length;j++){
	tinhtien[j].addEventListener("click", function () {
		var t = document.getElementById("option2").innerHTML;
		if(this.style.background == 'yellowgreen'){
		    document.getElementsByClassName('total')[so].innerHTML=(parseInt(document.getElementsByClassName('total')[so].innerHTML,10))+parseInt(t);
		    
		}
		else if(this.style.background == 'white')
			document.getElementsByClassName('total')[so].innerHTML=(parseInt(document.getElementsByClassName('total')[so].innerHTML,10))-parseInt(t);
     
    });
}




