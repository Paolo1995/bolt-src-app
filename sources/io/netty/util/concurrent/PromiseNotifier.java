package io.netty.util.concurrent;

import io.netty.util.concurrent.Future;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PromiseNotificationUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* loaded from: classes5.dex */
public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PromiseNotifier.class);
    private final boolean logNotifyFailure;
    private final Promise<? super V>[] promises;

    @SafeVarargs
    public PromiseNotifier(boolean z7, Promise<? super V>... promiseArr) {
        ObjectUtil.checkNotNull(promiseArr, "promises");
        for (Promise<? super V> promise : promiseArr) {
            if (promise == null) {
                throw new IllegalArgumentException("promises contains null Promise");
            }
        }
        this.promises = (Promise[]) promiseArr.clone();
        this.logNotifyFailure = z7;
    }

    @Override // io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(F f8) throws Exception {
        InternalLogger internalLogger;
        if (this.logNotifyFailure) {
            internalLogger = logger;
        } else {
            internalLogger = null;
        }
        int i8 = 0;
        if (f8.isSuccess()) {
            Object obj = f8.get();
            Promise<? super V>[] promiseArr = this.promises;
            int length = promiseArr.length;
            while (i8 < length) {
                PromiseNotificationUtil.trySuccess(promiseArr[i8], obj, internalLogger);
                i8++;
            }
        } else if (f8.isCancelled()) {
            Promise<? super V>[] promiseArr2 = this.promises;
            int length2 = promiseArr2.length;
            while (i8 < length2) {
                PromiseNotificationUtil.tryCancel(promiseArr2[i8], internalLogger);
                i8++;
            }
        } else {
            Throwable cause = f8.cause();
            Promise<? super V>[] promiseArr3 = this.promises;
            int length3 = promiseArr3.length;
            while (i8 < length3) {
                PromiseNotificationUtil.tryFailure(promiseArr3[i8], cause, internalLogger);
                i8++;
            }
        }
    }
}
