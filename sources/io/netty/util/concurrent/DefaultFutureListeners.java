package io.netty.util.concurrent;

import java.util.Arrays;

/* loaded from: classes5.dex */
final class DefaultFutureListeners {
    private GenericFutureListener<? extends Future<?>>[] listeners;
    private int size = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultFutureListeners(GenericFutureListener<? extends Future<?>> genericFutureListener, GenericFutureListener<? extends Future<?>> genericFutureListener2) {
        this.listeners = r1;
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = {genericFutureListener, genericFutureListener2};
    }

    public void add(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i8 = this.size;
        if (i8 == genericFutureListenerArr.length) {
            genericFutureListenerArr = (GenericFutureListener[]) Arrays.copyOf(genericFutureListenerArr, i8 << 1);
            this.listeners = genericFutureListenerArr;
        }
        genericFutureListenerArr[i8] = genericFutureListener;
        this.size = i8 + 1;
    }

    public GenericFutureListener<? extends Future<?>>[] listeners() {
        return this.listeners;
    }

    public void remove(GenericFutureListener<? extends Future<?>> genericFutureListener) {
        GenericFutureListener<? extends Future<?>>[] genericFutureListenerArr = this.listeners;
        int i8 = this.size;
        for (int i9 = 0; i9 < i8; i9++) {
            if (genericFutureListenerArr[i9] == genericFutureListener) {
                int i10 = (i8 - i9) - 1;
                if (i10 > 0) {
                    System.arraycopy(genericFutureListenerArr, i9 + 1, genericFutureListenerArr, i9, i10);
                }
                int i11 = i8 - 1;
                genericFutureListenerArr[i11] = null;
                this.size = i11;
                return;
            }
        }
    }

    public int size() {
        return this.size;
    }
}
