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
        $(".exercise-sections").sortable({
            items: ".exercise-section",
            update: function(event, ui) {
                var newOrder = $(this).sortable("toArray", { attribute: "data-id" });
                console.log("New order:", newOrder);
            },
            start: function(event, ui) {
                $(".delete-btn", ui.item).show();
            },
        });

        $(".warm-up-sections").sortable({
            items: ".warm-up-section",
            update: function(event, ui) {
                var newOrder = $(this).sortable("toArray", { attribute: "data-id" });
                console.log("New order:", newOrder);
            }
        });

        $(".cool-down-sections").sortable({
            items: ".cool-down-section",
            update: function(event, ui) {
                var newOrder = $(this).sortable("toArray", { attribute: "data-id" });
                console.log("New order:", newOrder);
            }
        });

        $(".delete-warm-up-item").on('click', function(){
            var id = $(this).parent().attr('data-id')
            $(this).parent().slideToggle(100);
            $(this).parent().remove();
            debugger;
            if ($('.warm-up-section').parent().children().length < 1){
                $('#warm-up-btn').toggleClass('selected');
                $('#warm-up-section').toggleClass('hide-activity-box');
            }
        });

        $(".delete-exercise-item").on('click', function(){
            var id = $(this).parent().attr('data-id')
            $(this).parent().slideToggle(100);
            $(this).parent().remove();
            if ($('.exercise-section').parent().children().length < 1){
                $('#exercise-btn').toggleClass('selected');
                $('#exercise-section').toggleClass('hide-activity-box');
            }
        });

        $(".delete-cool-down-item").on('click', function(){
            var id = $(this).parent().attr('data-id')
            $(this).parent().slideToggle(100);
            $(this).parent().remove();
            if ($('.cool-down-section').parent().children().length < 1){
                $('#cool-down-btn').toggleClass('selected');
                $('#cool-down-section').toggleClass('hide-activity-box');
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

        $('#warm-up-section, #exercise-section, #cool-down-section').droppable({
            accept: '.search-results div',
            drop: function (event, ui) {
                var droppedItem = ui.helper.clone();
                var sectionId = $(this).closest('.box').attr('id');
                var sectionClass;

                switch (sectionId) {
                    case 'warm-up-section':
                        sectionClass = 'delete-warm-up-item';
                        break;
                    case 'exercise-section':
                        sectionClass = 'delete-exercise-item';
                        break;
                    case 'cool-down-section':
                        sectionClass = 'delete-cool-down-item';
                        break;
                }
                debugger;
                droppedItem.removeClass('ui-draggable ui-draggable-handle').removeAttr('style');
                droppedItem.find('.delete-icon').addClass(sectionClass);

                $(this).append(droppedItem);
            }
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



    $('.search-input').on('input', function() {
        var searchTerm = $(this).val();
        if (searchTerm.trim() !== '' && searchTerm.trim().length >=4) {
            $.ajax({
                url: '/api/search/workout',
                method: 'GET',
                data: { query: searchTerm },
                success: function(response) {
                    updateSearchResults(response);
                    $('.search-results div').draggable({
                        helper: 'clone',
                        revert: 'invalid',
                    });
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        } else {
            clearSearchResults();
        }
    })


    function updateSearchResults(results) {
        clearSearchResults();
        var resultContainer = $('.search-results');
        for (var i = 0; i < results.length; i++) {
            var item = results[i]
            var newItem = $('<div>').addClass('exercise-section').attr('data-id', item.id);

            newItem.append($('<div>').addClass('image')
                .append($('<img>').attr('src', 'https://us.123rf.com/450wm/lioputra/lioputra2106/lioputra210600059/170025342-man-doing-monkey-bars-climbing-frame-exercise-flat-vector-illustration-isolated-on-white.jpg')));

            newItem.append($('<div>').addClass('item-info')
                .append($('<span>').text(item.workoutName))
                .append($('<span>').text(item.description)));
            resultContainer.append(newItem);
        }
    }

    function clearSearchResults() {
        $('.search-results').empty();
    }
});