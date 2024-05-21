// Esperar a que el documento esté listo
$(document).ready(function () {
    // Manejar la presentación del formulario
    $('form').submit(function (event) {
        event.preventDefault(); // Evitar el envío del formulario

        // Validar los campos antes de enviar el formulario
        if (validarCampos()) {
            // Si los campos son válidos, enviar el formulario
            this.submit();
        } else {
            alert('Por favor, rellena todos los campos correctamente.');
        }
    });

    // Función para validar los campos del formulario
    function validarCampos() {
        let isValid = true;

        // Validar campo "Durabilidad"
        let durabilidad = parseInt($('#durabilidad').val());
        if (isNaN(durabilidad) || durabilidad < 0) {
            $('#durabilidad').addClass('is-invalid');
            isValid = false;
        } else {
            $('#durabilidad').removeClass('is-invalid');
        }

        // Validar campo "Precio"
        let precio = parseInt($('#precio').val());
        if (isNaN(precio) || precio < 0) {
            $('#precio').addClass('is-invalid');
            isValid = false;
        } else {
            $('#precio').removeClass('is-invalid');
        }

        // Validar campo "Marca"
        let marca = $('#marca').val();
        if (marca.trim() === '') {
            $('#marca').addClass('is-invalid');
            isValid = false;
        } else {
            $('#marca').removeClass('is-invalid');
        }

        // Validar campo "Carrera"
        let carrera = $('#opcionesCarrera').val();
        if (carrera === '') {
            $('#opcionesCarrera').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opcionesCarrera').removeClass('is-invalid');
        }

        // Validar campo "Coche"
        let coche = $('#opcionesCoche').val();
        if (coche === '') {
            $('#opcionesCoche').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opcionesCoche').removeClass('is-invalid');
        }

        // Validar campo "Jefe Equipo"
        let jefeEquipo = $('#opcionesJefe').val();
        if (jefeEquipo === '') {
            $('#opcionesJefe').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opcionesJefe').removeClass('is-invalid');
        }

        return isValid;
    }
});
