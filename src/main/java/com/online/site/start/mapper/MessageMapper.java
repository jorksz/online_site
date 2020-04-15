package com.online.site.start.mapper;

import com.online.site.start.entity.History;
import com.online.site.start.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    /**
     * 查询信息
     * @param userId 用户id
     * @return
     */
    List<Message> listMessage(Integer userId);

    /**
     * 保存信息
     * @param message
     * @return
     */
    Integer saveMessage(Message message);
}
