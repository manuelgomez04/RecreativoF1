document.addEventListener('DOMContentLoaded', function () {
    let formulario = document.getElementById('formulario');
    let fechaInput = document.getElementById('fecha');
    let mensajeValidacionFecha = document.getElementById('mensaje-validacion-fecha');

    formulario.addEventListener('submit', function (event) {
        let fecha = fechaInput.value.trim();

        if (!fecha) {
            event.preventDefault(); // Evita que se envíe el formulario si el campo de fecha está vacío
            mensajeValidacionFecha.style.display = 'block';
            fechaInput.classList.add('is-invalid');
        } else if (!validarFechaMayor18(fecha)) {
            event.preventDefault(); // Evita que se envíe el formulario si la fecha no es mayor de 18 años
            mensajeValidacionFecha.style.display = 'block';
            fechaInput.classList.add('is-invalid');
        }
    });

    fechaInput.addEventListener('input', function () {
        let fecha = fechaInput.value.trim();

        if (!fecha) {
            mensajeValidacionFecha.style.display = 'none';
            fechaInput.classList.remove('is-invalid');
        } else if (!validarFechaMayor18(fecha)) {
            mensajeValidacionFecha.style.display = 'block';
            fechaInput.classList.add('is-invalid');
        } else {
            mensajeValidacionFecha.style.display = 'none';
            fechaInput.classList.remove('is-invalid');
        }
    });
});

function validarFechaMayor18(fecha) {
    let fechaNacimiento = new Date(fecha);
    let hoy = new Date();
    let edad = hoy.getFullYear() - fechaNacimiento.getFullYear();
    let mes = hoy.getMonth() - fechaNacimiento.getMonth();

    if (mes < 0 || (mes === 0 && hoy.getDate() < fechaNacimiento.getDate())) {
        edad--;
    }

    return edad >= 18;
}
