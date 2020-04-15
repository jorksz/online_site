package com.online.site.start.controller;

import com.online.site.start.entity.History;
import com.online.site.start.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping("/{userId}")
    public List<History> listHistory(@PathVariable Integer userId){
        return historyService.listHistory(userId);
    }
}
