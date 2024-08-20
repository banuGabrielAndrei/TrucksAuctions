const priceInput = document.getElementById("price");
    const priceValue = document.getElementById("price-value");
    priceInput.addEventListener("input", () => {
    priceValue.textContent = priceInput.value + "€";
});