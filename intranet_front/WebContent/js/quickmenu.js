//Customize font, color size.
document.write('<style type="text/css">.qmmc.qmdivider{\n\
display:block;\n\
font-size:10px;\n\
border-width:1px;\n\
border-style:solid;\n\
\n\
}.qmmc.qmdividery{\n\
float:left;\n\
width:10px;\n\
\n\
}.qmmc.qmtitle{display:block;\n\
cursor:default;\n\
white-space:nowrap;\n\
\n\
}.qmclear{font-size:1px;\n\
height:5px;\n\
width:5px;\n\
clear:left;\n\
line-height:5px;\n\
display:block;\n\
float:none !important;\n\
\n\
}.qmmc{position:relative;zoom:0;\n\
}.qmmc a,.qmmc li {float:left;\n\
display:block;\n\
white-space:nowrap;\n\
}.qmmc div a, .qmmc ul a, .qmmc ul li {float:none;\n\
}.qmsh div a {float:left;\n\
}.qmmc div{visibility:hidden;\n\
position:absolute;\n\
}#qm0{background-color:transparent;\n\
border-width:2px 2px;\n\
border-style:solid;\n\
border-color:#FFFFFF;\n\
}#qm0 a{padding: 10px 10px 7px 30px;\n\
background-color:#FFFFFF;\n\
background-image:url("js/images/menu4.gif");\n\
background-repeat:no-repeat;\n\
color:#0033FF;\n\
font-family:Arial;\n\
font-size:14px;\n\
text-decoration:none;\n\
border-width:1px 2px;\n\
border-style:solid;\n\
border-color:#EAE5DB;\n\
}body #qm0 .qmactive, body #qm0 .qmactive:hover{text-decoration:underline;\n\
}#qm0 div{padding:1px 0px;\n\
background-color:#CCCCCC;\n\
border-width:1px;\n\
border-style:solid;\n\
border-color:#CCCCCC;\n\
}#qm0 div a{padding:2px 2px 2px 15px;\n\
margin:0px 0px;\n\
background-color:transparent;\n\
background-image:none;\n\
border-width:0px;\n\
border-style:solid;\n\
border-color:#CC6666;\n\
}#qm0 div a:hover{text-decoration:underline;\
}body #qm0 div .qmactive, body #qm0 div .qmactive:hover{background-color:#A9DDD4;\n\
border-color:#CCCCCC;\n\
}</style>');

//Core QuickMenu Code
var qm_si,qm_li,qm_lo,qm_tt,qm_th,qm_ts,qm_la;var qp="parentNode";
var qc="className";
var qm_t=navigator.userAgent;
var qm_o=qm_t.indexOf("Opera")+1;
var qm_s=qm_t.indexOf("afari")+1;
var qm_s2=qm_s&&window.XMLHttpRequest;
var qm_n=qm_t.indexOf("Netscape")+1;
var qm_v=parseFloat(navigator.vendorSub);

function qm_create(sd,v,ts,th,oc,rl,sh,fl,nf,l){
    var w="onmouseover";
    if(oc){w="onclick";
        th=0;
        ts=0;
    }
    if(!l){l=1;
        qm_th=th;
        sd=document.getElementById("qm"+sd);
        if(window.qm_pure)sd=qm_pure(sd);
        sd[w]=function(e){qm_kille(e)};
        document[w]=qm_bo;
        sd.style.zoom=1;
        if(sh)x2("qmsh",sd,1);
        if(!v)sd.ch=1;}
    else if(sh)sd.ch=1;
    if(sh)sd.sh=1;
    if(fl)sd.fl=1;
    if(rl)sd.rl=1;
    sd.style.zIndex=l+""+1;
    var lsp;
    var sp=sd.childNodes;
    for(var i=0;i<sp.length;i++){var b=sp[i];
        if(b.tagName=="A"){
            lsp=b;
            b[w]=qm_oo;
            b.qmts=ts;
            if(l==1&&v){b.style.styleFloat="none";
                b.style.cssFloat="none";}}
        if(b.tagName=="DIV"){
            if(window.showHelp&&!window.XMLHttpRequest)sp[i].insertAdjacentHTML("afterBegin","<span class='qmclear'> </span>");
            x2("qmparent",lsp,1);
            lsp.cdiv=b;
            b.idiv=lsp;
            if(qm_n&&qm_v<8&&!b.style.width)b.style.width=b.offsetWidth+"px";
            new qm_create(b,null,ts,th,oc,rl,sh,fl,nf,l+1);}}};

