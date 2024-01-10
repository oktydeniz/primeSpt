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

    $(function() {

        $(".exercise-section").sortable({
            items: ".swipeable", // Elements with this class will be sortable
            handle: ".inner", // Use the ".inner" class as the handle to drag
            axis: "y", // Only allow vertical dragging for reordering
            containment: "parent", // Limit dragging within the parent container
            connectWith: ".exercise-section",
            stop: function(event, ui) {
                var newOrder = $(this).sortable("toArray");
                console.log("New order:", newOrder);
                // Perform any action with the new order here
            }
        });

        $('.swipeable .inner').each(function(e) {
            var snapper = new Snap({
                element: this,
                maxPosition: 100,
                minPosition: -100,
                disable: 'left'
            });
        });

        $('.delete').on('click', function(e){
            console.log("delete -clicked")
            $(this).parent().slideToggle(100);
        });

        $('.save').on('click', function(e){
            console.log("delete -save")
        });
    });


    $('#warm-up-btn').click(function() {
        $(this).toggleClass('selected');
        $('#warm-up-section').toggleClass('hide-activity-box');
    })

    $('#exercise-btn').click(function() {
        $(this).toggleClass('selected');
        $('#exercise-section').toggleClass('hide-activity-box');
    })

    $('#cool-down-btn').click(function() {
        $(this).toggleClass('selected');
        $('#cool-down-section').toggleClass('hide-activity-box');
    })
});