// updates the color while editing a rectangle's attributes
function updateColor(input) {
    var color = input.value;
    var span = input.previousElementSibling;
    span.textContent = color;
}
