package com.asdc.boot.valuation.tool.service.impl;

import com.asdc.boot.valuation.tool.service.FileDownloadService;
import org.springframework.context.annotation.Bean;

import java.io.*;

public class FileDownloadServiceImpl implements FileDownloadService {
    @Override
    public String findFileList(String project_id) {

        return null;
    }

    public static void main(String[] args){
        FileDownloadServiceImpl fileDownloadService = new FileDownloadServiceImpl();
        fileDownloadService.updateFileName("https://file.chinaratings.com.cn/finchina/2019-7/2019-07-31/11645140.pdf");
    }

    /**
     * 设置文件另存为名称
     * @param
     * @param
     */
    private void updateFileName(String path){

        try {
            InputStream is = new FileInputStream(path);
            byte[] b = new byte[5];//把所有的数据读取到这个字节当中
            //声明一个int存储每次读取到的数据
            int i = 0;
            //定义一个记录索引的变量
            int index = 0;
            //循环读取每个数据
            while((i=is.read())!=-1){//把读取的数据放到i中
                b[index]=(byte) i;
                index++;
            }
            //把字节数组转成字符串
            System.out.println(new String(b));
            //关闭流
            is.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            //系统强制解决的问题：文件没有找到
            e.printStackTrace();
        } catch (IOException e) {
            //文件读写异常
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
