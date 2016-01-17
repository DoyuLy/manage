function sugTemplate() {}

if ((window.navigator.appName.toUpperCase().indexOf("MICROSOFT") >= 0) && (document.execCommand)) {
  try {
    document.execCommand("BackgroundImageCache", false, true)
  } catch(e) {}
}

sugTemplate.prototype.$c = function(D, C, A) {
  var B = document.createElement(D);
  if (C) {
    C.appendChild(B)
  }
  if (A) {
    B.className = A
  }
  return B
};

if (!String.prototype.trim) {
  String.prototype.trim = function () {
    return this.replace(/^\s+|\s+$/g, '');
  };
}

function sogouSugg(newPara) {
  if (typeof SugPara != "object") {
    SugPara = {}
  }

  var isIe = navigator.userAgent.indexOf("MSIE") != -1 && !window.opera;
  var that = this,
  MAX_RETRY_FETCH_SITE = 3,
  handleRetry = MAX_RETRY_FETCH_SITE - 1,
  template = new sugTemplate(),
  myPara = newPara || SugPara,
  on = newPara ? 0 : 1,
  d = document,
  inputid = myPara.inputid || "searchinput",
  useParent = myPara.useParent || 0,
  // suggUri = "http://search.go2.cn/search/suggest/",
  suggUri = "http://suggest.go2.cn/suggest/get/",
  firstRun = 1,
  suggDiv,
  suggIfm = null,
  suggLis = [],
  suggOText = [],
  input_elem,
  input_form,
  mousedown_ontr = 0,
  noneed_query = "",
  lastinput_query = "",
  sending_timer = 0,
  highlight_li = -1,
  jsonData = [],
  jsonDataTongji = [],
  jsonDataTongji0 = [],
  jsonDataTongji1 = [],
  goTongjiId = [],
  hasPersonal = 0,
  hasPersonal1 = 0,
  userInputString = "",
  cache = {},
  sitecache = {},
  ajaj = null,
  originalQuery = "",
  suggestWordId = -1,
  input_time = 0,
  oldfunc = function() {},
  contentDiv,
  siteTimer,
  setTimer1,
  setTimer2,
  setTimer3,
  hideTimer,
  $c = sugTemplate.prototype.$c,
  handleFlag = handleRetry,
  vrFlag = {},
  cur_li = -1,
  isKeyTime = false,
  mouseTime_li = -1;
  that.sw = function(kw, sw) {
    if (!sw) {
      try {
        handleData(["", []])
      } catch(E) {}
    }
    on = sw || false;
    noneed_query = kw || ""
  };
  function $(elemid) {
    return d.getElementById(elemid)
  }
  function bind(elem, evt, func) {
    if (elem) {
      return elem.addEventListener ? elem.addEventListener(evt, func, false) : elem.attachEvent("on" + evt, func)
    }
  }
  function init() {
    if (!$(inputid)) {
      setTimeout(init, 50);
      return
    }
    input_elem = $(inputid);
    input_form = input_elem.parentNode;
    while (input_form && input_form.tagName.toLowerCase() != "form") {
      input_form = input_form.parentNode
    }
    if (!input_form) {
      return
    }
    if (myPara.reset) {
      input_form.reset()
    }
    input_elem.setAttribute("autocomplete", "off");
    bind(input_elem, "mousedown", mousedown);
    bind(input_elem, "keydown", keydown)
  }
  function mousedown() {
    if (firstRun) {
      start()
    }
    if (myPara.oms) {
      noneed_query = "";
      lastinput_query = ""
    }
  }
  function positionDiv() {
    var inputBox = getPositionAndSize(useParent ? input_elem.parentNode: input_elem);
    var isIndex = (location.href.indexOf("query=") > 0) ? false: true;
    suggDiv.style.top = (inputBox[1] + inputBox[3] + (isIndex ? -1 : 0)) + "px";
    suggDiv.style.left = (inputBox[0] + (isIndex ? 0 : -1)) + "px"
  }
  function getPositionAndSize(ele) {
    var x = 0,
    y = 0,
    w = ele.offsetWidth,
    h = ele.offsetHeight;
    if (ele) {
      x += ele.offsetLeft;
      y += ele.offsetTop;
      ele = ele.offsetParent
    }
    return [0, y, 578, h]
  }
  function getQuery() {
    return input_elem.value
  }
  function checkQuery() {
    var curr_query = getQuery();
    curr_query = curr_query.trim();
    if (curr_query && noneed_query != curr_query && lastinput_query == curr_query) {
      if (!sending_timer) {
        sending_timer = setTimeout(function() {
          noneed_query = "";
          suggestWordId = -1;
          if(curr_query != "") { needData(curr_query); }
        },
        100)
      }
    } else {
      clearTimeout(sending_timer);
      sending_timer = 0;
      lastinput_query = curr_query;
      if (!curr_query) {
        hideDiv()
      }
    }
    setTimeout(checkQuery, 10)
  }
  function needData(query) {
    if (!input_time) {
      input_time = new Date().getTime()
    }
    if (cache[query]) {
      handleData(cache[query])
    } else {
      var EEE;
      try {
        d.body.removeChild(ajaj)
      } catch(EEE) {}
      ajaj = d.createElement("script");
      ajaj.src = suggUri + encodeURIComponent(query);
      ajaj.charset = "utf-8";
      d.body.appendChild(ajaj)
    }
  }
  if (typeof window.sogou != "object" || window.sogou == null) {
    window.sogou = {}
  }
  if (typeof window.sogou.sug != "undefined") {
    oldfunc = window.sogou.sug
  }
  window.sogou.sug = function(result_array) {
    try {
      oldfunc(result_array)
    } catch(E) {}
    cache[result_array[0]] = result_array;
    handleData(result_array)
  };
  window.sogou.site = function(result_array) {
    clearTimeout(setTimer1);
    clearTimeout(setTimer2);
    clearTimeout(setTimer3);
    if (result_array) {
      if (result_array.doc_num != 0) {
        handleFlag = handleRetry;
        sitecache[decodeURIComponent(result_array.query)] = result_array;
      } else {
        var cur_query = null;
        for (var i = 0; i < suggLis.length; i++) {
          if (suggLis[i].className == "over") {
            cur_query = jsonData[i]
          }
        }
      }
    }
  };
  function escapeForSpecialChars(input) {
    if (input != null) {
      return input.replace(/&/g, "&amp;").replace(/ /g, "&nbsp;").replace(/</g, "&lt;").replace(/>/g, "&gt;").replace(/"/g, "&quot;")
    } else {
      return ""
    }
  }
  function handleData(results) {
    if (firstRun) {
      return
    }
    userInputString = results[0] || userInputString;
    jsonData = results[1];
    if (results.length > 2) {
      jsonDataTongji = results[2];
      jsonDataTongji0 = [];
      jsonDataTongji1 = [];
      goTongjiId = [];
      for (var k = 0; k < jsonDataTongji.length; ++k) {
        var tempTongji = jsonDataTongji[k].split(";");
        vrFlag[results[1][k]] = tempTongji[2];
        if (tempTongji != null && tempTongji.length >= 2) {
          jsonDataTongji0.push(tempTongji[0]);
          jsonDataTongji1.push(tempTongji[1])
        } else {
          jsonDataTongji0.push( - 1);
          jsonDataTongji1.push(0)
        }
        goTongjiId.push(0)
      }
    }
    if (results.length > 3) {
      hasPersonal1 = results[3][0]
    }
    var i = 0,
    j;
    clearHighlight();
    highlight_li = -1;
    positionDiv();
    var show = isShowing();
    showDiv("show");
    var suggList = suggDiv.getElementsByTagName("ul")[0],
    tmpLi;
    while (suggList.childNodes.length > 0) {
      suggList.removeChild(suggList.childNodes[0])
    }
    suggLis = [];
    suggOText = [];
    for (var i = 0; i < jsonData.length && i < 10; i++) {
      tmpLi = d.createElement("li");
      tmpLi.onmouseover = mouseOver;
      tmpLi.onmouseout = mouseOut;
      tmpLi.onmousedown = mouseDown;
      tmpLi.onclick = mouseClick;
      tmpLi.setAttribute("lid", i);
      tmpLi.innerHTML = escapeForSpecialChars(jsonData[i]);
      if (vrFlag[jsonData[i]] == 1) {
        tmpLi.innerHTML += "<span></span>"
      }
      suggLis.push(tmpLi);
      suggOText.push(tmpLi.innerHTML);
      suggList.appendChild(tmpLi);
    }
    hideDiv();
    if ((jsonData.length > 0 || newPara) && on && suggLis.length > 0) {
      suggLis[0].className = "first";
      positionDiv();
      showDiv(show);
      handleFlag = handleRetry;
    }
    if (jsonData.length == 0 || !on) {
      hideDiv()
    }
  }
  function stopEvent(evt) {
    if (evt.preventDefault) {
      evt.preventDefault()
    }
    evt.cancelBubble = true;
    return evt.returnValue = false
  }
  var useKey = false,
  submitby = "default";
  function keydown(evt) {
    if (firstRun) {
      start()
    }
    if (!input_time) {
      input_time = new Date().getTime()
    }
    evt = evt || window.event;
    if (evt.keyCode == 27) {
      if (isShowing()) {
        hideDiv();
        noneed_query = input_elem.value;
        setTimeout(function() {
          noneed_query = input_elem.value
        },
        1)
      }
    } else {
      if (evt.keyCode == 13) {
        hideDiv();
        submitby = "enter";
        try {
          if (input_form.enter) {
            input_form.enter.value = "1"
          }
        } catch(e) {}
        // return stopEvent(evt)
      } else {
        if (isShowing()) {
          if (evt.keyCode == 38) {
            useKey = true;
            upKey();
            return stopEvent(evt)
          } else {
            if (evt.keyCode == 9 || evt.keyCode == 40) {
              useKey = true;
              downKey();
              return stopEvent(evt)
            }
          }
        } else {
          if ((evt.keyCode == 38) || (evt.keyCode == 40)) {
            useKey = true;
            getQuery() && needData(getQuery())
          }
        }
      }
    }
  }
  function downKey() {
    if (!suggDiv.onmousemove) {
      suggDiv.onmousemove = mouseMove
    }
    isKeyTime = true;
    clearTimeout(setTimer3);
    highlight_li++;
    if (highlight_li == jsonData.length) {
      highlight_li = -1
    }
    highlight()
  }
  function upKey() {
    if (!suggDiv.onmousemove) {
      suggDiv.onmousemove = mouseMove
    }
    isKeyTime = true;
    clearTimeout(setTimer3);
    clearHighlight();
    highlight_li--;
    if (highlight_li == -2) {
      highlight_li = jsonData.length - 1
    }
    highlight()
  }
  function highlight() {
    clearHighlight();
    if (highlight_li >= 0) {
      suggLis[highlight_li].className = "over";
      input_elem.value = jsonData[highlight_li];
      handleFlag = handleRetry;
    } else {
      input_elem.value = userInputString
    }
    suggestWordId = highlight_li;
    noneed_query = input_elem.value
  }
  function listHighlight() {
    clearHighlight();
    if (highlight_li >= 0) {
      suggLis[highlight_li].className = "over"
    }
  }
  function clearHighlight() {
    for (var i = 0; i < suggLis.length; i++) {
      suggLis[i].className = ""
    }
  }
  function mouseMove() {
    suggDiv.onmousemove = null;
    isKeyTime = false;
    clearTimeout(hideTimer);
    hideTimer = setTimeout(function() {
      var li = null;
      if (mouseTime_li >= 0 && (li = suggLis[mouseTime_li])) {
        clearHighlight();
        li.className = "over";
        highlight_li = mouseTime_li;
        handleFlag = handleRetry;
      }
      mouseTime_li = -1
    },
    50)
  }
  function mouseOut() {
    clearTimeout(hideTimer)
  }
  function mouseOver() {
    mouseTime_li = parseInt(this.getAttribute("lid"));
    if (isKeyTime) {
      return
    }
    clearHighlight();
    this.className = "over";
    clearTimeout(setTimer3);
    clearTimeout(hideTimer);
    var that = this;
    hideTimer = setTimeout(function() {
      clearHighlight();
      that.className = "over";
      highlight_li = parseInt(that.getAttribute("lid"));
      handleFlag = handleRetry;
    },
    100)
  }
  function mouseDown(event) {
    if (event && event.stopPropagation) {
      event.stopPropagation()
    }
    mousedown_ontr = 1;
    return false
  }
  function mouseClick() {
    suggestWordId = parseInt(this.getAttribute("lid"));
    input_elem.value = jsonData[suggestWordId];
    noneed_query = input_elem.value;
    hideDiv();
  }
  function isShowing() {
    return (suggDiv && (suggDiv.style.display == "block"))
  }
  function showDiv(showOrNot) {
    suggDiv.style.display = "block";
    if (suggIfm) {
      suggIfm.style.display = "block"
    }
    try {
      if (!useParent) {
        input_elem.parentNode.appendChild(suggDiv);
        input_elem.parentNode.appendChild(suggIfm)
      } else {
        input_elem.parentNode.appendChild(suggDiv);
        input_elem.parentNode.appendChild(suggIfm)
      }
    } catch(e) {}
  }
  function hideDiv() {
    suggDiv.style.display = "none";
    if (suggIfm) {
      suggIfm.style.display = "none"
    }
    try {
      if (!useParent) {
        input_elem.offsetParent.removeChild(suggDiv);
        input_elem.offsetParent.removeChild(suggIfm)
      } else {
        input_elem.parentNode.offsetParent.removeChild(suggDiv);
        input_elem.parentNode.offsetParent.removeChild(suggIfm)
      }
    } catch(e) {}
  }
  function start() {
    if (!firstRun) {
      return
    }
    firstRun = 0;
    function createDiv() {
      if (isIe) {

        input_elem.offsetParent.style.position = "relative";
        var tmp = input_elem.offsetParent;
        while (tmp) {
          if (! (parseInt(tmp.currentStyle.zIndex))) {
            tmp.style.zIndex = "2000"
          }
          tmp = tmp.offsetParent
        }
      }
      suggDiv = $c("div", null, "suggestion nobg");
      suggDiv.id = "vl";
      var tmpLi, innerDiv = $c("div", suggDiv, "suginner"),
      suggList = $c("ul", innerDiv, "suglist");
      suggLis = [];
      for (var i = 0; i < 10; i++) {
        tmpLi = d.createElement("li");
        tmpLi.onmouseover = mouseOver;
        tmpLi.onmouseout = mouseOut;
        tmpLi.onmousedown = mouseDown;
        tmpLi.onclick = mouseClick;
        tmpLi.setAttribute("lid", i);
        suggLis.push(tmpLi);
        suggList.appendChild(tmpLi)
      }

      contentDiv = $c("div", innerDiv, "sugc");
      contentDiv.id = "sugc";
      contentDiv.onmouseover = function() {
        mouseTime_li = -1
      };
      contentDiv.style.display = "none";

      suggList.onmouseout = listHighlight
    }
    createDiv();

    bind(d, "click",function(evt) {
      evt = evt || window.event;
      var ele = evt.srcElement || evt.target;
      while (ele) {
        if (ele == contentDiv || ele == input_elem) {
          return
        }
        ele = ele.parentNode
      }
      hideDiv()
    });
    checkQuery()
  }
  init();
}
var smugg = new sogouSugg();