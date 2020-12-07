package com.vultum.dreams_notebook.dto;

import com.vultum.dreams_notebook.entity.Note;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoteWrapper extends Wrapper<Note> {
    private Long id;
    private String title;
    private String text;
    private UserWrapper author;

    public NoteWrapper() {}

    public NoteWrapper(Note note) {
        toWrapper(note);
    }

    @Override
    public void toWrapper(Note item) {
        if (item != null) {
            id = item.getId();
            title = item.getTitle();
            text = item.getText();
            author = new UserWrapper(item.getAuthor());
        }
    }

    @Override
    public void fromWrapper(Note item) {
        if (item != null) {
            item.setTitle(title);
            item.setText(text);
        }
    }
}
