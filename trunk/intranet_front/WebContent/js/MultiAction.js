/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

*/
/* Add data into SELECT */
function addMe(value){
  /*var elSel = document.getElementById('selGroup');
  
  if (elSel.selectedIndex >= 0) {
    var elOptNew = document.createElement('option');
    elOptNew.text = value;
    elOptNew.value = value;
    var elOptOld = elSel.options[elSel.selectedIndex];  
    alert(value);
    try {
      elSel.add(elOptNew, elOptOld); // standards compliant; doesn't work in IE
    }
    catch(ex) {
      elSel.add(elOptNew, elSel.selectedIndex); // IE only
    }
 }*/
  	var oSelField = document.getElementById("selGroup");
	var oOption = document.createElement("OPTION");
	oSelField.options.add(oOption);
	oOption.text = value
	oOption.value = value;



}

function fncSubmit(strPage){
   if(strPage == "1")
   {
       document.UpdateUserProfiles.action="Upload";
   }
   if(strPage == "2")
   {
       document.UpdateUserProfiles.action="UpdateEditeProfiles";
   }
   
  document.UpdateUserProfiles.submit();
}
//Class Announcement
 function submitMe(){
     myTitle=document.getElementById('title').value;
         document.forms[0].action='/Administration/AdminUpload';
        document.forms[0].submit();
     //document.forms[0].action="AdminUpload?title="+myTitle;
     //document.forms[0].submit();
 }
 //Class My upload
 function SubmitValue(){
     //alert("hell");
    CateID=document.getElementById('Selection').value;
    Title=document.getElementById('Title').value;
    ShortDesc=document.getElementById('ShortDesc').value;
    FullDesc=document.getElementById('FullDesc').value;
    KeyW=document.getElementById('KeyW').value;
    document.UploadFile.action="ClassUploadFile?CateID="+CateID+"&Title="+Title+"&ShortDesc="+ShortDesc+"&FullDesc="+FullDesc+"&KeyW="+KeyW+"";
   document.UploadFile.submit();
      }