package com.example.demo.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.demo.model.LogData;

@Service
public class LoggerProcessor {
	
	@Value("${log.file.path}")
	private String folderPath;
	
	private LogData logData;

	@Bean(name="logDataMapping")
    public LogData getData() {
    	StringBuilder sb = new StringBuilder();
    	logData = new LogData();
		try {
			FileInputStream fstream = new FileInputStream(folderPath + "/ClientApp.log");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				sb.append(strLine);
				sb.append(System.lineSeparator());
			}
			fstream.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		logData.setData(sb.toString());
		return logData;
    }
	
	public String[] getLogStrings() {
		String[] responseArr = logData.getData().split("\\r?\\n");
		return responseArr;
	}
}
