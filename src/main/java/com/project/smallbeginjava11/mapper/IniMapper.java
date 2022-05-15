package com.project.smallbeginjava11.mapper;

import java.util.Map;

import com.project.smallbeginjava11.DTO.Initiative;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IniMapper {
    void insertIni(Map<String, Object> params);
    Initiative selectMaxIniByObCode(Map<String, Object> map);

}
