package com.how2java.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
 
// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	
	 @Autowired
	 CategoryService categoryService;
	
	@RequestMapping(value="/categories",method=RequestMethod.GET)
    public String editCategory(Category category){
        Category c= categoryService.get(1);
        JSONObject json= new JSONObject();
        json.put("category", JSONObject.toJSON(c));
        return json.toJSONString();
    }  
	
    @ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category) {
        System.out.println("SSM接受到浏览器提交的json，并转换为Category对象:"+category);
        return "ok";
    }
     
    @ResponseBody
    @RequestMapping(value = "/getOneCategory/{id}",method=RequestMethod.GET)
    public String getOneCategory1(Category c) {
         Category category = categoryService.get(c.getId());
         JSONObject json= new JSONObject();
         json.put("category", JSONObject.toJSON(category));
         return json.toJSONString();
    }
    @ResponseBody
    @RequestMapping("/getManyCategory")
    public String getManyCategory() {
        List<Category> cs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }
 
        return JSONObject.toJSON(cs).toString();
    }
 
}