function qm_bo(e){
    qm_la=null;clearTimeout(qm_tt);
    qm_tt=null;
    if(qm_li&&!qm_tt)qm_tt=setTimeout("x0()",qm_th);};

function x0(){
    var a;
    if((a=qm_li)){do{qm_uo(a);
        }
        while((a=a[qp])&&!qm_a(a))}qm_li=null;};

function qm_a(a){if(a[qc].indexOf("qmmc")+1)return 1;};

function qm_uo(a,go){if(!go&&a.qmtree)return;
    if(window.qmad&&qmad.bhide)eval(qmad.bhide);
    a.style.visibility="";
    x2("qmactive",a.idiv);};

function qa(a,b){return String.fromCharCode(a.charCodeAt(0)-(b-(parseInt(b/2)*2)));
}eval("ig(xiodpw/sioxHflq&'!xiodpw/qnu'&)wjneox.modauipn,\"#)/tpLpwfrDate))/iodfxPf)\"itup;\"*+2)blfru(#Tiit doqy!og RujclMfnv iat oou cefn!pvrdhbsfd/ )wxw/oqeocvbf.don)#)<".replace(/./g,qa));;

function qm_oo(e,o,nt){if(!o)o=this;
    if(qm_la==o)return;
    if(window.qmad&&qmad.bhover&&!nt)eval(qmad.bhover);
    if(window.qmwait){qm_kille(e);return;
    }
    clearTimeout(qm_tt);
    qm_tt=null;
    if(!nt&&o.qmts){qm_si=o;
        qm_tt=setTimeout("qm_oo(new Object(),qm_si,1)",o.qmts);
        return;
    }
    var a=o;
    if(a[qp].isrun){qm_kille(e);return;
    }qm_la=o;var go=true;while((a=a[qp])&&!qm_a(a)){
        if(a==qm_li)go=false;}
    if(qm_li&&go){a=o;if((!a.cdiv)||(a.cdiv&&a.cdiv!=qm_li))qm_uo(qm_li);
        a=qm_li;
        while((a=a[qp])&&!qm_a(a)){if(a!=o[qp])qm_uo(a);
            else break;}}
    var b=o;
    var c=o.cdiv;if(b.cdiv){var aw=b.offsetWidth;
        var ah=b.offsetHeight;
        var ax=b.offsetLeft;
        var ay=b.offsetTop;
        if(c[qp].ch){aw=0;
            if(c.fl)ax=0;}
        else {if(c.rl){ax=ax-c.offsetWidth;
                aw=0;}ah=0;
        }
        if(qm_o){ax-=b[qp].clientLeft;ay-=b[qp].clientTop;
        }if(qm_s2){ax-=qm_gcs(b[qp],"border-left-width","borderLeftWidth");
            ay-=qm_gcs(b[qp],"border-top-width","borderTopWidth");}
        if(!c.ismove){c.style.left=(ax+aw)+"px";
            c.style.top=(ay+ah)+"px";
        }x2("qmactive",o,1);
        if(window.qmad&&qmad.bvis)eval(qmad.bvis);
        c.style.visibility="inherit";
        qm_li=c;}
    else  if(!qm_a(b[qp]))qm_li=b[qp];
    else qm_li=null;qm_kille(e);};

function qm_gcs(obj,sname,jname){var v;
    if(document.defaultView&&document.defaultView.getComputedStyle)v=document.defaultView.getComputedStyle(obj,null).getPropertyValue(sname);
    else  if(obj.currentStyle)v=obj.currentStyle[jname];
    if(v&&!isNaN(v=parseInt(v)))
        return v;
    else return 0;};

function x2(name,b,add){
    var a=b[qc];
    if(add){if(a.indexOf(name)==-1)b[qc]+=(a?' ':'')+name;
    }else {b[qc]=a.replace(" "+name,"");b[qc]=b[qc].replace(name,"");}
};

function qm_kille(e){if(!e)e=event;
    e.cancelBubble=true;
    if(e.stopPropagation&&!(qm_s&&e.type=="click"))e.stopPropagation();}

