function abrirModal(modalId, pilotoId) {
    var modal = document.getElementById(modalId);
    modal.addEventListener('show.bs.modal', function (event) {
        var button = event.relatedTarget;
        var nombre = button.parentNode.previousElementSibling.firstChild.innerText;
        var modalBody = modal.querySelector('.modal-body');
        var deleteBtn = modal.querySelector('#deleteModalConfirmBtn');
        deleteBtn.setAttribute('href', '/pilotos/borrar/' + pilotoId);
        modalBody.innerHTML = '¿Estás seguro de que deseas borrar a ' + nombre + '?';
    });
    var modalInstance = new bootstrap.Modal(modal, { keyboard: false });
    modalInstance.show();
}