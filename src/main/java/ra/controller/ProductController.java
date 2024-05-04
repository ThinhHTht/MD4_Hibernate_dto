package ra.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.dto.request.CreateProductRequest;
import ra.dto.request.UpdateProductRequest;
import ra.service.CategoryService;
import ra.service.ProductService;

@Controller
@RequestMapping("productController")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getAll")
    public ModelAndView getAllProducts() {
        ModelAndView mav = new ModelAndView("listProducts");
        mav.addObject("listProducts", productService.findAll());
        return mav;
    }

    @GetMapping("/add")
    public String preAdd(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "addProduct";
    }

    @PostMapping("/add")
    public String doAdd(@ModelAttribute CreateProductRequest productRequest) {
        productService.save(productRequest);
        return "redirect:getAll";
    }

    @GetMapping("update")
    public String preUpdate(Model model, int productId) {
        model.addAttribute("updateProduct", productService.findById(productId));
        model.addAttribute("categories", categoryService.findAll());
        return "updateProduct";
    }

    @PostMapping("/update")
    public String doUpdate(UpdateProductRequest request) {
        productService.update(request);
        return "redirect: getAll";
    }

    @GetMapping("/delete")
    public String delete(int productId){
        productService.delete(productId);
        return "redirect: getAll";
    }

}
