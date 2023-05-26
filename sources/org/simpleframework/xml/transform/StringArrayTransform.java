package org.simpleframework.xml.transform;

import java.util.regex.Pattern;

/* loaded from: classes5.dex */
class StringArrayTransform implements Transform<String[]> {
    private final Pattern pattern;
    private final String token;

    public StringArrayTransform() {
        this(",");
    }

    public StringArrayTransform(String str) {
        this.pattern = Pattern.compile(str);
        this.token = str;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String[] read(String str) {
        return read(str, this.token);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(String[] strArr) {
        return write(strArr, this.token);
    }

    private String[] read(String str, String str2) {
        String[] split = this.pattern.split(str);
        for (int i8 = 0; i8 < split.length; i8++) {
            String str3 = split[i8];
            if (str3 != null) {
                split[i8] = str3.trim();
            }
        }
        return split;
    }

    private String write(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            if (str2 != null) {
                if (sb.length() > 0) {
                    sb.append(str);
                    sb.append(' ');
                }
                sb.append(str2);
            }
        }
        return sb.toString();
    }
}
