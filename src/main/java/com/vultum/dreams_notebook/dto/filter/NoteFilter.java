package com.vultum.dreams_notebook.dto.filter;

import com.vultum.dreams_notebook.dto.EnumWrapper;
import com.vultum.dreams_notebook.enums.NoteSortingFields;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteFilter extends Filter {
    private Long author;
    private NoteSortingFields orderBy = NoteSortingFields.DATE_CREATE;

    public void setOrderBy(EnumWrapper orderBy) {
        if (orderBy != null)
            this.orderBy = NoteSortingFields.valueOf(orderBy.getValue());
    }
}
