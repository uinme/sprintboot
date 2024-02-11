package org.uinme.tools.springboot.csv;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Component
public class CsvReader {    
    public <T> List<T> getData(Path filePath, Class<T> clazz) {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper
                .schemaFor(clazz)
                // ヘッダー有の場合
                //.withHeader()
                // ヘッダー無の場合
                .withoutHeader();
        try {
            MappingIterator<T> mappingIterator = mapper.readerFor(clazz)
                .with(schema)
                .readValues(filePath.toFile());
            return (List<T>) mappingIterator.readAll();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
