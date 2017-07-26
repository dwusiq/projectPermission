/*页面加载的时候执行*/
function onLoad() {
    console.log("33");
    loadCatalogTree()
}

/*加载目录树*/
function loadCatalogTree() {
    $.ajax({
        type: 'GET',
        url: '/projectPermission/permissionManage/queryCatalogTreeList.json',
        success: function (result) {
            //    var myJson = eval('(' + result + ')');
            $('#catalogTree').tree({
                data: result
            });
        }
    });
}

/*
    $('#catalogTree').tree({
        url : '/easyuiLayout/catalogManage/queryCatalogTreeList.json',
    });
}*/