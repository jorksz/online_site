package com.online.site.start.mapper;

import com.online.site.start.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VideoMapper {

    /**
     * 根据视频名查询
     * @param videoName 视频名
     * @return
     */
    List<Video> listVideos(String videoName, Integer isPass);

    /**
     * 根据视频类型查询
     * @param typeName
     * @return
     */
    List<Video> listVideosByType(String typeName, Integer isPass);

    /**
     * 根据ID获取某个视频
     * @param id
     * @return
     */
    List<Video> getVideo(Integer id, Integer isPass);

    /**
     * 获取全部视频
     * @return
     */
    List<Video> listAll(Integer isPass);

    /**
     * 获取全部视频-管理员
     * @return
     */
    List<Video> listAllM();

    /**
     * 删除视频
     * @param id 视频id
     * @return
     */
    Integer deleteVideo(Integer id);

    /**
     * 更新视频审核
     * @param id 视频id
     * @param isPass
     * @return
     */
    Integer updateVideo(Integer id, Integer isPass);

    /**
     * 保存视频
     * @param video 视频
     * @return
     */
    Integer saveVideo(Video video);
}
