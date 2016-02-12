Ext.define('Task', {//定义一个新类
	    extend: 'Ext.data.Model',//这个新类从Ext.data.Model扩展，表明这个新类能用Ext.data.Model所有的属性和方法
	    fields: [ //数组对象，里面包含json对象，fields这个是静态属性，可通过Task.fields[]访问
	        {name:'gupiaodaima',type:'string'},     
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
	        {name: 'jsqbh6', type: 'float'}
	    ]
	});

    var mystoretmp=Ext.create('Ext.data.Store',{
    	model: 'Task',  //属性model由上面新类Task赋值  
    	data:[{}]
    });
	var mystore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Task',  //属性model由上面新类Task赋值  
	    asynchronousLoad : false,
	    proxy:{
	    	type:'ajax',
		    url:'JsonAction!getrzzgsByCondition'		   
	    }
	});


	var mystorea = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Task',  //属性model由上面新类Task赋值
	    asynchronousLoad : false,
	    proxy:{
	    	type:'ajax',
		    url:'JsonAction!getrzzgsbygupiaodaima'
		    
	    }
	});

	

	//定义一个新类

	Ext.define('myPanel', {
		    extend:'Ext.grid.Panel',
		    bufferedRenderer: false,
		    store:mystoretmp,
	        width: 700,
	        height: 250,
	        frame: false,           
	        columnLines : true,      
	        layout: 'border',       
	      split: true,
	      columns: [{
		            xtype: 'rownumberer',
		            width: 40,
		            sortable: false
	        	},{
	                header: '股票代码',
	                width: 80,
	                sortable: true,
	                dataIndex: 'gupiaodaima'
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
	            }]
	 });
	var myobj = new myPanel(); 
	var myobj1= new myPanel();
	mystore.on('load',function(parent, records, successful, operation, eOpts){
		if(successful){
			myobj.reconfigure(mystore);
			myobj.on('rowdblclick',function( parent,record){				
				mystorea.reload({params: {gupiaodaima:record.data.gupiaodaima}});
				myobj1.reconfigure(mystorea);
			},this);
			mystorea.load({params:{gupiaodaima:records[0].data.gupiaodaima}});		
		}
	});
	mystorea.on('load',function(parent, records, successful, operation, eOpts){
		if(successful){			
			myobj1.reconfigure(mystorea);
		}
	});
	mystore.load({params:{jsqbh:20,jsqbh2:40,riqi:'2015-09-30'}});
