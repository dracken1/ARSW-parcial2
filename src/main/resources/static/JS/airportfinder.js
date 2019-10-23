

$("#buscarbtnid").click(function(){
    alert("funca");
       var ciudad = document.getElementById('campotextoid').value;
       var url = '/airports/' + ciudad;
           fetch(url, {
               method: 'GET',
               headers: {
                   'Content-Type': 'application/json'
               }
           })
           .then(response => response.json())
           .then(data => {
               console.log(data);
           })
   });
