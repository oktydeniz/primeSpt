$(document).ready(function() {


    $('#create_activity').click(function(e) {
        var data = {
            name : $('#name').val(),
            description : $('#description').val(),
            imageUrl : $('#imageUrl').val(),
            workoutLevel : $('#workoutLevel').val(),
            activity : $('#activities').val(),
            isPrivate : $('#isPrivate').prop('checked'),
            id : $('#activity_id').val(),
        };
        $.ajax({
            url: '/profile/program/update',
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