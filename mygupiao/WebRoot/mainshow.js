Ext.Loader.setConfig({
    enabled: true
});

Ext.Loader.setPath('Ext.ux', './js/packages/ux/classic/src');
Ext.require([
    'Ext.grid.*',
    'Ext.layout.container.Border',
    'Ext.data.*',
    'Ext.form.field.Number',
    'Ext.form.field.Date',
    'Ext.tip.QuickTipManager',
    'Ext.ux.DataTip'
]);

Ext.onReady(function(){
	
	
	
	
	
	Ext.tip.QuickTipManager.init();  
	var northPanel = Ext.create('Ext.panel.Panel', {
        title : '',
        border : false,
        collapsible : false,
        split : false,
        region : 'north'
    });
    var southPanel = Ext.create('Ext.panel.Panel', {
        title : '',
        region : 'south',
        height : 150
    });
    var westPanel = Ext.create('Ext.tree.Panel', {
        title : '',
        region : 'west',    
        split : true, 
        width:150,       
        collapsible:true, 
        rootVisible : false,
        listerers:{
        	afterrender:{
        		fn:function(){
        			this.width=Ext.getBody().getViewSize().width/10;
        		}
        	}
        },
        store:treestore
    });
    var centerPanel = Ext.create('Ext.tab.Panel', {
        title : '',
        collapsible : false,
        region : 'center',
        autoDestroy:false
    });
  
   var viewport= Ext.create('Ext.container.Viewport', {
        title : 'Border Layout',
        layout : 'border',//layout:'border'
        items : [ northPanel, westPanel, centerPanel ],
        renderTo : Ext.getBody()
    });   
   var createTab=function(item,items){
	  
	   var tab=Ext.getCmp('tab'+item.data.id);
	   if(Ext.isEmpty(tab)){
			 centerPanel.add([{
				 title: item.data.text,
				 id:'tab'+item.data.id,
				 plain: true,
				 closable : true,
				 closeAction:'hide',
	             items:items 
			 }]); 
			 centerPanel.setActiveTab(Ext.getCmp('tab'+item.data.id));
	   }else{
		   if(Ext.isEmpty(tab.findParentByType())){
			   centerPanel.add(tab);
		   }
		   centerPanel.setActiveTab(tab);
	   }
	   
   };
   westPanel.on("itemclick", function( record, item, index, e, eOpts){	
	   switch(item.data.id)
	   {
	   case 'treeitem101':	
		 createTab(item,[Ext.isEmpty(Ext.getCmp('myPanel101'))?
		   Ext.create('Panel101',
		   {id:'myPanel101',
			dockedItems:[{
    			xtype:'toolbar',
    			dock:'top',
    			width:'100%',
    			height:25,
				id:'allrzzgs',
    			items:[{xtype:'button',
    						text:'自定义股票',
    						handler:function(){
								var records=this.ownerCt.ownerCt.getSelection();
								var objarray = new Array();
								for(var i=0;i<records.length;i++){
									var jsonobj={gupiaodaima:records[i].data.gupiaodaima};
									objarray.push(jsonobj);
								}
								if(records.length>0){
									console.log('OK');
									Ext.Ajax.request({url:'JsonActionUpdateUserdefine',
									params:{'jsonString':Ext.JSON.encode(objarray)}});
								}
							}
						},{
    					xtype:'textfield',
    					fieldLabel:'人均持股上升%',
    					labelAlign:'right',
    					labelWidth:90,
    					width:150,
						value:10,
    					id:'jsqbh'
    				},{
    					xtype:'textfield',
    					fieldLabel:'人均持股两年上升%',
    					labelAlign:'right',
    					labelWidth:120,
    					width:180,
						value:40,
    					id:'jsqbh2'
    				}]
			}]})
		   :Ext.getCmp('myPanel101'),
		   Ext.isEmpty(Ext.getCmp('myPanel101a'))?
		   Ext.create('Panel101',{id:'myPanel101a',
				dockedItems:[{
					xtype:'toolbar',
					dock:'top',
					width:'100%',
					height:25,
					items:[{
							xtype:'textfield',
							fieldLabel:'股票代码',
							labelAlign:'right',
							labelWidth:60,
							width:150,
							id:'rzzgsgupiaodaima'
						},{xtype:'button',
    						text:'Rzzgs数据查询',
    						handler:function(){
								rzzgsbygupiaodaimastore.reload({params: {gupiaodaima:Ext.getCmp('rzzgsgupiaodaima').value}});
								Ext.getCmp('myPanel101a').reconfigure(rzzgsbygupiaodaimastore);
    						}
						}]
			}]})
		   :Ext.getCmp('myPanel101a')]);  
	   
			//初始化后返回月份数
			Ext.Ajax.request({
				url: 'JsonActiongetMonths',

				success: function(response, opts) {
					var obj = Ext.decode(response.responseText);
					var firstrow=0;
					for(var key in obj){
						 if(firstrow==0){//选择第一行作为返回数据的参数
							rzzgsstore.reload({params:{jsqbh:5,jsqbh2:40,riqi:obj[key].month}});
							Ext.getCmp('myPanel101').reconfigure(rzzgsstore);
						 }
						 firstrow++;
						 Ext.getCmp('allrzzgs').add('-');
						 Ext.getCmp('allrzzgs').add(Ext.create('Ext.Button',{
							 text: obj[key].month,
								handler:function(){
									rzzgsstore.reload({params:{jsqbh:Ext.getCmp('jsqbh').value,jsqbh2:Ext.getCmp('jsqbh2').value,riqi:this.text}});
									Ext.getCmp('myPanel101').reconfigure(rzzgsstore);
								}	
						 }));
					}
				//	
				},

				failure: function(response, opts) {
					console.log('server-side failure with status code ' + response.status);
				}
			});


	     break;
	   case 'treeitem102':
			createTab(item,[Ext.isEmpty(Ext.getCmp('myPanel102'))?Ext.create('Panel102',{id:'myPanel102'}):Ext.getCmp('myPanel102')]);
			trendlinesstore.reload();
			Ext.getCmp('myPanel102').reconfigure(trendlinesstore);
			break;	  
	   case 'treeitem103':
		createTab(item,[Ext.isEmpty(Ext.getCmp('myform108'))?Ext.create('form108',{id:'myform108'}):Ext.getCmp('myform108'),
                Ext.isEmpty(Ext.getCmp('mygridPanel10801'))?Ext.create('gridPanel10801',{id:'mygridPanel10801'}):Ext.getCmp('mygridPanel10801')]);
            break;   
	   case 'treeitem104':
			createTab(item,[Ext.isEmpty(Ext.getCmp('myPanel104'))?Ext.create('Panel104',{id:'myPanel104'}):Ext.getCmp('myPanel104')]);
	        scalewarmstore.reload();
			Ext.getCmp('myPanel104').reconfigure(scalewarmstore);
				break; 
	   case 'treeitem105':
			createTab(item,myitem105.getPanel());
	        myitem105.getcycwarmstore().reload();
			myitem105.getPanel().reconfigure(myitem105.getcycwarmstore());
				break; 
	   case 'treeitem106':
			createTab(item,myitem106.getPanel());
	        myitem106.getcycwarmstore().reload();
			myitem106.getPanel().reconfigure(myitem106.getcycwarmstore());
				break; 
	    
	   }
	},
	this);

	

	

});

