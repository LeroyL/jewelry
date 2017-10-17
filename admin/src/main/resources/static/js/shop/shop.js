/**
 * Created by leroy(lier@gr158.com) on 2017/10/16.
 */
var page = 0;
var pageSize = 10;
(function ($) {
    $('.menu-shop').addClass('active-menu');
    loadShopData(page, pageSize);
}(jQuery));

function loadShopData(page, pageSize) {
    $.ajax({
        type: 'GET',
        url: ctx + "/shop/findAll",
        data: {
            page: page,
            size: pageSize
        }
    }).success(function (data) {
        $("#content").html(data);
    }).error(function (XMLHttpRequest, textStatus, errorThrown) {
        alert("请求失败");
    });
}

function deleteShop(shopId) {

}