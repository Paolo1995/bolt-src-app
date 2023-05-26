package com.clevertap.android.sdk.network;

import android.content.Context;
import com.clevertap.android.sdk.events.EventGroup;

/* loaded from: classes.dex */
public abstract class BaseNetworkManager {
    public abstract void a(Context context, EventGroup eventGroup);

    public abstract int b();

    public abstract void c(EventGroup eventGroup, Runnable runnable);

    public abstract boolean d(EventGroup eventGroup);
}
