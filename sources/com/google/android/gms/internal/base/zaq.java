package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes.dex */
public interface zaq {
    ExecutorService zaa(ThreadFactory threadFactory, int i8);

    ExecutorService zab(int i8, int i9);

    ExecutorService zac(int i8, ThreadFactory threadFactory, int i9);
}
