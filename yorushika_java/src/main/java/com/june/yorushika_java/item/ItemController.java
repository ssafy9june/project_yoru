package com.june.yorushika_java.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model){

//        System.out.println(result.get(1).getTitle());
        var a = new Item();
//        System.out.println(a.toString());
//        System.out.println(a.getTitle());

        model.addAttribute("items", itemService.findAllItems());
        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String addPost(@RequestParam Map<String, String> formData) throws Exception {
        System.out.println(formData);
        itemService.saveItem(formData);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(Model model, @PathVariable Long id) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            System.out.println(result.get());
            model.addAttribute("detail", result.get());
            return "detail.html";
        } else {
            return "error.html";
            }
    }

    @GetMapping("/edit/{id}")
    String edit(Model model, @PathVariable Long id) {
        Optional<Item> savedData = itemRepository.findById(id);
        if (savedData.isPresent()) {
            model.addAttribute("e", savedData.get());
            return "edit.html";
        } else {
            return "error.html";
        }
    }

    @DeleteMapping("/item")
    ResponseEntity<String> deleteItem(@RequestParam Long id) throws Exception {
        System.out.println("controller" + id);
        itemRepository.deleteById(id);
        return ResponseEntity.status(200).body("삭제완료");
    }

//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("error occurred");
//        }


}
