package org.simpleframework.xml.transform;

import java.util.Date;

/* loaded from: classes5.dex */
class DateTransform<T extends Date> implements Transform<T> {
    private final DateFactory<T> factory;

    public DateTransform(Class<T> cls) throws Exception {
        this.factory = new DateFactory<>(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.simpleframework.xml.transform.Transform
    public /* bridge */ /* synthetic */ String write(Object obj) throws Exception {
        return write((DateTransform<T>) ((Date) obj));
    }

    @Override // org.simpleframework.xml.transform.Transform
    public synchronized T read(String str) throws Exception {
        return this.factory.getInstance(Long.valueOf(DateType.getDate(str).getTime()));
    }

    public synchronized String write(T t7) throws Exception {
        return DateType.getText(t7);
    }
}
