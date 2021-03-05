function convert() {
    let a = parseFloat(document.getElementById("amount").value);
    let fr = document.getElementById("from").value;
    let to = document.getElementById("to").value;

    if (fr === "vnd") {
        if (to === "vnd")
        {
            document.getElementById("result").innerHTML = "₫ " + a;
        }
        if (to === "usd") {
            document.getElementById("result").innerHTML = "$ " + (a / 23200);}
}
    if (fr === "usd") {
        if (to === "vnd")
        {
            document.getElementById("result").innerHTML = "₫ " + (a * 23200);
        }
        if (to === "usd") {
            document.getElementById("result").innerHTML = "$ " + a ;}
    }
}