import React from 'react';
import axios from 'axios';


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

// function sendInfo(locationData){
//         axios.post('', { location: locationData })
//           .then((response) => {
//             console.log(response);
//           })
//           .catch((error) => {
//             console.log(error);
//           });
// }

export function response() {
  console.log("HELLOOOOOOO !!!")
  axios.get("http://ipwhois.app/json/" + ip)
  .then((response)=> {
      // handle success
      console.log("SUCCESS")
      var location = response.data
      console.log(location.country);
      //sendInfo(location)
      if(location.country == "France") {
          console.log("check1 " + true);
          return true
      }
      else {
        console.log("check2 " + true);
        return true
      }
    })
    .catch((error)=> {
      // handle error
      console.log("ERROR")
      console.log(error);
      console.log("check " + true);
      return true
    });

};