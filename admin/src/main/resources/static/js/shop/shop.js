/**
 * Created by leroy(lier@gr158.com) on 2017/10/16.
 */
var page = 0;
var pageSize = 10;

$(function(){
    $('.menu-shop').addClass('active-menu');
    loadShopData(page, pageSize);
});

function loadShopData(page, pageSize) {
    $.get(ctx + "/shop/findAll",
        {page: page,size: pageSize},
        function (data) {
            $("#content").html(data);
        }
    );
}

function deleteShop(shopId) {
    var result = confirm("是否要删除该店铺？");
    if(result == false){
        return;
    }
    $.post(ctx + "/shop/delete", {id: shopId}, function (data) {
        if(data.code == 0){
            alert("删除成功");
            window.location.href = ctx + "/shop";
        } else {
            alert(data.message);
        }
    });
}

function saveShop() {
    var name = $("#shop-name").val();
    var ownerId = $("#shop-owner").val();
    var icon = $("#logo-upload-form-input").val();
    $.post(ctx + "/shop/save",
        {shopName: name, ownerId: ownerId, icon: icon},
        function (data) {
            if(data.code == 0){
                alert("保存成功");
                window.location.href = ctx + "/shop";
            } else {
                alert(data.message);
            }
        }
    );
}

function updateShop() {
    
}
