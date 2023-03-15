package com.wms.controller;

import com.github.pagehelper.PageInfo;
import com.wms.common.DateUtils;
import com.wms.pojo.Materials;
import com.wms.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/material")
public class MaterialController {

    @Autowired
    private IMaterialService iMaterialService;

    /**
     * 查询所有物品
     * @param page
     * @param size
     * @param materialsName
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-material-all.do")
    public ModelAndView selectProductAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                         @RequestParam(name = "size",required = true,defaultValue = "10")Integer size,
                                         @RequestParam(name = "materialsName",required = false,defaultValue = "")String materialsName) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Materials> materialsList = iMaterialService.selectProductAll(page,size,materialsName);
        if (!CollectionUtils.isEmpty(materialsList)) {
            for (Materials materials : materialsList) {
                // 时间格式转换
                String s = DateUtils.dateToString(materials.getCreatedTime());
                materials.setCreatedTimeStr(s);
            }
        }
        PageInfo pageInfo = new PageInfo(materialsList);
        modelAndView.addObject("materialsList",materialsList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("material-list");
        return modelAndView;

    }

    /**
     * 添加物品
     * @param material
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String addMaterial(Materials material) throws Exception {
        iMaterialService.addMaterial(material);
        return "redirect:/material/select-material-all.do";
    }

    /**
     * 更新物品信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/update-materials.do")
    public String updateMaterials(Materials materials) throws Exception {
        iMaterialService.updateMaterials(materials);
        return "redirect:/material/select-material-all.do";
    }

    /**
     * 根据id查询物品
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/select-id.do")
    public ModelAndView selectMaterialsById(@RequestParam(name = "id",required = true) String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Materials materials = iMaterialService.selectMaterialsById(id);
        modelAndView.addObject("material",materials);
        modelAndView.setViewName("material-update");
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
        iMaterialService.delMaterials(id);
        return "redirect:/material/select-material-all.do";
    }

    /**
     * 批量删除物品
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping("/del-list.do")
    public String delMaterials(@RequestParam(value = "ids",required=true)List<String> ids) throws Exception {
        iMaterialService.delMaterialsList(ids);
        return "redirect:/material/select-material-all.do";
    }

}
