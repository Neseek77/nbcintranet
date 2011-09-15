/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.

*/

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

 function submitMe(){
     
       var myTitle=document.getElementById('title').value;
       var desc=document.getElementById('desc').value;
       document.PostAnnouncement.action="AdminUploadAnnouncement?title="+myTitle+"&desc="+desc;
       document.PostAnnouncement.submit();
 }
 
 function MultiUpload(){
       var myTitle=document.getElementById('title').value;
       var desc=document.getElementById('desc').value;
       var file1=document.getElementById("filename_1").value;
       var file2=document.getElementById("filename_2").value;
       //alert("hellow");
       document.AdminPostNewsEvent.action="AdminMultiUploadNewsEvent?title="+myTitle+"&desc="+desc+"&fl1="+file1+"&fl2="+file2;
       document.AdminPostNewsEvent.submit();
 }