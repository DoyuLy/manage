package com.go2plus.core.common;

import com.go2plus.common.X;

/**
 * <p>Description: 
 * <p>User: mtwu
 * <p>Date: 2015-12-12
 * <p>Version: 1.0
 */
public class PhotographyConfig {
  public static String file_upload_dir = "";
  public static String root_dir = "";
  public static String idcard_dir = "";
  public static String model_product_dir = "";
  public static String photographer_product_dir = "";
  public static String advertise_dir = "";
  
  public static String file_upload_server_dir = "";
  
  public static String upload_dir = "";
  
  
  public static synchronized void reload(){
//    PropertiesLoader  loader = new PropertiesLoader("resources.properties");
//    file_upload_dir = loader.getProperty(Constants.FILE_UPLOAD_DIR);
//    root_dir = loader.getProperty(Constants.ROOT_DIR);
//    idcard_dir = loader.getProperty(Constants.IDCARD_DIR);
//    model_product_dir = loader.getProperty(Constants.MODEL_PRODUCT_DIR);
//    photographer_product_dir = loader.getProperty(Constants.PHOTOGRAPHER_PRODUCT_DIR);
//
//    advertise_dir = loader.getProperty(Constants.ADVERTISE_DIR);
//    file_upload_server_dir = loader.getProperty(Constants.FILE_UPLOAD_SERVER_DIR);
//    upload_dir = loader.getProperty(Constants.UPLOAD_DIR);
    file_upload_dir = X.getConfig(Constants.FILE_UPLOAD_DIR);
    root_dir = X.getConfig(Constants.ROOT_DIR);
    idcard_dir = X.getConfig(Constants.IDCARD_DIR);
    model_product_dir = X.getConfig(Constants.MODEL_PRODUCT_DIR);
    photographer_product_dir = X.getConfig(Constants.PHOTOGRAPHER_PRODUCT_DIR);

    advertise_dir = X.getConfig(Constants.ADVERTISE_DIR);
    file_upload_server_dir = X.getConfig(Constants.FILE_UPLOAD_SERVER_DIR);
    upload_dir = X.getConfig(Constants.UPLOAD_DIR);
  }
  
  static {
    PhotographyConfig.reload();
  }
}