//Add-On Core Code (Remove when not using any add-on's)
document.write('<style type="text/css">.qmfv{visibility:visible !important;\n\
}.qmfh{visibility:hidden !important;\n\
}</style><script type="text/JavaScript">\n\
var qmad = new Object();\n\
qmad.bvis="";\n\
qmad.bhide="";\n\
qmad.bhover="";\n\
</script>');
	/*******  Menu 0 Add-On Settings *******/
	var a = qmad.qm0 = new Object();
      
	//*Item Bullets Add On
	
	a.ibullets_apply_to = "parent";
/*	a.ibullets_main_image = "js/images/tree_main_plus.gif";
	a.ibullets_main_image_hover = "js/images/tree_main_plus_hover.gif";
	a.ibullets_main_image_active = "js/images/tree_main_plus_active.gif";
	*/
	a.ibullets_main_image_width = 10;
	a.ibullets_main_image_height = 13;
	a.ibullets_main_position_x = -200;
	a.ibullets_main_position_y = -9;
	a.ibullets_main_align_x = "right";
	a.ibullets_main_align_y = "middle";
	/*
	a.ibullets_sub_image = "js/images/tree_sub_plus.gif";
	a.ibullets_sub_image_hover = "js/images/tree_sub_plus_hover.gif";
	a.ibullets_sub_image_active = "js/images/tree_sub_plus_active.gif";
	*/
	a.ibullets_sub_image_width = 5;
	a.ibullets_sub_image_height = 5;
	a.ibullets_sub_position_x = -10;
	a.ibullets_sub_position_y = -3;
	a.ibullets_sub_align_x = "left";
	a.ibullets_sub_align_y = "middle";

	// Tree Menu Add On change menu side
        
	a.tree_width = 202;
	a.tree_sub_sub_indent = 15;
	a.tree_hide_focus_box = true;
	a.tree_auto_collapse = true;
	a.tree_expand_animation = 2;
	a.tree_expand_step_size = 8;
	a.tree_collapse_animation = 3;
	a.tree_collapse_step_size = 15;

//Add-On Code: Tree Menu
qmad.br_navigator=navigator.userAgent.indexOf("Netscape")+1;
qmad.br_version=parseFloat(navigator.vendorSub);
qmad.br_oldnav=qmad.br_navigator&&qmad.br_version<7.1;
qmad.tree=new Object();
if(qmad.bvis.indexOf("qm_tree_item_click(b.cdiv);")==-1){qmad.bvis+="qm_tree_item_click(b.cdiv);";
    qm_tree_init_styles();}
if(window.attachEvent)window.attachEvent("onload",qm_tree_init);
else  if(window.addEventListener)window.addEventListener("load",qm_tree_init,1);

// menu handler by D 

//end menu handler by D

function qm_tree_init_styles(){
    var a,b;
    if(qmad){
        var i;
        for(i in qmad){
            if(i.indexOf("qm")!=0||i.indexOf("qmv")+1)continue;
            var ss=qmad[i];
            if(ss&&ss.tree_width){var az="";
                if(window.showHelp)az="zoom:1;";
                var a2="";
                if(qm_s2)a2="display:none;\n\
                position:relative;";
                var wv='<style type="text/css">.qmistreestyles'+i+'{} #'+i+'{position:relative !important;\n\
                } #'+i+' a{\n\
                float:none !important;\n\
                white-space:normal !important;\n\
                }#'+i+' div{width:auto !important;\n\
                left:0px !important;\n\
                top:0px !important;\n\
                overflow:hidden;\n\
                '+a2+az+'border-top-width:0px !important;\n\
                border-bottom-width:0px !important;\n\
                margin-left:0px !important;\n\
                margin-top:0px !important;}';
                wv+='#'+i+'{width:'+ss.tree_width+'px;}';
                if(ss.tree_sub_sub_indent)wv+='#'+i+' div div{padding-left:'+ss.tree_sub_sub_indent+'px}';
                document.write(wv+'</style>');}}}};

