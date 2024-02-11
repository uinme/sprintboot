package org.uinme.tools.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.uinme.tools.springboot.config.Settings;
import org.uinme.tools.springboot.csv.MasterCsvModel;
import org.uinme.tools.springboot.mybatis.TestTable;

@Component
public class Transformer {
    @Autowired
    private Settings settings;
    
    public List<TestTable> transform(List<MasterCsvModel> masterCsvList) {
        List<TestTable> testTableList = new ArrayList<TestTable>();
        for (MasterCsvModel masterCsv : masterCsvList) {
            TestTable testTable = new TestTable();
            testTable.setColumn1(masterCsv.getColumn1());
            testTable.setColumn2(masterCsv.getColumn2());
            testTable.setColumn3(masterCsv.getColumn3());
            testTable.setColumn4(masterCsv.getColumn4());
            testTable.setColumn5(masterCsv.getColumn5());
            testTableList.add(testTable);
        }
        return testTableList;
    }
}
