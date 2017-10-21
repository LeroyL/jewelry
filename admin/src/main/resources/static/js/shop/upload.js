$(function(){
    var options = {
        type: 'POST',
        url: ctx + '/file/upload',
        success:uploadResponse,
        dataType: 'json',
        error : function(xhr, status, err) {
            alert("上传失败");
        }
    };
    $("form").submit(function(){
        $(this).ajaxSubmit(options);
        return false;   //防止表单自动提交
    });
});

var formId;
/**
 * 保存操作
 */
function upload(elementId){
    formId = elementId;
    $("#" + formId).submit();
}

/**
 * 保存后，执行回调
 * @param responseText
 * @param statusText
 * @param xhr
 * @param $form
 */
function uploadResponse(responseText, statusText, xhr, $form){
    if(responseText.code == "0"){
        var inputId = formId + "-input";
        $("#" + inputId).val(responseText.data);
        alert("上传成功");
    } else {
        alert(responseText.message);
    }
}