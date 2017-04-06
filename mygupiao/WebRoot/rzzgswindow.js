Ext.create('Ext.form.Panel', {
    title: 'Simple Form with FieldSets',
    labelWidth: 75, // label settings here cascade unless overridden
    url: 'save-form.php',
    frame: true,
    bodyStyle: 'padding:5px 5px 0',
    width: 550,
    renderTo: Ext.getBody(),
    layout: 'column', // arrange fieldsets side by side
    items: [{
        // Fieldset in Column 1 - collapsible via toggle button
        xtype:'fieldset',
        columnWidth: 0.5,
        title: 'Fieldset 1',
        collapsible: true,
        defaultType: 'textfield',
        defaults: {anchor: '100%'},
        layout: 'anchor',
        items :[{
            fieldLabel: 'Field 1',
            name: 'field1'
        }, {
            fieldLabel: 'Field 2',
            name: 'field2'
        }]
    }, {
        // Fieldset in Column 2 - collapsible via checkbox, collapsed by default, contains a panel
        xtype:'fieldset',
        title: 'Show Panel', // title or checkboxToggle creates fieldset header
        columnWidth: 0.5,
        checkboxToggle: true,
        collapsed: true, // fieldset initially collapsed
        layout:'anchor',
        items :[{
            xtype: 'panel',
            anchor: '100%',
            title: 'Panel inside a fieldset',
            frame: true,
            height: 52
        }]
    }]
});
Ext.create('Ext.window.Window', {
    title: 'Hello',
    height: 200,
    width: 400,
    layout: 'fit',
    items: {  // Let's put an empty grid in just to illustrate fit layout
        xtype: 'grid',
        border: false,
        columns: [{header: 'World'}],                 // One header just for show. There's no data,
        store: Ext.create('Ext.data.ArrayStore', {}) // A dummy empty data store
    }
}).show();