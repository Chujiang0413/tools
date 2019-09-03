package com.asdc.boot.valuation.tool.controller;

import com.asdc.boot.valuation.tool.service.ResolveExcelService;
import com.asdc.boot.valuation.tool.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chujiangjiang
 * @date 2019-08-31
 * @deprecated Excel文件导入
 */
@Slf4j
@RestController
@RequestMapping("")
public class ResolveExcelController {

    @Autowired
    ResolveExcelService resolveExcelService;

    @RequestMapping("/importExcel")
    @ResponseBody
    public Result importExcel(@RequestParam String path,HttpRequest request,HttpResponse response) {
        return resolveExcelService.importExcel();
    }

}
