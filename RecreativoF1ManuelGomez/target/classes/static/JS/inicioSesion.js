$(document).ready(function() {
    $('#showPasswordBtn').click(function() {
        var passwordField = $('#password');
        var passwordFieldType = passwordField.attr('type');
        if (passwordFieldType === 'password') {
            passwordField.attr('type', 'text');
            $(this).text('Ocultar');
        } else {
            passwordField.attr('type', 'password');
            $(this).text('Mostrar');
        }
    });
});

//Inicio sesión
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('loginBtn').addEventListener('click', function () {
        window.location.href = '/inicioSesion';
    });
});

