Ext.define('Trendlines', {//定义一个新类
	    extend: 'Ext.data.Model',//这个新类从Ext.data.Model扩展，表明这个新类能用Ext.data.Model所有的属性和方法
	    fields: [ //数组对象，里面包含json对象，fields这个是静态属性，可通过Task.fields[]访问
	        {name:'gupiaodaima',type:'string'},
	        {name:'gupiaomingcheng',type:'string'}, 
			{name:'riqi1',type:'date'},
			{name:'dot1',type:'float'},
			{name:'riqi2',type:'date'},
			{name:'dot2',type:'float'},
			{name:'dot1todot2',type:'float'},
			{name:'gradient',type:'float'},
			{name:'riqi3',type:'date'},
			{name:'dot3',type:'float'},
			{name:'forecastprice',type:'float'},
	        {name:'riqi4',type:'string'},
			{name:'upordown',type:'string'}
	    ]
	});
var trendlinesstoretmp=Ext.create('Ext.data.Store',{
    	model: 'Trendlines',  //属性model由上面新类Rzzgs赋值  
    	data:[{}]
});
var trendlinesstore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Trendlines',  //属性model由上面新类Rzzgs赋值  
	    asynchronousLoad : true,
	    proxy:{
	    	type:'ajax',
		    url:'JsonActiongetTrendlinestmp'		   
	    }
});
//定义一个新类

Ext.define('Panel102', {
		 extend:'Ext.grid.GridPanel',
		buffenedRenderer:true,
		store:trendlinesstore,
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
				items:[{
    					xtype:'textfield',
    					fieldLabel:'股票</br>代码',
    					labelAlign:'right',
    					labelWidth:40,
    					width:100,
    					id:'trendlinesgupiaodaima'
    				},{
    					xtype:'datefield',
    					fieldLabel: '请选择第</br>一日期',
                        labelWidth:50,
						width: 160,
                        format:'Y年m月d日',
    					id:'riqi1'
    				},{
    					xtype:'textfield',
    					fieldLabel:'第一日</br>期价格',
    					labelAlign:'right',
    					labelWidth:60,
    					width:120,
    					id:'dot1'
    				},{
    					xtype:'datefield',
    					fieldLabel: '请选择第</br>二日期',
						labelWidth:50,
						width: 160,
                        format:'Y年m月d日',
    					id:'riqi2'
    				},{
    					xtype:'textfield',
    					fieldLabel:'第二日</br>期价格',
    					labelAlign:'right',
    					labelWidth:60,
    					width:120,
    					id:'dot2'
    				},{
    					xtype:'datefield',
    					fieldLabel: '请选择第三日期',
						labelWidth:50,
						width: 160,
                        format:'Y年m月d日',
    					id:'riqi3'
    				},{
    					xtype:'textfield',
    					fieldLabel:'第三日</br>期价格',
    					labelAlign:'right',
    					labelWidth:60,
    					width:120,
    					id:'dot3'
    				},{
						xtype:'combobox',
						fieldLabel: '请选择突破</br>还是下跌到',
						labelAlign:'right',
						labelWidth:80,
						width: 160,
						store: Ext.create('Ext.data.Store', {
									fields: ['upordown', 'name'],
									data : [
									{"upordown":0, "name":"下跌到"},
									{"upordown":1, "name":"突破"}]}),
						displayField: 'name',
						valueField: 'upordown',
						triggerAction: 'all',
						emptyText: '请选择...',
						allowBlank: false,
						blankText: '请选择',
						editable: false,
						mode: 'local',
					    id:'upordown'
					},{xtype:'button',
    						text:'保存',
    						handler:function(){
								if(Ext.isEmpty(Ext.getCmp('trendlinesgupiaodaima').value) || Ext.isEmpty(Ext.getCmp('riqi1').value) || Ext.isEmpty(Ext.getCmp('riqi2').value) || Ext.isEmpty(Ext.getCmp('riqi3').value) || Ext.isEmpty(Ext.getCmp('dot1').value) || Ext.isEmpty(Ext.getCmp('dot2').value) || Ext.isEmpty(Ext.getCmp('dot3').value) || Ext.isEmpty(Ext.getCmp('upordown').value))  {
									alert('所有数据不能为空！')
								}else{
									
									var objarray = new Array();
									
									var jsonobj={gupiaodaima:Ext.getCmp('trendlinesgupiaodaima').value,riqi1:Ext.getCmp('riqi1').value,riqi2:Ext.getCmp('riqi2').value,riqi3:Ext.getCmp('riqi3').value,dot1:Ext.getCmp('dot1').value,dot2:Ext.getCmp('dot2').value,dot3:Ext.getCmp('dot3').value,upordown:Ext.getCmp('upordown').value};
									objarray.push(jsonobj);
									
									Ext.Ajax.request({
										url:'JsonActionupdateTrendlines',
										params:{'jsonString':Ext.JSON.encode(objarray)},
										success:function(param1,param2){
											
											//在这更新数据
											this.ownerCt.ownerCt.store.reload();
										
											var obj=Ext.JSON.decode(param1.responseText);
											  Ext.Msg.alert('消息',obj.msg);
										},
										failure:function(){Ext.Msg.alert('消息','failure');}
									});
    						}
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
	                header: '日期1',
					xtype:'datecolumn',
	                width: 100,
	                sortable: true,
	                dataIndex: 'riqi1'
	            },{
	                header: '价格1',
	                width: 80,	                
	                sortable: true,
	                dataIndex: 'dot1'            
	            }, 
				{
	                header: '日期2',
					xtype:'datecolumn',
	                width: 100,
	                sortable: true,
	                dataIndex: 'riqi2'
	            },{
	                header: '价格2',
	                width: 80,	                
	                sortable: true,
	                dataIndex: 'dot2'            
	            },{
	                header: '价格1到价格2间差价',
	                width: 80,             
	                dataIndex: 'dot1todot2'                
	            }, {
	            	 header: '价格变化速率',
	                 width: 80,             
	                 dataIndex: 'gradient'
	            },{
	                header: '日期3',
					xtype:'datecolumn',
	                width: 100,
	                sortable: true,
	                dataIndex: 'riqi3'
	            },{
	                header: '价格3',
	                width: 80,	                
	                sortable: true,
	                dataIndex: 'dot3'            
	            }, { 
	            	header: '预测价格',
	                width: 80,             
	                dataIndex: 'forecastprice'
	            },{
	                header: '到达日期',					
	                width: 100,
	                sortable: true,
	                dataIndex: 'riqi4'
	            }, {
	                header: '0下跌到，1突破',
	                width: 140,             
	                dataIndex: 'upordown'
	            }
	            
	            ]
});