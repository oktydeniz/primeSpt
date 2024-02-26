$(document).ready(function() {

    $('#permissions-container').on('change', 'input[type="checkbox"]', function() {
        const action = $(this).data('action');
        const data = {
            action: action,
            isChecked: $(this).prop('checked')
        };

        $.ajax({
            url: '/setting/permissions',
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

    $('#user-language').on('change', function() {
        $.ajax({
            url: '/setting/language',
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

function openFirstTab() {
    document.querySelector(".tablinks").click();
}

window.onload = openFirstTab;
function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}