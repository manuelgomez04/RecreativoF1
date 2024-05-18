   // Esperar a que el documento esté listo
   $(document).ready(function () {
    // Manejar la presentación del formulario
    $('.login-form').submit(function (event) {
        event.preventDefault(); // Evitar el envío del formulario

        // Validar los campos antes de enviar el formulario
        if (validarCampos()) {
            // Si los campos son válidos, enviar el formulario
            this.submit();
        }
    });

    // Función para validar los campos del formulario
    function validarCampos() {
        let isValid = true;

        // Validar campo "Durabilidad"
        let durabilidad = parseInt($('#apellidos').val());
        if (isNaN(durabilidad) || durabilidad < 0) {
            $('#apellidos').addClass('is-invalid');
            isValid = false;
        } else {
            $('#apellidos').removeClass('is-invalid');
        }

        // Validar campo "Precio"
        let precio = parseInt($('#dni').val());
        if (isNaN(precio) || precio < 0) {
            $('#dni').addClass('is-invalid');
            isValid = false;
        } else {
            $('#dni').removeClass('is-invalid');
        }

        // Validar campo "Marca"
        let marca = $('#fecha').val();
        if (marca.trim() === '') {
            $('#fecha').addClass('is-invalid');
            isValid = false;
        } else {
            $('#fecha').removeClass('is-invalid');
        }

        // Validar campo "Carrera"
        let carrera = $('#opciones').val();
        if (carrera === '') {
            $('#opciones').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opciones').removeClass('is-invalid');
        }

        // Validar campo "Coche"
        let coche = $('#opciones').val();
        if (coche === '') {
            $('#opciones').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opciones').removeClass('is-invalid');
        }

        // Validar campo "Jefe Equipo"
        let jefeEquipo = $('#opciones').val();
        if (jefeEquipo === '') {
            $('#opciones').addClass('is-invalid');
            isValid = false;
        } else {
            $('#opciones').removeClass('is-invalid');
        }

        return isValid;
    }
});