package org.simpleframework.xml.transform;

import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
class LocaleTransform implements Transform<Locale> {
    private final Pattern pattern = Pattern.compile("_");

    @Override // org.simpleframework.xml.transform.Transform
    public Locale read(String str) throws Exception {
        String[] split = this.pattern.split(str);
        if (split.length >= 1) {
            return read(split);
        }
        throw new InvalidFormatException("Invalid locale %s", str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Locale locale) {
        return locale.toString();
    }

    private Locale read(String[] strArr) throws Exception {
        String[] strArr2 = {"", "", ""};
        for (int i8 = 0; i8 < 3; i8++) {
            if (i8 < strArr.length) {
                strArr2[i8] = strArr[i8];
            }
        }
        return new Locale(strArr2[0], strArr2[1], strArr2[2]);
    }
}
