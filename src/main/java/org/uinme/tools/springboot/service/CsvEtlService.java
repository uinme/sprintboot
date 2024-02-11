package org.uinme.tools.springboot.service;

import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uinme.tools.springboot.config.Settings;
import org.uinme.tools.springboot.csv.CsvReader;
import org.uinme.tools.springboot.csv.MasterCsvModel;
import org.uinme.tools.springboot.mybatis.TestTable;
import org.uinme.tools.springboot.mybatis.TestTableMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CsvEtlService {
    @Autowired
    private Settings settings;
    @Autowired
    private CsvReader csvReader;
    @Autowired
    private TestTableMapper testTableMapper;
    @Autowired
    private Transformer transformer;
    
    public void run(String... args) {
        List<MasterCsvModel> masterCsvList = csvReader.getData(Paths.get("C:/Users/uinme/Desktop/data.csv"), MasterCsvModel.class);
        
        List<TestTable> testTableList = transformer.transform(masterCsvList);
        
        for (TestTable testTable : testTableList) {
            testTableMapper.insert(testTable);
        }
    }
}
