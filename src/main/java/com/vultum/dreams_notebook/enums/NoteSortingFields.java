package com.vultum.dreams_notebook.enums;

public enum NoteSortingFields {
    DATE_CREATE,
    DATE_UPDATE,
    DATE_DREAM;

    // this names using on front
    public String getName() {
        switch (this) {
            case DATE_DREAM:
                return "Дате сна";
            case DATE_CREATE:
                return "Дате создания";
            case DATE_UPDATE:
                return "Дате редактирования";
            default:
                return null;
        }
    }
}
