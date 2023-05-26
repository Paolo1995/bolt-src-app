package org.simpleframework.xml.transform;

import java.lang.reflect.Constructor;
import java.util.Date;

/* loaded from: classes5.dex */
class DateFactory<T extends Date> {
    private final Constructor<T> factory;

    public DateFactory(Class<T> cls) throws Exception {
        this(cls, Long.TYPE);
    }

    public T getInstance(Object... objArr) throws Exception {
        return this.factory.newInstance(objArr);
    }

    public DateFactory(Class<T> cls, Class... clsArr) throws Exception {
        this.factory = cls.getDeclaredConstructor(clsArr);
    }
}
