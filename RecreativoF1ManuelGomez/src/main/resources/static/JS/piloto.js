document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('siguienteBtn').addEventListener('click', function () {
        window.location.href = '/mecanicos';
    });
});

document.getElementById("addPilotoButton").addEventListener("click", function() {
    window.location.href = '/pilotoForm';
});