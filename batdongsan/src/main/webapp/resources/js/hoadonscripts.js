const chooseBtn = document.querySelector(".test");
const mapSeat = document.querySelector(".child");
chooseBtn.addEventListener("click", () => {
    mapSeat.classList.toggle("hide");
})
