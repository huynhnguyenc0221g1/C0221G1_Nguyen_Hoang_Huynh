function fibonacci(number) {
    if (number < 0) {
        return -1;
    }
    else if (number == 0 || number == 1) {
        return number;
    }
    else {
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
let sum = 0;
console.log("First 10 fibonacci numbers");
for (let i = 0; i < 10; i++) {
    console.log(fibonacci(i) + " ");
    sum += fibonacci(i);
}
console.log("Sum:" + sum);
//# sourceMappingURL=main.js.map