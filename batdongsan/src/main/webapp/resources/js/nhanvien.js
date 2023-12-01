/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function Test(){
	var UserDate = document.getElementById("todate").value;
	if(UserDate === null)
		
	return true;
}  
function TDate() {
    var UserDate = document.getElementById("todate").value;
    var ToDate = new Date();
	//ToDate.setDate(ToDate.getDate()+1);
    if (new Date(UserDate).getTime() <= ToDate.getTime()) {
        alert("Ngay di phai lon hon ngay hien tai");
		var tam = new Date();
	    tam.setDate(tam.getDate()+1);
        document.getElementById('todate').value = tam.toISOString().slice(0, 10);
    }
	
    return true;
}

