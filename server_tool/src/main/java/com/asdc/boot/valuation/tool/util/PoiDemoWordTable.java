//package com.asdc.boot.valuation.tool.util;
//
//import org.apache.poi.xwpf.usermodel.XWPFDocument;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//
//import static com.asdc.boot.valuation.tool.util.WordUtils.replaceAll;
//
//public class PoiDemoWordTable {
//    public static void main(String[] args) throws Exception {
//        final String returnurl = "d://poi/test.docx";
//        final String templateurl = "D://poi/onepage.docx";
//        InputStream is = new FileInputStream(new File(templateurl));
//        XWPFDocument doc = new XWPFDocument(is);
//        replaceAll(doc);
//        //文件存在删除
//        try {
//            File file = new File(returnurl);
//            if (file.exists()) {
//                file.delete();
//            }
//            FileOutputStream fos = new FileOutputStream(returnurl);
//            doc.write(fos);
//            fos.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