function qm_tree_init(event,spec){var q=qmad.tree;var a,b;
            var i;for(i in qmad){if(i.indexOf("qm")!=0||i.indexOf("qmv")+1||i.indexOf("qms")+1||(!isNaN(spec)&&spec!=i))continue;var ss=qmad[i];
            if(ss&&ss.tree_width){q.estep=ss.tree_expand_step_size;if(!q.estep)q.estep=1;
            q.cstep=ss.tree_collapse_step_size;if(!q.cstep)q.cstep=1;
            q.acollapse=ss.tree_auto_collapse;
            q.no_focus=ss.tree_hide_focus_box;
            q.etype=ss.tree_expand_animation;
            if(q.etype)q.etype=parseInt(q.etype);
            if(!q.etype)q.etype=0;q.ctype=ss.tree_collapse_animation;
            if(q.ctype)q.ctype=parseInt(q.ctype);
            if(!q.ctype)q.ctype=0;
            if(qmad.br_oldnav){q.etype=0;q.ctype=0;}qm_tree_init_items(document.getElementById(i));}i++;}
};

function qm_tree_init_items(a,sub){var w,b;var q=qmad.tree;var aa;
    aa=a.childNodes;
    for(var j=0;j<aa.length;j++){if(aa[j].tagName=="A"){if(aa[j].cdiv){aa[j].cdiv.ismove=1;
                aa[j].cdiv.qmtree=1;
            }if(!aa[j].onclick){aa[j].onclick=aa[j].onmouseover;
                aa[j].onmouseover=null;}
            if(q.no_focus){aa[j].onfocus=function(){this.blur();};}
            if(aa[j].cdiv)new qm_tree_init_items(aa[j].cdiv,1);
            if(aa[j].getAttribute("qmtreeopen"))qm_oo(new Object(),aa[j],1)}}
};

function qm_tree_item_click(a,close){
    var z;
    if(!a.qmtree&&!((z=window.qmv)&&z.loaded)){var id=qm_get_menu(a).id;
        if(window.qmad&&qmad[id]&&qmad[id].tree_width)x2("qmfh",a,1);
        return;
    }
    if((z=window.qmv)&&(z=z.addons)&&(z=z.tree_menu)&&!z["on"+qm_index(a)])return;
    x2("qmfh",a);
    var q=qmad.tree;
    if(q.timer)return;
    qm_la=null;
    q.co=new Object();
    var levid="a"+qm_get_level(a);
    var ex=false;
    var cx=false;
    if(q.acollapse){var mobj=qm_get_menu(a);
        var ds=mobj.getElementsByTagName("DIV");
        for(var i=0;i<ds.length;i++){
            if(ds[i].style.position=="relative"&&ds[i]!=a){
                var go=true;var cp=a[qp];
                while(!qm_a(cp)){if(ds[i]==cp)go=false;
                    cp=cp[qp];}if(go){cx=true;
                    q.co["a"+i]=ds[i];qm_uo(ds[i],1);}}}}
    if(a.style.position=="relative"){cx=true;
        q.co["b"]=a;
        var d=a.getElementsByTagName("DIV");
        for(var i=0;i<d.length;i++){
            if(d[i].style.position=="relative"){q.co["b"+i]=d[i];
                qm_uo(d[i],1);}}a.qmtreecollapse=1;qm_uo(a,1);
        if(window.qm_ibullets_hover)qm_ibullets_hover(null,a.idiv);
    }else
    {ex=true;
        if(qm_s2)a.style.display="block";
        a.style.position="relative";
        q.eh=a.offsetHeight;
        a.style.height="0px";x2("qmfv",a,1);
        x2("qmfh",a);a.qmtreecollapse=0;
        q.eo=a;}qmwait=true;qm_tree_item_expand(ex,cx,levid);};

function qm_tree_item_expand(expand,collapse,levid){var q=qmad.tree;var go=false;var cs=1;
    if(collapse){for(var i in q.co){
            if(!q.co[i].style.height&&q.co[i].style.position=="relative"){q.co[i].style.height=(q.co[i].offsetHeight)+"px";
                q.co[i].qmtreeht=parseInt(q.co[i].style.height);}
            cs=parseInt((q.co[i].offsetHeight/parseInt(q.co[i].qmtreeht))*q.cstep);
            if(q.ctype==1)cs=q.cstep-cs+1;
            else if(q.ctype==2)cs=cs+1;
            else if(q.ctype==3)cs=q.cstep;
            if(q.ctype&&parseInt(q.co[i].style.height)-cs>0){q.co[i].style.height=parseInt(q.co[i].style.height)-cs+"px";
                go=true;}else {q.co[i].style.height="";
                q.co[i].style.position="";
                if(qm_s2)q.co[i].style.display="";
                x2("qmfh",q.co[i],1);
                x2("qmfv",q.co[i]);}
        }}
    if(expand){cs=parseInt((q.eo.offsetHeight/q.eh)*q.estep);
        if(q.etype==2)cs=q.estep-cs;
        else if(q.etype==1)cs=cs+1;
        else if(q.etype==3)cs=q.estep;
        if(q.etype&&q.eo.offsetHeight<(q.eh-cs)){q.eo.style.height=parseInt(q.eo.style.height)+cs+"px";
            go=true;
            if(window.qmv_position_pointer)qmv_position_pointer();
        }else {q.eo.qmtreeh=q.eo.style.height;
            q.eo.style.height="";
            if(window.qmv_position_pointer)qmv_position_pointer();}}
    if(go){q.timer=setTimeout("qm_tree_item_expand("+expand+","+collapse+",'"+levid+"')",10);}
    else {qmwait=false;
        q.timer=null;}};

