package com.vultum.dreams_notebook.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtils {

    public static Long toUnix(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    public static Long nowUnix() {
        return toUnix(LocalDateTime.now());
    }
}
