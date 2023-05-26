package org.simpleframework.xml.transform;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes5.dex */
enum DateType {
    FULL("yyyy-MM-dd HH:mm:ss.S z"),
    LONG("yyyy-MM-dd HH:mm:ss z"),
    NORMAL("yyyy-MM-dd z"),
    SHORT("yyyy-MM-dd");
    
    private DateFormat format;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class DateFormat {
        private SimpleDateFormat format;

        public DateFormat(String str) {
            this.format = new SimpleDateFormat(str);
        }

        public synchronized Date getDate(String str) throws Exception {
            return this.format.parse(str);
        }

        public synchronized String getText(Date date) throws Exception {
            return this.format.format(date);
        }
    }

    DateType(String str) {
        this.format = new DateFormat(str);
    }

    public static Date getDate(String str) throws Exception {
        return getType(str).getFormat().getDate(str);
    }

    private DateFormat getFormat() {
        return this.format;
    }

    public static String getText(Date date) throws Exception {
        return FULL.getFormat().getText(date);
    }

    public static DateType getType(String str) {
        int length = str.length();
        if (length > 23) {
            return FULL;
        }
        if (length > 20) {
            return LONG;
        }
        if (length > 11) {
            return NORMAL;
        }
        return SHORT;
    }
}
