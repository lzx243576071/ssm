package com.soecode.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

/**
 * 文件操作工具类
 * @author Young
 * @date 2017/10/24
 */
public final class FileUtils {

    /**
     * 文件上传保存文件夹路径
     */
    public static final String PATH;

    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    static {
        PATH = PropertyConfigLoader.getProperty("upload.path");
    }

    private FileUtils() {
        throw new AssertionError("不能产生该对象");
    }

    /**
     * 保存上传的文件
     * @param file 上传的文件
     * @param path 上传的文件所属文件夹名称
     * @param id 上传的文件id
     * @return 文件名
     */
    public static String uploadFile(MultipartFile file, String path, String id) throws IOException {
        if (file == null || file.isEmpty()) {
            return null;
        }
        String originName = file.getOriginalFilename();
        int index = originName.lastIndexOf('.');
        String suffix;
        if (index != -1) {
            suffix = originName.substring(index);
        } else {
            String contentType = file.getContentType();
            suffix = "." + contentType.substring(contentType.indexOf('/') + 1);
        }
        StringBuilder s = new StringBuilder(PATH);
        String filename = UUID.randomUUID().toString();
        s.append(path).append('/').append(id).append('/').append(filename).append(suffix);
        filename = s.toString();
        File f = createFile(filename);
        
        file.transferTo(f);
        s.delete(0, PATH.length());
        return s.toString();
    }

    /**
     * 创建新文件
     * @param f 文件
     * @throws IOException 创建文件失败抛出异常
     */
    public static File createFile(File f) throws IOException {
        f.getParentFile().mkdirs();
        f.createNewFile();
        return f;
    }

    /**
     * 创建新文件
     * @param filename 文件路径
     * @throws IOException
     */
    public static File createFile(String filename) throws IOException {
        return createFile(new File(filename));
    }

    /**
     * 获取文件
     * @param filename 文件名
     * @return 文件对象
     */
    public static File getFile(String filename) {
        return new File(PATH + filename);
    }

    /**
     * 将文件写入到输出流
     * @param f 文件
     * @param out 输出流
     * @throws IOException
     */
    public static void writeToStream(File f, OutputStream out) throws IOException {
        try (FileInputStream fis = new FileInputStream(f)) {
            byte[] buf = new byte[4096];
            int len = -1;
            while ((len = fis.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
        }
    }
}
