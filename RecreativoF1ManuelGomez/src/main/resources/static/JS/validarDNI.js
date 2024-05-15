function validarDNI(dni) {
    let expresionRegularDNI = /^\d{8}[a-zA-Z]$/;
    return expresionRegularDNI.test(dni);
}

document.addEventListener('DOMContentLoaded', function () {
    let formulario = document.getElementById('formulario');
    let dniInput = document.getElementById('dni');
    let mensajeValidacionDNI = document.getElementById('mensaje-validacion-dni');

    formulario.addEventListener('submit', function (event) {
        let dni = dniInput.value.trim();

        if (!dni) {
            event.preventDefault(); // Evita que se envíe el formulario si el campo de DNI está vacío
            mensajeValidacionDNI.style.display = 'block';
            dniInput.classList.add('is-invalid');
        } else if (!validarDNI(dni)) {
            event.preventDefault(); // Evita que se envíe el formulario si el formato del DNI es inválido
            mensajeValidacionDNI.style.display = 'block';
            dniInput.classList.add('is-invalid');
        }
    });

    dniInput.addEventListener('input', function () {
        let dni = dniInput.value.trim();

        if (!dni) {
            mensajeValidacionDNI.style.display = 'none';
            dniInput.classList.remove('is-invalid');
        } else if (!validarDNI(dni)) {
            mensajeValidacionDNI.style.display = 'block';
            dniInput.classList.add('is-invalid');
        } else {
            mensajeValidacionDNI.style.display = 'none';
            dniInput.classList.remove('is-invalid');
        }
    });
});
