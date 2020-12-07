package com.vultum.dreams_notebook.dto.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filter {
    private String search = "";
    private int page = 0;
    private int size = 20;


}
