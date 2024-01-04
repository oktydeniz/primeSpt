$(document).ready(function() {
    var selectedID = null;

    $('.exercise-section').click(function(e) {
        var id = $(this).data('id');
        console.log(e);
        data = {
            id:id,
        }
        $.ajax({
            url: '/home/workout/' + id,
            method: 'GET',
            contentType: 'application/json',
            success: function(data) {
                $('#workout-name').text(data.workoutName);
                $('#workout-description').text(data.description);
                $('#workout-equipment').text(data.equipment);
                $('#workout-bodyPart').text(data.bodyPart);
                $('#workout-targetMuscle').text(data.targetMuscle);

                $('#workoutPopup').css('display', 'flex');
            },
            error: function(xhr, status, error) {
                console.error('Request failed:', status, error);
            }
        });

    });

    $('.closeBtn').click(function() {
        $('#workoutPopup').css('display', 'none');
    });
    $('.delete-list').click(function() {
        var id = $('.update-list').data('id');
        $.ajax({
            url: '/home/workout/' + id,
            method: 'DELETE',
            contentType: 'application/json',
            success: function(data) {
                console.log("success");
            },
            error: function(xhr, status, error) {
                console.error('Request failed:', status, error);
            }
        });
    });

    $('#make-private').on('change', function() {
        var id = $('.update-list').data('id');
        $.ajax({
            url: '/home/workout/' + id,
            method: 'PATCH',
            data: {
                language: $(this).val()
            },
            success: function(response) {
                console.log('Language updated successfully');
            },
            error: function(xhr, status, error) {
                console.error('Failed to update language:', status, error);
            }
        });
    });

});
