package com.vultum.dreams_notebook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnumWrapper {
    private String name;
    private String value;

    public EnumWrapper(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
