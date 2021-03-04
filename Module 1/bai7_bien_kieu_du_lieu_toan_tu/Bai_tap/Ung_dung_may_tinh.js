function add() {
    a = parseFloat(document.getElementById("num1").value);
    b = parseFloat(document.getElementById("num2").value);
    document.getElementById("result").innerHTML = "Result Add:  " + (a + b);
}
function subtract() {
    a = document.getElementById("num1").value;
    b = document.getElementById("num2").value;
    document.getElementById("result").innerHTML = "Result Subtract:  " + (a - b);
}
function multiply() {
    a = document.getElementById("num1").value;
    b = document.getElementById("num2").value;
    document.getElementById("result").innerHTML = "Result Multiply:  " + (a * b);
}
function divide() {
    a = document.getElementById("num1").value;
    b = document.getElementById("num2").value;
    document.getElementById("result").innerHTML = "Result Divide:  " + (a / b);
}
