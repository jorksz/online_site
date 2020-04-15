package com.online.site.start.mapper;

import com.online.site.start.entity.History;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HistoryMapper {

    /**
     * 查询历史信息
     * @param userId 用户id
     * @return
     */
    List<History> listHistory(Integer userId);

    /**
     * 保存历史信息
     * @param history
     * @return
     */
    Integer saveHistory(History history);
}
