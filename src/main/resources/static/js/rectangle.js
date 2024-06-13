
function addDeleteEvListeners() {
    var inputs = document.getElementsByClassName("delete-link");
    for (let j = 0; j < inputs.length; j++) {
        inputs[j].addEventListener('click', function (e) {
            e.preventDefault();
            deleteRectangle(inputs[j]);
        });
    }
}

// function deleteRectangle(input) {
//     var cell = input.parentNode;
//     var row = cell.parentNode;
//     var rowIndex = input.parentNode.parentNode.rowIndex;

//     var uid = row.querySelector('.uid').innerText;

// }

function deleteRectangle(input) {
    var row = input.closest('tr'); // Find the closest table row to the clicked element
    var uid = row.querySelector('.uid').innerText; // Get the UID from the row

    // Send a DELETE request to the server
    fetch(`/rectangle/${uid}`, {
        method: 'DELETE',
    }).then(response => {
        if (response.ok) {
            console.log('Rectangle deleted successfully');
        } else {
            console.error('Failed to delete rectangle');
        }
    }).catch(error => {
        console.error('Error:', error);
    });
}
