$(document).ready(function() {
    initMap()
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

    $('#customSelect').on('change', function() {
        // Optional: Handle change event if needed
    });

    $('#customSelect').on('focus', function() {
        $('.arrow').html('&#9650;'); // Up arrow
    }).on('blur', function() {
        $('.arrow').html('&#9660;'); // Down arrow
    });

    $(".close-button").click(function() {
        $("#infoModal").fadeOut();
    });

    $(window).click(function(e) {
        if ($(e.target).is('.modal')) {
            $("#infoModal").fadeOut();
        }
    });
});

function openInfoAlert(e, id) {
    $("#modelIdDisplay").text("Model ID: " + id);
    $("#infoModal").fadeIn();
}

function openInputs(e) {
        $('.hidden-inputs').toggle();
}

function openFirstTab() {
    document.querySelector(".tablinks").click();
    document.querySelector(".sub-tab-links").click();
}

window.onload = openFirstTab;

function chancePassword() {
    $('.chance-password').toggle();
}

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

function openSubTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("sub-tab-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("sub-tab-links");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

async function initMap() {
    const { Map } = await google.maps.importLibrary("maps");
    var location = {lat: 41.01384, lng: 28.94966};
    var map = new Map(document.getElementById('map'), {
        center: location,
        zoom: 15
    });
    var marker = new google.maps.Marker({
        position: location,
        map: map
    });
    var input = document.getElementById('pac-input');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    var markers = [];
    searchBox.addListener('places_changed', function() {
        var places = searchBox.getPlaces();

        if (places.length == 0) {
            return;
        }

        markers.forEach(function(marker) {
            marker.setMap(null);
        });
        markers = [];

        var bounds = new google.maps.LatLngBounds();
        places.forEach(function(place) {
            if (!place.geometry) {
                console.log("Returned place contains no geometry");
                return;
            }
            var icon = {
                url: place.icon,
                size: new google.maps.Size(71, 71),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(25, 25)
            };

            markers.push(new google.maps.Marker({
                map: map,
                icon: icon,
                title: place.name,
                position: place.geometry.location
            }));

            console.log("Selected place name:"+  place.name + "  place.geometry.location  " + place.geometry.location);

            if (place.geometry.viewport) {
                bounds.union(place.geometry.viewport);
            } else {
                bounds.extend(place.geometry.location);
            }
        });
        map.fitBounds(bounds);
    });


    map.addListener('click', function(e) {
        if (marker) {
            marker.setMap(null);
        }
        marker = new google.maps.Marker({
            position: e.latLng,
            map: map
        });
        map.panTo(e.latLng);

        const infoWindow = new google.maps.InfoWindow({
            content: `<p>Marker Location: ${e.latLng.lat()}, ${e.latLng.lng()}</p>`
        });
        marker.addListener('click', () => {
            infoWindow.open(map, marker);
        });

        console.log("Selected location:", e.latLng.lat(), e.latLng.lng());
    });
}