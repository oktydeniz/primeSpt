$(document).ready(function() {
    window.onload = openFirstTab;
    function openFirstTab() {
        document.querySelector(".tablinks").click();
    }
    initMap()
    events()
})

function openInputs(e) {
    $('.hidden-inputs').toggle();
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

function events() {

    $('#create-package').on('click', function () {
        openPackagePopup(this)
    })

    $('.close-button').on('click', function(){
        $('#package-screen').fadeOut()
    })
}

const openPackagePopup = (e, id = null) => {
    $('#package-screen').fadeIn()
}

$('#imageInput').on('change', function(event) {
    var file = event.target.files[0];

    if (file) {
        var reader = new FileReader();
        reader.onload = function(e) {
            var img = $('<img>').attr('src', e.target.result).css({width: '300px', height: 'auto'});
            $('#imageContainer').html(img);
        };

        reader.readAsDataURL(file);
    }
});