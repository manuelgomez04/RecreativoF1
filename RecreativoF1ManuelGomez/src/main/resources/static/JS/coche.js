//Coche
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('siguienteBtn').addEventListener('click', function () {
        window.location.href = '/pilotos';
    });
});

document.getElementById("addCocheButton").addEventListener("click", function() {
    window.location.href = '/editarCoche';
});

