/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function Message(){
    
    var pass=document.getElementById('Password').value;
    var conpass=document.getElementById('ConformPassword').value;
    var str=document.getElementById('NBCMail').value;
    var mail=document.getElementById('NBCMail').value;
    if(pass.toString()==conpass.toString()&& pass.toString()!=""){
        
        document.forms[0].action='Register';
        document.forms[0].submit();
    }
    else{
        alert("Please verify your password \n\n Thanks");

    return false
    }
var at="@"
		var dot="."
		var lat=str.indexOf(at)
		var lstr=str.length	
	 if (str.substring(lat+1,lstr)!="nbc.org.kh"){
          alert(str.substring(lat+1,lstr));
	alert("Sorry!!\nOnly NBC Email is Valide.\nIf you don't have OR forget your NBC's email or password, Please contact IT department for assistant.\n\n\Thanks!")
	 return false
         }else{
             document.forms[0].action='Register';
             document.forms[0].submit();
         }
            
   document.getElementById("Register").submit();	
}

function ValidateForm(){
	var emailID=document.frmSample.txtEmail
	if ((emailID.value==null)||(emailID.value=="")){
		alert("Please Enter your Email ID")
		emailID.focus()
		return false
	}
	if (echeck(emailID.value)==false){
		emailID.value=""
		emailID.focus()
		return false
	}
	return true;
}

function CreateWindow(uri) {
    var newWin = window.open(uri,'newwin1','width=500,height=400,resizable,scrollable,scrollbars=yes');
    newWin.focus();

} 

function Validate(id){
    alert(id);
    
}