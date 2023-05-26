package com.clevertap.android.sdk;

import android.content.Context;
import com.clevertap.android.sdk.events.BaseEventQueueManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class LocationManager extends BaseLocationManager {

    /* renamed from: a  reason: collision with root package name */
    private int f11058a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f11059b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final BaseEventQueueManager f11060c;

    /* renamed from: d  reason: collision with root package name */
    private final CleverTapInstanceConfig f11061d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f11062e;

    /* renamed from: f  reason: collision with root package name */
    private final CoreMetaData f11063f;

    /* renamed from: g  reason: collision with root package name */
    private final Logger f11064g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationManager(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, CoreMetaData coreMetaData, BaseEventQueueManager baseEventQueueManager) {
        this.f11062e = context;
        this.f11061d = cleverTapInstanceConfig;
        this.f11064g = cleverTapInstanceConfig.n();
        this.f11063f = coreMetaData;
        this.f11060c = baseEventQueueManager;
    }
}
