

$("#buscarbtnid").click(function(){
    alert("funca");
       var ciudad = document.getElementById('campotextoid').value;
       var url = '/airports/' + ciudad;
       var map;
           fetch(url, {
               method: 'GET',
               headers: {
                   'Content-Type': 'application/json'
               }
           })
           .then(response => response.json())
           .then(data => {
               console.log(data);
               map = new google.maps.Map(document.getElementById('mapitaid'), {
                center: {lat: data[0].location.latitude, lng: data[0].location.longitude},
                zoom: 8
                });
               for(var i in data){
                    var mostrarresultado = "Codigo Aeropurto: " + data[i].code + ", Aeropuerto: " + data[i].name + ", Ciudad: " + data[i].city + ", Codigo pais:" + data[i].countryCode;
                    document.getElementById("contenidoid").value = mostrarresultado;
                    console.log(mostrarresultado);
                    var latlong = {lat: data[i].location.latitude, lng: data[i].location.longitude};
                    var marker = new google.maps.Marker({position: latlong, map: map});
               }
            });
       });
