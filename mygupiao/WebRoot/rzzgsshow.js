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
	        {name: 'beizhu' ,type: 'string'}
	        
	    ]
	});
Ext.define('RiqiGroupCounts',{
	extend:'Ext.data.Model',
	fields:[
	        {name:'riqi',type:'date'},
	        {name:'rowcounts',type:'int'}
	        ]
});
var mystoreRiqiGroupCounts = Ext.create('Ext.data.Store',{
		model:'RiqiGroupCounts',
		asynchronousLoad : false,
	    proxy:{
	    	type:'ajax',
		    url:'JsonAction!getrzzgsGroupByCondition'		   
	    }
});
var mystoretmp=Ext.create('Ext.data.Store',{
    	model: 'Rzzgs',  //属性model由上面新类Rzzgs赋值  
    	data:[{}]
});
var mystore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Rzzgs',  //属性model由上面新类Rzzgs赋值  
	    asynchronousLoad : false,
	    proxy:{
	    	type:'ajax',
		    url:'JsonActiongetrzzgsByCondition'		   
	    }
});


var mystorea = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Rzzgs',  //属性model由上面新类Rzzgs赋值
	    asynchronousLoad : false,
	    proxy:{
	    	type:'ajax',
		    url:'JsonActiongetrzzgsbygupiaodaima'
		    
	    }
});

	
	//定义一个新类

Ext.define('myPanel', {
		    extend:'Ext.grid.Panel',
		    bufferedRenderer: false,
		    store:mystoretmp,
	        width: '100%',
	        height: 250,
	        frame: false,           
	        columnLines : true,      
	        layout: 'border',       
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
	            }
	            ]
});
var myobj = new myPanel(); 
var myobj1= new myPanel();
mystore.on('load',function(parent, records, successful, operation, eOpts){
		if(successful && records.length>0){
			myobj.reconfigure(mystore);
			myobj.on('rowdblclick',function( parent,record){				
				mystorea.reload({params: {gupiaodaima:record.data.gupiaodaima}});
				myobj1.reconfigure(mystorea);
			},this);
		
			
				mystorea.load({params:{gupiaodaima:records[0].data.gupiaodaima}});	
			
		}
});
mystorea.on('load',function(parent, records, successful, operation, eOpts){
		if(successful && records.length>0){		
		
			myobj1.reconfigure(mystorea);
			myobj1.on('rowdblclick',function(parent,record){
				 mypopwindow.rowvalue=record;
				 mypopwindow.show();
				
			})
		}
});
var westForm=Ext.create('Ext.form.FormPanel', {
	    title      : 'Sample TextArea',
	    id:'mainwestForm',
	    width      : 160,
	    bodyPadding: 10,
	    layout:{
        	type:'vbox',
        	align:'center'
        },
        items:[
               Ext.create('Ext.form.field.Text',{id:'gupiaodaima',fieldLabel:'股票代码',labelWidth:70,width:140}),
               Ext.create('Ext.Button',{
                   text: 'rzzgs数据查询',
   					handler:function(){
   						mystorea.reload({params: {gupiaodaima:Ext.getCmp('gupiaodaima').value}});
   						myobj1.reconfigure(mystorea);
   					}	
               }),
               Ext.create('Ext.form.field.Text',{id:'jsqbh',fieldLabel:'人均持股上升大于%',labelWidth:70,value:10,width:140}),
               Ext.create('Ext.form.field.Text',{id:'jsqbh2',fieldLabel:'人均持股两年内上升大于%',labelWidth:70,value:40,width:140})
              
        ]
});



	
