var data=new Array();


$.ajax({url:"http://113.107.154.131:9001/gupiao/JsonAction",data:{"gupiaodaima":"000001"},DataType:"json"}).error(function(){alert("error");});			
$(document).ajaxSuccess(function(event, xhr, settings) {
	//alert("success"+xhr.responseText);
	var objTEST=eval("("+xhr.responseText+")"); 
	for(i=0;i<objTEST.length;i++){
		data.push([parseInt(objTEST[i].aa),parseFloat(objTEST[i].bb),parseFloat(objTEST[i].cc),parseFloat(objTEST[i].dd),parseFloat(objTEST[i].ee),parseFloat(objTEST[i].ff),parseFloat(objTEST[i].gg),parseFloat(objTEST[i].hh)]);
		
	}
	
});
debugger;
	


