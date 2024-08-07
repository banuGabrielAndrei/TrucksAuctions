document.addEventListener("DOMContentLoaded", function() {
    let passwordField = document.getElementById("password");
    let showPasswordCheckbox = document.getElementById("showPassword");
    showPasswordCheckbox.addEventListener("change", function() {
        if (this.checked) {
            passwordField.type = "text";
        } else {
            passwordField.type = "password";
        }
    });
});