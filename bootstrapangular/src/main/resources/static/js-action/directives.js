// 定义一指令名为为datePicker
actionApp.directive('datePicker', function () {
   return {
     restrict:'ABC', // 限制为属性指令和样式指令
     link:function (scope, elem, attrs) { // 使用link方法来定义指令，在link方法内使用当前scope、当前元素及元素毒性
         elem.datepicker(); // 初始化jqueryui的datePicker（jquery的写法是$('#id').datePicker()）
     }
   };

});