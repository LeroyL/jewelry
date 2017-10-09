package com.jewelry.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by lier on 2017/9/29.
 */
public interface BaseService<T> {

    /**
     * 查找单个实体
     * @param id   实体ID
     * @return
     */
    T findOne(int id);

    /**
     * 分页查找实体列表
     * @param pageable 分页对象
     * @return
     */
    Page<T> findAll(Pageable pageable);

    /**
     * 保存实体-新增/更新
     * @param entity 实体对象
     * @return
     */
    T save(T entity);

    /**
     * 删除实体
     * @param id 实体ID
     * @return 0 = 成功，-1 = 失败
     */
    int delete(int id);

    /**
     * 批量保存实体
     * @param entities 实体列表
     * @return
     */
    List<T> batchSave(List<T> entities);

}
