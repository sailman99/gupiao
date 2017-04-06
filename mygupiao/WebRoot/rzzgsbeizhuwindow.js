/*
 * 修改Rzzgs备注用的弹出窗口
 */

var popwindowsrzzgsPanel=Ext.create('Ext.form.FormPanel', {
    title      : '修改股票备注',
    width      : 650,
    bodyPadding: 10,
	dockedItems:[{
    			xtype:'toolbar',
    			dock:'top',
    			width:'100%',
    			height:45,
				items:[
					{xtype:'fieldcontainer',
					 fieldLabel:'CYC触发',
					 labelWidth:50,
					 layout:'hbox',
					 defaultType:'checkboxfield',
					 items:[
						{boxLabel:'CYC55',
						 name:'CYC',
					     value:false,
				         disabled:false,
					     inputValue:55,
					     id:'poprzzgswindowcyc55'
						},
						{boxLabel:'CYC125',
						 name:'CYC',
					     value:false,
				         disabled:false,
					     inputValue:125,
					     id:'poprzzgswindowcyc125'
						},
						{boxLabel:'CYC250',
						 name:'CYC',
					     value:false,
				         disabled:false,
					     inputValue:250,
					     id:'poprzzgswindowcyc250'
						},
						{boxLabel:'50%',
						 name:'CYC',
					     value:false,
				         disabled:false,
					     inputValue:0.50,
					     id:'poprzzgswindowdown50'
						},
						{boxLabel:'61.8%',
						 name:'CYC',
					     value:false,
				         disabled:false,
					     inputValue:0.618,
					     id:'poprzzgswindowdown618'
						},
						{boxLabel:'73.2%',
						 name:'CYC',
					     value:false,
				         disabled:false,
					     inputValue:0.732,
					     id:'poprzzgswindowdown732'
						},
						{
    					xtype:'datefield',
    					fieldLabel: '请选择最</br>低点日期',
                        labelWidth:60,
						width: 180,
                        format:'Y年m月d日',
						value:new Date(),	
    					id:'poprzzgswindowminriqi'
						}
					 ]
					}
				]
	}],
    items: [{
        xtype     : 'textareafield',
        grow      : true,
		id:'poprzzgswindowbeizhuinput',
        name      : 'message',
        fieldLabel: '备注',
        anchor    : '100%'
    }]
});
Ext.define('rzzgspopwindow',{
	extend:'Ext.window.Window',
    title: '备注输入',
    height: 300,
    width: 650,
    layout: 'fit',
    closeAction:'hide',
    
    items:[  // Let's put an empty grid in just to illustrate fit layout
             popwindowsrzzgsPanel
    ],
	buttons:[{text:'保存',handler:function(){
			var objarray=new Array();
			var thisParent=this.ownerCt.ownerCt;//提交数据后要关闭窗口时用到
			var jsonObject={
					gupiaodaima:this.ownerCt.ownerCt.rowvalue.data.gupiaodaima,
					riqi:this.ownerCt.ownerCt.rowvalue.data.riqi,
					gdzs:this.ownerCt.ownerCt.rowvalue.data.gdzs,
					rzzg:this.ownerCt.ownerCt.rowvalue.data.rzzg,
					jsqbh:this.ownerCt.ownerCt.rowvalue.data.jsqbh,
					zgb:this.ownerCt.ownerCt.rowvalue.data.zgb,
					ltg:this.ownerCt.ownerCt.rowvalue.data.ltg,
					jsqbh2:this.ownerCt.ownerCt.rowvalue.data.jsqbh2,
					jsqbh3:this.ownerCt.ownerCt.rowvalue.data.jsqbh3,
					jsqbh4:this.ownerCt.ownerCt.rowvalue.data.jsqbh4,
					jsqbh5:this.ownerCt.ownerCt.rowvalue.data.jsqbh5,
					jsqbh6:this.ownerCt.ownerCt.rowvalue.data.jsqbh6,
					genericriqi:this.ownerCt.ownerCt.rowvalue.data.genericriqi,
					beizhuriqi:this.ownerCt.ownerCt.rowvalue.data.beizhuriqi,
					beizhu:Ext.getCmp('poprzzgswindowbeizhuinput').value,	  
					cyc55:Ext.getCmp('poprzzgswindowcyc55').getValue(),
					cyc125:Ext.getCmp('poprzzgswindowcyc125').getValue(),
					cyc250:Ext.getCmp('poprzzgswindowcyc250').getValue(),
					down50:Ext.getCmp('poprzzgswindowdown50').getValue(),
					down618:Ext.getCmp('poprzzgswindowdown618').getValue(),
					down732:Ext.getCmp('poprzzgswindowdown732').getValue(),
					minriqi:Ext.getCmp('poprzzgswindowminriqi').getValue()

			};
	//		console.log(Ext.getCmp('cyc55'));
			objarray.push(jsonObject);
			Ext.Ajax.request({
				url:'JsonActionupdateRzzgsBeizhu',
				params:{'jsonString':Ext.JSON.encode(objarray)},
				success:function(){
					rzzgsbygupiaodaimastore.reload({params: {gupiaodaima:thisParent.rowvalue.data.gupiaodaima}});
					Ext.getCmp('myPanel101a').reconfigure(rzzgsbygupiaodaimastore);
					thisParent.hide();
				},
				failure:function(){}
			});
			
			 }}]
});
rzzgspopwindow.prototype.rowvalue={};//用它来储存一行数据传递给窗口用的。
var myrzzgspopwindow=Ext.create('rzzgspopwindow');
myrzzgspopwindow.on('beforeShow',function(){
	Ext.getCmp('poprzzgswindowbeizhuinput').setFieldLabel(this.rowvalue.data.gupiaomingcheng);
	Ext.getCmp('poprzzgswindowbeizhuinput').setValue(this.rowvalue.data.beizhu);
	
});