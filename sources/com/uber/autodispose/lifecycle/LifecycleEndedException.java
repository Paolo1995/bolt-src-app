package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

/* loaded from: classes3.dex */
public class LifecycleEndedException extends OutsideScopeException {
    public LifecycleEndedException() {
        this("Lifecycle has ended!");
    }

    public LifecycleEndedException(String str) {
        super(str);
    }
}
