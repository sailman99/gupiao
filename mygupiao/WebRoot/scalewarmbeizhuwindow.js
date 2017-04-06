/*
 * 修改Rzzgs备注用的弹出窗口
 */

var popwindowsscalewarmPanel=Ext.create('Ext.form.FormPanel', {
    title      : '修改股票备注',
    width      : 650,
    bodyPadding: 10,
    items: [{
        xtype     : 'textareafield',
        grow      : true,
		id:'scalewarmpopwindowbeizhuinput',
        name      : 'message',
        fieldLabel: '备注',
        anchor    : '100%'
    }]
});
Ext.define('scalewarmpopwindow',{
	extend:'Ext.window.Window',
    title: 'scalewarm备注输入',
    height: 300,
    width: 650,
    layout: 'fit',
    closeAction:'hide',
    
    items:[  // Let's put an empty grid in just to illustrate fit layout
            popwindowsscalewarmPanel
    ],
	buttons:[{text:'保存',handler:function(){
			var objarray=new Array();
			var thisParent=this.ownerCt.ownerCt;//提交数据后要关闭窗口时用到
			var jsonObject={
					gupiaodaima:this.ownerCt.ownerCt.rowvalue.data.gupiaodaima,
					zuidiriqi:this.ownerCt.ownerCt.rowvalue.data.zuidiriqi,
					zuidijia:this.ownerCt.ownerCt.rowvalue.data.zuidijia,
					scale:this.ownerCt.ownerCt.rowvalue.data.scale,
					zuigaoriqi:this.ownerCt.ownerCt.rowvalue.data.zuigaoriqi,
					zuigaojia:this.ownerCt.ownerCt.rowvalue.data.zuigaojia,
					jiage:this.ownerCt.ownerCt.rowvalue.data.jiage,
					riqi:this.ownerCt.ownerCt.rowvalue.data.riqi,
					beizhu:Ext.getCmp('scalewarmpopwindowbeizhuinput').value

			};
	
			objarray.push(jsonObject);
			Ext.Ajax.request({
				url:'JsonActionupdateScalewarmBeizhu',
				params:{'jsonString':Ext.JSON.encode(objarray)},
				success:function(){
					scalewarmstore.reload();
					Ext.getCmp('myPanel104').reconfigure(scalewarmstore);
					thisParent.hide();
				},
				failure:function(){}
			});
			
			 }}]
});
scalewarmpopwindow.prototype.rowvalue={};//用它来储存一行数据传递给窗口用的。
var myscalewarmpopwindow=Ext.create('scalewarmpopwindow');
myscalewarmpopwindow.on('beforeShow',function(){
	Ext.getCmp('scalewarmpopwindowbeizhuinput').setFieldLabel(this.rowvalue.data.gupiaomingcheng);
	Ext.getCmp('scalewarmpopwindowbeizhuinput').setValue(this.rowvalue.data.beizhu);
	
});