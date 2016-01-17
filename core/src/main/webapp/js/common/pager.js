/**
 * js分页插件
 * @param pls see '$.fn.go2Pager.defaults'
 * @returns html
 */
(function ($) {
    $.fn.go2Pager = function (options) {
        var self = this;
        var opts = $.extend($.fn.go2Pager.defaults, options);
        opts.pageIndex = parseInt(opts.pageIndex);
        opts.pageSize = parseInt(opts.pageSize);
        opts.recordTotal = parseInt(opts.recordTotal);
        var pageTotal = parseInt(Math.ceil(opts.recordTotal / opts.pageSize));

        function onPageChange(index) {
            opts.pageIndex = index;
            if (opts.pageChange != null)
                opts.pageChange(index);
            render(self);
        }

        function render(obj) {
            switch (opts.type) {
                case 1:
                    reader_1(obj);
                    break;
                case 2:
                    render_2(obj);
                    break;
            }
        }

        function reader_1(obj) {
            var html = "<li><span class='total'>" + opts.totalText.format(opts.recordTotal) + "</span></li>";
            if (opts.pageIndex > 1)
                html += "<li><a page='{0}' class='page-prev'>{1}</a></li>".format(opts.pageIndex - 1, opts.prevText);

            var start = opts.pageIndex - opts.displayNum < 1 ? 1 : opts.pageIndex - opts.displayNum;
            if (start == 2)
                html += "<li><a page='1' class='page-link'>1</a></li>";
            else if (start > 2) {
                html += "<li><a page='1' class='page-first'>1</a></li>";
                html += "<li><span class='ellipsis'>...</span></li>";
            }

            for (var i = start; i <= opts.pageIndex - 1; i++)
                html += "<li><a page='{0}' class='page-link'>{0}</a></li>".format(i);

            html += "<li class='active'><span class='page-cur'>{0}</span></li>".format(opts.pageIndex);

            var end = opts.pageIndex + opts.displayNum > pageTotal ? pageTotal : opts.pageIndex + opts.displayNum;
            for (var i = opts.pageIndex + 1; i <= end ; i++)
                html += "<li><a page='{0}' class='page-link'>{0}</a></li>".format(i);

            if (end + 1 == pageTotal)
                html += "<li><a page='{0}' class='page-link'>{0}</a></li>".format(pageTotal);
            else if (end < pageTotal) {
                html += "<li class='ellipsis'>...</li>";
                html += "<li><a page='{0}' class='page-last'>{0}</a></li>".format(pageTotal);
            }

            if (opts.pageIndex < pageTotal)
                html += "<li><a page='{0}' class='page-next'>{1}</a></li>".format(opts.pageIndex + 1, opts.nextText);

            html += "<li><span class='page-info'><input type='text' class='page-input' value='{0}'/> / {1} 页</span></li>".format(opts.pageIndex, pageTotal);

            $(obj).html(html);
            $(obj).find("a").attr("href", "javascript:void(0)").click(function () {
                onPageChange(parseInt($(this).attr("page")));
            });
            $(obj).find("input").keydown(function (e) {
                if (e.keyCode == 13) {
                    var val = $(this).val();
                    if (val != undefined && val != '') {
                        if (!isNaN(val)) {
                            if (val > pageTotal || val < 1)
                                val = opts.pageIndex;
                            else
                                val = parseInt(val);
                            onPageChange(val);
                        } else
                            $(this).val(opts.pageIndex);
                    }
                }
            });
        }

        function render_2(obj) {
            var html = "";
            if (opts.totalText != "")
                html += "<li class='page-text-total'>" + opts.totalText.format(opts.recordTotal) + "</li>";

            html += "<li class='page-text-summary'><span>{0}</span>/<span>{1}</span>页</li>".format(opts.pageIndex, pageTotal);

            html += "<li class='page-link page-first{0}' title='第一页' data-page='1'>{1}</li>".format(opts.pageIndex == 1 ? " disable" : "", opts.firstText);
            html += "<li class='page-link page-prev{0}' title='上一页' data-page='{2}'>{1}</li>".format(opts.pageIndex == 1 ? " disable" : "", opts.prevText, opts.pageIndex - 1);

            html += "<li class='page-link page-next{0}' title='下一页' data-page='{2}'>{1}</li>".format(opts.pageIndex == pageTotal ? " disable" : "", opts.nextText, opts.pageIndex + 1);
            html += "<li class='page-link page-last{0}' title='最后一页' data-page='{2}'>{1}</li>".format(opts.pageIndex == pageTotal ? " disable" : "", opts.lastText, pageTotal);

            $(obj).html(html);

            $(obj).find("li").click(function () {
                if ($(this).attr("class").indexOf("disable") >= 0)
                    return false;
                var index = $(this).attr("data-page");
                onPageChange(index);
            });
        }

        render(self);
        return self;

    };

    $.fn.go2Pager.defaults = {
        pageSize: 20,                           //页大小
        pageIndex: 1,                           //当前页,从1开始
        recordTotal: 0,                         //数据总数

        type: 1,                                //分页风格，1：完整、2：简易
        displayNum: 3,                          //显示页码个数

        firstText: "&lt;&lt;",                  //第一页显示内容
        prevText: "&lt;",                       //上一页显示内容
        nextText: "&gt;",                       //下一页显示内容
        lastText: "&gt;&gt;",                   //最后一页显示内容

        noData: "暂无数据",                     //无数据显示的内容
        totalText: "共<span>{0}</span>条",      //总数据条数显示的内容

        pageChange: null                        //事件-页码发生改变时
    };

})(jQuery);