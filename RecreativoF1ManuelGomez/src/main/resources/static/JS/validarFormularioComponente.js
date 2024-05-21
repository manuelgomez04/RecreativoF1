// Esperar a que el documento esté listo
$(document).ready(function () {
    // Manejar la presentación del formulario
    $('form').submit(function (event) {
        event.preventDefault(); // Evitar el envío del formulario

        if (validarCampos()) {
            this.submit();
        } else {
            // En lugar de alert, mostrar mensajes de error debajo de cada campo
            $('form .is-invalid').each(function() {
                $(this).after('<div class="invalid-feedback">Por favor, rellena este campo correctamente.</div>');
            });
        }
    });

    function validarCampos() {
        let isValid = true;

        // Limpiar mensajes de error anteriores
        $('.invalid-feedback').remove();

        let durabilidad = parseInt($('#durabilidad').val());
        if (isNaN(durabilidad) || durabilidad < 0) {
            $('#durabilidad').addClass('is-invalid');
            isValid = false;
        } else {
            $('#durabilidad').removeClass('is-invalid');
        }

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

        let carrera = $('#opcionesCarrera').val();
        if (carrera === '') {
            $('#opcionesCarrera').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opcionesCarrera').removeClass('is-invalid');
        }

        let coche = $('#opcionesCoche').val();
        if (coche === '') {
            $('#opcionesCoche').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opcionesCoche').removeClass('is-invalid');
        }

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
