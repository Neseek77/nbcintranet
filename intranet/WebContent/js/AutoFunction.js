
window.onload=function Load()
{  
for(var i=1;i<32;i++){  
var select = document.getElementById("SlDayOB");
select.options[select.options.length] = new Option(i,i);
var select = document.getElementById("SlDayHD");
select.options[select.options.length] = new Option(i,i);
}
for(var j=2011;j>1989;j--){  
var select = document.getElementById("SlYearOB");
select.options[select.options.length] = new Option(j,j);
var select = document.getElementById("SlYearHD");
select.options[select.options.length] = new Option(j,j);
}
}

function OnClick(){
    for(var i=1;i<32;i++){  
var select = document.getElementById("SlDayOB");
select.options[select.options.length] = new Option(i,i);
var select = document.getElementById("SlDayHD");
select.options[select.options.length] = new Option(i,i);
}
for(var j=2011;j>1989;j--){  
var select = document.getElementById("SlYearOB");
select.options[select.options.length] = new Option(j,j);
var select = document.getElementById("SlYearHD");
select.options[select.options.length] = new Option(j,j);
}
}