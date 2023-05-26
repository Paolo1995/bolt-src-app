package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

/* loaded from: classes5.dex */
class CharacterArrayTransform implements Transform {
    private final Class entry;

    public CharacterArrayTransform(Class cls) {
        this.entry = cls;
    }

    @Override // org.simpleframework.xml.transform.Transform
    public Object read(String str) throws Exception {
        char[] charArray = str.toCharArray();
        return this.entry == Character.TYPE ? charArray : read(charArray, charArray.length);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Object obj) throws Exception {
        int length = Array.getLength(obj);
        if (this.entry == Character.TYPE) {
            return new String((char[]) obj);
        }
        return write(obj, length);
    }

    private Object read(char[] cArr, int i8) throws Exception {
        Object newInstance = Array.newInstance(this.entry, i8);
        for (int i9 = 0; i9 < i8; i9++) {
            Array.set(newInstance, i9, Character.valueOf(cArr[i9]));
        }
        return newInstance;
    }

    private String write(Object obj, int i8) throws Exception {
        StringBuilder sb = new StringBuilder(i8);
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj2 = Array.get(obj, i9);
            if (obj2 != null) {
                sb.append(obj2);
            }
        }
        return sb.toString();
    }
}
