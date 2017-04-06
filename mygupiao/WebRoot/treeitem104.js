Ext.define('Scalewarm', {//定义一个新类
	    extend: 'Ext.data.Model',//这个新类从Ext.data.Model扩展，表明这个新类能用Ext.data.Model所有的属性和方法
	    fields: [ //数组对象，里面包含json对象，fields这个是静态属性，可通过Task.fields[]访问
	        {name:'gupiaodaima',type:'string'},
	        {name:'gupiaomingcheng',type:'string'}, 
			{name:'zuidiriqi',type:'date'},
			{name:'zuidijia',type:'float'},
			{name:'scale',type:'float'},
			{name:'zuigaoriqi',type:'date'},
			{name:'zuigaojia',type:'float'},
			{name:'jiage',type:'float'},
			{name:'riqi',type:'string'},
			{name:'beizhu',type:'string'},
            {name:'beizhuriqi',type:'string'},
            {name:'huitiaobili',type:'float'},
            {name:'fantanbili',type:'float'},
            {name:'zaihuitiaobili',type:'float'},
            {name:'jierudianjiageariqi',type:'date'},
            {name:'jierudianjiagebriqi',type:'date'}
	    ]
	});
var scalewarmstoretmp=Ext.create('Ext.data.Store',{
    	model: 'Scalewarm',  //属性model由上面新类Rzzgs赋值  
    	data:[{}]
});
var scalewarmstore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Scalewarm',  //属性model由上面新类Rzzgs赋值  
	    asynchronousLoad : true,
	    proxy:{
	    	type:'ajax',
		    url:'JsonActiongetScalewarmtmp'		   
	    }
});
//定义一个新类

Ext.define('Panel104', {
		 extend:'Ext.grid.GridPanel',
		buffenedRenderer:true,
		store:scalewarmstoretmp,
		id:'scalewarmgrid',
		height:200,
		width:'100%',
		scrollable:true,
		frame:true,
		columnLines:true,
		stripeRows:true,	
        selModel:{selType:'checkboxmodel'},
		dockedItems:[{
    			xtype:'toolbar',
    			dock:'top',
    			width:'100%',
    			height:45,
				items:[{xtype:'button',
    						text:'保存',
    						handler:function(){
						
						}
					},{xtype:'button',
						text:'删除',
						handler:function(){
							var objarray = new Array();

							for(i=0;i<this.ownerCt.ownerCt.getSelectionModel().getSelection().length;i++){
								var jsonobj={gupiaodaima:this.ownerCt.ownerCt.getSelectionModel().getSelection()[i].data.gupiaodaima};
			            		objarray.push(jsonobj);
							}
							Ext.Ajax.request({
			            		url:'JsonActionupdateQx_scxx',
			            		params:{'jsonString':Ext.JSON.encode(objarray)},
			            		success:function(param1,param2){
			            			Ext.getCmp('checkboxgroup').removeAll(true);
			            			var obj=Ext.JSON.decode(param1.responseText);
			            			  Ext.Msg.alert('消息',obj.msg);
			            		},
			            		failure:function(){}
			            	});
							
			            }
					}]
		}],	 
    	listeners:{
				afterrender:{
					fn:function(){
						this.height=Ext.getBody().getViewSize().height-30;
					}
				},
				select:{
					fn:function(object,record , index , eOpts ){
						
					}
				}
		  },
	      split: true,
	      columns: [{
		            xtype: 'rownumberer',
		            width: 30,
		            sortable: false
	        	},{
	                header: '股票代码',
	                width: 60,
	                sortable: true,
	                dataIndex: 'gupiaodaima'
	            },{
	                header: '股票名称',
	                width: 80,
	                sortable: true,
	                dataIndex: 'gupiaomingcheng'
	            },
				
				{
	                header: '最低价日期',
					xtype:'datecolumn',
	                width: 90,
	                sortable: true,
	                dataIndex: 'zuidiriqi'
	            },{
	                header: '最低价',
	                width: 60,	                
	                sortable: true,
	                dataIndex: 'zuidijia'            
	            }, 
				{
	                header: '回调比例',
	                width: 50,
	                sortable: true,
	                dataIndex: 'scale'
	            },{
	                header: '最高价日期',
					xtype:'datecolumn',
	                width: 90,	                
	                sortable: true,
	                dataIndex: 'zuigaoriqi'            
	            },{
	                header: '最高价',
	                width: 70,             
	                dataIndex: 'zuigaojia'                
	            }, {
	            	 header: '预测跌</br>到的价格',
	                 width: 90,             
	                 dataIndex: 'jiage'
	            },{
	                header: '跌到预测</br>价格日期',
	                width: 90,
	                sortable: true,
	                dataIndex: 'riqi'
	            },{
	                header: '备注',
	                width: 300,
	                sortable: true,
	                dataIndex: 'beizhu'
	            },{
	                header: '备注日期',
	                width: 90,
	                sortable: true,
	                dataIndex: 'beizhuriqi'
	            },{
	                header: '已回调比例',
	                width: 90,
	                sortable: true,
	                dataIndex: 'huitiaobili'
	            },{
	                header: '反弹比例',
	                width: 90,
	                sortable: true,
	                dataIndex: 'fantanbili'
	            },{
	                header: '再回调比例',
	                width: 90,
	                sortable: true,
	                dataIndex: 'zaihuitiaobili'
	            },{
	                header: '回调到50%日期',
	                width: 90,
	                sortable: true,
	                dataIndex: 'jierudianjiageariqi'
	            },{
	                header: '回调到61.8%日期',
	                width: 90,
	                sortable: true,
	                dataIndex: 'jierudianjiagebriqi'
	            } 
	         
	            
	            ]
});
				//数据装载成功
scalewarmstore.on('load',function(parent, records, successful, operation, eOpts){
		if(successful && records.length>0){		
			
			Ext.getCmp('myPanel104').reconfigure(this);
			Ext.getCmp('myPanel104').on('rowdblclick',function(parent,record){
				myscalewarmpopwindow.rowvalue=record;
				myscalewarmpopwindow.show();
			})
		}
});
