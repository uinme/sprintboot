package org.uinme.tools.springboot.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestTableMapper {
    @Insert("insert into test (column1, column2, column3, column4, column5) values (#{column1}, #{column2}, #{column3}, #{column4}, #{column5})")
    void insert(TestTable records);
}
