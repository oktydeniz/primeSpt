$(document).ready(function() {
    $('#loginBtn').click(function() {
        $('#loginPopup').css('display', 'flex');
    });

    $('.closeBtn').click(function() {
        $('#loginPopup').css('display', 'none');
    });

    $('#create_activity').click(function() {
        data = {
            name: $('#name').val(),
            description: $('#description').val(),
            imageUrl: $('#imageUrl').val(),
            workoutLevel: parseInt($('#workoutLevel').val()),
            activityType: parseInt($('#activities').val()),
            isPrivate: $("#isPrivate").prop('checked'),

        }
        debugger;
        $.ajax({
            url: '/activity/create',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function(response) {
                console.log('Request successful');
                history.pushState({}, '', '/profile');
            },
            error: function(xhr, status, error) {
                console.error('Request failed:', status, error);
            }
        });
    });
});
