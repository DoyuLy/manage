package com.go2plus.core.common;

/**
 * <p>User: mtwu
 * <p>Date: 13-2-7 下午5:14
 * <p>Version: 1.0
 */
public interface Constants {
    /**
     * 操作名称
     */
    String OP_NAME = "op";


    /**
     * 消息key
     */
    String MESSAGE = "message";

    /**
     * 错误key
     */
    String ERROR = "error";

    /**
     * 上个页面地址
     */
    String BACK_URL = "BackURL";

    String IGNORE_BACK_URL = "ignoreBackURL";

    /**
     * 当前请求的地址 带参数
     */
    String CURRENT_URL = "currentURL";

    /**
     * 当前请求的地址 不带参数
     */
    String NO_QUERYSTRING_CURRENT_URL = "noQueryStringCurrentURL";

    String CONTEXT_PATH = "ctx";
    
    /**
     * 当前登录的用户
     */
    String CURRENT_USER = "user";
    String CURRENT_USERNAME = "username";

    String ENCODING = "UTF-8";
    
    String IMAGESERVERURL = "imageServerUrl";
    /**
     * 分页信息
     */
    String PAGE_START_NUM = "startNum";
    String PAGE_SIZE = "pageSize";
    
    //文件存放目录
    String FILE_UPLOAD_DIR = "file.upload.dir";
    String ROOT_DIR="file.root.dir";
    String IDCARD_DIR="file.idcard.dir";
    String MODEL_PRODUCT_DIR="file.model.product.dir";
    String PHOTOGRAPHER_PRODUCT_DIR="file.photographer.product.dir";

    String ADVERTISE_DIR="file.advertise.dir";

    String FILE_UPLOAD_SERVER_DIR = "file.upload.server.dir";


    String UPLOAD_DIR = "file.upload.dir";


    String PHOTOGRAPHER_SHOP_PICTURE_DIR = "file.photographer.shop_picture.dir";
    
}
