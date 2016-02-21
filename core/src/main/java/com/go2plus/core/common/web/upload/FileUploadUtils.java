package com.go2plus.core.common.web.upload;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import com.go2plus.core.common.utils.LogUtils;
import com.go2plus.core.common.utils.security.Coder;
import com.go2plus.core.common.web.upload.exception.FileNameLengthLimitExceededException;
import com.go2plus.core.common.web.upload.exception.InvalidExtensionException;

/**
 * 文件上传工具类
 * <p>User: mtwu
 * <p>Date: 13-2-12 上午8:32
 * <p>Version: 1.0
 */
public class FileUploadUtils {

    //默认大小 50M
    public static long defaultMaxSize = 52428800;

    //默认上传的地址
    private static String defaultBaseDir = "upload";

    //默认的文件名最大长度
    public static final int DEFAULT_FILE_NAME_LENGTH = 200;
    
    //服务器文件目录
    private static String serverDir = null;
   //文件服务器url第三
    private static String serverUrl = null;
    
    public static final String[] IMAGE_EXTENSION = {
            "bmp", "gif", "jpg", "jpeg", "png"
    };

    public static final String[] FLASH_EXTENSION = {
            "swf", "flv"
    };

    public static final String[] MEDIA_EXTENSION = {
            "swf", "flv", "mp3", "wav", "wma", "wmv", "mid", "avi", "mpg", "asf", "rm", "rmvb"
    };

    public static final String[] DEFAULT_ALLOWED_EXTENSION = {
            //图片
            "bmp", "gif", "jpg", "jpeg", "png",
            //word excel powerpoint
            "doc", "docx", "xls", "xlsx", "ppt", "pptx",
            "html", "htm", "txt",
            //压缩文件
            "rar", "zip", "gz", "bz2",
            //pdf
            "pdf",
            //音频视频
            "swf", "flv", "mp3", "wav", "wma", "wmv", "mid", "avi", "mpg", "asf", "rm", "rmvb","mp4","webm","ogg"
    };


    private static int counter = 0;


    public static void setDefaultBaseDir(String defaultBaseDir) {
        FileUploadUtils.defaultBaseDir = defaultBaseDir;
    }

    public static String getDefaultBaseDir() {
        return defaultBaseDir;
    }
    
    

    public static String getServerDir() {
		return serverDir;
	}

	public static void setServerDir(String serverDir) {
		FileUploadUtils.serverDir = serverDir;
	}

	public static String getServerUrl() {
		return serverUrl;
	}

	public static void setServerUrl(String serverUrl) {
		FileUploadUtils.serverUrl = serverUrl;
	}

	
	public static long getDefaultMaxSize() {
		return defaultMaxSize;
	}

	public static void setDefaultMaxSize(long defaultMaxSize) {
		FileUploadUtils.defaultMaxSize = defaultMaxSize;
	}

	/**
     * 以默认配置进行文件上传
     *
     * @param request 当前请求
     * @param file    上传的文件
     * @param result  添加出错信息
     * @return
     */
    public static final String upload(HttpServletRequest request, MultipartFile file, BindingResult result) {
        return upload(request, file, result, DEFAULT_ALLOWED_EXTENSION);
    }


    /**
     * 以默认配置进行文件上传
     *
     * @param request          当前请求
     * @param file             上传的文件
     * @param result           添加出错信息
     * @param allowedExtension 允许上传的文件类型
     * @return
     */
    public static final String upload(HttpServletRequest request, MultipartFile file, BindingResult result, String[] allowedExtension) {
        try {
            return upload(request, getDefaultBaseDir(), file, allowedExtension, defaultMaxSize, true, true);
        } catch (IOException e) {
            LogUtils.logError("file upload error", e);
            result.reject("upload.server.error");
        } catch (InvalidExtensionException.InvalidImageExtensionException e) {
            result.reject("upload.not.allow.image.extension");
        } catch (InvalidExtensionException.InvalidFlashExtensionException e) {
            result.reject("upload.not.allow.flash.extension");
        } catch (InvalidExtensionException.InvalidMediaExtensionException e) {
            result.reject("upload.not.allow.media.extension");
        } catch (InvalidExtensionException e) {
            result.reject("upload.not.allow.extension");
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            result.reject("upload.exceed.maxSize");
        } catch (FileNameLengthLimitExceededException e) {
            result.reject("upload.filename.exceed.length");
        }
        return null;
    }


