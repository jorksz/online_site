package com.online.site.start.service;

import com.online.site.start.entity.History;

import java.util.List;

public interface HistoryService {
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
    boolean saveHistory(History history);
}
