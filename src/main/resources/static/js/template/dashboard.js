$(document).ready(function() {


    $('.category-item').click(function() {
        var id = $(this).data('id');
        console.log("Clicked ID:", id);

    });

    $('.see-all').click(function() {
        var id = $(this).data('id');

    });
});
