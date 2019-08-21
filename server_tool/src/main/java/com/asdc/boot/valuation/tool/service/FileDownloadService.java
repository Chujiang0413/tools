package com.asdc.boot.valuation.tool.service;

public interface FileDownloadService {
    /**
     * 根据project_id查询文件列表
     * @param project_id
     * @return
     */
    String findFileList(String project_id);
}