    /**
     * 文件上传
     *
     * @param request          当前请求 从请求中提取 应用上下文根
     * @param baseDir          相对应用的基目录
     * @param file             上传的文件
     * @param allowedExtension 允许的文件类型 null 表示允许所有
     * @param maxSize          最大上传的大小 -1 表示不限制
     *@param needDatePathAndRandomName 是否需要日期目录和随机文件名前缀
     * @return 返回上传成功的文件名
     * @throws InvalidExtensionException      如果MIME类型不允许
     * @throws FileSizeLimitExceededException 如果超出最大大小
     * @throws FileNameLengthLimitExceededException
     *                                        文件名太长
     * @throws IOException                    比如读写文件出错时
     */
    public static final String upload(
            HttpServletRequest request, String baseDir, MultipartFile file,
            String[] allowedExtension, long maxSize, boolean needDatePathAndRandomName, boolean randomAddFileName)
            throws InvalidExtensionException, FileSizeLimitExceededException, IOException, FileNameLengthLimitExceededException {

        int fileNamelength = file.getOriginalFilename().length();
        if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new FileNameLengthLimitExceededException(file.getOriginalFilename(), fileNamelength, FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }

        assertAllowed(file, allowedExtension, maxSize);
        String filename = extractFilename(file, baseDir, needDatePathAndRandomName, randomAddFileName);

        File desc = getAbsoluteFile(extractUploadDir(request), filename);

        file.transferTo(desc);
        return filename;
    }
    
    /**
     * 文件上传
     *
     * @param localPath      文件存放的本地路径（远程服务器可以挂接硬盘到本地）
     * @param serverUrl        文件服务访问URL
     * @param baseDir          相对应用的基目录
     * @param file             上传的文件
     * @param allowedExtension 允许的文件类型 null 表示允许所有
     * @param maxSize          最大上传的大小 -1 表示不限制
     *@param needDatePathAndRandomName 是否需要日期目录和随机文件名前缀
     * @return 返回上传成功的文件名
     * @throws InvalidExtensionException      如果MIME类型不允许
     * @throws FileSizeLimitExceededException 如果超出最大大小
     * @throws FileNameLengthLimitExceededException
     *                                        文件名太长
     * @throws IOException                    比如读写文件出错时
     */
    public static final String upload(
            String serverDir,String serverUrl, String baseDir, MultipartFile file,
            String[] allowedExtension, long maxSize, boolean needDatePathAndRandomName, boolean randomAddFileName)
            throws InvalidExtensionException, FileSizeLimitExceededException, IOException, FileNameLengthLimitExceededException {
    	String name = file.getOriginalFilename();
        int fileNamelength = name.length();
        if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new FileNameLengthLimitExceededException(name, fileNamelength, FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }

        assertAllowed(file, allowedExtension, maxSize);
        String filename = extractFilename(file, baseDir, needDatePathAndRandomName, randomAddFileName);
        
        
        //文件放到项目的context下面
        File desc = getAbsoluteFile(serverDir, filename);

        file.transferTo(desc);
        return filename;
    }
    private static final File getAbsoluteFile(String uploadDir, String filename) throws IOException {

        uploadDir = FilenameUtils.normalizeNoEndSeparator(uploadDir);

        File desc = new File(uploadDir + File.separator + filename);
        try {
          if (!desc.getParentFile().exists()) {
              desc.getParentFile().mkdirs();
          }
          if (!desc.exists()) {
              desc.createNewFile();
          }
        } catch (IOException e) {
          throw new IOException(e.getMessage()+"["+desc.getPath()+"]");
        }
        return desc;
    }


