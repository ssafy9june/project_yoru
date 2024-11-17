package com.june.yorushika_java.item;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    @Autowired
    private final ItemRepository itemRepository;

    public void saveItem(Map<String, String> formData) throws Exception {
        Integer id = formData.containsKey("id") && !formData.get("id").isEmpty()
                ? Integer.parseInt(formData.get("id"))
                : null;

        Item targetItem;

        if (id != null && itemRepository.existsById(id.longValue())) {
            targetItem = itemRepository.getReferenceById(id.longValue());
        } else {
            targetItem = new Item();
        }

        targetItem.setTitle(formData.get("title"));
        targetItem.setPrice(Integer.parseInt(formData.get("price")));

        if (targetItem.isValid()) {
            itemRepository.save(targetItem);
        } else {
            throw new ResponseStatusException(
                HttpStatus.NOT_ACCEPTABLE, "is not valid"
            );
        }
    }

//    public void deleteItem(Long id) throws Exception {
//        System.out.println(id);
//        itemRepository.deleteById(id);
//    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }
}
