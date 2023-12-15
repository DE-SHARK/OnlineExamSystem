package org.liulinger.Service.Impl;

import org.liulinger.Service.GetExamService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetExamServiceImpl implements GetExamService {
    public GetExamServiceImpl() {
    }
    @Override
    public String GetExam(String url) throws IOException {
        // 读取本地JSON文件路径
        String filePath = url;
        // 读取JSON文件内容
        StringBuilder jsonData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonData.append(line);
            }
        }
        String jsondata = jsonData.toString();
        return jsondata;
    }
}
