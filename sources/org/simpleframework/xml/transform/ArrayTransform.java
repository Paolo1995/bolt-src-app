package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
class ArrayTransform implements Transform {
    private final Transform delegate;
    private final Class entry;
    private final StringArrayTransform split = new StringArrayTransform();

    public ArrayTransform(Transform transform, Class cls) {
        this.delegate = transform;
        this.entry = cls;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public Object read(String str) throws Exception {
        String[] read = this.split.read(str);
        return read(read, read.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) throws Exception {
        return write(obj, Array.getLength(obj));
    }

    private String write(Object obj, int i8) throws Exception {
        String[] strArr = new String[i8];
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj2 = Array.get(obj, i9);
            if (obj2 != null) {
                strArr[i9] = this.delegate.write(obj2);
            }
        }
        return this.split.write(strArr);
    }

    private Object read(String[] strArr, int i8) throws Exception {
        Object newInstance = Array.newInstance(this.entry, i8);
        for (int i9 = 0; i9 < i8; i9++) {
            Object read = this.delegate.read(strArr[i9]);
            if (read != null) {
                Array.set(newInstance, i9, read);
            }
        }
        return newInstance;
    }
}
