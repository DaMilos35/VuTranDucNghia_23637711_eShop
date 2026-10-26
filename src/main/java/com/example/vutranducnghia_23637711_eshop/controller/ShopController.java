package com.example.vutranducnghia_23637711_eshop.controller;

import com.example.vutranducnghia_23637711_eshop.service.CategoryService;
import com.example.vutranducnghia_23637711_eshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping({"/", "/products"})
    public String index(@RequestParam(required = false) String keyword,
                        @RequestParam(required = false) Long categoryId,
                        @RequestParam(defaultValue = "0") int page,
                        Model model) {
        model.addAttribute("products", productService.search(keyword, categoryId, page, 12));
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("keyword", keyword);
        model.addAttribute("categoryId", categoryId);
        return "shop/index";
    }

    @GetMapping("/products/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "shop/detail";
    }

    @GetMapping("/help")
    public String help(@RequestParam(required = false, defaultValue = "all") String tab, Model model) {
        model.addAttribute("activeTab", tab);
        model.addAttribute("categories", categoryService.findAll());
        return "help/index";
    }

    @GetMapping("/terms")
    public String terms(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "help/terms";
    }
}
