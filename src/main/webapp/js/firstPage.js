/*页面加载的时候执行*/
function onLoad() {
    loadCatalogTree()
    var t2 = window.setInterval("hello()",3000);
//去掉定时器的方法
    window.clearInterval(t2);
}
var i = 0;
function hello() {
    console.log(i);
    i++;
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
                        //调用方法添加选项卡
                        Open(node.id,node.text, node.attributes.url);
                        //调用方法检查按钮的权限
                        checkButtonPermission(node.id);
                    }
                }
            });
        }
    });
}


/*在右边center区域打开菜单，新增tab*/
function Open(id,text, url) {
    if ($("#tabs").tabs('exists', text)) {
        $('#tabs').tabs('select', text);
    } else {
        var content = '<iframe id='+id+' width="100%" height="100%" frameborder="0"  src='+url+' style="width:100%;height:100%;margin:0px 0px;"></iframe>';
        $('#tabs').tabs('add', {
            title : text,
            closable : true,
            content :content
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
    var $iframe = document.getElementById(parentId);//获取子页面元素
    var $contentWindow = $iframe.contentWindow;
    //子加载完后页面加载完后
    $contentWindow.onload=function () {
        var $document = $contentWindow.document;
        for (var i=0;i<buttonPermissionList.length;i++)
        {
            var $button = $document.getElementById(buttonPermissionList[i].resName);//获取按钮（有时候获取的是null）
            $button.style.display="block";//让有权限的按钮显示
        }
    }
}