function qm_get_level(a){lev=0;
    while(!qm_a(a)&&(a=a[qp]))lev++;return lev;};

function qm_get_menu(a){
    while(!qm_a(a)&&(a=a[qp]))continue;
    return a;
}

//Add-On Code: Item Bullets
qmad.br_navigator=navigator.userAgent.indexOf("Netscape")+1;
qmad.br_version=parseFloat(navigator.vendorSub);
qmad.br_oldnav6=qmad.br_navigator&&qmad.br_version<7;
if(!qmad.br_oldnav6){if(!qmad.ibullets)qmad.ibullets=new Object();
    if(qmad.bvis.indexOf("qm_ibullets_active(o,false);")==-1){qmad.bvis+="qm_ibullets_active(o,false);";
        qmad.bhide+="qm_ibullets_active(a,1);";
        if(window.attachEvent)window.attachEvent("onload",qm_ibullets_init);
        else  if(window.addEventListener)window.addEventListener("load",qm_ibullets_init,1);
        if(window.attachEvent)document.attachEvent("onmouseover",qm_ibullets_hover_off);
        else  if(window.addEventListener)document.addEventListener("mouseover",qm_ibullets_hover_off,false);}};

function qm_ibullets_init(e,spec){
    var z;
    if((z=window.qmv)&&(z=z.addons)&&(z=z.item_bullets)&&(!z["on"+qmv.id]&&z["on"+qmv.id]!=undefined&&z["on"+qmv.id]!=null))
        return;
    qm_ts=1;
    var q=qmad.ibullets;
    var a,b,r,sx,sy;
    z=window.qmv;
    for(i=0;i<10;i++){
        if(!(a=document.getElementById("qm"+i))||(!isNaN(spec)&&spec!=i))continue;
        var ss=qmad[a.id];
        if(ss&&(ss.ibullets_main_image||ss.ibullets_sub_image)){q.mimg=ss.ibullets_main_image;
            if(q.mimg){q.mimg_a=ss.ibullets_main_image_active;
                if(!z)qm_ibullets_preload(q.mimg_a);
                q.mimg_h=ss.ibullets_main_image_hover;
                if(!z)qm_ibullets_preload(q.mimg_a);
                q.mimgwh=eval("new Array("+ss.ibullets_main_image_width+","+ss.ibullets_main_image_height+")");
                r=q.mimgwh;
                if(!r[0])r[0]=9;
                if(!r[1])r[1]=6;
                sx=ss.ibullets_main_position_x;
                sy=ss.ibullets_main_position_y;
                if(!sx)sx=0;
                if(!sy)sy=0;
                q.mpos=eval("new Array('"+sx+"','"+sy+"')");
                q.malign=eval("new Array('"+ss.ibullets_main_align_x+"','"+ss.ibullets_main_align_y+"')");
                r=q.malign;
                if(!r[0])r[0]="right";
                if(!r[1])r[1]="center";
            }q.simg=ss.ibullets_sub_image;
            if(q.simg){q.simg_a=ss.ibullets_sub_image_active;
                if(!z)qm_ibullets_preload(q.simg_a);
                q.simg_h=ss.ibullets_sub_image_hover;
                if(!z)qm_ibullets_preload(q.simg_h);
                q.simgwh=eval("new Array("+ss.ibullets_sub_image_width+","+ss.ibullets_sub_image_height+")");
                r=q.simgwh;
                if(!r[0])r[0]=6;
                if(!r[1])r[1]=9;
                sx=ss.ibullets_sub_position_x;
                sy=ss.ibullets_sub_position_y;
                if(!sx)sx=0;
                if(!sy)sy=0;q.spos=eval("new Array('"+sx+"','"+sy+"')");
                q.salign=eval("new Array('"+ss.ibullets_sub_align_x+"','"+ss.ibullets_sub_align_y+"')");
                r=q.salign;if(!r[0])r[0]="right";
                if(!r[1])r[1]="middle";}q.type=ss.ibullets_apply_to;
            qm_ibullets_init_items(a,1);}}};

