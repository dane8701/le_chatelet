import React from 'react';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

//IP Detection with output
var ip = ''; // Current IP

//XMLHttp.onreadystatechange = function() {
//	if (this.readyState == 4 && this.status == 200) {
//		var json = JSON.parse(this.responseText);
//		// Country code output, field "country_code"
//		if (json.country_code == "FR")
//			alert("Right Country : " +json.country_code);
//		else alert ("Wrong Country : " + json.country_code)
//	}
//};
function sendInfo(locationData){
        axios.post('', { location: locationData })
          .then((response) => {
            console.log(response);
          })
          .catch((error) => {
            console.log(error);
          });
}

function CountryCheck(locationData){
        const navigate = useNavigate();
        if (locationData.country == "France")
            console.log("Right Country")
        else {
            console.log("Wrong Country")
            navigate("./../pages/Rejection/index")
        };
}

export function response() {
    console.log("HELLOOOOOOO !!!")
    axios.get("http://ipwhois.app/json/" + ip)
        .then((response)=> {
        // handle success
        console.log("SUCCESS")
        var location = response.data
        console.log(location.country);
        sendInfo(location)

        })
        .catch((error)=> {
        // handle error
        console.log("ERROR")
        console.log(error);
        });

};