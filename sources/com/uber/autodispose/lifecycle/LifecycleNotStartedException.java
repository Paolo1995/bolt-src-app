package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;

/* loaded from: classes3.dex */
public class LifecycleNotStartedException extends OutsideScopeException {
    public LifecycleNotStartedException() {
        this("Lifecycle hasn't started!");
    }

    public LifecycleNotStartedException(String str) {
        super(str);
    }
}
