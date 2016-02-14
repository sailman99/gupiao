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
        items:[myobj,myobj1]
    });
    /*
    westPanel.add(Ext.create('Ext.Button', {
        text: 'Click me',
        handler: function() {
            alert('You clicked the button!');
        }
    });*/
    Ext.create('Ext.container.Viewport', {
        title : 'Border Layout',
        layout : 'border',
        items : [ northPanel, westPanel, centerPanel ],
        renderTo : Ext.getBody()
    });    
});