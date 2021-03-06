Ext.define('Rzzgs', {//定义一个新类
	    extend: 'Ext.data.Model',//这个新类从Ext.data.Model扩展，表明这个新类能用Ext.data.Model所有的属性和方法
	    fields: [ //数组对象，里面包含json对象，fields这个是静态属性，可通过Task.fields[]访问
	        {name:'gupiaodaima',type:'string'},
	        {name:'gupiaomingcheng',type:'string'},
	        {name: 'riqi', type:'date'},
	        {name: 'gdzs', type: 'float'},
	        {name: 'rzzg', type: 'float'},
	        {name: 'jsqbh', type: 'float'},
	        {name: 'zgb', type: 'float'},
	        {name: 'ltg', type: 'float'},
	        {name: 'jsqbh2', type: 'float'},
	        {name: 'jsqbh3', type: 'float'},
	        {name: 'jsqbh4', type: 'float'},
	        {name: 'jsqbh5', type: 'float'},
	        {name: 'jsqbh6', type: 'float'},
	        {name: 'genericriqi',type: 'string'},
	        {name: 'beizhuriqi' ,type: 'string'},
	        {name: 'beizhu' ,type: 'string'},
	        {name: 'dazhongjiaoyicounts',type: 'int'}
	        
	    ]
	});
var rzzgsstoretmp=Ext.create('Ext.data.Store',{
    	model: 'Rzzgs',  //属性model由上面新类Rzzgs赋值  
    	data:[{}]
});
var rzzgsstore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Rzzgs',  //属性model由上面新类Rzzgs赋值  
	    asynchronousLoad : true,
	    proxy:{
	    	type:'ajax',
		    url:'JsonActiongetrzzgsByCondition'		   
	    }
});

//通过股票代码查表rzzgs
var rzzgsbygupiaodaimastore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Rzzgs',  //属性model由上面新类Rzzgs赋值
	    asynchronousLoad : false,
	    proxy:{
	    	type:'ajax',
		    url:'JsonActiongetrzzgsbygupiaodaima'
		    
	    }
});
//定义load事件
rzzgsstore.on('load',function(parent, records, successful, operation, eOpts){
		if(successful && records.length>0){//数据装载成功并且返回数据
		
			Ext.getCmp('myPanel101').on('rowdblclick',function( parent,record){				
				rzzgsbygupiaodaimastore.reload({params: {gupiaodaima:record.data.gupiaodaima}});
				Ext.getCmp('myPanel101a').reconfigure(rzzgsbygupiaodaimastore);
			},this);
			rzzgsbygupiaodaimastore.load({params:{gupiaodaima:records[0].data.gupiaodaima}});	
			
		}
});


//数据装载成功
rzzgsbygupiaodaimastore.on('load',function(parent, records, successful, operation, eOpts){
		if(successful && records.length>0){		
			
			Ext.getCmp('myPanel101a').reconfigure(this);
			Ext.getCmp('myPanel101a').on('rowdblclick',function(parent,record){
				myrzzgspopwindow.rowvalue=record;
				myrzzgspopwindow.show();
			})
		}
});





//定义一个新类

Ext.define('Panel101', {
		 extend:'Ext.grid.GridPanel',
		buffenedRenderer:true,
		store:rzzgsstoretmp,
		height:200,
		width:'100%',
		scrollable:true,
		frame:true,
		columnLines:true,
    	selModel:{selType:'checkboxmodel'}, 
		stripeRows:true,	
    	listeners:{
				afterrender:{
					fn:function(){
						this.height=(Ext.getBody().getViewSize().height-30)/2;
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
	                width: 60,
	                sortable: true,
	                dataIndex: 'gupiaomingcheng'
	            },{
	                header: '日期',
	                xtype: 'datecolumn',
	                width: 80,	                
	                sortable: true,
	                dataIndex: 'riqi'            
	            }, {
	                header: '股东总数',
	                width: 80,             
	                dataIndex: 'gdzs'                
	            }, {
	            	 header: '人均持股数',
	                 width: 80,             
	                 dataIndex: 'rzzg'
	            }, { 
	            	header: '人均持股上升',
	                width: 80,             
	                dataIndex: 'jsqbh'
	            }, {
	                header: '总股本（万股）',
	                width: 80,             
	                dataIndex: 'zgb'
	            }, {
	            	 header: '流通股（万股）',
	                 width: 80,             
	                 dataIndex: 'ltg'                
	            }, { 
	            	header: '两年内上升',
	                width: 80,             
	                dataIndex: 'jsqbh2'
	            }, { 
	            	header: '数据生成日期',
	                width: 80,             
	                dataIndex: 'genericriqi'
	            }, { 
	            	header: '备注日期',
	                width: 80,             
	                dataIndex: 'beizhuriqi'
	            }, { 
	            	header: '备注',
	                width: 280,             
	                dataIndex: 'beizhu'
	            }, { 
	            	header: '九个月内大宗交易笔数',
	                width: 280,             
	                dataIndex: 'dazhongjiaoyicounts'
	            }
	            ]
});