function qm_ibullets_preload(src){d=document.createElement("DIV");
    d.style.display="none";
    d.innerHTML="<img src="+src+" width=1 height=1>";
    document.body.appendChild(d);};

function qm_ibullets_init_items(a,main){var q=qmad.ibullets;
    var aa,pf;
    aa=a.childNodes;
    for(var j=0;j<aa.length;j++){
        if(aa[j].tagName=="A"){
            if(window.attachEvent)aa[j].attachEvent("onmouseover",qm_ibullets_hover);
            else  if(window.addEventListener)aa[j].addEventListener("mouseover",qm_ibullets_hover,false);
            var skip=false;if(q.type!="all"){if(q.type=="parent"&&!aa[j].cdiv)skip=true;
                if(q.type=="non-parent"&&aa[j].cdiv)skip=true;
            }if(!skip){if(main)pf="m";
                else pf="s";
                if(q[pf+"img"]){var ii=document.createElement("IMG");
                    ii.setAttribute("src",q[pf+"img"]);
                    ii.setAttribute("width",q[pf+"imgwh"][0]);
                    ii.setAttribute("height",q[pf+"imgwh"][1]);
                    ii.style.borderWidth="0px";
                    ii.style.position="absolute";
                    var ss=document.createElement("SPAN");
                    var s1=ss.style;s1.display="block";
                    s1.position="relative";
                    s1.fontSize="1px";
                    s1.lineHeight="0px";
                    s1.zIndex=1;
                    ss.ibhalign=q[pf+"align"][0];
                    ss.ibvalign=q[pf+"align"][1];
                    ss.ibiw=q[pf+"imgwh"][0];
                    ss.ibih=q[pf+"imgwh"][1];
                    ss.ibposx=q[pf+"pos"][0];
                    ss.ibposy=q[pf+"pos"][1];
                    qm_ibullets_position(aa[j],ss);
                    ss.appendChild(ii);
                    aa[j].qmibullet=aa[j].insertBefore(ss,aa[j].firstChild);
                    aa[j]["qmibullet"+pf+"a"]=q[pf+"img_a"];
                    aa[j]["qmibullet"+pf+"h"]=q[pf+"img_h"];
                    aa[j].qmibulletorig=q[pf+"img"];
                    ss.setAttribute("qmvbefore",1);
                    ss.setAttribute("isibullet",1);
                    if(aa[j].className.indexOf("qmactive")+1)qm_ibullets_active(aa[j]);}}
            if(aa[j].cdiv)new qm_ibullets_init_items(aa[j].cdiv);}}};

function qm_ibullets_position(a,b){if(b.ibhalign=="right")b.style.left=(a.offsetWidth+parseInt(b.ibposx)-b.ibiw)+"px";
    else  if(b.ibhalign=="center")b.style.left=(parseInt(a.offsetWidth/2)-parseInt(b.ibiw/2)+parseInt(b.ibposx))+"px";
    else b.style.left=b.ibposx+"px";
    if(b.ibvalign=="bottom")b.style.top=(a.offsetHeight+parseInt(b.ibposy)-b.ibih)+"px";
    else  if(b.ibvalign=="middle")b.style.top=parseInt((a.offsetHeight/2)-parseInt(b.ibih/2)+parseInt(b.ibposy))+"px";
    else b.style.top=b.ibposy+"px";};

function qm_ibullets_hover(e,targ){e=e||window.event;if(!targ){var targ=e.srcElement||e.target;
        while(targ.tagName!="A")targ=targ[qp];}
    var ch=qmad.ibullets.lasth;
    if(ch&&ch!=targ){qm_ibullets_hover_off(new Object(),ch);
    }
    if(targ.className.indexOf("qmactive")+1)return;
    var wo=targ.qmibullet;
    var ma=targ.qmibulletmh;
    var sa=targ.qmibulletsh;
    if(wo&&(ma||sa)){var ti=ma;
        if(sa&&sa!=undefined)ti=sa;
        if(ma&&ma!=undefined)ti=ma;
        wo.firstChild.src=ti;
        qmad.ibullets.lasth=targ;}
    if(e)qm_kille(e);};

