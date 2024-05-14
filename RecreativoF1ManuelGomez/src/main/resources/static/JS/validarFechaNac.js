function validarEdadMayor18(fechaNacimiento) {
    let fechaNacimientoObj = new Date(fechaNacimiento);
    let hoy = new Date();
    let edad = hoy.getFullYear() - fechaNacimientoObj.getFullYear();
    let mes = hoy.getMonth() - fechaNacimientoObj.getMonth();

    if (mes < 0 || (mes === 0 && hoy.getDate() < fechaNacimientoObj.getDate())) {
        edad--;
    }

    return edad >= 18;
}

// Event listener para validar la edad en el envío del formulario
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('formulario').addEventListener('submit', function(event) {
        let fechaInput = document.getElementById('fecha');
        let fechaNacimiento = fechaInput.value;

        if (!validarEdadMayor18(fechaNacimiento)) {
            alert('Debe ser mayor de 18 años para registrarse.');
            event.preventDefault(); // Evita que el formulario se envíe
            fechaInput.focus(); // Pone el foco en el campo de fecha de nacimiento
        }
    });
});