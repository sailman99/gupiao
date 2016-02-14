Ext.require([
    'Ext.grid.*',
    'Ext.data.*',
    'Ext.util.*',
//    'Ext.state.*',
    'Ext.grid.filters.Filters'
]);


Ext.onReady(function(){

//Ext.state.Manager.setProvider(new Ext.state.CookieProvider());

    Ext.define('ForumThread', {
        extend: 'Ext.data.Model',
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
    // create the Data Store
    var store = Ext.create('Ext.data.Store', {
        id: 'store',
        model: 'ForumThread',       
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an Ajax proxy would be better
            type: 'ajax',
            url: 'JsonAction!getrzzgsByCondition?jsqbh=40&&jsqbh2=40&&riqi=2015-09-30',            
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        autoLoad: true
       
    });

    function renderTopic(value, p, record) {
        return Ext.String.format(
            '<a href="http://sencha.com/forum/showthread.php?t={2}" target="_blank">{0}</a>',
            value,
            record.data.forumtitle,
            record.getId(),
            record.data.forumid
        );
    }

    var grid = Ext.create('Ext.grid.Panel', {
        width: 700,
        height: 500,
        collapsible: true,
        title: 'ExtJS.com - Browse Forums',
        store: store,
        loadMask: true,
        selModel: {
            pruneRemoved: false
        },
        multiSelect: true,
        viewConfig: {
            trackOver: false
        },        
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
        }],
        renderTo: Ext.getBody()
    });
});
