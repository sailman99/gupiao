Ext.Loader.setConfig({
    enabled: true
});

Ext.Loader.setPath('Ext.ux', './ext-6.0.0/packages/ux/classic/src');
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
	
	
	var myobj = new myPanel(); 
	
	myobj.reconfigure(mystore);
	var myobj1= new myPanel();
	myobj1.reconfigure(mystorea);
	/*
	myobj.on('rowdblclick',function( parent,record){				
		mystorea.reload({params: {gupiaodaima:record.data.gupiaodaima}});
		myobj1.reconfigure(mystorea);
	},this);
*/
	var northPanel = Ext.create('Ext.panel.Panel', {
        title : 'admin系统管理平台',
        border : false,
        collapsible : false,
        split : false,
        region : 'north'
    });
    var southPanel = Ext.create('Ext.panel.Panel', {
        title : '公司描述',
        region : 'south',
        height : 150
    });
    var westPanel = Ext.create('Ext.panel.Panel', {
        title : '导航菜单',
        region : 'west',
        collapsible : true,
        split : true,
        width : 200
    });
    var centerPanel = Ext.create('Ext.panel.Panel', {
        title : '内容显示',
        collapsible : false,
        region : 'center',
        items:myobj
    });
    Ext.create('Ext.container.Viewport', {
        title : 'Border Layout',
        layout : 'border',
        items : [ northPanel, southPanel, westPanel, centerPanel ],
        renderTo : Ext.getBody()
    });

});