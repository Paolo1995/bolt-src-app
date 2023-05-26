package com.hivemq.client.internal.util.collections;

import com.hivemq.client.internal.util.collections.NodeList;

/* loaded from: classes3.dex */
public class HandleList<E> extends NodeList<Handle<E>> {

    /* loaded from: classes3.dex */
    public static class Handle<E> extends NodeList.Node<Handle<E>> {

        /* renamed from: c  reason: collision with root package name */
        private final E f18684c;

        Handle(E e8) {
            this.f18684c = e8;
        }

        public E c() {
            return this.f18684c;
        }
    }

    public Handle<E> i(E e8) {
        Handle<E> handle = new Handle<>(e8);
        a(handle);
        return handle;
    }
}
