package com.wms.controller;

import com.github.pagehelper.PageInfo;
import com.wms.common.DateUtils;
import com.wms.pojo.StorageLocation;
import com.wms.service.StorageLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/storageLocation")
public class StorageLocationController {

    @Autowired
    private StorageLocationService storageLocationService;

    /**
     * 查询所有库区库位
     * @param page
     * @param size
     * @param storageLocationName
     * @return
     * @throws Exception
     */
    @RequestMapping("/storage-location-list.do")
    public ModelAndView selectStorageLocationAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                                 @RequestParam(name = "size",required = true,defaultValue = "10")Integer size,
                                                 @RequestParam(name = "storageLocationName",required = false,defaultValue = "")String storageLocationName) throws Exception{
        List<StorageLocation> storageLocationList = storageLocationService.selectStorageLocationAll(page, size, storageLocationName);
        if (!CollectionUtils.isEmpty(storageLocationList)) {
            for (StorageLocation storageLocation : storageLocationList) {
                // 时间格式转换
                String createdTime = DateUtils.dateToString(storageLocation.getCreatedTime());
                storageLocation.setCreatedTimeStr(createdTime);
            }
        }
        PageInfo pageInfo = new PageInfo(storageLocationList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("storageLocationList",storageLocationList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("storage-location-list");
        return modelAndView;
    }

    /**
     * 查询库区库位-下拉框
     * @return
     * @throws Exception
     */
    @RequestMapping("/get-storage-location-list.do")
    public @ResponseBody List<StorageLocation> getStorageLocationList() throws Exception {
        return storageLocationService.selectStorageLocationAList();
    }

    /**
     * 添加库区库位
     * @param storageLocation
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String addStorageLocation(StorageLocation storageLocation) throws Exception{
        storageLocationService.addStorageLocation(storageLocation);
        return "redirect:/storageLocation/storage-location-list.do";
    }

    /**
     * 更新库存库位信息
     * @param storageLocation
     * @return
     * @throws Exception
     */
    @RequestMapping("/update-storageLocation.do")
    public String updateStorageLocation(StorageLocation storageLocation) throws Exception {
        storageLocationService.updateStorageLocation(storageLocation);
        return "redirect:/storageLocation/storage-location-list.do";
    }


    /**
     * 根据id查询库区库位
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-id.do")
    public ModelAndView selectStorageLocationById(@RequestParam(name = "id",required = true) String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        StorageLocation storageLocation = storageLocationService.selectStorageLocationById(id);
        modelAndView.addObject("storageLocation",storageLocation);
        modelAndView.setViewName("storage-location-update");
        return modelAndView;

    }


    /**
     * 删除单个物品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/del.do")
    public String delMaterials(String id) throws Exception {
        storageLocationService.delStorageLocation(id);
        return "redirect:/storageLocation/storage-location-list.do";
    }

    /**
     * 批量删除库位信息
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/del-list.do")
    public String delMaterials(@RequestParam(value = "ids",required=true)List<String> ids) throws Exception {
        storageLocationService.delStorageLocationList(ids);
        return "redirect:/storageLocation/storage-location-list.do";
    }

}
