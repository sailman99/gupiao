var treestore = Ext.create('Ext.data.TreeStore', {
	width:200,	
    root: {       
        expanded: true, 
        width:'100%',
        children: [
            {
                text: 'Rzzgs数据',
                leaf: true,
                width:'100%',
                id:'treeitem101'
            },
            {
                text: 'trendlines趋势线数据',
                leaf: true,
                width:'100%',
                id:'treeitem102'           
            }
            ,
            {
                text: 'inoroutprice买入卖出价数据',
                leaf: true,
                width:'100%',
                id:'treeitem103'           
            }
            ,
            {
                text: '比例回调数据',
                leaf: true,
                width:'100%',
                id:'treeitem104'           
            },
            {
                text: '突破EXPMA线数据',
                leaf: true,
                width:'100%',
                id:'treeitem105'           
            },
            {
                text: '测试用的',
                leaf: true,
                width:'100%',
                id:'treeitem106'           
            }
        ]
    }
});
 
var treeobj = Ext.create('Ext.tree.Panel', {
    width:'99%',
    layout:'fit',
    store:treestore
    
});