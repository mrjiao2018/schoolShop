/**
 * 两个功能：
 * 1. 加载shopOperation界面时，请求种类category和区域area信息，加载到界面上
 * 2. 提交用户的请求
 * 3. 验证表单输入
 */
$(function () {
    var initUrl = "/schoolshop/shopadmin/getshopinitinfo";
    var registerShopUrl = "/schoolshop/shopadmin/registershop";
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
        // 获取用户输入的商店信息
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

        // 获取用户上传的图片信息
        var shopImg = $("#shop-img")[0].files[0];

        // 检查验证码
        var verifyCodeActual = $("#j_captcha").val();
        if(!verifyCodeActual){
            $.toast("请输入验证码！");
            return;
        }

        // 将信息封装
        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));
        formData.append('verifyCodeActual', verifyCodeActual);

        // 上传
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
                $("#captcha_img").click();
            }
        })
    });
});