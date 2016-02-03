Ext.define('Task', {//定义一个新类
	    extend: 'Ext.data.Model',//这个新类从Ext.data.Model扩展，表明这个新类能用Ext.data.Model所有的属性和方法
	    fields: [ //数组对象，里面包含json对象，fields这个是静态属性，可通过Task.fields[]访问
	        {name:'gupiaodaima',type:'string'},     
	        {name: 'riqi', type:'string'},
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


	var mystore = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Task',  //属性model由上面新类Task赋值  
	    proxy:{
		    url:'JsonAction!getrzzgsByCondition',
		    type:'ajax'
	    }
	});


	var mystorea = Ext.create('Ext.data.Store', {//创建全局变量store,这是实例化Ext.data.Store
	    model: 'Task',  //属性model由上面新类Task赋值
	    proxy:{
		    url:'JsonAction!getrzzgsbygupiaodaima',
		    type:'ajax'
	    }
	});

	mystore.on('load',function(parent, records, successful, operation, eOpts){
		if(successful){
			mystorea.load({params:{gupiaodaima:records[0].data.gupiaodaima}});		
		}
	});
	mystore.load({params:{jsqbh:40,jsqbh2:40,riqi:'2015-09-30'}});


	//定义一个新类

	Ext.define('myPanel', {
		    extend:'Ext.grid.Panel',
		    bufferedRenderer: false,
	        width: 650,
	        height: 250,
	        frame: false,           
	        columnLines : true,      
	        layout: 'border',       
	      split: true,
	      columns: [{
	                header: '股票代码',
	                width: 80,
	                sortable: true,
	                dataIndex: 'gupiaodaima'
	            },{
	                header: '日期',
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
	            	header: '人均持股',
	                width: 80,             
	                dataIndex: 'jsqbh'
	            }, {
	                header: '总股本',
	                width: 80,             
	                dataIndex: 'zgb'
	            }, {
	            	 header: '流通股数',
	                 width: 80,             
	                 dataIndex: 'ltg'                
	            }, { 
	            	header: '两年内 ',
	                width: 80,             
	                dataIndex: 'jsqbh2'
	            }]
	 });
	