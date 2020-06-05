package com.online.site.start.service.impl;

import com.online.site.start.entity.History;
import com.online.site.start.mapper.HistoryMapper;
import com.online.site.start.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper histroyMapper;

    @Override
    public List<History> listHistory(Integer userId) {
        return histroyMapper.listHistory(userId);
    }

    @Override
    public boolean saveHistory(History history) {
        return histroyMapper.saveHistory(history) > 0;
    }

    @Override
    public boolean deleteHistory(Integer historyId) {
        return histroyMapper.deleteHistory(historyId) > 0;
    }
}
