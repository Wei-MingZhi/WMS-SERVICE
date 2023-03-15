package com.wms.controller;

import com.github.pagehelper.PageInfo;
import com.wms.pojo.Materials;
import com.wms.pojo.OutPutWarehouse;
import com.wms.service.IMaterialService;
import com.wms.service.OutPutWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/out-put-warehouse")
public class OutPutWarehouseController {

    @Autowired
    private IMaterialService iMaterialService;
    @Autowired
    private OutPutWarehouseService outPutWarehouseService;

    /**
     * 查询物品的数据
     * @return
     * @throws Exception
     */
    @RequestMapping("/material-list.do")
    public ModelAndView selectMaterialApply(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                            @RequestParam(name = "size",required = true,defaultValue = "10")Integer size,
                                            @RequestParam(name = "materialsName",required = false,defaultValue = "")String materialsName) throws Exception {
        List<Materials> materialsList = iMaterialService.selectProductAll(page, size, materialsName);
        PageInfo pageInfo = new PageInfo(materialsList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("out-put-warehouse");
        return modelAndView;
    }

    /**
     * 根据id查询要出入库的物品
     * @param materialId
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-out-put-material.do")
    public ModelAndView selectOutPutWarehouseRecord(@RequestParam(name = "materialId", required = true)String materialId) throws Exception {
        Materials materials = iMaterialService.selectMaterialsById(materialId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("materials",materials);
        modelAndView.setViewName("out-put-warehouse-show");
        return modelAndView;
    }

    /**
     * 添加到出入库信息
     * @param outPutWarehouse
     * @return
     * @throws Exception
     */
    @RequestMapping("/add-warehouse-record.do")
    public String addOutPutWarehouseRecord(OutPutWarehouse outPutWarehouse) throws Exception {
        outPutWarehouseService.addOutPutWarehouseRecord(outPutWarehouse);
        return "redirect:/out-put-warehouse/material-list.do";
    }

    /**
     * 查询出入库记录
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-warehouse-record.do")
    public ModelAndView selectOutPutWarehouseRecord(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                                    @RequestParam(name = "size",required = true,defaultValue = "10")Integer size) throws Exception {
        List<OutPutWarehouse> outPutWarehouseList = outPutWarehouseService.selectOutPutWarehouseRecord(page,size);
        PageInfo pageInfo = new PageInfo(outPutWarehouseList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("out-put-warehouse-record");
        return modelAndView;
    }

    /**
     * 跟新审核状态
     * @param id
     * @param auditStatus
     * @return
     * @throws Exception
     */
    @RequestMapping("/update-audit-status.do")
    public String updateOutPutWarehouse(String id,String auditStatus) throws Exception {
        outPutWarehouseService.updateOutPutWarehouse(id,auditStatus);
        return "redirect:/out-put-warehouse/select-warehouse-record.do";
    }

}
