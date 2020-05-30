package com.online.site.start.service;

import com.github.pagehelper.Page;
import com.online.site.start.entity.Video;

import java.util.List;

public interface VideoService {

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
    Video getVideo(Integer id, Integer isPass);


    /**
     * 获取全部视频
     * @return
     */
    Page<Video> listAll(Integer isPass);

    /**
     * 删除视频
     * @param id 视频id
     * @return
     */
    boolean deleteVideo(Integer id);

    /**
     * 视频审核
     * @param video
     * @return
     */
    boolean updateVideo(Video video);

    /**
     * 上传视频
     * @param video 视频
     * @return
     */
    boolean uploadVideo(Video video);
}
