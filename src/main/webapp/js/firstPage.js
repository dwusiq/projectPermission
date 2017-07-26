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
                data: result,
                onClick : function (node) {
                    if (node.attributes) {
                        Open(node.id,node.text, node.attributes.url);
                        checkButtonPermission(node.id);
                    }
                }
            });
        }
    });
}


//在右边center区域打开菜单，新增tab
function Open(id,text, url) {
    if ($("#tabs").tabs('exists', text)) {
        $('#tabs').tabs('select', text);
    } else {
        $('#tabs').tabs('add', {
            title : text,
            closable : true,
            content : '<iframe id='+id+' width="100%" height="100%" frameborder="0"  src="/projectPermission/pageChange/userManagePage.do" style="width:100%;height:100%;margin:0px 0px;"></iframe>'
        });
    }
}

/*检查按钮的权限*/
function checkButtonPermission(parentId) {
    $.ajax({
        type: 'GET',
        data:{resParent:parentId,resCode:"0010004"},
        url: '/projectPermission/permissionManage/queryPermissionList.json',
        success: function (result) {
            viewButtonByPermission(parentId,result)
        }
    });
}

/*根据权限决定是否显示button*/
function viewButtonByPermission(parentId,buttonPermissionList) {
    var $iframe = document.getElementById(parentId);
    var $contentWindow = $iframe.contentWindow;
    var $document = $contentWindow.document;
    for (var i=0;i<buttonPermissionList.length;i++)
    {
        console.log($iframe.contentWindow.document.getElementById(buttonPermissionList[i].resName));
      //  $iframe.contentWindow.document.getElementById(buttonPermissionList[i].resName).style.display="block";
        $document.getElementById(buttonPermissionList[i].resName).style.display="block";
    //  $("#"+buttonPermissionList[i].resName).show();//显示有权限的按钮
    }
}