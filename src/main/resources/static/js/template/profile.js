$(document).ready(function() {

    $('#permissions-container').on('change', 'input[type="checkbox"]', function() {
        const action = $(this).data('action');
        const data = {
            action: action,
            isChecked: $(this).prop('checked')
        };

        $.ajax({
            url: '/profile/permissions',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                console.log('Request successful');
            },
            error: function(xhr, status, error) {
                console.error('Request failed:', status, error);
            }
        });
    });
});