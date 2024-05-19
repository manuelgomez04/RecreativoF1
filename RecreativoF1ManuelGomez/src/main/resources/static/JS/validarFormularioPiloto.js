document.addEventListener('DOMContentLoaded', function() {
    let form = document.getElementById('formulario');

    form.addEventListener('submit', function(event) {
        let isValid = true;
        let inputs = form.querySelectorAll('input[required], input[type="number"]');
        let selectElements = form.querySelectorAll('select[required]');

        let errorMessages = form.querySelectorAll('.invalid-feedback');
        for (let i = 0; i < errorMessages.length; i++) {
            errorMessages[i].style.display = 'none';
        }

        for (let i = 0; i < inputs.length; i++) {
            let input = inputs[i];
            let errorElement = input.nextElementSibling;

            if (!input.value.trim()) {
                isValid = false;
                input.classList.add('is-invalid');
                errorElement.style.display = 'block';
                errorElement.textContent = 'Este campo es obligatorio.';
            } else {
                input.classList.remove('is-invalid');
                errorElement.style.display = 'none';
            }

            if (input.type === 'number' && input.value < 0) {
                isValid = false;
                input.classList.add('is-invalid');
                errorElement.style.display = 'block';
                errorElement.textContent = 'El valor no puede ser negativo.';
            } else if (input.type === 'number' && input.value >= 0) {
                input.classList.remove('is-invalid');
                errorElement.style.display = 'none';
            }
        }

        for (let i = 0; i < selectElements.length; i++) {
            let select = selectElements[i];
            let errorElement = select.nextElementSibling;

            if (!select.value.trim()) {
                isValid = false;
                select.classList.add('is-invalid');
                errorElement.style.display = 'block';
                errorElement.textContent = 'Este campo es obligatorio.';
            } else {
                select.classList.remove('is-invalid');
                errorElement.style.display = 'none';
            }
        }

        if (!isValid) {
            event.preventDefault();
        }
    });
});