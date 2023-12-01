var ten=document.getElementById("ten");
var sdt=document.getElementById("sdt");
var diachi=document.getElementById("diachi");
function validateForm(event){
	event.preventDefault();
	//alert(document.getElementById("fromdate").value);
	if(document.getElementById("ten").value === "" || document.getElementById("sdt").value === "" || document.getElementById("diachi").value === "")
	{
		alert("Phai nhap day du thong tin");
		document.thongtinform.fromdate.focus();
		return false;
	}
	else{
		document.thongtinform.submit();
	}
}

