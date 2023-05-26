package io.netty.util;

import io.netty.util.Constant;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public abstract class ConstantPool<T extends Constant<T>> {
    private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
    private final AtomicInteger nextId = new AtomicInteger(1);

    private static String checkNotNullAndNotEmpty(String str) {
        ObjectUtil.checkNotNull(str, "name");
        if (!str.isEmpty()) {
            return str;
        }
        throw new IllegalArgumentException("empty name");
    }

    private T getOrCreate(String str) {
        T t7 = this.constants.get(str);
        if (t7 == null) {
            T newConstant = newConstant(nextId(), str);
            T putIfAbsent = this.constants.putIfAbsent(str, newConstant);
            if (putIfAbsent == null) {
                return newConstant;
            }
            return putIfAbsent;
        }
        return t7;
    }

    protected abstract T newConstant(int i8, String str);

    @Deprecated
    public final int nextId() {
        return this.nextId.getAndIncrement();
    }

    public T valueOf(Class<?> cls, String str) {
        return valueOf(((Class) ObjectUtil.checkNotNull(cls, "firstNameComponent")).getName() + '#' + ((String) ObjectUtil.checkNotNull(str, "secondNameComponent")));
    }

    public T valueOf(String str) {
        checkNotNullAndNotEmpty(str);
        return getOrCreate(str);
    }
}
