package com.asdc.boot.valuation.tool.controller;

import com.asdc.boot.valuation.tool.dto.ScoreInfo;
import com.asdc.boot.valuation.tool.vo.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.bind.JAXBIntrospector.getValue;

/**
 * @author chujiangjiang
 * @date 2019-08-31
 * @deprecated Excel文件导入
 */
@Slf4j
public class ResolveExcelController {

    @RequestMapping("/importExcel")
    @ResponseBody
    public RestResponse importTeacher(@RequestParam String path,
                                      HttpRequest request,
                                      HttpResponse response) throws IOException {


        RestResponse<List<ScoreInfo>> restResponse = new RestResponse<List<ScoreInfo>>();
        List<ScoreInfo> list = new ArrayList<ScoreInfo>();
        try{
        FileInputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);

        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    ScoreInfo scoreInfo = new ScoreInfo();
                    HSSFCell date = hssfRow.getCell(0);
                    HSSFCell blance = hssfRow.getCell(1);
                    scoreInfo.setDate((String) getValue(date));
                    scoreInfo.setBlance((Double) getValue(blance));
                    list.add(scoreInfo);
                }
            }
        }}catch (Exception e){
            log.info("读取Excel失败");
            restResponse.setData(list);
            restResponse.setCode(500);
            restResponse.setMsg("导入失败");
            return restResponse;
        }
        restResponse.setData(list);
        restResponse.setCode(200);
        restResponse.setMsg("导入成功");
        return restResponse;

    }

}
