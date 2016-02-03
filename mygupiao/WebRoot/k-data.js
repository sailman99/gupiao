var ddata=[];
var LocString=String(window.document.location.href);   		
			$.ajax({url:"http://113.107.154.131:9001/gupiao/JsonAction",
				data:{"gupiaodaima":getQueryStr("gupiaodaima")},
				DataType:"script",
				async:false}).
			error(function(){alert("error");})
			.success(function(data,textStatus,jqXHR){
				//alert("success one"+jqXHR.responseText);
				var objTEST=eval("("+jqXHR.responseText+")"); 
				
				//alert(objTEST.length);
				for(i=0;i<objTEST.length;i++){
					ddata.push([parseInt(objTEST[i].aa),parseFloat(objTEST[i].bb),parseFloat(objTEST[i].cc),parseFloat(objTEST[i].dd),parseFloat(objTEST[i].ee),parseFloat(objTEST[i].ff),parseFloat(objTEST[i].gg),parseFloat(objTEST[i].hh)]);
					
				}

				});
var data=ddata;

function getQueryStr(str){   
	     var rs = new RegExp("(^|)"+str+"=([^\&]*)(\&|$)","gi").exec(LocString), tmp;   			       
		 if(tmp=rs){   
		          return tmp[2];   
		 }   
			       return "000001";   
}   

function getKLData() {
    var result = {};
    var ks = [];
    for (var i = 0; i < ddata.length; i++) {
        var rawData = ddata[i];
        //20111215,11.68,11.65,11.76,11.40,11.41,43356655,502325991
        //日期,昨收,开盘价,高,低，收,量，额
        var item = {
            quoteTime: rawData[0],
            preClose: rawData[1],
            open: rawData[2],
            high: rawData[3],
            low: rawData[4],
            close: rawData[5],
            volume: rawData[6],
            amount: rawData[7]
        };
        if (ks.length == 0) {
            result.low = item.low;
            result.high = item.high;
        } else {
            result.high = Math.max(result.high, item.high);
            result.low = Math.min(result.low, item.low);
        }
        ks.push(item);
    }
    result.ks = ks;
    return result;
}