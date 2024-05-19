document.addEventListener('DOMContentLoaded', function () {
    let deleteLinks = document.querySelectorAll('.delete-link');
    deleteLinks.forEach(function (deleteLink) {
        deleteLink.addEventListener('click', function (event) {
            event.preventDefault();
            let modal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'), {});
            modal.show();
            let deleteUrl = deleteLink.getAttribute('href');
            document.getElementById('deleteLink').setAttribute('href', deleteUrl);
        });
    });
});