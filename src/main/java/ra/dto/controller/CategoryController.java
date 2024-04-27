package ra.dto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.dto.dto.request.CreateCategoryRequest;
import ra.dto.dto.response.CreateCategoryResponse;
import ra.dto.model.Category;
import ra.dto.service.CategoryService;

@Controller
@RequestMapping("categoryController")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public ModelAndView getAll(){
        ModelAndView mav = new ModelAndView("listCategories");
        mav.addObject("listCategories", categoryService.findAll());
        return mav;
    }
    @GetMapping("/addCategory")
    public String preAdd(){
        return "addCategory";
    }

    @PostMapping("add")
    public String doAdd(@ModelAttribute CreateCategoryRequest categoryRequest){
        CreateCategoryResponse addedCategory = categoryService.save(categoryRequest);
        return "redirect: getAll";
    }
    @GetMapping("initUpdate")
    public String initUpdate(ModelMap modelMap, int catalogId){
        modelMap.addAttribute("updateCat", categoryService.findById(catalogId));
        return "updateCategory";
    }

    @PostMapping("update")
    public String update(Category category){
        boolean result = categoryService.update(category);
        if(result){
         return "redirect: getAll";
        }return "errors";
    }

    @GetMapping("delete")
    public String delete(int catalogId){
        boolean result = categoryService.delete(catalogId);
        if(result){
            return "redirect: getAll";
        }return "errors";
    }

}
