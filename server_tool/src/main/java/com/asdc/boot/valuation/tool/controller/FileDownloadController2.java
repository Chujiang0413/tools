//package com.asdc.boot.valuation.tool.controller;
//
//import org.springframework.util.StringUtils;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.*;
//import java.net.URL;
//import java.net.URLConnection;
//import java.net.URLEncoder;
//
///**
// * 文件下载
// */
//@RestController
//@RequestMapping("/fileDownload")
//public class FileDownloadController2 {
//
//    // @Resource
//    //FileDownloadService fileDownloadService;
////
////    /**
////     * 根据project_id查询文件列表
////     */
////    @RequestMapping("/findFileList")
////    public String findFileList(String project_id){
////        try{
////            String findFileList = fileDownloadService.findFileList(project_id);
////            return findFileList;
////        }catch (Exception e) {
////            return null;
////        }
////    }
////    /**
////     *  文件下载，转换文件名传输到前端
////     */
////    @RequestMapping("/download")
////    public void download(HttpServletRequest request,HttpServletResponse response) throws Exception{
////        //读取property文件，获取下载地址
////        Properties properties = new Properties();
////
////        String filePath = getClass().getClassLoader().getResource("/").getPath()+"config.properties";
////        InputStream in = new BufferedInputStream(new FileInputStream(filePath));
////        properties.load(in);
////        String path = properties.getProperty("version.url");
////        //初始化文件流，提供客户端下载
////
////        if(!"".equals(path)){
////            path = new String(path.getBytes("ISO-8859-1"),"UTF-8");
////            //构造出要下载的文件
////            File file = new File(request.getSession().getServletContext().getRealPath("/")+path);
////            //判断路径是否存在
////            if(file.exists()){
////                //构造一个读取文件的io流对象
////                InputStream ins = new FileInputStream(request.getSession().getServletContext().getRealPath("/")+path);
////                //放到缓冲流中
////
////                BufferedInputStream bins = new BufferedInputStream(ins);
////                //获取文件输出io流
////                OutputStream outs = response.getOutputStream();
////                BufferedOutputStream bouts = new BufferedOutputStream(outs);
////                //设置response内容的类型-普通的下载类型
////                response.setContentType("application/x-download");
////                //设置文件大小
////                response.setContentLength((int)file.length());
////                //设置头部信息
////                response.setHeader("Content-disposition","attachment:filename="+ URLEncoder.encode(file.getName(),"UTF-8"));
////                int bytesRead = 0;
////                byte[] buffer = new byte[8192];
////                //开始向网络传输文件流
////                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
////                    bouts.write(buffer, 0, bytesRead);
////            }
////                //清空缓存区
////                bouts.flush();
////                //关闭流
////                ins.close();
////                bins.close();
////                outs.close();
////                bouts.close();
////        }
////
////    }
////}
//
//
//    /**
//     * http://localhost:8080/fileDownload/downloadAttachment?data_name="文案计划"
//     * &path="https://file.chinaratings.com.cn/finchina/2019-7/2019-07-19/11534349.pdf"&suffix=pdf
//     *
//     * @param path
//     * @param data_name
//     * @param suffix
//     * @param request
//     * @param response
//     * @return
//     * @throws Exception
//     */
//    @RequestMapping(value = "/downloadAttachment", method = RequestMethod.GET)
//    @ResponseBody
//    public String downloadAttachment(String path, String data_name, String suffix, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        if (StringUtils.isEmpty(path)) {
//            throw new Exception("路径不能为空！");
//        }
//        if (StringUtils.isEmpty(data_name)) {
//            throw new Exception("文件名不能为空！");
//        }
//        //获取的下载链接 http://sk.sit.fosuntech.cn/group1/M00/00/72/CqYKHVn69wyAMl6YAAVf953sp4Y075.pdf
////        String downLoadPath = fileDownloadService.findFileList(project_id);//todo
//        BufferedInputStream bis = null;
//        BufferedOutputStream bos = null;
//        try {
//            //响应二进制流
//            StringBuffer s = new StringBuffer();
//            String filename = s.append(data_name).append(".").append(suffix).toString();
//            System.out.println(data_name);
//            System.out.println(filename);
//
//            Writer out = response.getWriter();
//            //setFileDownloadHeader函数主要是根据当前用户的浏览器不同，对文件的名字进行不同的编码设置，从而解决不同浏览器下文件名中文乱码问题
//            try {
//                String finalFileName = null;
//                final String userAgent = request.getHeader("USER-AGENT");
//                if (userAgent.equalsIgnoreCase("MSIE")) {//IE浏览器
//                    finalFileName = URLEncoder.encode(filename, "UTF-8");
//                } else if (userAgent.equalsIgnoreCase("Mozilla")) {//google,火狐浏览器
//                    finalFileName = new String(filename.getBytes(), "ISO8859-1");
//                } else {
//                    finalFileName = URLEncoder.encode(filename, "UTF-8");//其他浏览器
//                }
//                response.setHeader("Content-Disposition", "attachment; filename=\"" + finalFileName + "\"");//这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
//            } catch (UnsupportedEncodingException e) {
//                throw new UnsupportedOperationException("Fail to set Encode!");
//            }
//            response.addHeader("Content-Disposition", "attachment;filename="
//                    + filename);//这里设置一下让浏览器弹出下载提示框，而不是直接在浏览器中打开
//            response.setContentType("application/pdf");//设置页面下载为普通类型
//            response.reset();//清除response中的缓存
//            //根据网络文件地址创建URL
//            URL url = new URL(path.substring(1, path.length() - 1));
//            //获取此路径的连接
//            URLConnection conn = url.openConnection();//打开这儿链接
//            Long fileLength = conn.getContentLengthLong();//获取文件大小
//            String oldContentType = conn.getContentType();
//            String charset = conn.getContentEncoding();//todo
//            //设置reponse响应头，真实文件名重命名，就是在这里设置，设置编码
//
////            response.setHeader("Content-Disposition",
////                    "attachment; filename=\""
////                            + new String(data_name.getBytes("UTF-8"), "ISO8859-1")
////                            + new String(("." + suffix).getBytes("UTF-8"), "ISO8859-1")
////                            + "\"");
//
//            response.setHeader("Content-Length", String.valueOf(fileLength));
//
//            bis = new BufferedInputStream(conn.getInputStream());//构造缓冲读取流
//            bos = new BufferedOutputStream(response.getOutputStream());//构造输出流
//            byte[] buff = new byte[1024];
//            int bytesRead;
//            //每次读取缓存大小的流，写到输出流
//            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
//                bos.write(buff, 0, bytesRead);
//            }
//            //todo xian xia zai bendi
//            response.flushBuffer();//将所有的读取的流返回给客户端
//        } catch (
//                IOException e) {
//            throw new Exception("文件下载失败！");
//        } finally {
//            try {
//                if (null != bis) {
//                    bis.close();
//                }
//                if (null != bos) {
//                    bos.close();
//                }
//            } catch (Exception e) {
//                throw new Exception("文件下载失败！");
//            }
//        }
//        return null;
//    }
//}
