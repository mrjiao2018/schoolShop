/**
 * 两个功能：
 * 1. 加载shopOperation界面时，请求种类category和区域area信息，加载到界面上
 * 2. 提交用户的请求
 * 3. 验证表单输入
 */
$(function () {
    var initUrl = "/schoolshop/shopadmin/getshopinitinfo";
    var registerShopUrl = "/schoolshop/shopadmin/registershop";
    alert(initUrl);
    getShopInitInfo();
    
    function getShopInitInfo() {
        $.getJSON(initUrl, function (data) {
            if(data.success){
                var tempCategoryHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function(item, index){
                    tempCategoryHtml += '<option data-id="' + item.shopCategoryId
                        + '">' + item.shopCategoryName + '</option>'
                });
                // TODO 为什么使用@ResponseBody序列化成字符串时，key的名称"areaName"变成了"name"？很有可能粗心导致
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.name + '</option>';
                });
                $("#shop-category").html(tempCategoryHtml);
                $("#area").html(tempAreaHtml);
            }
        })
    }

    $("#submit").click(function () {
        var shop = {};
        shop.shopName = $("#shop-name").val();
        shop.shopAddr = $("#shop-addr").val();
        shop.phone = $("#shop-phone").val();
        shop.shopDesc = $("#shop-desc").val();
        shop.shopCategory = {
            shopCategoryId:$("#shop-category").find("option").not(function () {
                return !this.selected;
            }).data('id')
        };
        shop.area = {
            areaId:$("#area").find("option").not(function () {
                return !this.selected;
            }).data('id')
        };

        var shopImg = $("#shop-img")[0].files[0];

        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));

        $.ajax({
            url:registerShopUrl,
            type:"POST",
            data:formData,
            contentType:false,
            processData:false,
            cache:false,
            success:function(data){
                if(data.success){
                    $.toast("提交成功");
                } else {
                    $.toast("提交失败" + data.errMsg);
                }
            }
        })
    });
});