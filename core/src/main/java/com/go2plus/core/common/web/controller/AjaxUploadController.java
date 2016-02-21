package com.go2plus.core.common.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.go2plus.core.common.Constants;
import com.go2plus.core.common.utils.ImagesUtils;
import com.go2plus.core.common.utils.LogUtils;
import com.go2plus.core.common.utils.MessageUtils;
import com.go2plus.core.common.web.entity.AjaxUploadResponse;
import com.go2plus.core.common.web.upload.FileUploadUtils;
import com.go2plus.core.common.web.upload.exception.FileNameLengthLimitExceededException;
import com.go2plus.core.common.web.upload.exception.InvalidExtensionException;

/**
 * ajax文件上传/下载
 * <p>User: mtwu
 * <p>Date: 13-2-11 上午8:46
 * <p>Version: 1.0
 */
@Controller
public class AjaxUploadController {


    //最大上传大小 字节为单位
    private long maxSize = FileUploadUtils.defaultMaxSize;
    //允许的文件内容类型
    private String[] allowedExtension = FileUploadUtils.DEFAULT_ALLOWED_EXTENSION;
    //文件上传下载的父目录
    private String baseDir = FileUploadUtils.getDefaultBaseDir();
    
    /**
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(value = "ajaxUpload", method = RequestMethod.POST)
    @ResponseBody
    public AjaxUploadResponse ajaxUpload(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "files[]", required = false) MultipartFile[] files) {

        //The file upload plugin makes use of an Iframe Transport module for browsers like Microsoft Internet Explorer and Opera, which do not yet support XMLHTTPRequest file uploads.
        response.setContentType("text/plain");

        AjaxUploadResponse ajaxUploadResponse = new AjaxUploadResponse();

        if (ArrayUtils.isEmpty(files)) {
            return ajaxUploadResponse;
        }

        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            long size = file.getSize();
            
            try {
            	//filename = new String(file.getOriginalFilename().getBytes("iso-8859-1"), "UTF-8");
            	filename = file.getOriginalFilename();
                String url = FileUploadUtils.upload(request, baseDir, file, allowedExtension, maxSize, true, true);
                String deleteURL = "/ajaxUpload/delete?filename=" + URLEncoder.encode(url, Constants.ENCODING);
                String thumbnail_url = request.getServletContext()+File.separator+url;
                if (ImagesUtils.isImage(filename)) {
                    ajaxUploadResponse.add(filename, size, url, thumbnail_url, deleteURL);
                } else {
                    ajaxUploadResponse.add(filename, size, url, deleteURL);
                }
                continue;
            } catch (UnsupportedEncodingException e) {
            	LogUtils.logError("file upload error", e);
            	ajaxUploadResponse.add(filename, size, e.getMessage());
            	continue;
			} catch (IOException e) {
                LogUtils.logError("file upload error", e);
                ajaxUploadResponse.add(filename, size, MessageUtils.message("upload.server.error"));
                continue;
            } catch (InvalidExtensionException e) {
                ajaxUploadResponse.add(filename, size, MessageUtils.message("upload.not.allow.extension"));
                continue;
            } catch (FileUploadBase.FileSizeLimitExceededException e) {
                ajaxUploadResponse.add(filename, size, MessageUtils.message("upload.exceed.maxSize"));
                continue;
            } catch (FileNameLengthLimitExceededException e) {
                ajaxUploadResponse.add(filename, size, MessageUtils.message("upload.filename.exceed.length"));
                continue;
            }
        }
        return ajaxUploadResponse;
    }
    
    /**
     * @param request
     * @param files
     * @return
     */
    @RequestMapping(value = "ajaxUpload2Server", method = RequestMethod.POST)
    @ResponseBody
    public AjaxUploadResponse ajaxUpload2Server(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "files[]", required = false) MultipartFile[] files) {
        //The file upload plugin makes use of an Iframe Transport module for browsers like Microsoft Internet Explorer and Opera, which do not yet support XMLHTTPRequest file uploads.
        response.setContentType("text/plain");
        AjaxUploadResponse ajaxUploadResponse = new AjaxUploadResponse();
        
        if (ArrayUtils.isEmpty(files)) {
            return ajaxUploadResponse;
        }
        
        for (MultipartFile file : files) {
        	String filename="";
        	long size = file.getSize();
        	

            try {
            	//filename = new String(file.getOriginalFilename().getBytes("iso-8859-1"), "UTF-8");
            	filename = file.getOriginalFilename();
            	String xString = FileUploadUtils.getServerDir();
            	String yString = FileUploadUtils.getServerUrl();
            	//本地路径或远程服务器
                String url = FileUploadUtils.upload(FileUploadUtils.getServerDir(), FileUploadUtils.getServerUrl(), baseDir, file, allowedExtension, maxSize, true, false);
                String deleteURL = "ajaxUpload/delete?filename=" + URLEncoder.encode(FileUploadUtils.getServerDir() +File.separator+ url, Constants.ENCODING);
                String fullUrl = FileUploadUtils.getServerDir()+File.separator+url;
                String thumbnail_url = FileUploadUtils.getServerUrl()+File.separator+url;
                thumbnail_url = thumbnail_url.replace("\\", "/");
                if (ImagesUtils.isImage(filename)) {
                    ajaxUploadResponse.add(filename, size, fullUrl, thumbnail_url, deleteURL);
                } else {
                    ajaxUploadResponse.add(filename, size, fullUrl, deleteURL);
                }
                continue;
                
            } catch (UnsupportedEncodingException e) {
            	LogUtils.logError("file upload error", e);
            	ajaxUploadResponse.add(filename, size, e.getMessage());
            	continue;
			} catch (IOException e) {
            	e.printStackTrace();
                LogUtils.logError("file upload error", e);
                ajaxUploadResponse.add(filename, size, e.getMessage());
                continue;
            } catch (InvalidExtensionException e) {
                ajaxUploadResponse.add(filename, size, e.getMessage());
                continue;
            } catch (FileUploadBase.FileSizeLimitExceededException e) {
                ajaxUploadResponse.add(filename, size, e.getMessage());
                continue;
            } catch (FileNameLengthLimitExceededException e) {
                ajaxUploadResponse.add(filename, size, e.getMessage());
                continue;
            } 
        }
        return ajaxUploadResponse;
    }
        
    @RequestMapping(value = "ajaxUpload/delete", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxUploadDelete(
            HttpServletRequest request,
            @RequestParam(value = "filename") String filename) throws Exception {

        if (StringUtils.isEmpty(filename) || filename.contains("\\.\\.")) {
            return "";
        }
        filename = URLDecoder.decode(filename, Constants.ENCODING);

        //String filePath = FileUploadUtils.extractUploadDir(request) + "/" + filename;
        String filePath = filename;
        File file = new File(filePath);
        //在JVM进程退出的时候删除文件
        //file.deleteOnExit();
        file.delete();
        return "";
    }
}
