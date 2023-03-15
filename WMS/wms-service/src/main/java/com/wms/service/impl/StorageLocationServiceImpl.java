package com.wms.service.impl;

import com.github.pagehelper.PageHelper;
import com.wms.dao.StorageLocationDao;
import com.wms.pojo.StorageLocation;
import com.wms.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Transactional
public class StorageLocationServiceImpl implements StorageLocationService {

    @Autowired
    private StorageLocationDao storageLocationDao;

    /**
     * 查询所有库区库位
     * @param page
     * @param size
     * @param storageLocationName
     * @return
     * @throws Exception
     */
    @Override
    public List<StorageLocation> selectStorageLocationAll(Integer page, Integer size,String storageLocationName) throws Exception {
        PageHelper.startPage(page,size);
        return storageLocationDao.selectStorageLocationAll(storageLocationName);
    }

    /**
     * 查询所有库区库位-下拉框
     * @return
     * @throws Exception
     */
    @Override
    public List<StorageLocation> selectStorageLocationAList() throws Exception {
        return storageLocationDao.selectStorageLocationAll(null);
    }

    /**
     * 添加库区库位
     * @param storageLocation
     * @throws Exception
     */
    @Override
    public void addStorageLocation(StorageLocation storageLocation) throws Exception {
        if (!ObjectUtils.isEmpty(storageLocation)) {
            storageLocation.setCreatedBy("admin");
            storageLocation.setUpdatedBy("admin");
            storageLocationDao.addStorageLocation(storageLocation);
        }
    }

    /**
     * 更新库位库区信息
     * @param storageLocation
     * @throws Exception
     */
    @Override
    public void updateStorageLocation(StorageLocation storageLocation) throws Exception {
        storageLocationDao.updateStorageLocation(storageLocation);
    }

    /**
     * 根据id查询库区库位信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public StorageLocation selectStorageLocationById(String id) throws Exception {
        return storageLocationDao.selectStorageLocationById(Integer.valueOf(id));
    }

    /**
     * 删除库位信息
     * @param id
     * @throws Exception
     */
    @Override
    public void delStorageLocation(String id) throws Exception {
        storageLocationDao.delStorageLocation(Integer.valueOf(id));
    }

    /**
     * 批量删除库位信息
     * @param ids
     * @throws Exception
     */
    @Override
    public void delStorageLocationList(List<String> ids) throws Exception {
        if (!CollectionUtils.isEmpty(ids)) {
            ids.forEach(i ->{
                if (!i.isEmpty()){
                    try {
                        storageLocationDao.delStorageLocation(Integer.valueOf(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
