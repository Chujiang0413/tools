package com.asdc.boot.valuation.tool.service.impl;

import com.asdc.boot.valuation.tool.dto.ScoreInfo;
import com.asdc.boot.valuation.tool.service.ResolveExcelService;
import com.asdc.boot.valuation.tool.util.DateFormatUtil;
import com.asdc.boot.valuation.tool.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.bind.JAXBIntrospector.getValue;

@Slf4j
@Service
public class ResolveExcelServiceImpl implements ResolveExcelService {

    @Override
    public Result importExcel(MultipartFile file) {
        List<ScoreInfo> list = new ArrayList<ScoreInfo>();
        if (file.getOriginalFilename().indexOf("xlsx") != -1) {
            try {
                InputStream is = file.getInputStream();
                XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                    XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                    if (null == xssfSheet) {
                        continue;
                    }
                    // 循环行Row
                    for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                        XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                        if (null == xssfRow.getCell(0) || null == xssfRow.getCell(1)
                                || "".equals(String.valueOf(xssfRow.getCell(0)))
                                || "".equals(String.valueOf(xssfRow.getCell(1)))) {
                            ScoreInfo scoreInfo = new ScoreInfo();
                            XSSFCell date = xssfRow.getCell(0);
                            XSSFCell blance = xssfRow.getCell(1);

                            /**
                             * 日期格式转换
                             */
                            scoreInfo.setDate(DateFormatUtil.formatDate(String.valueOf(date)));
                            scoreInfo.setBlance((Double) getValue(blance));
                            list.add(scoreInfo);
                        }
                    }
                }
            } catch (Exception e) {
                log.info("读取Excel失败");
                return Result.handleError("导入失败");
            }
            return Result.handleSuccess("导入成功", list);
        } else {
            try {
                InputStream is = file.getInputStream();
                HSSFWorkbook xssfWorkbook = new HSSFWorkbook(is);
                // 循环工作表Sheet
                for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                    HSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                    if (null == xssfSheet) {
                        continue;
                    }
                    // 循环行Row
                    for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                        HSSFRow xssfRow = xssfSheet.getRow(rowNum);
                        if (null == xssfRow.getCell(0) || null == xssfRow.getCell(1)
                                || "".equals(String.valueOf(xssfRow.getCell(0)))
                                || "".equals(String.valueOf(xssfRow.getCell(1)))) {
                            ScoreInfo scoreInfo = new ScoreInfo();
                            HSSFCell date = xssfRow.getCell(0);
                            HSSFCell blance = xssfRow.getCell(1);

                            /**
                             * 日期格式转换
                             */
                            scoreInfo.setDate(DateFormatUtil.formatDate(String.valueOf(date)));
                            scoreInfo.setBlance((Double) getValue(blance));
                            list.add(scoreInfo);
                        }
                    }
                }
            } catch (Exception e) {
                log.info("读取Excel失败");
                return Result.handleError("导入失败");
            }
            return Result.handleSuccess("导入成功", list);
        }

    }
}
