 var myitem105=(function(){
	Ext.define('Cycwarm', {//定义一个新类
			extend: 'Ext.data.Model',//这个新类从Ext.data.Model扩展，表明这个新类能用Ext.data.Model所有的属性和方法
			fields: [ //数组对象，里面包含json对象，fields这个是静态属性，可通过Task.fields[]访问
				{name:'gupiaodaima',type:'string'},
				{name:'gupiaomingcheng',type:'string'}, 
				{name:'riqi',type:'date'},
				{name:'cyc',type:'float'},
				{name:'jiage',type:'float'},
				{name:'comeriqi',type:'string'},
				{name:'beizhu',type:'string'},
				{name:'beizhuriqi',type:'string'} 
			]
		});
	var cycwarmstoretmp=Ext.create('Ext.data.Store',{
			model: 'Cycwarm',  //属性model由上面新类Rzzgs赋值  
			data:[{}]
	});
	var cycwarmstore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
			model: 'Cycwarm',  //属性model由上面新类Rzzgs赋值  
			asynchronousLoad : true,
			proxy:{
				type:'ajax',
				url:'JsonActiongetCycwarmtmp'		   
			}
	});
					//数据装载成功
	cycwarmstore.on('load',function(parent, records, successful, operation, eOpts){
				if(successful && records.length>0){		
					myPanel.reconfigure(this);
					myPanel.on('rowdblclick',function(parent,record){
						mycycwarmpopwindow.rowvalue=record;
						mycycwarmpopwindow.show();
						//console.log("rowdblclick");
					})
				}
	});
	
	//定义一个新类

	Ext.define('newPanel', {
		 extend:'Ext.grid.GridPanel',
		buffenedRenderer:true,
		store:cycwarmstoretmp,
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
					}]
		}],
    	listeners:{
				afterrender:{
					fn:function(){
						this.height=Ext.getBody().getViewSize().height-30;
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
	                header: '日期',
					xtype:'datecolumn',
	                width: 100,
	                sortable: true,
	                dataIndex: 'riqi'
	            },{
	                header: 'Expma线',
	                width: 80,	                
	                sortable: true,
	                dataIndex: 'cyc'            
	            }, 
				{
	                header: '价格',
	                width: 80,
	                sortable: true,
	                dataIndex: 'jiage'
	            },{
	                header: '到达日期',
	                width: 100,	                
	                sortable: true,
	                dataIndex: 'comeriqi'            
	            },{
	                header: '备注',
	                width: 180,             
	                dataIndex: 'beizhu'                
	            }, {
	            	 header: '备注日期',
	                 width: 100,             
	                 dataIndex: 'beizhuriqi'
	            }
	            ]
	});
				
	var myPanel = new newPanel();
	function getcycwarmstore(){
		return cycwarmstore;
	}
	function getPanel(){
		return myPanel;
	}
	return {
		getcycwarmstore :getcycwarmstore,
		getPanel :getPanel
	}
		
})();
