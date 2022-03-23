//Browser detection

// Browser name
browserName = "default";
function getBrowserName(name, isBrowser) {
	if (isBrowser == true) {
		browserName = name;
	}
}

// Opera 8.0+
var isOpera = (!!window.opr && !!opr.addons) || !!window.opera || navigator.userAgent.indexOf(' OPR/') >= 0;
getBrowserName("Opera", isOpera);

// Firefox 1.0+
var isFirefox = typeof InstallTrigger !== 'undefined';
getBrowserName("Firefox", isFirefox);

// Safari 3.0+ "[object HTMLElementConstructor]"
var isSafari = /constructor/i.test(window.HTMLElement) || (function (p) { return p.toString() === "[object SafariRemoteNotification]"; })(!window['safari'] || (typeof safari !== 'undefined' && window['safari'].pushNotification));
getBrowserName("Safari", isSafari);

// Internet Explorer 6-11
var isIE = /*@cc_on!@*/false || !!document.documentMode;
getBrowserName("IE", isIE);

// Edge 20+
var isEdge = !isIE && !!window.StyleMedia;
getBrowserName("Edge",isEdge);

// Chrome 1 - 79
var isChrome = !!window.chrome && (!!window.chrome.webstore || !!window.chrome.runtime);
getBrowserName("Chrome", isChrome);

// Edge (based on chromium) detection
var isEdgeChromium = isChrome && (navigator.userAgent.indexOf("Edg") != -1);
getBrowserName("EdgeChromium", isEdgeChromium);

// Blink engine detection
var isBlink = (isChrome || isOpera) && !!window.CSS;
getBrowserName("Blink", isBlink);

//alert
alert ("Browser detected : "+ browserName)