    public static final String extractFilename(MultipartFile file, String baseDir, boolean needDatePathAndRandomName, boolean randomAddFileName)
            throws UnsupportedEncodingException {
        String filename = file.getOriginalFilename();
        int slashIndex = filename.indexOf("/");
        if (slashIndex >= 0) {
            filename = filename.substring(slashIndex + 1);
        }
        if(needDatePathAndRandomName) {
            filename = baseDir + File.separator + datePath() + File.separator + encodingFilename(filename, randomAddFileName);
        } else {
            filename = baseDir + File.separator + filename;
        }

        return filename;
    }

    /**
     * 编码文件名,默认格式为：
     * 1、'_'替换为 ' '
     * 2、hex(md5(filename + now nano time + counter++))
     * 3、[2]_原始文件名
     *
     * @param filename
     * @return
     */
    private static final String encodingFilename(String filename, boolean randomAddFileName) {
        filename = filename.replace("_", " ");
        if(randomAddFileName){
        	filename = Coder.encryptMD5(filename + System.nanoTime() + counter++) + "_" + filename;
        }
        else{
        	int index= filename.lastIndexOf(".");
        	filename = Coder.encryptMD5(filename + System.nanoTime() + counter++)+ (index>0 ? filename.substring(filename.lastIndexOf(".")) : "");
        }
        return filename;
    }

    /**
     * 日期路径 即年/月/日  如2013/01/03
     *
     * @return
     */
    private static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }


    /**
     * 是否允许文件上传
     *
     * @param file             上传的文件
     * @param allowedExtension 文件类型  null 表示允许所有
     * @param maxSize          最大大小 字节为单位 -1表示不限制
     * @return
     * @throws InvalidExtensionException      如果MIME类型不允许
     * @throws FileSizeLimitExceededException 如果超出最大大小
     */
    public static final void assertAllowed(MultipartFile file, String[] allowedExtension, long maxSize)
            throws InvalidExtensionException, FileSizeLimitExceededException {

        String filename = file.getOriginalFilename();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (allowedExtension != null && !isAllowedExtension(extension, allowedExtension)) {
            if (allowedExtension == IMAGE_EXTENSION) {
                throw new InvalidExtensionException.InvalidImageExtensionException(allowedExtension, extension, filename);
            } else if (allowedExtension == FLASH_EXTENSION) {
                throw new InvalidExtensionException.InvalidFlashExtensionException(allowedExtension, extension, filename);
            } else if (allowedExtension == MEDIA_EXTENSION) {
                throw new InvalidExtensionException.InvalidMediaExtensionException(allowedExtension, extension, filename);
            } else {
                throw new InvalidExtensionException(allowedExtension, extension, filename);
            }
        }

        long size = file.getSize();
        if (maxSize != -1 && size > maxSize) {
            throw new FileSizeLimitExceededException("文件大小超出了最大长度", size, maxSize);
        }
    }

    /**
     * 判断MIME类型是否是允许的MIME类型
     *
     * @param extension
     * @param allowedExtension
     * @return
     */
    public static final boolean isAllowedExtension(String extension, String[] allowedExtension) {
        for (String str : allowedExtension) {
            if (str.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 提取上传的根目录 默认是应用的根
     *
     * @param request
     * @return
     */
    public static final String extractUploadDir(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
    }


    public static final void delete(HttpServletRequest request, String filename) throws IOException {
        if (StringUtils.isEmpty(filename)) {
            return;
        }
        File desc = getAbsoluteFile(extractUploadDir(request), filename);
        if (desc.exists()) {
            desc.delete();
        }
    }
    public static final String relace2UrlSeprator(String filepath){
      return filepath.replace("\\", "/");
    }
}
