/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function setDate() {
    var UserDate = document.getElementById("date-chuyen").value;
    var ToDate = new Date();
	//ToDate.setDate(ToDate.getDate()+1);
    if (new Date(UserDate).getTime() <= ToDate.getTime()) {
        alert("Ngay di phai lon hon ngay hien tai");
		var tam = new Date();
	    tam.setDate(tam.getDate()+1);
        document.getElementById('date-chuyen').value = tam.toISOString().slice(0, 10);
    }
	
    return true;
}
function handleClick(){
if (document.getElementById('NvChuyen').checked) {
    document.getElementById('NvChuyen').value="chuyen";
}
else if(document.getElementById('NvChuyen').checked==false){
    document.getElementById('NvChuyen').value="thuong";
}
}