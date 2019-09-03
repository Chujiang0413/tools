package com.asdc.boot.valuation.tool.service;

import com.asdc.boot.valuation.tool.util.Result;
import org.springframework.web.multipart.MultipartFile;

public interface ResolveExcelService {
    Result importExcel(MultipartFile file);
}
