package com.core.Category;

import com.core.DTO.CategoryDTO;

import java.util.List;
import java.util.Objects;

public class HtmlCategoryMenu {
    //#exampleAccordion\" href=\"#exampleAccordion1\" aria-expanded=\"true\" aria-controls=\"exampleAccordion1\">\n"
    public String genereteHtml(List<CategoryDTO> categoryTree) {
        StringBuilder sb = new StringBuilder();
        for (CategoryDTO category : categoryTree) {
            //raiz
            sb.append("<div id=\"collapse").append(category.getId()).append("\" data-children=\".item\">");
            sb.append("<div class=\"item\">");
            sb.append("<div class=\"main p-2\">");
            sb.append("<a data-toggle=\"collapse\" data-parent=\"#collapse")
                    .append(category.getId())
                    .append("\" href=\"#collapse")
                    .append(category.getId())
                    .append("\" aria-expanded=\"true\"")
                    .append("aria-controls=\"")
                    .append("collapse")
                    .append(category.getId())
                    .append("\">\n");
            sb.append(category.getName());
            sb.append("</a>");
            sb.append("<i class=\"fa fa-chevron-right\" aria-hidden=\"true\"></i>");
            sb.append("</div>");
            sb.append("</div>");
            sb.append("</div>");
        }
        System.out.println(sb.toString());
        return null;
    }

    public void children(List<CategoryDTO> categoryDTOS) {

    }
}
