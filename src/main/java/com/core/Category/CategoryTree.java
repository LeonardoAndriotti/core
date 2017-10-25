package com.core.Category;

import com.core.DTO.CategoryDTO;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.isNull;

public class CategoryTree {




    public List<CategoryDTO> rootCategory(List<CategoryDTO> categorys) {
        List<CategoryDTO> categoryJson = new LinkedList<>();

        for (CategoryDTO category : categorys) {
            if (isNull(category.getIdFather())) {
                category.setChildren(leafCategory(categorys, category));
                categoryJson.add(category);
            }
        }
        return categoryJson;
    }

    private List<CategoryDTO> leafCategory(List<CategoryDTO> categoryChildren, CategoryDTO categoryRoot) {
        List<CategoryDTO> categoryJsonChildren = new LinkedList<>();
        for (CategoryDTO leafCategory : categoryChildren) {
            if (categoryRoot.getId().equals(leafCategory.getIdFather())) {
                leafCategory.setChildren(leafCategory(categoryChildren, leafCategory));
                categoryJsonChildren.add(leafCategory);
            }

        }
        return categoryJsonChildren;
    }


}
