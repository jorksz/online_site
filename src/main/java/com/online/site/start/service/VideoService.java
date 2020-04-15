package com.online.site.start.service;

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
    List<Video> getVideo(Integer id, Integer isPass);


    /**
     * 获取全部视频
     * @return
     */
    List<Video> listAll(Integer isPass);

    /**
     * 获取全部视频
     * @return
     */
    List<Video> listAllM();


    /**
     * 删除视频
     * @param id 视频id
     * @return
     */
    boolean deleteVideo(Integer id);

    /**
     * 更新视频审核
     * @param id 视频id
     * @param isPass 审核是否通过
     * @return
     */
    boolean updateVideo(Integer id, Integer isPass);

    /**
     * 上传视频
     * @param video 视频
     * @return
     */
    boolean uploadVideo(Video video);
}
