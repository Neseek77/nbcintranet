function popupWin() {
text =  "<html>\n<head>\n<title>Pop Window</title>\n<body>\n";
text += "<center>fdsfsd fsdfsdfd\n<br>";
text += "<a href='http://javascript.internet.com/new' target='_blank'><h2>New JavaScripts</h2></a>";
text += "</center>\n</body>\n</html>\n";
setTimeout('windowProp(text)', 1000); 		// delay 3 seconds before opening
}
function windowProp(text) {
newWindow = window.open('','newWin','width=1000,height=1200');
newWindow.document.write(text);
setTimeout('closeWin(newWindow)', 100000);	// delay 5 seconds before closing
}
function closeWin(newWindow) {
newWindow.close();				// close small window and depart
}