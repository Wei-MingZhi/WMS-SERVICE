package com.wms.controller;

import com.github.pagehelper.PageInfo;
import com.wms.pojo.Materials;
import com.wms.pojo.StorageLocationRevolving;
import com.wms.service.IMaterialService;
import com.wms.service.StorageLocationRevolvingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/storage-location-revolving")
public class StorageLocationRevolvingController {

    @Autowired
    private IMaterialService iMaterialService;
    @Autowired
    private StorageLocationRevolvingService storageLocationRevolvingService;

    /**
     * 查询物品的信息
     * @param page
     * @param size
     * @param materialsName
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-material.do")
    public ModelAndView selectMaterial(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                       @RequestParam(name = "size",required = true,defaultValue = "10")Integer size,
                                       @RequestParam(name = "materialsName",required = false,defaultValue = "")String materialsName) throws Exception {
        List<Materials> materialsList = iMaterialService.selectProductAll(page,size,materialsName);
        PageInfo pageInfo = new PageInfo(materialsList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("storage-location-revolving");
        return modelAndView;
    }

    /**
     * 根据id查询物品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-material-by-id.do")
    public ModelAndView selectStorageLocationRevolving(String id) throws Exception {
        Materials materials = iMaterialService.selectMaterialsById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("materials",materials);
        modelAndView.setViewName("storage-location-revolving-show");
        return modelAndView;
    }

    /**
     * 添加物品周转申请记录
     * @param storageLocationRevolving
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-storage-location-revolving.do")
    public String addStorageLocationRevolvingRecord(StorageLocationRevolving storageLocationRevolving) throws Exception {
        storageLocationRevolvingService.addStorageLocationRevolvingRecord(storageLocationRevolving);
        return "redirect:/storage-location-revolving/select-material.do";
    }

    /**
     * 查询物品申请记录
     * @param materialName
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-revolving-record.do")
    public ModelAndView selectStorageLocationRevolvingRecord(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                                             @RequestParam(name = "size",required = true,defaultValue = "10")Integer size,
                                                             @RequestParam(name = "materialsName",required = false,defaultValue = "")String materialsName) throws Exception {
        List<StorageLocationRevolving> storageLocationRevolvingList = storageLocationRevolvingService.selectStorageLocationRevolvingRecord(page,size,materialsName);
        PageInfo pageInfo = new PageInfo(storageLocationRevolvingList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("storage-location-revolving-record");
        return modelAndView;
    }


    /**
     * 更新物品库位周转的审核状态
     * @return
     * @throws Exception
     */
    @RequestMapping("/update-revolving-record.do")
    public String updateStorageLocationRevolvingRecord(String id,String auditStatus) throws Exception {
        storageLocationRevolvingService.updateStorageLocationRevolving(id,auditStatus);
        return "redirect:/storage-location-revolving/select-revolving-record.do";
    }

}
