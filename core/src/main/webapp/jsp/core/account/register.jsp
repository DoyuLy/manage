<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!--@PAGE_START@ <%=application.getRealPath(request.getRequestURI())%>-->
<%@include file="/jsp/common/head.jsp"%>
<!-- 私有样式==========================================-->
<style>

</style>
<!-- 页面标题==========================================-->
<title>欢迎注册</title>

<!--[if IE]><meta http-equiv="x-ua-compatible" content="IE=9" /><![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="/resources/js/html5shiv.min.js"></script>
      <script src="/resources/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="/css/core/account/register.css"/>
</head>
<body>

  <!-- 导航==========================================-->
  <%@include file="/jsp/common/nav.jsp"%>
  
  <!-- 内容==========================================-->
  <div class="content">
  	 <div class="message">
        <a class="logo" href="<?= $master_station ?>" target="_blank"></a>
        <div class="about_us">
            <p class="fy24 welcome">欢迎注册</p>
            <p class="f12 aaaaaa">中国最大女鞋厂商货源市场/一双也批发</p>
        </div>
    </div>
    
    <div class="role_head">
            <div class="fy20 role seller ${select=='seller'?'selected':''}">
                <span>采购商</span>
        <div class="tips-in">
          ?
          <div class="tip-dets">
            <p class="f12">淘宝店主及网商企业/个人注册成为采购商身份</p>
            <img src="/img/tips-tri.png">
          </div>
        </div>
            </div>
            <div class="fy20 role factory ${select=='supplier'?'selected':''}">
                <span>供应商</span>
        <div class="tips-in">
          ?
          <div class="tip-dets">
            <p class="f12">鞋类生产企业及经销商/代理商/批发商统一注册身份为供应商</p>
            <img src="/img/tips-tri.png">
          </div>
        </div>
            </div>
            <div class="fy20 role server ${select=='daifa'?'selected':''}">
                <span>代发商</span>
        <div class="tips-in">
          ?
          <div class="tip-dets">
            <p class="f12">申请加入代发货团队</p>
            <img src="/img/tips-tri.png">
          </div>
        </div>
            </div>

            <p class="contact f12">热线&nbsp;<span class="bold fa18"><?= $service_phone ?></span></p>
            <!--<div class="contact f12">-->
                <!--<p>客服</p>-->
                <!--<div class="qqnumber">&nbsp;</div>-->
            <!--</div>-->
        </div>
        
        
        <!-- 采购商注册模块 -->
        <div class="detail_sel module">
           <form id="user_form" class="reg-form" action="/register/register_as_seller" method="post">
            <!-- 用户类型 -->
            <input type="hidden" name="type" value="0"/>
            <p>${msg }</p>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">用户名</span>
          </div>
          <input type="text" name="username" class="input f14 myname" placeholder="请设置2-20位汉字,字母,数字组合的用户名">
          <div class="input_img name_back"></div>
          <span class="auth-ok f12">

          </span>
                </div>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">设置密码</span>
          </div>
                    <input type="password" name="password_01" class="input" placeholder="请设置6-20位密码">
          <div class="input_img pass_back"></div>
          <p class="reminder f13">
            安全程度：
            <span class="strength">弱</span>
            <span>中</span>
            <span>强</span>
          </p>
                </div>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">重复密码</span>
          </div>
                    <input type="password" name="password" class="input" placeholder="重复输入已设置的密码，两次密码要一致">
          <div class="input_img pass_back"></div>
                </div>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">手机号码</span>
          </div>
          <input type="text" name="phonenumber" id="mobile1" class="input" placeholder="便于安全找回密码">
                    <div class="input_img phone_back"></div>
          <span class="phone-ok f12">

          </span>
                </div>
                <div class="store">
          <div class="left-contain pull-left">
            <span class="bold">您的店铺</span>
          </div>
                    <div class="chebox">
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="淘宝网店">淘宝网店</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="天猫商城">天猫商城</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="阿里巴巴">阿里巴巴</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="京东商城">京东商城</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="微店店主">微店店主</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="手机微商">手机微商</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="美丽说">美丽说&nbsp;&nbsp;</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="蘑菇街">蘑菇街</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="实体店主">实体店主</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="随便逛逛">随便逛逛</div>
                        <div class="sto"><input type="checkbox" name="store" class="checkbox" value="其他">其他</div>
                        <div class="last-netsto sto"><input type="text" name="others" class="sto others" placeholder="请输入第三方平台名称"></div>
                        <p class="ff6c00 secsto f12">可多选，便于系统为您推荐更适合的热销产品</p>
                    </div>                    
                </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">QQ号码</span>
          </div>
          <input type="text" name="qqnumber" class="input f14" placeholder="请输入您的QQ号码">
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">邮箱地址</span>
          </div>
          <input type="text" name="email" id="email1" class="input f14" placeholder="请输入您的邮箱地址"><span id="myemail1"></span>
          <span class="email-ok f12">

          </span>
        </div>
                <div class="coding">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">验证码</span>
          </div>
                    <div class="code_agree">
                        <input type="text" name="code" id='mycode1' class="code input" placeholder="请按右图填写">
                        <div class="coder">
                        <!-- 验证码制作 --> 
          
                      <img class="captcha1" src="/login/verify" onclick="this.src='/login/verify?t='+Math.random()">
                    </div>
            <a class="refimg f12 captcha2 other-code">看不清楚，换一张</a>

                        
            
            <!--<span class="auth-ok f12">-->
              <!--<img src="/img/auth-ok.png">-->
              <!--验证成功-->
            <!--</span>-->
                        <div class="protocol f12">
                            <input type="checkbox" name="agree" value="agree" checked>
                            我已阅读并同意
                            <a class="protocol-det">&lt;&lt;<?= $name ?>平台服务协议&gt;&gt;</a>
                        </div>
                    </div>
                </div>
                <input class="submit fy18" type="submit" value="提交">
                
            </form>
            <div class="ad_sel ad_right">
        <div class="slider slider01">
        </div>
            </div>
        </div>
        
        
        <!-- 供应商注册模块 -->
        <div class="detail_fac module ">
            <form id="fac_form" class="reg-form" action="/register/register_as_supplier" method="post">
                <!-- 用户类型 -->
                <input type="hidden" name="type" value="1"/>              
        <p class="f16 bold fac-title">账户信息</p>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">用户名</span>
          </div>
                    <input type="text" name="username" class="input f14 pull-left myname" placeholder="请设置2-20位汉字,字母,数字组合的用户名">
          <div class="input_img name_back"></div>
          <span class="auth-ok f12">

          </span>
                </div>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">设置密码</span>
          </div>
                    <input type="password" name="password_01" class="input" placeholder="请设置6-20位密码">
          <div class="input_img pass_back"></div>
          <p class="reminder f13">
            安全程度：
            <span class="strength">弱</span>
            <span>中</span>
            <span>强</span>
          </p>
                </div>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">重复密码</span>
          </div>
                    <input type="password" name="password" class="input" placeholder="重复输入已设置的密码，两次密码要一致">
          <div class="input_img pass_back"></div>
                </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold"><?= $site_name_upper ?>店铺地址</span>
          </div>
          <span class="addr-title">Http://</span>
          <input type="text" name="link" id="link1" class="input addr-input f14" placeholder="请输入3-16位字母和数字，不可修改">
          <span>.<?= $server_main_domain ?></span>
          <p class="addr-tips f12">店铺地址是您在<?= $site_name_upper ?>上的真实地址，可进行直接输入地址访问</p>
          <span class="addr-ok">

          </span>
        </div>
        <p class="f16 bold fac-title">联系信息</p>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">商家名称</span>
          </div>
          <input type="text" name="factoryname" class="input f14" placeholder="请输入您的厂名（汉字、字母或数字）">
          <span class="addr-ok f12">

          </span>
                </div>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">档口地址</span>
          </div>
                    <input type="text" name="storeaddr" class="input f14" placeholder="请输入门店地址方便（采购商/服务商）拿货">
                </div>
                <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">厂址</span>
          </div>
          <input type="text" name="facaddr" class="input f14" placeholder="您是生产厂家，请输入厂址，便于认证服务">
                </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">联系人</span>
          </div>
          <input type="text" name="contact" class="input f14" placeholder="请填写真实姓名">
          <div class="input_img name_back"></div>
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">手机号码</span>
          </div>
          <input type="text" name="phonenumber" id="mobile2" class="input f14" placeholder="请输入您的手机号码">
          <div class="input_img phone_back"></div>
          <span class="phone-ok f12">

          </span>
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">QQ号码</span>
          </div>
          <input type="text" name="qqnumber" class="input f14" placeholder="请输入您的QQ号">
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">邮箱地址</span>
          </div>
          <input type="text" name="email" id="email2" class="input f14" placeholder="请输入您正确的邮箱地址"><span id="myemail2"></span>
          <span class="email-ok f12">

          </span>
        </div>
        <p class="f16 bold fac-title">公司信息</p>
                <div class="store">
                    <span class="bold fac_attr pull-left">经营性质</span>
                    <div class="chebox">
                        <div class="sto"><input type="checkbox" name="nature" class="checkbox" value="生产厂家">生产厂家</div>
                        <div class="sto"><input type="checkbox" name="nature" class="checkbox" value="门市销售">门市销售</div>
                        <div class="sto"><input type="checkbox" name="nature" class="checkbox" value="经销代理">经销代理</div>
                        <div class="sto"><input type="checkbox" name="nature" class="checkbox" value="个人">个人</div>
                    </div>                    
                </div>
                <div class="store">
                    <span class="bold fac_attr pull-left">生产规模</span>
                    <select class="worker-number" name="worker_number">
            <option value="1-5人">1-5人</option>
            <option value="5-20人">5-20人</option>
            <option value="20-50人">20-50人</option>
            <option value="50-100人">50-100人</option>
            <option value="100-200人">100-200人</option>
            <option value="200-500人">200-500人</option>
            <option value="500人以上">500人以上</option>
                    </select>
                </div>
                <div class="store">
                    <span class="bold fac_attr pull-left">发货设置</span>
                    <div class="chebox">
                        <div class="sto"><input type="checkbox" name="carry" class="checkbox" value="需要代发货">需要代发货</div>
                        <div class="sto"><input type="checkbox" name="carry" class="checkbox" value="自行发货">自行发货</div>
                    </div>                    
                </div>
                <div class="store">
                    <span class="bold fac_attr pull-left"><span class="must" style="font-weight: normal">*</span>分销招募</span>
                    <div class="chebox">
                        <div class="agency sto"><input type="checkbox" name="agency" class="checkbox check-sell check-pro" checked value="net">阅读并同意<a class="sell-protocol" >&lt;&lt;开通分销招募服务&gt;&gt;</a>，为网销代理供货&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
                        <div class="agency sto"><input type="checkbox" name="agency" class="checkbox check-sell check-role" checked value="招募淘宝店主">招募淘宝店主</div>
                        <div class="agency sto"><input type="checkbox" name="agency" class="checkbox check-sell check-role" checked value="招募微店/微商">招募微店/微商</div>
                        <div class="agency sto"><input type="checkbox" name="agency" class="checkbox check-sell check-role" checked value="招募实体店主">招募实体店主</div>
                    </div>                    
                </div>
        <div class="coding pad-top40">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">验证码</span>
          </div>
          <div class="code_agree">
            <input type="text" name="code" class="code input" placeholder="请按右图填写">
            <div class="coder">
                        <!-- 验证码制作 --> 
          
                      <img class="captcha1" src="/login/verify">
                    </div>
            <a class="refimg f12 captcha2 other-code">看不清楚，换一张</a>


            <!--<span class="auth-ok f12">-->
              <!--<img src="/img/auth-ok.png">-->
              <!--验证成功-->
            <!--</span>-->
            <!--<p class="invalid">验证失败，请重新输入</p>-->
            <div class="protocol f12">
              <input type="checkbox" name="agree" value="agree" checked>
              我已阅读并同意
              <a class="protocol-det">&lt;&lt;<?= $name ?>平台服务协议&gt;&gt;</a>
            </div>
          </div>
        </div>
                <div class="sub_aud">
                    <input class="submit fy18 audit" type="submit" value="提交审核">
                    <p class="f12">注册成功，即可成为供应商发布商品</p>
                    <p class="f12">通过<?= $name ?>市场人员审核认证后，前台才能展示。</p>
                </div>
            </form>
            <div class="ad_fac ad_right">
        <div class="slider slider02">
        </div>
            </div>
        </div>
        
        
        
        <!-- 服务商注册模块 -->
        <div class="detail_ser module">
            <form id="ser_form" class="reg-form" action="/register/registerAsDaiFa" method="post">
              <input type="hidden" name="_csrf" value="<?= $_csrf ?>"/>
              <!-- 用户类型 -->
              <input type="hidden" name="type" value="3"/>
        <p class="f16 bold fac-title">账户信息</p>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">用户名</span>
          </div>
          <input type="text" name="username" class="input f14 pull-left" placeholder="请设置2-20位汉字,字母,数字组合的用户名">
          <div class="input_img name_back"></div>
          <span class="auth-ok f12">

          </span>
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">设置密码</span>
          </div>
          <input type="password" name="password_01" class="input" placeholder="请设置6-20位密码">
          <div class="input_img pass_back"></div>
          <p class="reminder f13">
            安全程度：
            <span class="strength">弱</span>
            <span>中</span>
            <span>强</span>
          </p>
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">重复密码</span>
          </div>
          <input type="password" name="password" class="input" placeholder="重复输入已设置的密码，两次密码要一致">
          <div class="input_img pass_back"></div>
        </div>

        <p class="f16 bold fac-title">联系信息</p>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">联系人</span>
          </div>
          <input type="text" name="contact" class="input f14" placeholder="请填写真实姓名">
          <div class="input_img name_back"></div>
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">手机号码</span>
          </div>
          <input type="text" name="phonenumber" id="mobile3" class="input f14" placeholder="请输入您的手机号码">
          <div class="input_img phone_back"></div>
          <span class="phone-ok f12">

          </span>
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">QQ号码</span>
          </div>
          <input type="text" name="qqnumber" class="input f14" placeholder="请输入您的QQ号">
        </div>
        <div class="det_message">
          <div class="left-contain pull-left">
            <span class="bold">邮箱地址</span>
          </div>
          <input type="text" name="email" id="email3" class="input f14" placeholder="请输入您正确的邮箱地址"><span id='myemail3'></span>
          <span class="email-ok f12">

          </span>
        </div>
        <p class="f16 bold fac-title">公司信息</p>
        <div class="store">
          <div class="fac_attr pull-left">
            <span class="must">*</span>
            <span class="bold pull-right">服务性质</span>
          </div>
          <div class="chebox">
            <div class="sto"><input type="radio" checked="checked" name="serverteam" class="checkbox" value="团队">团队</div>
            <div class="sto"><input type="radio" name="serverteam" class="checkbox" value="公司">公司</div>
            <div class="sto"><input type="radio" name="serverteam" class="checkbox" value="个人">个人</div>
          </div>
        </div>
        <div class="coding">
          <div class="left-contain pull-left">
            <span class="must">*</span>
            <span class="bold">验证码</span>
          </div>
          <div class="code_agree">
            <input type="text" name="code" class="code input" placeholder="请按右图填写">
            <div class="coder">
                        <!-- 验证码制作 --> 
          
                      <img class="captcha1" src="/login/verify">
                    </div>
            <a class="refimg f12 captcha2 other-code">看不清楚，换一张</a>


            <div class="protocol f12">
              <input type="checkbox" name="agree" value="agree" checked>
              我已阅读并同意
              <a class="protocol-det">&lt;&lt;<?= $name ?>平台服务协议&gt;&gt;</a>
            </div>
          </div>
        </div>
        <div class="sub_aud">
          <input class="submit fy18 audit" type="submit" value="提交审核">
          <p class="f12">开通服务商资格需注册通过后进行实名认证，方可发布服务信息</p>
          <p class="f12">申请服务商认证，请根据服务规则提供相应<a class="auth-data">认证材料</a></p>
        </div>
            </form>
            <div class="ad_ser ad_right">
        <div class="slider slider03">
        </div>
            </div>
        </div>
  <!-- 弹窗背景-->
  <div class="back-tran"></div>
  <!-- <?= $name ?>服务协议弹窗-->
  <div class="modal" id="register-protocol">
    <div class="add-content">
      <div class="modal-head">
        <button type="button" class="closebtn j_close">×</button>
        <p class="fy22 add-titles"><?= $name ?>平台服务协议</p>
      </div>
      <div class="modal-contents">
        <h3 class="f14 md-title bold">提示条款</h3>
        <p class="det-con f12">欢迎您与各<?= $name ?>平台经营者（详见定义条款）共同签署本《<?= $name ?>平台服务协议》（下称“本协议”）并使用<?= $name ?>平台服务！</p>
        <p class="det-con f12">自本协议发布之日起，<?= $name ?>平台各处所称“<?= $name ?>服务协议”均指本协议。</p>
        <p class="det-con f12">各服务条款前所列索引关键词仅为帮助您理解该条款表达的主旨之用，不影响或限制本协议条款的含义或解释。为维护您自身权益，建议您仔细阅读各条款具体表述。</p>
        <p class="det-con f12"><b>【审慎阅读】</b>您在申请注册流程中点击同意前，应当认真阅读以下协议。<b>请您务必审慎阅读、充分理解协议中相关条款内容，其中包括：</b></p>
        <p class="det-con f12"><b>1、与您约定免除或限制责任的条款；</b></p>
        <p class="det-con f12"><b>2、与您约定法律适用和管辖的条款；</b></p>
        <p class="det-con f12"><b>3、其他以粗体下划线标识的重要条款。</b></p>
        <p class="det-con f12">如您对协议有任何疑问，可向平台客服咨询。</p>
        <p class="det-con f12"><b>【签约动作】</b>当您按照注册页面提示填写信息、阅读并同意协议且完成全部注册程序后，即表示您已充分阅读、理解并接受协议的全部内容。如您因平台服务与<?= $name ?>发生争议的，适用《<?= $name ?>平台服务协议》处理。如您在使用平台服务过程中与其他用户发生争议的，依您与其他用户达成的协议处理。</p>
        <p class="det-con f12"><b>阅读本协议的过程中，如果您不同意本协议或其中任何条款约定，您应立即停止注册程序。</b></p>
        <h3 class="f14 md-title bold">一、 &nbsp;定义</h3>
        <p class="det-con f12"><b><?= $name ?>平台：</b>指成都星购途信息技术有限公司（以下简称<?= $name ?>）经营的<?= $name ?>（域名为 <?= $server_main_domain ?>）网站。</p>
        <p class="det-con f12"><b><?= $name ?>平台服务：</b><?= $name ?>基于互联网，以包含<?= $name ?>平台网站在内的各种形态（包括未来技术发展出现的新的服务形态）向您提供的各项服务。</p>
        <p class="det-con f12"><b><?= $name ?>平台规则：</b>包括在所有<?= $name ?>平台规则内已经发布及后续发布的全部规则、解读、公告等内容以及<?= $name ?>各平台在论坛、帮助中心内发布的各类规则、实施细则、产品流程说明、公告等。</p>
        <p class="det-con f12"><b>同一用户：</b>使用同一身份认证信息或经<?= $name ?>排查认定多个<?= $name ?>账户的实际控制人为同一人的，均视为同一用户。</p>
        <h3 class="f14 md-title bold">二、&nbsp;协议范围</h3>
        <h4>2.1&nbsp;签约主体</h4>
        <p class="det-con f12"><b>【平等主体】</b>本协议由您与<?= $name ?>平台经营者共同缔结，本协议对您与<?= $name ?>平台经营者均具有合同效力。</p>
        <p class="det-con f12"><b>【主体信息】</b><?= $name ?>平台经营者是指经营<?= $name ?>平台的各法律主体，本协议项下，<b><?= $name ?>平台经营者可能根据<?= $name ?>平台的业务调整而发生变更，变更后的<?= $name ?>平台经营者与您共同履行本协议并向您提供服务，<?= $name ?>平台经营者的变更不会影响您本协议项下的权益。<?= $name ?>平台经营者还有可能因为提供新的<?= $name ?>平台服务而新增，如您使用新增的<?= $name ?>平台服务的，视为您同意新增的<?= $name ?>平台经营者与您共同履行本协议。发生争议时，您可根据您具体使用的服务及对您权益产生影响的具体行为对象确定与您履约的主体及争议相对方。</b></p>
        <h3 class="f14 md-title bold">三、&nbsp;账户注册与使用</h3>
        <h4>3.1&nbsp;用户资格</h4>
        <p class="det-con f12">您确认，在您开始注册程序使用<?= $name ?>平台服务前，您应当具备中华人民共和国法律规定的与您行为相适应的民事行为能力。<b>若您不具备前述与您行为相适应的民事行为能力，则您及您的监护人应依照法律规定承担因此而导致的一切后果。</b></p>
        <h4>3.2&nbsp;账户说明</h4>
        <p class="det-con f12"><b>【账户获得】</b>当您按照注册页面提示填写信息、阅读并同意本协议且完成全部注册程序后，您可获得<?= $name ?>平台账户并成为<?= $name ?>平台用户。</p>
        <p class="det-con f12"><b>【账户使用】</b>您有权使用您设置或确认的<?= $name ?>会员名、邮箱、手机号码（以下简称“账户名称”）及您设置的密码（账户名称及密码合称“账户”）登录<?= $name ?>平台。</p>
        <p class="det-con f12"><b>【账户转让】</b>由于用户账户关联用户信用信息，仅当有法律明文规定、司法裁定或经<?= $name ?>同意，并符合<?= $name ?>平台规则规定的用户账户转让流程的情况下，您可进行账户的转让。您的账户一经转让，该账户项下权利义务一并转移。<b>除此外，您的账户不得以任何方式转让，否则由此产生的一切责任均由您承担。</b></p>
        <h4>3.3&nbsp;注册信息管理</h4>
        <h5>3.3.1&nbsp;真实合法</h5>
        <p class="det-con f12"><b>【信息真实】</b>在使用<?= $name ?>平台服务时，您应当按<?= $name ?>平台页面的提示准确完整地提供您的信息（包括您的姓名及电子邮件地址、联系电话、联系地址等），以便<?= $name ?>或其他用户与您联系。<b>您了解并同意，您有义务保持您提供信息的真实性及有效性。</b></p>
        <p class="det-con f12"><b>【会员名的合法性】您设置的<?= $name ?>会员名不得违反国家法律法规及<?= $name ?>规则关于会员名的管理规定，否则<?= $name ?>可回收您的<?= $name ?>会员名。</b><?= $name ?>会员名的回收不影响您以邮箱、手机号码登录<?= $name ?>平台并使用<?= $name ?>平台服务。</p>
        <h5>3.3.2&nbsp;更新维护</h5>
        <p class="det-con f12">您应当及时更新您提供的信息，在法律有明确规定要求<?= $name ?>作为平台服务提供者必须对部分用户（如平台卖家等）的信息进行核实的情况下，<?= $name ?>将依法不时地对您的信息进行检查核实，您应当配合提供最新、真实、完整的信息。</p>
        <p class="det-con f12"><b>如<?= $name ?>按您最后一次提供的信息与您联系未果、您未按<?= $name ?>的要求及时提供信息、您提供的信息存在明显不实的，您将承担因此对您自身、他人及<?= $name ?>造成的全部损失与不利后果。</b></p>
        <h4>3.4&nbsp;账户安全规范</h4>
        <p class="det-con f12"><b>【账户安全保管义务】</b>您的账户为您自行设置并由您保管，<?= $name ?>及其工作人员任何时候均不会主动要求您提供您的账户和密码。因此，建议您务必保管好您的账户，并确保您在每个上网时段结束时退出登录并以正确步骤离开<?= $name ?>平台。</p>
        <p class="det-con f12"><b>账户因您主动或保管不善泄露或遭受他人攻击、诈骗等行为导致的损失及后果，均由您自行承担。</b></p>
        <p class="det-con f12"><b>【账户行为责任自负】</b>除<?= $name ?>存在过错外，<b>您账户项下的所有行为（包括但不限于在线签署各类协议、发布信息、购买商品及服务及披露信息等）均视为您本人的行为，并由您承担相应后果。</b></p>
        <p class="det-con f12"><b>【日常维护须知】</b>如发现任何未经授权使用您账户登录<?= $name ?>平台或其他可能导致您账户遭窃、遗失的情况，建议您立即通知<?= $name ?>。<b>您理解<?= $name ?>对您的任何请求采取行动均需要合理时间，除<?= $name ?>存在过错外，<?= $name ?>对在采取行动前已经产生的后果不承担任何责任。</b></p>
        <h3 class="f14 md-title bold">四、&nbsp;<?= $name ?>平台服务及规范</h3>
        <p class="det-con f12"><b>【服务概况】</b>您有权在<?= $name ?>平台上享受店铺管理、商品及/或服务的销售与推广、商品及/或服务的购买与评价、交易争议处理等服务，具体功能以<?= $name ?>平台的说明为准。</p>
        <h4>4.1&nbsp;店铺管理</h4>
        <p class="det-con f12"><b>【店铺创建】</b>通过在<?= $name ?>创建店铺，您可发布生产直销或代理经销商品及/或服务信息并与其他用户达成交易。</p>
        <p class="det-con f12"><b>【店铺转让】</b>由于店铺转让实质为店铺经营者账户的转让，店铺转让的相关要求与限制请适用本协议3.2条账户转让条款。</p>
        <h4>4.2&nbsp;商品及/或服务的销售与推广</h4>
        <p class="det-con f12"><b>【商品及/或服务信息发布】</b>通过<?= $name ?>提供的服务，您有权通过文字、图片等形式在<?= $name ?>平台上发布商品及/或服务信息，招揽和物色交易对象、达成交易。</p>
        <p class="det-con f12"><b>【禁止销售范围】</b>您应当确保您对您在<?= $name ?>平台上发布的商品及/或服务享有相应的权利，<b>您不得在<?= $name ?>平台上销售以下商品及/或提供以下服务：</b></p>
        <p class="det-con f12"><b>（一）国家禁止或限制的；</b></p>
        <p class="det-con f12"><b>（二）侵犯他人知识产权或其它合法权益的；</b></p>
        <p class="det-con f12"><b>（三）<?= $name ?>平台规则或各平台与您单独签署的协议中已明确说明不适合在<?= $name ?>平台上销售及/或提供的。</b></p>
        <p class="det-con f12"><b>【交易秩序保障】</b>您应当遵守诚实信用原则，确保您所发布的商品及/或服务信息真实、与您实际所销售的商品及/或提供的服务相符，并在交易过程中切实履行您的交易承诺。您应当维护<?= $name ?>平台市场良性竞争秩序，不得贬低、诋毁竞争对手，不得干扰<?= $name ?>平台上进行的任何交易、活动，不得以任何不正当方式提升或试图提升自身的信用度，不得以任何方式干扰或试图干扰<?= $name ?>平台的正常运作。</p>
        <p class="det-con f12"><b>【促销及推广】</b>您有权自行决定商品及/或服务的促销及推广方式，<?= $name ?>亦为您提供了形式丰富的促销推广工具。<b>您的促销推广行为应当符合国家相关法律法规及<?= $name ?>平台的要求。</b></p>
        <p class="det-con f12"><b>【依法纳税】依法纳税是每一个公民、企业应尽的义务，您应对销售额/营业额超过法定免征额部分及时、足额地向税务主管机关申报纳税。</b></p>
        <h4>4.3&nbsp;商品及/或服务的购买与评价</h4>
        <p class="det-con f12"><b>【商品及/或服务的购买】</b>当您在<?= $name ?>平台购买商品及/或服务时，请您务必仔细确认所购商品的品名、价格、数量、型号、规格、尺寸或服务的时间、内容、限制性要求等重要事项，并在下单时核实联系地址、电话、收货人等信息。<b>如非您本人进行发货，而是由代发组织进行发货，则在收货过程中所产生的法律后果均由您和代发组织进行协调承担。</b></p>
        <p class="det-con f12"><b>【评价】</b>您有权在<?= $name ?>平台提供的评价系统中对与您达成交易的其他用户商品及/或服务进行评价。您应当理解，您在<?= $name ?>平台的评价信息是公开的，如您不愿意在评价信息中向公众披露您的身份信息，您有权选择通过匿名形式发表评价内容。</p>
        <p class="det-con f12">您的所有评价行为应遵守<?= $name ?>平台规则的相关规定，评价内容应当客观真实，不应包含任何污言秽语、色情低俗、广告信息及法律法规与本协议列明的其他禁止性信息；您不应以不正当方式帮助他人提升信用或利用评价权利对其他用户实施威胁、敲诈勒索。<b><?= $name ?>可按照<?= $name ?>平台规则的相关规定对您实施上述行为所产生的评价信息进行删除或屏蔽。</b></p>
        <h4>4.4&nbsp;交易争议处理</h4>
        <p class="det-con f12"><b>【交易争议处理途径】</b>您在<?= $name ?>平台交易过程中与其他用户发生争议的，您或其他用户中任何一方均有权选择以下途径解决：</p>
        <p class="det-con f12">（一）与争议相对方自主协商；</p>
        <p class="det-con f12">（二）使用<?= $name ?>平台提供的争议调处服务；</p>
        <p class="det-con f12">（三）请求消费者协会或者其他依法成立的调解组织调解；</p>
        <p class="det-con f12">（四）向有关行政部门投诉；</p>
        <p class="det-con f12">（五）根据与争议相对方达成的仲裁协议（如有）提请仲裁机构仲裁；</p>
        <p class="det-con f12">（六）向人民法院提起诉讼。</p>
        <p class="det-con f12"><b>【平台调处服务】</b>如您选择使用<?= $name ?>平台的争议调处服务，则表示您认可<?= $name ?>平台的客服或大众评审员（二者统称“调处方”）以非专业人士的标准根据其所了解到的争议事实并依据<?= $name ?>平台规则所作出的调处决定（包括调整相关订单的交易状态、判定将争议款项的全部或部分支付给交易一方或双方等）。在<?= $name ?>平台调处决定作出前，您可选择其他途径解决争议以中止<?= $name ?>平台的争议调处服务。</p>
        <p class="det-con f12"><b>如您对调处决定不满意，您仍有权采取其他争议处理途径解决争议，但通过其他争议处理途径未取得终局决定前，您仍应先履行调处决定。</b></p>
        <h4>4.5&nbsp;费用</h4>
        <p class="det-con f12"><?= $name ?>为<?= $name ?>平台向您提供的服务付出了大量的成本，除<?= $name ?>平台明示的收费业务外，<?= $name ?>向您提供的服务目前是免费的。如未来<?= $name ?>向您收取合理费用，<?= $name ?>会采取合理途径并以足够合理的期限提前通过法定程序并以本协议第八条约定的方式通知您，确保您有充分选择的权利。</p>
        <h4>4.6&nbsp;责任限制</h4>
        <p class="det-con f12"><b>【不可抗力】</b><?= $name ?>依法律规定承担基础保障义务，但<b>无法对由于信息网络设备维护、连接故障，电脑、通讯或其他系统的故障，电力故障，罢工，暴乱，火灾，洪水，风暴，爆炸，战争，黑客攻击，政府行为，司法行政机关的命令或因第三方原因而给您造成的损害结果承担责任。</b></p>
        <p class="det-con f12"><b>【海量信息】</b><?= $name ?>仅向您提供<?= $name ?>平台服务，您了解<?= $name ?>平台上的信息系用户自行发布，且可能存在风险和瑕疵。<b>鉴于<?= $name ?>平台具备存在海量信息及信息网络环境下信息与实物相分离的特点，<?= $name ?>无法逐一审查商品及/或服务的信息，亦没有对用户所发布的交易信息的合法性、真实性、准确性作出任何形式的保证或承诺。</b></p>
        <p class="det-con f12"><b>【调处决定】</b>您理解并同意，在争议调处服务中，<?= $name ?>平台的客服、大众评审员并非专业人士，仅能以普通人的认知对用户提交的凭证进行判断。因此，您理解并同意<b>调处方对争议调处决定免责。</b></p>
        <h3 class="f14 md-title bold">五、&nbsp;用户信息的保护及授权</h3>
        <h4>5.1&nbsp;个人信息的保护</h4>
        <p class="det-con f12"><?= $name ?>非常重视用户个人信息（即能够独立或与其他信息结合后识别用户身份的信息）的保护，在您使用<?= $name ?>提供的服务时，您同意<?= $name ?>按照在<?= $name ?>平台上公布的隐私权政策收集、存储、使用、披露和保护您的个人信息，以帮助您更好地保护您的隐私权。</p>
        <h4>5.2&nbsp;非个人信息的保证与授权</h4>
        <p class="det-con f12"><b>【信息的发布】</b>您声明并保证，您对您所发布的信息拥有相应、合法的权利。否则，<b><?= $name ?>可对您发布的信息依法或依本协议进行删除或屏蔽。</b></p>
        <p class="det-con f12"><b>【禁止性信息】您应当确保您所发布的信息不包含以下内容：</b></p>
        <p class="det-con f12"><b>（一）违反国家法律法规禁止性规定的；</b></p>
        <p class="det-con f12"><b>（二）政治宣传、封建迷信、淫秽、色情、赌博、暴力、恐怖或者教唆犯罪的；</b></p>
        <p class="det-con f12"><b>（三）欺诈、虚假、不准确或存在误导性的；</b></p>
        <p class="det-con f12"><b>（四）侵犯他人知识产权或涉及第三方商业秘密及其他专有权利的；</b></p>
        <p class="det-con f12"><b>（五）侮辱、诽谤、恐吓、涉及他人隐私等侵害他人合法权益的；</b></p>
        <p class="det-con f12"><b>（六）存在可能破坏、篡改、删除、影响<?= $name ?>平台任何系统正常运行或未经授权秘密获取<?= $name ?>平台及其他用户的数据、个人资料的病毒、木马、爬虫等恶意软件、程序代码的；</b></p>
        <p class="det-con f12"><b>（七）其他违背社会公共利益或公共道德或依据相关<?= $name ?>平台协议、规则的规定不适合在<?= $name ?>平台上发布的。</b></p>
        <p class="det-con f12"><b>【授权使用】</b>对于您提供及发布除个人信息外的文字、图片等非个人信息，<b>在版权保护期内您免费授予<?= $name ?>获得全球排他的许可使用权利及再授权给其他第三方使用的权利。您同意<?= $name ?>存储、使用、复制、修订、编辑、发布、展示、翻译、分发您的非个人信息或制作其派生作品，并以已知或日后开发的形式、媒体或技术将上述信息纳入其它作品内。</b></p>
        <p class="det-con f12">为方便您使用<?= $name ?>平台其他相关服务，<b>您授权<?= $name ?>将您在账户注册和使用<?= $name ?>平台服务过程中提供、形成的信息传递给相关服务提供者，或从其他相关服务提供者获取您在注册、使用相关服务期间提供、形成的信息。</b></p>
        <h3 class="f14 md-title bold">六、&nbsp;用户的违约及处理</h3>
        <h4>6.1&nbsp;违约认定</h4>
        <p class="det-con f12">发生如下情形之一的，视为您违约：</p>
        <p class="det-con f12">（一）使用<?= $name ?>平台服务时违反有关法律法规规定的；</p>
        <p class="det-con f12">（二）违反本协议约定的。</p>
        <p class="det-con f12">为适应电子商务发展和满足海量用户对高效优质服务的需求，您理解并同意，<b><?= $name ?>可在<?= $name ?>平台规则中约定违约认定的程序和标准。如：<?= $name ?>可依据您的常规用户数据与突然增长的海量用户数据的关系来认定您是否构成违约；您有义务对您的短时间内突然增长的数据异常现象进行充分举证和合理解释，否则将被认定为违约。</b></p>
        <h4>6.2&nbsp;违约处理措施</h4>
        <p class="det-con f12"><b>【信息处理】</b>您在<?= $name ?>平台上发布的信息构成违约的，<b><?= $name ?>可根据相应规则立即对相应信息进行删除、屏蔽处理或对您的商品进行下架、监管。</b></p>
        <p class="det-con f12"><b>【行为限制】</b>您在<?= $name ?>平台上实施的行为，或虽未在<?= $name ?>平台上实施但对<?= $name ?>平台及其用户产生影响的行为构成违约的，<?= $name ?><b>可依据相应规则对您执行账户扣分、限制参加营销活动、中止向您提供部分或全部服务、划扣违约金、停封账号、停止服务等处理措施。</b></p>
        <p class="det-con f12"><b>【处理结果公示】<?= $name ?>可将对您上述违约行为处理措施信息以及其他经国家行政或司法机关生效法律文书确认的违法信息在<?= $name ?>平台上予以公示。</b></p>
        <h4>6.3&nbsp;赔偿责任</h4>
        <p class="det-con f12"><b>1.如您的行为使<?= $name ?>遭受损失（包括自身的直接经济损失、商誉损失及对外支付的赔偿金、和解款、律师费、诉讼费等间接经济损失），您应赔偿<?= $name ?>的上述全部损失。</b></p>
        <p class="det-con f12"><b>2.如您的行为使<?= $name ?>遭受第三人主张权利，<?= $name ?>可在对第三人承担金钱给付等义务后就全部损失向您追偿。</b></p>
        <h4>6.4&nbsp;特别约定</h4>
        <p class="det-con f12"><b>【商业贿赂】</b>如您向<?= $name ?>的雇员或顾问等提供实物、现金、现金等价物、劳务、旅游等价值明显超出正常商务洽谈范畴的利益，则可视为您存在商业贿赂行为。<b>发生上述情形的，<?= $name ?>可立即终止与您的所有合作并向您收取违约金及/或赔偿金，</b>该等金额以<?= $name ?>因您的贿赂行为而遭受的经济损失和商誉损失作为计算依据。</p>
        <p class="det-con f12"><b>【关联处理】如<?= $name ?>与您签署的协议中明确约定了对您在本协议项下合作进行关联处理的情形，则<?= $name ?>出于维护平台秩序及保护消费者权益的目的，中止甚至终止协议，并以本协议第九条约定的方式通知您。</b></p>
        <h3 class="f14 md-title bold">七、&nbsp;协议的变更</h3>
        <p class="det-con f12"><?= $name ?>可根据国家法律法规变化及维护交易秩序、保护消费者权益需要，不时修改本协议，变更后的协议（下称“变更事项”）将通过法定程序并以本协议第九条约定的方式通知您。</p>
        <p class="det-con f12">如您不同意变更事项，您有权于变更事项确定的生效日前联系<?= $name ?>反馈意见。如反馈意见得以采纳，<?= $name ?>将酌情调整变更事项。</p>
        <p class="det-con f12"><b>如您对已生效的变更事项仍不同意的，您应当于变更事项确定的生效之日起停止使用<?= $name ?>平台服务，变更事项对您不产生效力；如您在变更事项生效后仍继续使用<?= $name ?>平台服务，则视为您同意已生效的变更事项。</b></p>
        <h3 class="f14 md-title bold">八、&nbsp;责任范围</h3>
        <p class="det-con f12"><b>8.1<?= $name ?>不对您及其它用户在<?= $name ?>平台所发布的信息所涉及的信息的是否合法、准确、有效、可靠以及其质量、稳定、完整和及时性作出任何承诺和保证。</b></p>
        <p class="det-con f12"><b>8.2您知悉<?= $name ?>平台上的交易信息系其他用户自行发布，且最终由其他用户履行相关义务，其中可能存在风险和瑕疵。购图提醒您应自行谨慎判定相关物品及/或信息的真实性、合法性和有效性，并由您自行承担因此产生的可能责任与损失。</b></p>
        <p class="det-con f12"><b>8.3购图平台仅作为交易信息的发布平台，并不作为交易双方之任何一方的身份参与交易，且<?= $name ?>不负责对交易履行核查、无法控制交易所涉及的产品质量、服务质量，无法保证交易各方履行其在口头或书面所达成的协议中各项义务的能力。</b></p>
        <h3 class="f14 md-title bold">九、&nbsp;通知</h3>
        <p class="det-con f12">您同意<?= $name ?>以以下合理的方式向您送达各类通知：</p>
        <p class="det-con f12">（一）<?= $name ?>按照注册账户时填写地址发出邮件或快递后的第3日，视为通知已送达您。发出日期以快递公司签收日为准。</p>
        <p class="det-con f12">（二）<?= $name ?>按照您注册账户时所填写的电子邮箱发出电子邮件后，视为通知已经送达用户。</p>
        <p class="det-con f12">（三）<?= $name ?>按照您注册账户时填写的电话号码通知您，如届时电话号码无效或联系人错误则仍以以上两种方式之一进行通知。</p>
        <h3 class="f14 md-title bold">十、&nbsp;协议的终止</h3>
        <h4>10.1&nbsp;终止的情形</h4>
        <p class="det-con f12"><b>【用户发起的终止】</b>您有权通过以下任一方式终止本协议：</p>
        <p class="det-con f12">（一）在满足<?= $name ?>平台公示的账户注销条件时您通过网站自助服务注销您的账户的；</p>
        <p class="det-con f12">（二）变更事项生效前您停止使用并明示不愿接受变更事项的；</p>
        <p class="det-con f12">（三）您明示不愿继续使用<?= $name ?>平台服务，且符合<?= $name ?>平台终止条件的。</p>
        <p class="det-con f12"><b>【<?= $name ?>发起的终止】</b>出现以下情况时，<?= $name ?>可以本协议第九条的所列的方式通知您终止本协议：</p>
        <p class="det-con f12">（一）您违反本协议约定，<?= $name ?>依据违约条款终止本协议的；</p>
        <p class="det-con f12">（二）您发布违禁信息、骗取他人财物、售假、扰乱市场秩序、采取不正当手段谋利等行为，<?= $name ?>依据<?= $name ?>平台规则对您的账户予以查封的；</p>
        <p class="det-con f12">（三）除上述情形外，因您违反<?= $name ?>平台规则相关规定且情节严重，<?= $name ?>依据<?= $name ?>平台规则对您的账户予以查封的；</p>
        <p class="det-con f12">（四）您在购图平台有欺诈、发布或销售假冒伪劣/侵权商品、侵犯他人合法权益或其他严重违法违约行为的；</p>
        <p class="det-con f12">（五）其它应当终止服务的情况。</p>
        <h4>10.2&nbsp;协议终止后的处理</h4>
        <p class="det-con f12"><b>【用户信息披露】本协议终止后，除法律有明确规定外，<?= $name ?>无义务向您或您指定的第三方披露您账户中的任何信息。</b></p>
        <p class="det-con f12"><b>【<?= $name ?>权利】</b>本协议终止后，<?= $name ?>仍享有下列权利：</p>
        <p class="det-con f12">（一）继续保存您留存于<?= $name ?>平台的本协议第五条所列的各类信息；</p>
        <p class="det-con f12">（二）对于您过往的违约行为，<?= $name ?>仍可依据本协议向您追究违约责任。</p>
        <p class="det-con f12"><b>【交易处理】本协议终止后，对于您在本协议存续期间产生的交易订单，<?= $name ?>可通知交易相对方并根据交易相对方的意愿决定是否关闭该等交易订单；如交易相对方要求继续履行的，则您应当就该等交易订单继续履行本协议及交易订单的约定，并承担因此产生的任何损失或增加的任何费用。</b></p>
        <h3 class="f14 md-title bold">十一、&nbsp;法律适用、管辖与其他</h3>
        <p class="det-con f12"><b>【法律适用】本协议之订立、生效、解释、修订、补充、终止、执行与争议解决均适用中华人民共和国大陆地区法律；如法律无相关规定的，参照商业惯例及/或行业惯例。</b></p>
        <p class="det-con f12"><b>【管辖】您因使用<?= $name ?>平台服务所产生及与<?= $name ?>平台服务有关的争议，由<?= $name ?>与您协商解决。协商不成时，任何一方均可向<?= $name ?>注册地人民法院提起诉讼。</b></p>
        <p class="det-con f12"><b>【可分性】</b>本协议任一条款被视为废止、无效或不可执行，该条应视为可分的且并不影响本协议其余条款的有效性及可执行性。</p>
        <p class="det-con f12"><b>【生效】</b>本协议经用户在线点击“我已仔细阅读并同意本协议全部条款”后生效。</p>
      </div>
      <div class="modal-footers">
        <button type="button" class="sure-btn protocol-sure fy16"><span>我已阅读并同意</span></button>
      </div>
    </div>
  </div>
  <!-- <?= $name ?>分销合作协议书-->
  <div class="modal" id="sell-protocol">
    <div class="add-content">
      <div class="modal-head">
        <button type="button" class="closebtn j_close">×</button>
        <p class="fy22 add-titles"><?= $name ?>分销合作协议书</p>
      </div>
      <div class="modal-contents">
        <p class="det-con f12" style="line-height: 30px;margin-top: 15px;">甲方：  <?= $name ?>供应商会员     （以下简称“甲方”）</p>
        <p class="det-con f12" style="line-height: 30px;margin-bottom: 15px;">乙方：  <?= $name ?>分销商会员     （以下简称“乙方”）</p>
        <p class="det-con f12">根据我国相关法律的规定，甲、乙双方经友好协商，在平等、自愿、公平、诚信、守法的原则下就甲、乙双方进行网络分销合作的具体事宜，达成如下一致协议：</p>
        <h3 class="f14 md-title bold">一、合作内容</h3>
        <p class="det-con f12">甲乙双方在资源共享和双赢的基础上进行合作。甲方按双方约定的价格提供分销商品，利用乙方的网店资源进行网络分销，并承诺按乙方提供地址按时发货；乙方负责介绍分销商品并促成交易成功。</p>
        <h3 class="f14 md-title bold">二、合作期限</h3>
        <p class="det-con f12">从协议签定之日起，有效期为1年，本协议约定的合作期限届满前一个月，双方可协商约定是否继续签约，否则双方权利义务关系至合同到期日即终止。</p>
        <h3 class="f14 md-title bold">三、商品质量</h3>
        <p class="det-con f12">1.&nbsp;甲方供应的分销商品质量应当符合中华人民共和国相关法律法规规定或行业规定的质量标准。</p>
        <p class="det-con f12">2.&nbsp;分销商品须与甲方事先所提供的样品或双方在正式合作前约定质量、品种及规格相符。</p>
        <p class="det-con f12">3.&nbsp;在售后服务期内，甲方的售后服务细则及标准，按甲方经营网店（<?= $name ?>平台的店铺）之标准规范执行。如遇特殊情形，可双方另行协商。</p>
        <p class="det-con f12">4.&nbsp;因分销商品的售后服务所产生的费用，可由乙方先行垫付，经甲方确认同意后，可由甲方直接给付乙方。</p>
        <h3 class="f14 md-title bold">四、交货</h3>
        <p class="det-con f12">1.&nbsp;交货地点：甲方按乙方指定地址自行发货或者交由代发机构发货。</p>
        <p class="det-con f12">2.&nbsp;运输方式；采用快递方式，运输费乙方承担。</p>
        <h3 class="f14 md-title bold">五、结算</h3>
        <p class="det-con f12">甲乙双方的交易，结算行为均属线下行为，与<?= $name ?>平台无关。双方在交易过程中出现交易纠纷应自行协商解决。</p>
        <h3 class="f14 md-title bold">六、双方的权责</h3>
        <p class="det-con f12">1.&nbsp;甲方的责任与义务：</p>
        <p class="det-con f12" style="text-indent: 20px;">1）甲方承诺在接到乙方订单请求时，在甲乙双方共同约定工作日内，按乙方提供地址发货。</p>
        <p class="det-con f12" style="text-indent: 20px;">2）甲方应根据乙方的需要提供推动分销商品的销售资料以及信息，协助乙方获得必要的产品说明。</p>
        <p class="det-con f12" style="text-indent: 20px;">3）甲方有权监督产品的销售，并要求乙方予以改进，乙方须配合解决问题。</p>
        <p class="det-con f12" style="text-indent: 20px;">4）甲方更改分销商品供货价格，须提前通知乙方。</p>
        <p class="det-con f12" style="text-indent: 20px;">5）在协议有效期内，甲方不可以无故干扰乙方的分销工作。</p>
        <p class="det-con f12">2.&nbsp;乙方的责任与义务：</p>
        <p class="det-con f12" style="text-indent: 20px;">1）乙方须通过不断完善、提高自身服务质量，提升其销售量。</p>
        <p class="det-con f12" style="text-indent: 20px;">2）乙方必须尊重甲方的商标权等知识产权。</p>
        <p class="det-con f12" style="text-indent: 20px;">3）乙方所使用甲方提供的资料和物品不得用于与双方所商定合作事项无关的事务上。</p>
        <p class="det-con f12" style="text-indent: 20px;">4）乙方确保不单方面使用甲方任何产品、资料、做与品牌网络分销无关的事宜。</p>
        <p class="det-con f12" style="text-indent: 20px;">5）乙方不得有损甲方的形象及声誉。因此而造成甲方的形象或声誉损害的，甲方有权随时终止协议，并追究乙方法律责任。</p>
        <p class="det-con f12" style="text-indent: 20px;">6）乙方不得随意对甲方产品进行变更或修改甲方产品的任何资料。因此而造成甲方权益损失的，甲方有权终止协议，并追究乙方的法律责任。</p>
        <h3 class="f14 md-title bold">七、保密协定</h3>
        <p class="det-con f12">1.&nbsp;除法律规定必须公开的资料以外，乙方不得向第三方展示甲方递交的有关资料和有损于甲方利益的情报。甲方不得向第三方泄漏乙方按本协议规定提供给甲方的经营秘密及有损乙方利益的情报。乙方有责任保证其员工不向第三方泄漏甲方秘密。</p>
        <p class="det-con f12">2.&nbsp;以上规定双方的保密义务在本协议期满后仍然有效。</p>
        <p class="det-con f12">3.&nbsp;甲乙任何一方违反上述保密义务，应当赔偿因此给对方造成的全部损失。</p>
        <h3 class="f14 md-title bold">八、协议的终止</h3>
        <p class="det-con f12">1.&nbsp;甲乙双方应按照本协议规定履行义务。如果甲乙任何一方违反本协议规定，并在对方发出书面通知之日起五个工作日内仍未及时改正的，非违约方有权取消违约方的合作资格，并可无条件终止本协议。</p>
        <p class="det-con f12">2.&nbsp;乙方如想单方面终止本协议，需向甲方提出书面申请材料，说明解除协议的原因，获得甲方批准后，本协议终止。</p>
        <h3 class="f14 md-title bold">九、通知送达</h3>
        <p class="det-con f12">1.&nbsp;任何一方向另一方发出与本协议有关的通知，可以挂号信、特快专递、电子邮件等方式发往另一方在甲乙双方网站上所确认的通知地址。通知被视为收到的日期约定如下：</p>
        <p class="det-con f12" style="text-indent: 20px;">1）以挂号信件发出的，投递日（以邮戳为准）后的第7天视为收件日期。</p>
        <p class="det-con f12" style="text-indent: 20px;">2）以特快专递发出的，发出当日（以快递公司签收日为准）后的第3天视为收件日期。</p>
        <p class="det-con f12" style="text-indent: 20px;">3）以电子邮件发出的，发出当日视为收件日期。</p>
        <p class="det-con f12">2.&nbsp;各方确认通知地址为甲乙双方网站上所确认的地址，如果一方的通知地址发生变更，该方应将其通知地址变更的情况按上述方式通知其他各方后，该方的新通知地址生效。</p>
        <p class="det-con f12">3.&nbsp;若一方认为邮件“内件品名”载明的内容与邮件中的实际文件内容不符，应在收到邮件之日起3个工作日内书面通知对方，逾期未通知对方则视为邮件“内件品名”载明的内容与邮件中文件内容一致。</p>
        <h3 class="f14 md-title bold">十、其它</h3>
        <p class="det-con f12">1.&nbsp;本协议未尽事项，经双方协商，可另立补充协议。</p>
        <p class="det-con f12">2.&nbsp;凡因履行本协议或与本协议有关的任何争议，由本协议甲方所在地人民法院管辖。</p>
        <p class="det-con f12">3.&nbsp;本协议经用户在线点击“我已仔细阅读并同意本协议全部条款”后生效。</p>
      </div>
      <div class="modal-footers">
        <button type="button" class="sure-btn sell-sure fy16"><span>我已阅读并同意</span></button>
      </div>
    </div>
    
  </div>
  
  <!-- 页脚==========================================-->
  <%@include file="/jsp/common/footer.jsp"%>
  
  <!-- 私有js==========================================-->
  <script src="/js/common/jquery.validate.js"></script>
  <!-- <script src="/js/common/unslider.min.js"></script> -->
  <script type="text/javascript">
    $(function() {
    $('.ope').mouseover(function(){
      $(this).addClass('mouseon');
    });
    $('.ope').mouseout(function(){
      $(this).removeClass('mouseon');
    });
    $('.role').click(function(){
            $('.role').removeClass('selected');
            $(this).addClass('selected');
            var role = $(this).children('span').text();
            switch(role){
                case '采购商' :
                    $('.module').css('display','none');
                    $('.detail_sel').css('display','block');
          $('.slider01').css('height','411px');
          $('.slider01').children('ul').css('height','411px');
                    break;
                case '供应商' :
                    $('.module').css('display','none');
                    $('.detail_fac').css('display','block');
          $('.slider02').css('height','514px');
          $('.slider02').children('ul').css('height','514px');
                    break;
                case '代发商' :
                    $('.module').css('display','none');
                    $('.detail_ser').css('display','block');
          $('.slider03').css('height','514px');
          $('.slider03').children('ul').css('height','514px');
                    break;
            };
        });
        $('.input').focus(function(){
            $('.input').removeClass('focusing');
            $(this).addClass('focusing');
        });
        $('.input').blur(function(){
            $(this).removeClass('focusing');
        });
        $('.module').click(function() {
            
        })
    });

  // 客服QQ对话窗
  $("body").on('click',".qq",function(event) {
        window.open("http://wpa.qq.com/msgrd?v=3&uin=<?= $service_qq ?>&site=qq&menu=yes");
    return false;
  });

  //  增加验证规则
  //用户名可用性验证
  $.validator.addMethod("nameRepeat",function(value,element,params){
    if (1) {
      var available = $(element).parent('.det_message').next('.auth-ok');
      available.css('display','inline-block');
      return true;
    }
  });
  // error隐藏可用提示
  $.validator.addMethod("EmailErrorHide",function(value,element,params){
        if($(element).hasClass('error')){
          $(element).parent('.det_message').find('.email-ok').html('');
        }
        return true;
  }); 
  $.validator.addMethod("NameErrorHide",function(value,element,params){
        if($(element).hasClass('error')){
          $(element).parent('.det_message').find('.auth-ok').html('');
        }
        return true;
  }); 
  $.validator.addMethod("MobileErrorHide",function(value,element,params){
        if($(element).hasClass('error')){
          $(element).parent('.det_message').find('.phone-ok').html('');
        }
        return true;
  }); 
  $.validator.addMethod("LinkErrorHide",function(value,element,params){
        if($(element).hasClass('error')){
          $(element).parent('.det_message').find('.addr-ok').html('');
        }
        return true;
  });   
  // 邮箱可用性重复验证
  $.validator.addMethod("EmailRepeat",function(value,element,params){
      if (value === '') {
        return true;
      }
      var self = $(element);    
      var send_data = {'email':value,'_csrf':"<?= $_csrf ?>"};
      var result;
      $.ajax({
             type: "post",
             url: "/register/ajaxEmail",
             data: send_data,
             dataType: "json",
             async: false,
             success: function(data){
          if(data){
            self.parent('.det_message').find('.email-ok').html('');
            result = false;
          }else{
                  self.parent('.det_message').find('.email-ok').html('<img src="/img/auth-ok.png">邮箱可用');
                  result = true;
          }
        }
      })
      return result;
  }); 
  // 电话可用性重复验证
  $.validator.addMethod("MobileRepeat",function(value,element,params){
      if (value === '') {
        return true;
      }
      var self = $(element);    
      var send_data = {'mobile':value,'_csrf':"<?= $_csrf ?>"};
      var result;
      $.ajax({
             type: "post",
             url: "/register/ajaxmobile",
             data: send_data,
             dataType: "json",
             async: false,
             success: function(data){
          if(data == 1){
            self.parent('.det_message').find('.phone-ok').html('');
            result = false;
          }else{
                  self.parent('.det_message').find('.phone-ok').html('<img src="/img/auth-ok.png">手机号可用');
                  result = true;
          }
        }
      })
      return result;
  });
    // 用户名可用性重复验证
  $.validator.addMethod("UserNameRepeat",function(value,element,params){
      if (value === '') {
        return true;
      }
      var self = $(element);    
      var send_data = {'username':value,'_csrf':"<?= $_csrf ?>"};
      var result;
      $.ajax({
             type: "post",
             url: "/register/ajaxname",
             data: send_data,
             dataType: "json",
             async: false,
             success: function(data){
          if(data){
            self.parent('.det_message').find('.auth-ok').html('');
            result = false;
          }else{
                  self.parent('.det_message').find('.auth-ok').html('<img src="/img/auth-ok.png">用户名可用');
                  result = true;
          }
        }
      })
      return result;
  }); 
        
        
        // 商家名称可用性重复验证
  $.validator.addMethod("FactorynameRepeat",function(value,element,params){
      if (value === '') {
        return true;
      }
      var self = $(element);    
      var send_data = {'factoryname':value,'_csrf':"<?= $_csrf ?>"};
      var result;
      $.ajax({
             type: "post",
             url: "/register/ajaxTitle",
             data: send_data,
             dataType: "json",
             async: false,
             success: function(data){
          if(data){

            self.parent('.det_message').find('.addr-ok').html('');
            result = false;
          }else{
            self.parent('.det_message').find('.addr-ok').html('<img src="/img/auth-ok.png">商家名称可用');
            result = true;
          }
                  
        }
      })
      return result;
  });   

    // url可用性重复验证
  $.validator.addMethod("LinkRepeat",function(value,element,params){
      if (value === '') {
        return true;
      }
      var self = $(element);    
      var send_data = {'link':value,'_csrf':"<?= $_csrf ?>"};
      var result;
      
      $.ajax({
             type: "post",
             url: "/register/ajaxUrl",
             data: send_data,
             dataType: "json",
             async: false,
             success: function(data){
          if(data){
            self.parent('.det_message').find('.addr-ok').html('');
            result = false;
          }else{
            self.parent('.det_message').find('.addr-ok').html('<img src="/img/auth-ok.png">URL可用');
            result = true;
          }
                  
        }
      })
      return result;
  });   


  // 验证码错误验证
  $.validator.addMethod("CodeError",function(value,element,params){
      if (value === '') {
        return true;
      }
      var self = $(element);    
      var send_data = {'code':value,'_csrf':"<?= $_csrf ?>"};
      var result;
      $.ajax({
             type: "post",
             url: "/validateCode",
             data: send_data,
             dataType: "json",
             async: false,
             success: function(data){
          if(data){
            result = true;
          }else{
            result = false;
          }
        }
      })
      return result;
  });      

  //是否是字母和数字组合
  $.validator.addMethod("isNumLet",function(value,element){
    var lan = /^[A-Za-z0-9]+$/;
    return this.optional(element) || lan.test(value);
  },"请输入大小写字母和数字的组合");
  //是否是非纯数字
  $.validator.addMethod("isunNum",function(value,element){
    var lan = /^[0-9]+$/;
    return this.optional(element) || !lan.test(value);
  },"用户名必须包含字母");
  //验证密码合法性
  $.validator.addMethod("isPassword",function(value,element){
    var password = /^[A-Za-z0-9]{6,20}$/;
    var len = value.length;
    var strongele = $(element).parent('.det_message').children('.reminder');
    if (len <6 || len > 20) {
      strongele.css('display','none');
    }
    return this.optional(element) || password.test(value);
  },"请输入6-20位密码");
  //验证密码强度
  $.validator.addMethod("isStrong",function(value,element){
    var len = value.length;
    var strongele = $(element).parent('.det_message').children('.reminder');
    if (len > 5 && len < 11) {
      strongele.children('span').removeClass('strength');
      strongele.children('span').eq(0).addClass('strength');
      strongele.css('display','block');
    }else if(len > 10 && len <15) {
      strongele.children('span').removeClass('strength');
      strongele.children('span').eq(1).addClass('strength');
      strongele.css('display','block');
    }else if(len > 14 && len <21) {
      strongele.children('span').removeClass('strength');
      strongele.children('span').eq(2).addClass('strength');
      strongele.css('display', 'block');
    }
    return true;
  });
  //验证重复输入密码是否正确
  $.validator.addMethod("eqPassword",function(value,element){
    var pass_01 = $(element).parent('.det_message').prev('.det_message').children('.input').val();
    return this.optional(element) || (pass_01 === value);
  }, "两次输入的密码不相同，请检查");
  //手机号码验证
  $.validator.addMethod("isMobile",function(value,element){
    var length = value.length;
    var mobile = /^[1][34578][0-9]{9}$/;
    return this.optional(element) || (length == 11 && mobile.test(value));
  }, "请正确填写您的手机号码");
  $.validator.addMethod("isLink",function(value,element){
    var link = /^[A-Za-z0-9]{3,16}$/;
    return this.optional(element) || link.test(value);
  });
    // 验证商家名称和联系人
  $.validator.addMethod("isFactoryName",function(value,element){
    var lan = /^[0-9a-z\u4e00-\u9fa5]+$/;
    return this.optional(element) || lan.test(value);
  },"必须是汉字，字母或数字");   
  $.validator.addMethod("isContact",function(value,element){
    var lan = /^[\u4e00-\u9fa5]{2,10}$/;
    return this.optional(element) || lan.test(value);
  },"联系人只能是汉字，且至少2位");   
  $.validator.addMethod("isUserName",function(value,element){
    var lan = /^[\u4e00-\u9fa5a-z0-9]{2,20}$/;
    return this.optional(element) || lan.test(value);
  },"用户名只能包含汉字、数字、小写字母，且长度为2到20位");  

  var rule = {
    rules: {
      username: {
        NameErrorHide: true,
        required: true,
        isUserName: true,
        nameRepeat: true,
        UserNameRepeat: true
      },
      password_01: {
        required: true,
        isPassword: true,
        isStrong: true
      },
      password: {
        required: true,
        isPassword: true,
        eqPassword: true
      },
      phonenumber: {
        MobileErrorHide: true,
        required: true,
        isMobile: true,
        MobileRepeat: true
      },
      qqnumber: {
        number: true,
        rangelength: [5, 11]
      },
      email: {
        EmailErrorHide: true,
        email: true,
        EmailRepeat: true
      },
      code: {
        required: true,
        CodeError: true
      },
      link: {
        LinkErrorHide: true,
        required: true,
        isLink: true,
        LinkRepeat: true
      },
      factoryname: {
        required: true,
        isFactoryName: true,
                                FactorynameRepeat:true
        //isFacName: true
      },
      contact: {
        required: true,
        isContact: true
      },
      serverteam: {
        required: true
      },
      retailsales: {
        required: true
      },
      'agency[]': {
        required: true
      },
      agree: {
        required: true
      },
      service: {
        required: true
      }
    },
    messages:
    {
      username: {
        NameErrorHide: '',
        required: "请输入用户名",
        rangelength: '用户名长度为6-20位字母和数字的组合',
        legal: "用户名不正确",
        UserNameRepeat: '用户名已经存在'
      },
      password_01: {
        required: "请输入密码",
      },
      password: {
        required: "请再次输入密码",
      },
      phonenumber: {
        MobileErrorHide: '',
        required: "请输入手机号码",
        MobileRepeat: "手机号已经存在"
      },
      qqnumber: {
        rangelength: '请输入5-11位QQ号码',
        number: '只能输入数字'
      },
      email:
      {
        EmailErrorHide: '',
        email: "请输入正确的邮箱地址",
        EmailRepeat: "邮箱已经存在"
      },
      code: {
        required: "请输入验证码",
        CodeError: '验证码错误！'
      },
      link: {
        LinkErrorHide: '',
        required: "请输入店铺地址",
        isLink: "地址输入有误，请输入3-16位字母和数字的组合",
        LinkRepeat: '子域名不可用'
      },
      factoryname: {
        required: "请输入商家名称",
                                FactorynameRepeat:"商家名称已存在"
        //isFacName: "商家名称输入有误，请重新输入"
      },
      contact: {
        required: "请填写联系人"
      },
      serverteam: {
        required: "请选择服务性质"
      },
      retailsales: {
        required: "请填写门店地址"
      },
      'agency[]': {
        required: '需同意开通分销招募协议'
      },
      agree: {
        required: '请勾选用户协议'
      },
      service: {
        required: '请选择申请服务'
      }
    }
  };
  //  开启验证
  $('#user_form').validate(rule);
  $('#fac_form').validate(rule);
  $('#ser_form').validate(rule);
  $('#sto_form').validate(rule);
  //图片轮播
  /* $('.slider01').unslider({
    speed: 100,               //  The speed to animate each slide (in milliseconds)
    delay: 3000,              //  The delay between slide animations (in milliseconds)
    complete: function() {},  //  A function that gets called after every slide animation
    keys: true,               //  Enable keyboard (left, right) arrow shortcuts
    dots: true,               //  Display dot navigation
    fluid: false              //  Support responsive design. May break non-responsive designs
  });
  $('.slider02').unslider({
    speed: 100,               //  The speed to animate each slide (in milliseconds)
    delay: 3000,              //  The delay between slide animations (in milliseconds)
    complete: function() {},  //  A function that gets called after every slide animation
    keys: true,               //  Enable keyboard (left, right) arrow shortcuts
    dots: true,               //  Display dot navigation
    fluid: false              //  Support responsive design. May break non-responsive designs
  });
  $('.slider03').unslider({
    speed: 100,               //  The speed to animate each slide (in milliseconds)
    delay: 3000,              //  The delay between slide animations (in milliseconds)
    complete: function() {},  //  A function that gets called after every slide animation
    keys: true,               //  Enable keyboard (left, right) arrow shortcuts
    dots: true,               //  Display dot navigation
    fluid: false              //  Support responsive design. May break non-responsive designs
  });
  $('.slider04').unslider({
    speed: 100,               //  The speed to animate each slide (in milliseconds)
    delay: 3000,              //  The delay between slide animations (in milliseconds)
    complete: function() {},  //  A function that gets called after every slide animation
    keys: true,               //  Enable keyboard (left, right) arrow shortcuts
    dots: true,               //  Display dot navigation
    fluid: false              //  Support responsive design. May break non-responsive designs
  }); */

  // 刷新验证码
     $('.role,.captcha1,.captcha2').click(function() {
        /* $.get('/login/verify?refresh=1', function(str) {
          alert(str)
           $('.captcha1').attr('src', str.url);
        }); */
        $(".captcha1").attr("src","/login/verify?res="+ Math.random());
    }).css('cursor', 'pointer'); 
 

  //注册协议弹出
  $('.protocol').children('a').click(function () {
    $('.back-tran').css('display','block');
    $('#register-protocol').css('display','block');
    $('body').css('overflow','hidden');
  });
  //点击同意注册协议按钮
  $('.protocol-sure').click(function () {
    $('.protocol').children('input').attr('checked',true);
    $('.protocol').children('input').prop('checked',true);
  });
  //分销协议弹出
  $('.sell-protocol').click(function () {
    $('.back-tran').css('display','block');
    $('#sell-protocol').css('display','block');
    $('body').css('overflow','hidden');
  });
  //点击同意分销协议按钮
  $('.sell-sure').click(function () {
    $('.check-sell').attr('checked',true);
    $('.check-sell').prop('checked',true);
  });
  //关闭协议弹窗
  $('.j_close').click(function () {
    $('.back-tran').css('display','none');
    $('.modal').css('display','none');
    $('body').css('overflow','auto');
  });
  $('.sure-btn').click(function () {
    $('.back-tran').css('display','none');
    $('.modal').css('display','none');
    $('body').css('overflow','auto');
  });
  //分销协议选取效果
  $('.check-sell').first().click(function () {
    if($(this).is(':checked')) {
      $('.check-sell').attr('checked',true);
      $('.check-sell').prop('checked',true);
    } else {
      $('.check-sell').removeAttr('checked');
    }
  })
  //角色无勾选，协议自动取消勾选
  $('.check-role').click(function () {
    var checknum = 0;
    var role = $('.check-role');
    for (var i = 0;i < role.length;i++) {
      if (role.eq(i).is(':checked')) {
        checknum += 1;
      }
    }
    if (!checknum) {
      $('.check-pro').removeAttr('checked');
    } else {
      $('.check-pro').attr('checked',true);
      $('.check-pro').prop('checked',true);
    }
  });

</script>
</body>
</html>