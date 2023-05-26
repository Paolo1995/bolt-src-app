package org.simpleframework.xml.transform;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* loaded from: classes5.dex */
class TimeZoneTransform implements Transform<TimeZone> {
    @Override // org.simpleframework.xml.transform.Transform
    public TimeZone read(String str) {
        return DesugarTimeZone.getTimeZone(str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(TimeZone timeZone) {
        return timeZone.getID();
    }
}
