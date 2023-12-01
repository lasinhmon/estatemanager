const dropdownBtn = document.querySelector(".dropdown_button");
const dropdownMenu = document.querySelector(".dropdown_menu");

dropdownBtn.addEventListener("click", () => {
    dropdownMenu.classList.toggle("hide");
})

const popupForm = document.querySelector(".tft96");
const popupBtnLogin = document.querySelector(".btn_dangnhap");
const popupBtnClose = document.querySelector(".close-button");
popupBtnLogin.addEventListener("click", () => {
    popupForm.classList.remove("hide");
})
popupBtnClose.addEventListener("click", () => {
    popupForm.classList.add("hide");
})
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
function FDate() {
    var UserDate = document.getElementById("todate").value;
    var FromDate = document.getElementById("fromdate").value;
    if (new Date(FromDate).getTime() < new Date(UserDate).getTime()) {
        alert("Ngay ve phai lon hon ngay di");
		var tam = new Date();
	    tam.setDate(tam.getDate()+1);
        document.getElementById("fromdate").value = tam.toISOString().slice(0, 10);
    }
    return true;
}

const placeSearchTo = document.querySelector(".place-to");
const placeSearchFrom = document.querySelector(".place-from");
const placeListTo = document.querySelector(".data-list-to");
const placeListFrom = document.querySelector(".data-list-from");
placeSearchTo.addEventListener("click", () => {
    placeListTo.classList.toggle("hide");
})
placeSearchFrom.addEventListener("click", () => {
    placeListFrom.classList.toggle("hide");
})

function ChoosePlaceTo(o) {
    document.getElementById('placeto').value = o.innerHTML;
}
function ChoosePlaceFrom(o) {
    document.getElementById('placefrom').value = o.innerHTML;
}
const showHideFrom = function () {
    document.querySelector("#radio2").addEventListener('click', function () {
        document.querySelector(".sd-container1").classList.remove("hide");
    });
    document.querySelector("#radio1").addEventListener('click', function () {
        document.querySelector(".sd-container1").classList.add("hide");
    });
}
showHideFrom();

var radiobtn = document.getElementById("radio2");

function validateForm(event){
	event.preventDefault();
	//alert(document.getElementById("fromdate").value);
	if(radiobtn.checked == true && document.getElementById("fromdate").value === "")
	{
		alert("Phai nhap ngay ve");
		document.homeform.fromdate.focus();
		return false;
	}
	else{
		document.homeform.submit();
	}
}