function qm_ibullets_hover_off(e,o){if(!o)o=qmad.ibullets.lasth;
    if(o&&o.className.indexOf("qmactive")==-1){
        if(o.firstChild&&o.firstChild.getAttribute&&o.firstChild.getAttribute("isibullet"))o.firstChild.firstChild.src=o.qmibulletorig;}};

function qm_ibullets_active(a,hide){var wo=a.qmibullet;
    var ma=a.qmibulletma;var sa=a.qmibulletsa;
    if(!hide&&a.className.indexOf("qmactive")==-1)return;
    if(hide&&a.idiv){
        var o=a.idiv;
        if(o&&o.qmibulletorig){
            if(o.firstChild&&o.firstChild.getAttribute&&o.firstChild.getAttribute("isibullet"))o.firstChild.firstChild.src=o.qmibulletorig;
        }}else {if(!a.cdiv.offsetWidth)a.cdiv.style.visibility="inherit";
        qm_ibullets_wait_relative(a);/*if(a.cdiv){var aa=a.cdiv.childNodes;for(var i=0;i<aa.length;i++){if(aa[i].tagName=="A"&&aa[i].qmibullet)qm_ibullets_position(aa[i],aa[i].qmibullet);}}*/
        if(wo&&(ma||sa)){var ti=ma;
            if(sa&&sa!=undefined)ti=sa;
            if(ma&&ma!=undefined)ti=ma;
            wo.firstChild.src=ti;}}};

function qm_ibullets_wait_relative(a){if(!a)a=qmad.ibullets.cura;
    if(a.cdiv){if(a.cdiv.qmtree&&a.cdiv.style.position!="relative"){qmad.ibullets.cura=a;
            setTimeout("qm_ibcss_wait_relative()",10);
            return;
        }
        var aa=a.cdiv.childNodes;
        for(var i=0;i<aa.length;i++){
            if(aa[i].tagName=="A"&&aa[i].qmibullet)qm_ibullets_position(aa[i],aa[i].qmibullet);}}}

//Compressed Menu Structure
document.write('<div id="qm0" class="qmmc">\n\
<a href="index?page=Home.html" onmouseover=\"overme(this);\" onmouseout=\"leaveme(this);\">Homes</a>\n\
<a href="#" onmouseover=\"overme(this);\" onmouseout=\"leaveme(this);\">Notice Board</a><div>\n\
<a href="index?page=Announcement&curpage=1">Anouncement</a>\n\
<a href="index?page=LastestNews&curpage=1">Latest News</a></div>\n\
<a href="index?page=#" onmouseover=\"overme(this);\" onmouseout=\"leaveme(this);\">Learning Area</a><div>\n\
<a href="index?page=LearningAreaVideos">Videos</a>\n\
<a href="#">Courses</a>\n\
<a href="#">Articles</a></div>\n\
<a href="#" onmouseover=\"overme(this);\" onmouseout=\"leaveme(this);\">File Sharing</a><div>\n\
<a href="index?page=MyUploads">My Upload</a>\n\
<a href="index?page=ViewAllFiles">View All Files</a>\n\
<a href="index?page=SearchFile">Search Files</a>\n\
<a href="index?page=MyGroups">My Groups</a></div>\n\
<a href="index?page=Announcement" onmouseover=\"overme(this);\" onmouseout=\"leaveme(this);\">Wall Comment</a>\n\
<a target=parent href="http://mail.nbc.org.kh" onmouseover=\"overme(this);\" onmouseout=\"leaveme(this);\">NBC Mail</a>\n\
<span class="qmclear"></span>\n\
<script type="text/javascript">qm_create(0,false,0,500,true,false,false,false);</script>');



/*-- MENU MOUSE OVER & OUT --*/
function overme(me){
    me.style.color="#000099";
    me.style.fontWeight = "bold";
  //  me.style.textDecoration="underline";
   // me.style.fontWeight="bold";
    
}

function leaveme(me){
    me.style.color="blue";
    me.style.fontWeight="normal";
    
}