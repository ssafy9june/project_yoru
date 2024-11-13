package com.june.yorushika_java;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model){

        List<Item> result = itemRepository.findAll();
        System.out.println(result.get(1).title);
        var a = new Item();
        System.out.println(a.toString());

        model.addAttribute("items", result);
        return "list.html";
    }
}
