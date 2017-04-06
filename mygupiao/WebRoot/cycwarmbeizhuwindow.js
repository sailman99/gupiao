/*
 * 修改Rzzgs备注用的弹出窗口
 */

var popwindowscycwarmPanel=Ext.create('Ext.form.FormPanel', {
    title      : '修改股票备注',
    width      : 650,
    bodyPadding: 10,
    items: [{
        xtype     : 'textareafield',
        grow      : true,
		id:'cycwarmpopwindowbeizhuinput',
        name      : 'message',
        fieldLabel: '备注',
        anchor    : '100%'
    }]
});
Ext.define('cycwarmpopwindow',{
	extend:'Ext.window.Window',
    title: 'cycwarm备注输入',
    height: 300,
    width: 650,
    layout: 'fit',
    closeAction:'hide',
    
    items:[  // Let's put an empty grid in just to illustrate fit layout
            popwindowscycwarmPanel
    ],
	buttons:[{text:'保存',handler:function(){
			var objarray=new Array();
			var thisParent=this.ownerCt.ownerCt;//提交数据后要关闭窗口时用到
			var jsonObject={
					gupiaodaima:this.ownerCt.ownerCt.rowvalue.data.gupiaodaima,
					riqi:this.ownerCt.ownerCt.rowvalue.data.riqi,
					cyc:this.ownerCt.ownerCt.rowvalue.data.cyc,
					jiage:this.ownerCt.ownerCt.rowvalue.data.jiage,
					comeriqi:this.ownerCt.ownerCt.rowvalue.data.comeriqi,
					beizhu:Ext.getCmp('cycwarmpopwindowbeizhuinput').value

			};
	
			objarray.push(jsonObject);
			Ext.Ajax.request({
				url:'JsonActionupdateCycwarmBeizhu',
				params:{'jsonString':Ext.JSON.encode(objarray)},
				success:function(){
					cycwarmstore.reload();
					Ext.getCmp('myPanel105').reconfigure(cycwarmstore);
					thisParent.hide();
				},
				failure:function(){}
			});
			
			 }}]
});
cycwarmpopwindow.prototype.rowvalue={};//用它来储存一行数据传递给窗口用的。
var mycycwarmpopwindow=Ext.create('cycwarmpopwindow');
myscalewarmpopwindow.on('beforeShow',function(){
	Ext.getCmp('cycwarmpopwindowbeizhuinput').setFieldLabel(this.rowvalue.data.gupiaomingcheng);
	Ext.getCmp('cycwarmpopwindowbeizhuinput').setValue(this.rowvalue.data.beizhu);
	
});