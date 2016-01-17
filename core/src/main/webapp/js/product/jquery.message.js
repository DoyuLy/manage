(function(e) {
	e.Message = function() {
		return function() {
			this.init.apply(this, arguments)
		}
	} ();
	e.Message.prototype = {
		init: function(t) {
			var n = this;
			n.set_options(t);
			if (n.simpleconfirm) {
				n.simple_confirm();
				return
			}
			var r = e(".message-box");
			if (r.length > 0) {
				return false
			}
			if (n.ismask) {
				if (e.browser.msie && e.browser.version == 6) {
					n.MLay = e(document.createElement("iframe"))
				} else {
					n.MLay = e(document.createElement("div"))
				}
				e("body").append(n.MLay);
				n.MLay.addClass("message-lay");
				n.MLay.css({
					display: "none"
				});
				n.mask_resize();
				n.MLay.fadeIn("slow",
				function() {
					n.MLay.css({
						display: ""
					})
				});
				e(window).resize(function() {
					n.mask_resize()
				});
				e(window).scroll(function() {
					n.mask_resize()
				})
			}
			e(document).bind("keypress", "esc",
			function() {
				n.result = "close";
				return n.close()
			});
			n.Box = e(document.createElement("div"));
			e("body").append(n.Box);
			n.Box.addClass("message-box");
			if (n.msn) {
				n.top = e(window).height() + e(window).scrollTop() - n.Box.outerHeight() - 1;
				n.left = e(window).width() - n.Box.outerWidth() - 1
			} else {
				n.top = n.top + e(window).scrollTop() - 3
			}
			if (n.istitle) {
				e(n.Box).append('<div class="message-title"><div class="message-title-txt">' + n.title + '</div><a title="关闭" href="javascript:;" class="message-title-close"></a></div>');
				if (n.isdrag) {
					e(n.Box).draggable({
						handle: e(".message-title")
					})
				} else {
					e(".message-title").css({
						cursor: "default"
					})
				}
				e(".message-title-close").click(function() {
					n.result = "close";

					if(n.close_click){
						eval(n.close_click+'()');
					}
					return n.close();
				})
			}
			var i = "";
			i = '<table class="message-content" width="100%" height="100%" border="0" cellspacing="0" cellpadding="0"><tr>';
			if (n.confirm) {
				n.icon = "ask"
			}
			if (n.icon != "none") {
				i += '<td class="message-content-' + n.icon + '"> </td>'
			}
			i += '<td class="message-content-txt" align="left">' + n.content + "</td></tr></table>";
			if (n.iframe) {
				i = e('<iframe class="message-content" style="width:100%; height:' + (n.height - ((n.button.cancel || n.button.ok || n.confirm) && !n.iframe) ? e(".message-button").outerHeight() : 0 - n.istitle ? e(".message-title").outerHeight() : 0) + 'px; border:none;" src="' + n.target + '" frameborder="0"></iframe>')
			}
			e(n.Box).append(e(i));
			if (n.iframe) {
				e(i, parent.document.body).attr("src", n.target)
			}
			if ((n.button.cancel || n.button.ok || n.confirm) && !n.iframe) {
				var s = '<div class="message-button">';
				if (n.button.ok || n.confirm) {
					s += '<input type="button" class="message-button-ok" value="' + n.button.okname + '" />'
				}
				if ((n.button.cancel || n.confirm) && n.icon != "err" && n.icon != "info" && n.icon != "success") {
					s += '<input type="button" class="message-button-cancel" value="取 消" />'
				}
				s += "</div>";
				e(n.Box).append(s);
				if (n.button.ok || n.confirm) {
					e(".message-button-ok").click(function() {
						n.result = "ok";
						return n.close()
					});
					e(document).bind("keypress", "return",
					function() {
						n.result = "ok";
						return n.close()
					})
				}
				if (n.button.cancel || n.confirm) {
					e(".message-button-cancel").click(function() {
						n.result = "close";
						return n.close()
					})
				}
			}
			e(".message-content").css({
				height: n.height - ((n.button.cancel || n.button.ok || n.confirm) && !n.iframe ? e(".message-button").outerHeight() : 0) - (n.istitle ? e(".message-title").outerHeight() : 0) + "px"
			});
			n.Box.css({
				zIndex: 10001,
				display: "none",
				left: n.left + "px",
				top: n.top + "px",
				position: "absolute",
				width: n.width + "px",
				height: n.height + "px"
			});
			n.box_resize();
			e(window).resize(function() {
				n.box_resize()
			});
			e(window).scroll(function() {
				n.box_resize()
			});
			n.Box.fadeIn("slow",
			function() {
				n.Box.css({
					display: ""
				})
			});
			if (n.autoclose) {
				setTimeout(function() {
					n.result = "close";
					return n.close()
				},
				n.autotime)
			}
		},
		set_title: function(t) {
			e(".message-title-txt").html(t)
		},
		disabled_ok: function(t) {
			e(".message-button-ok").attr("disabled", t)
		},
		simple_confirm: function() {
			var t = this;
			var n = e("#" + t.simpleconfirmobj.id + "_confirm");
			if (n.length <= 0) {
				var r = t.simpleconfirmobj.offset().top;
				var i = t.simpleconfirmobj.offset().left;
				var s = t.simpleconfirmobj.height();
				var o = '<div class="message-simpleconfirm" id="' + t.simpleconfirmobj.id + '_confirm">					<div class="message-simpleconfirm-triangle"></div>					<div class="message-simpleconfirm-box">						<div class="message-simpleconfirm-title">' + t.title + '</div>						<div class="message-simpleconfirm-botton"><input id="' + t.simpleconfirmobj.id + '_confirm_ok" value="确定" type="button" /> <input id="' + t.simpleconfirmobj.id + '_confirm_cancel" value="取消" type="button" /></div>					</div>				</div>';
				e("body").append(o);
				n = e("#" + t.simpleconfirmobj.id + "_confirm");
				n.css("display", "none");
				n.fadeIn("slow");
				n.css("position", "absolute");
				n.css("top", r + s);
				n.css("left", i - e("#" + t.simpleconfirmobj.id + "_confirm").width());
				e("#" + t.simpleconfirmobj.id + "_confirm_ok").click(function() {
					n.fadeOut("slow",
					function() {
						e(this).remove();
						t.handle("ok")
					})
				});
				e("#" + t.simpleconfirmobj.id + "_confirm_cancel").click(function() {
					n.fadeOut("slow",
					function() {
						e(this).remove()
					})
				})
			}
		},
		mask_resize: function() {
			var t = this;
			if (t.ismask) {
				var n = 0;
				t.MLay.css({
					zIndex: 1e4,
					left: "0px",
					top: n + "px",
					opacity: t.opacity,
					position: "absolute",
					width: e(window).width() + "px",
					height: e(document).height() + "px",
					background: t.maskbackground
				})
			}
		},
		box_resize: function() {
			var t = this;
			if (t.msn) {
				t.left = e(window).width() - t.Box.outerWidth() - 1;
				if (t.isflow) {
					t.top = e(window).height() + e(window).scrollTop() - t.Box.outerHeight() - 1
				}
			} else {
				t.left = (e(window).width() - t.width) / 2;
				if (t.isflow) {
					t.top = (e(window).height() - t.height) / 2 + +e(window).scrollTop() - 3
				}
			}
			t.Box.css({
				top: t.top + "px",
				left: t.left + "px"
			})
		},
		close: function() {
			var e = this;
			if (e.result == "ok") {
				if (e.button.okclose) {
					e.destroy()
				}
			} else {                
				e.destroy();
			}
			if (e.handle) {
				e.handle(e.result)
			} else {
				return e.result
			}
		},
		destroy: function() {
			var t = this;
			t.Box.fadeOut("slow",
			function() {
				t.Box.remove()
			});
			if (t.ismask) {
				t.MLay.fadeOut("slow",
				function() {
					t.MLay.remove()
				})
			}
			e(document).unbind("keypress", "esc");
			e(document).unbind("keypress", "return")
		},
		set_options: function(t) {
			t = t || {};
			var n = this;
			n.title = t.title || "标题";
			n.content = t.content || "";
			n.width = t.width || 280;
			n.height = t.height || 160;
			n.left = t.left || (e(window).width() - n.width) / 2;
			n.top = t.top || (e(window).height() - n.height) / 2;
			n.opacity = t.opacity == undefined ? .35 : t.opacity;
			n.maskbackground = t.maskbackground == undefined ? "#000": t.maskbackground;
			n.ismask = t.ismask == undefined ? true: t.ismask;
			n.istitle = t.istitle == undefined ? true: t.istitle;
			n.isdrag = t.isdrag == undefined ? true: t.isdrag;
			n.isrefresh = t.isrefresh == undefined ? true: t.isrefresh;
			n.button = t.button == undefined ? {
				ok: true,
				okname: "确定",
				cancel: true
			}: t.button;
			n.button.ok = n.button.ok == undefined ? true: n.button.ok;
			n.button.okclose = n.button.okclose == undefined ? true: n.button.okclose;
			n.button.okname = n.button.okname == undefined ? "确定": n.button.okname;
			n.button.cancel = n.button.cancel == undefined ? true: n.button.cancel;
			n.autoclose = t.autoclose == undefined ? false: t.autoclose;
			n.autotime = t.autotime || 3e3;
			n.icon = t.icon == undefined ? "info": t.icon;
			n.iframe = t.iframe == undefined ? false: t.iframe;
			n.target = t.target == undefined ? "": t.target;
			n.confirm = t.confirm == undefined ? false: t.confirm;
			n.simpleconfirm = t.simpleconfirm == undefined ? false: t.simpleconfirm;
			n.simpleconfirmobj = t.simpleconfirmobj == undefined ? "": e(t.simpleconfirmobj);
			n.handle = t.handle == undefined ?
			function(e) {
				return e
			}: t.handle;
			n.isflow = t.isflow == undefined ? true: t.isflow;
			n.msn = t.msn == undefined ? false: t.msn;
			n.result = "close"
			n.close_click=t.close_click||false;
		}
	}
})(jQuery)