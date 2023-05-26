package org.simpleframework.xml.transform;

/* loaded from: classes5.dex */
public interface Transform<T> {
    T read(String str) throws Exception;

    String write(T t7) throws Exception;
}
