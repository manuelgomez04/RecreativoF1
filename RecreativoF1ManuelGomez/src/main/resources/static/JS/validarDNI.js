function validarDNI(dni) {
    let expresionRegularDNI = /^\d{8}[a-zA-Z]$/;
    return expresionRegularDNI.test(dni);
}

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('formulario').addEventListener('submit', function (event) {
        let dniInput = document.getElementById('dni');
        let dni = dniInput.value.trim();

        if (!validarDNI(dni)) {
            alert('Por favor, introduce un DNI válido (8 dígitos seguidos de una letra).');
            event.preventDefault(); // Evita que el formulario se envíe
            dniInput.focus(); // Pone el foco en el campo DNI
        }
    });
});