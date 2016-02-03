Ext.Loader.setConfig({
    enabled: true
});
Ext.Loader.setPath('Ext.ux', './packages/ux/classic/src');
Ext.require([
    'Ext.grid.*',
    'Ext.layout.container.Border',
    'Ext.data.*',
    'Ext.form.field.Number',
    'Ext.form.field.Date',
    'Ext.tip.QuickTipManager',
    'Ext.ux.DataTip'
]);

Ext.define('Task', {
    extend: 'Ext.data.Model',
    fields: [       
        {name: 'dc_date', type: 'date',dateFormat:'Y/m/d'},
        {name: 'breakfast_num', type: 'int'},
        {name: 'meat_num', type: 'int'},
        {name: 'dinner_num', type: 'int'},
        {name: 'breakfast1_num', type: 'int'},
        {name: 'meat1_num', type: 'int'},
        {name: 'dinner1_num', type: 'int'}
        
    ]
});

var data = [
    {dc_date:'2016/01/06',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:6,dinner1_num:2},
    {dc_date:'2016/01/07',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/08',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/09',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/10',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/11',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/12',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/13',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/14',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/15',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/16',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/17',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/18',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/19',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/20',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/21',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/22',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/23',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/24',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/25',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/26',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/27',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/28',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/29',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/30',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2},
    {dc_date:'2016/01/31',breakfast_num:1,meat_num:1,dinner_num:1,breakfast1_num:1,meat1_num:1,dinner1_num:2}  
];

Ext.onReady(function(){
    
    Ext.tip.QuickTipManager.init();   //?
    
    var store = Ext.create('Ext.data.Store', {
        model: 'Task',  
        data: data       
    });

   
    var grid = Ext.create('Ext.grid.Panel', {  
        width: 880,
        height: 450,
        frame: true,
        title: '订餐情况',
        iconCls: 'icon-grid',
        renderTo: document.body,
        columnLines : true,
        store: store,
        layout: 'border',
        
       
        selModel: {
            selType: 'cellmodel'//
        },
       
        dockedItems: [{//锁定项目
            dock: 'top',//锁定在顶部
            xtype: 'toolbar',//工具条
            height:50,
            items: [{
                xtype: 'datefield',
                fieldLabel: '选择年月:',
                labelAlign:'right',
                format: 'Y-m',
                width:200,
                name: 'theDate',
                value: new Date(),
                maxValue: new Date()
            	},
                    {//项目
                tooltip: 'Toggle the visibility of the summary row',//提示信息
                text: 'Toggle Summary',//文本信息
                enableToggle: true,//?
                pressed: true,//
                handler: function() {//处理函数
                    grid.lockedGrid.getView().getFeature('group').toggleSummaryRow();
                }
            }]
        }],
        features: [{//?
            id: 'group',
            ftype: 'groupingsummary',
            groupHeaderTpl: '{name}',
            hideGroupedHeader: true,
            enableGroupingMenu: true
        }, {
            ftype: 'summary',
            dock: 'bottom'
        }],
        split: true,
        lockedGridConfig: {
            header: false,
            collapsible: true,
            width: 300,
            forceFit: true//?
        },
        lockedViewConfig: {
            scroll: 'horizontal'
        },
        columns: [{
            header: '职工餐订餐',
            columns: [{
                header: '订餐日期',
                width: 120,
                sortable: true,
                dataIndex: 'dc_date',
                renderer: Ext.util.Format.dateRenderer('Y-m-d')
            }, {
                header: '早餐',
                width: 125,             
                dataIndex: 'breakfast_num',
                summaryType: 'sum',
                renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
                    return value + ' 份';
                },
                summaryRenderer: function(value, summaryData, dataIndex) {
                    return value + ' 份';
                },
                field: {
                    xtype: 'numberfield'
                }
            }, {
            	 header: '午餐',
                 width: 120,             
                 dataIndex: 'meat_num',
                 summaryType: 'sum',
                 renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
                     return value + ' 份';
                 },
                 summaryRenderer: function(value, summaryData, dataIndex) {
                     return value + ' 份';
                 },
                field: {
                    xtype: 'numberfield'
                }
            }, { header: '晚餐',
                width: 125,             
                dataIndex: 'dinner_num',
                summaryType: 'sum',
                renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
                    return value + ' 份';
                },
                summaryRenderer: function(value, summaryData, dataIndex) {
                    return value + ' 份';
                },
               field: {
                   xtype: 'numberfield'
               }                
            }]
        },
        {
            header: '家属餐订餐',
            columns: [{
                header: '早餐 ',
                width: 120,             
                dataIndex: 'breakfast1_num',
                summaryType: 'sum',
                renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
                    return value + ' 份';
                },
                summaryRenderer: function(value, summaryData, dataIndex) {
                    return value + ' 份';
                },
                field: {
                    xtype: 'numberfield'
                }
            }, {
            	 header: '午餐',
                 width: 120,             
                 dataIndex: 'meat1_num',
                 summaryType: 'sum',
                 renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
                     return value + ' 份';
                 },
                 summaryRenderer: function(value, summaryData, dataIndex) {
                     return value + ' 份';
                 },
                field: {
                    xtype: 'numberfield'
                }
            }, { header: '晚餐 ',
                width: 120,             
                dataIndex: 'dinner1_num',
                summaryType: 'sum',
                renderer: function(value, metaData, record, rowIdx, colIdx, store, view){
                    return value + ' 份';
                },
                summaryRenderer: function(value, summaryData, dataIndex) {
                    return value + ' 份';
                },
               field: {
                   xtype: 'numberfield'
               }                
            }]
        }]
    });
});
