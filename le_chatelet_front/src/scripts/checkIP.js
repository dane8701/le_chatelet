//IP Detection with output
var ip = ''; // Current IP
var XMLHttp = new XMLHttpRequest();

XMLHttp.onreadystatechange = function() {
	if (this.readyState == 4 && this.status == 200) {
		var json = JSON.parse(this.responseText);
		// Country code output, field "country_code"
		if (json.country_code == "FR")
			alert("Right Country : " +json.country_code);
		else alert ("Wrong Country : " + json.country_code)
	}
};
XMLHttp.open("GET", "http://ipwhois.app/json/" + ip, true);
XMLHttp.send();