package com.june.yorushika_java;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model){

        List<Item> result = itemRepository.findAll();
//        System.out.println(result.get(1).getTitle());
        var a = new Item();
//        System.out.println(a.toString());
//        System.out.println(a.getTitle());

        model.addAttribute("items", result);
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam Map<String, String> formData) {
        System.out.println(formData);
        System.out.println(formData.get("title"));
        System.out.println(formData.get("price"));

        Item newItem = new Item();
        newItem.setTitle(formData.get("title"));
        newItem.setPrice(Integer.parseInt(formData.get("price")));

        if (newItem.isValid()) {
            itemRepository.save(newItem);
            return "redirect:/list";
        } else {
            return "redirect:/error";
        }
    }

    @GetMapping("/detail/{id}")
    String detail(Model model, @PathVariable Long id) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
//            System.out.println(result.get());
            model.addAttribute("detail", result.get());
            return "detail.html";
        } else {
            return "error.html";
        }
    }
}
