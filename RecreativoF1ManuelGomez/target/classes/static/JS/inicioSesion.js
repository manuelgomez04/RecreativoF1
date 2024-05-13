$(document).ready(function() {
    $('#showPasswordBtn').click(function() {
        let passwordField = $('#password');
        let passwordFieldType = passwordField.attr('type');
        if (passwordFieldType === 'password') {
            passwordField.attr('type', 'text');
            $(this).text('Ocultar');
        } else {
            passwordField.attr('type', 'password');
            $(this).text('Mostrar');
        }
    });
});


