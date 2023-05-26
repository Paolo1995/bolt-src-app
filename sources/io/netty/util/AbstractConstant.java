package io.netty.util;

import io.netty.util.AbstractConstant;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public abstract class AbstractConstant<T extends AbstractConstant<T>> implements Constant<T> {
    private static final AtomicLong uniqueIdGenerator = new AtomicLong();
    private final int id;
    private final String name;
    private final long uniquifier = uniqueIdGenerator.getAndIncrement();

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractConstant(int i8, String str) {
        this.id = i8;
        this.name = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((AbstractConstant<T>) obj);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final int id() {
        return this.id;
    }

    public final String name() {
        return this.name;
    }

    public final String toString() {
        return name();
    }

    public final int compareTo(T t7) {
        if (this == t7) {
            return 0;
        }
        int hashCode = hashCode() - t7.hashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        long j8 = this.uniquifier;
        long j9 = t7.uniquifier;
        if (j8 < j9) {
            return -1;
        }
        if (j8 > j9) {
            return 1;
        }
        throw new Error("failed to compare two different constants");
    }
}
