window.onload = function(){
    if(navigator.geolocation){
        navigator.geolocation.getCurrentPosition(onSuccess,onError,{
            maximumAge : 60*1000,
            timeout : 5*60*1000,
            enableHighAccuracy:true
        });
    }else{
        document.getElementById("weather").innerHTML = "Your browser does not support HTML5 geolocation";
    }
}
function onSuccess(position){
    var currentLat = position.coords.latitude;
    var currentLon = position.coords.longitude;
    //xml http request object
    var xmlHttpWeatherRequest = new XMLHttpRequest();
    var url = "http://api.openweathermap.org/data/2.5/weather?lat="+currentLat+"&lon="+currentLon+"&appid=6e1377917ba5dc606d32495c04dfd273&lang=en"
    //type de request
    xmlHttpWeatherRequest.open("GET",url,false);
    xmlHttpWeatherRequest.send();
    if(xmlHttpWeatherRequest.readyState == 4 && xmlHttpWeatherRequest.status == 200){
        var jsonResponse = xmlHttpWeatherRequest.responseText;
        var weatherInfo = eval("("+jsonResponse+")");
        var location = weatherInfo.name;
        var description = weatherInfo.weather[0].description;
        var temperature = weatherInfo.main.temp;
        var pressure = weatherInfo.main.pressure;
        var humidity = weatherInfo.main.humidity;
        var windSpeed = weatherInfo.wind.speed;
        // var icon = "https://openweathermap.org/img/w/"+weatherInfo.weather[0].icon+".png";

        var output = "<p><b class='text-primary'> Weather for "+ location +"</b></p>"
            output+= "<table><tr><th class='text-info'>Currently :</th><td class='text-danger'>"+ description +"</td></tr>";
            output+= "<tr><th class='text-info'>Temperature : </th><td class='text-danger'>"+ Math.round(Math.round((temperature -273.15)*100)/100) +' o'.sup()+"C</td></tr>";
            output+= "<tr><th class='text-info'>Pressure :</th><td class='text-danger'>"+ pressure +" hpa</td></tr>";
            output+= "<tr><th class='text-info'>Humidity :</th><td class='text-danger'>"+ humidity +" %</td></tr>";
            output+= "<tr><th class='text-info'>Wind Speed :</th><td class='text-danger'>"+ windSpeed +" Km</td></tr></table>";
        document.getElementById("weather").innerHTML = output;
        document.getElementById("location").innerHTML = location;
        document.getElementById("description").innerHTML = description;
        document.getElementById("temperature").innerHTML = Math.round(Math.round((temperature -273.15)*100)/100) +' o'.sup()+"C";
        document.getElementById("pressure").innerHTML = pressure;
        document.getElementById("humidity").innerHTML = humidity;
        document.getElementById("windSpeed").innerHTML = windSpeed;
        // document.getElementById("icon").src = icon;
    }
}
function onError(error){
    switch(error.code){
        case PERMISSION_DENIED :
            alert("Accéss denied");
        break;
        case TIMEOUT :
            alert("Timeout");
        break;
        case POSITION_UNAVAILABLE :
            alert("Position unavailable");
        break;
        default:
            alert("Unkown Error");
        break;
    }
}
function findWeather(){
    var ville = document.getElementById("ville").value.replace(" ","+");
    //xml http request object
    var xmlHttpWeatherRequest = new XMLHttpRequest();
    var url = "http://api.openweathermap.org/data/2.5/find?q="+ville+"&appid=6e1377917ba5dc606d32495c04dfd273&lang=id";
    //type de request
    xmlHttpWeatherRequest.open("GET",url,false);
    xmlHttpWeatherRequest.send();
    if(xmlHttpWeatherRequest.readyState == 4 && xmlHttpWeatherRequest.status == 200){
        var jsonResponse = xmlHttpWeatherRequest.responseText;
        var weatherInfo = eval("("+jsonResponse+")");
        var location = weatherInfo.list[0].name;
        var description = weatherInfo.list[0].weather[0].description;
        var temperature = weatherInfo.list[0].main.temp;
        var pressure = weatherInfo.list[0].main.pressure;
        var humidity = weatherInfo.list[0].main.humidity;
        var windSpeed = weatherInfo.list[0].wind.speed;
        // var icon = "https://openweathermap.org/img/w/"+weatherInfo.weather[0].icon+".png";

        var output= "<table><tr><th class='text-info'>Currently :</th><td class='text-danger'>"+ description +"</td></tr>";
            output+= "<tr><th class='text-info'>Temperature : </th><td class='text-danger'>"+ Math.round(Math.round((temperature -273.15)*100)/100) +' o'.sup()+"C</td></tr>";
            output+= "<tr><th class='text-info'>Pressure :</th><td class='text-danger'>"+ pressure +" hpa</td></tr>";
            output+= "<tr><th class='text-info'>Humidity :</th><td class='text-danger'>"+ humidity +" %</td></tr>";
            output+= "<tr><th class='text-info'>Wind Speed :</th><td class='text-danger'>"+ windSpeed +" Km</td></tr></table>";
        document.getElementById("weather").innerHTML = output;
        // document.getElementById("icon").src = icon;
    }
}