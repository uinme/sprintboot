package org.uinme.tools.springboot.csv;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "column1",
    "column2",
    "column3",
    "column4",
    "column5"
})
public class MasterCsvModel {
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
}
