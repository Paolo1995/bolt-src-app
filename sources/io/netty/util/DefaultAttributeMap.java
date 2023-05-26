package io.netty.util;

import androidx.concurrent.futures.a;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes5.dex */
public class DefaultAttributeMap implements AttributeMap {
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, AtomicReferenceArray> updater = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, AtomicReferenceArray.class, "attributes");
    private volatile AtomicReferenceArray<DefaultAttribute<?>> attributes;

    private static int index(AttributeKey<?> attributeKey) {
        return attributeKey.id() & 3;
    }

    @Override // io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> attributeKey) {
        ObjectUtil.checkNotNull(attributeKey, "key");
        AtomicReferenceArray<DefaultAttribute<?>> atomicReferenceArray = this.attributes;
        if (atomicReferenceArray == null) {
            atomicReferenceArray = new AtomicReferenceArray<>(4);
            if (!a.a(updater, this, null, atomicReferenceArray)) {
                atomicReferenceArray = this.attributes;
            }
        }
        int index = index(attributeKey);
        DefaultAttribute<?> defaultAttribute = atomicReferenceArray.get(index);
        if (defaultAttribute == null) {
            DefaultAttribute defaultAttribute2 = new DefaultAttribute();
            DefaultAttribute defaultAttribute3 = new DefaultAttribute(defaultAttribute2, attributeKey);
            defaultAttribute2.next = defaultAttribute3;
            defaultAttribute3.prev = defaultAttribute2;
            if (io.ktor.utils.io.pool.a.a(atomicReferenceArray, index, null, defaultAttribute2)) {
                return defaultAttribute3;
            }
            defaultAttribute = atomicReferenceArray.get(index);
        }
        synchronized (defaultAttribute) {
            DefaultAttribute<?> defaultAttribute4 = defaultAttribute;
            while (true) {
                DefaultAttribute<?> defaultAttribute5 = ((DefaultAttribute) defaultAttribute4).next;
                if (defaultAttribute5 == null) {
                    DefaultAttribute defaultAttribute6 = new DefaultAttribute(defaultAttribute, attributeKey);
                    ((DefaultAttribute) defaultAttribute4).next = defaultAttribute6;
                    defaultAttribute6.prev = defaultAttribute4;
                    return defaultAttribute6;
                } else if (((DefaultAttribute) defaultAttribute5).key == attributeKey && !((DefaultAttribute) defaultAttribute5).removed) {
                    return defaultAttribute5;
                } else {
                    defaultAttribute4 = defaultAttribute5;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private final DefaultAttribute<?> head;
        private final AttributeKey<T> key;
        private DefaultAttribute<?> next;
        private DefaultAttribute<?> prev;
        private volatile boolean removed;

        DefaultAttribute(DefaultAttribute<?> defaultAttribute, AttributeKey<T> attributeKey) {
            this.head = defaultAttribute;
            this.key = attributeKey;
        }

        /* JADX WARN: Multi-variable type inference failed */
        DefaultAttribute() {
            this.head = this;
            this.key = null;
        }
    }
}
