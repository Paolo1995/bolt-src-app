package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
/* loaded from: classes.dex */
public interface AnalyticsConnector {

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    /* loaded from: classes.dex */
    public interface AnalyticsConnectorHandle {
    }

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    /* loaded from: classes.dex */
    public interface AnalyticsConnectorListener {
        @KeepForSdk
        void a(int i8, Bundle bundle);
    }

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    /* loaded from: classes.dex */
    public static class ConditionalUserProperty {
        @NonNull
        @KeepForSdk

        /* renamed from: a  reason: collision with root package name */
        public String f15417a;
        @NonNull
        @KeepForSdk

        /* renamed from: b  reason: collision with root package name */
        public String f15418b;
        @KeepForSdk

        /* renamed from: c  reason: collision with root package name */
        public Object f15419c;
        @KeepForSdk

        /* renamed from: d  reason: collision with root package name */
        public String f15420d;
        @KeepForSdk

        /* renamed from: e  reason: collision with root package name */
        public long f15421e;
        @KeepForSdk

        /* renamed from: f  reason: collision with root package name */
        public String f15422f;
        @KeepForSdk

        /* renamed from: g  reason: collision with root package name */
        public Bundle f15423g;
        @KeepForSdk

        /* renamed from: h  reason: collision with root package name */
        public String f15424h;
        @KeepForSdk

        /* renamed from: i  reason: collision with root package name */
        public Bundle f15425i;
        @KeepForSdk

        /* renamed from: j  reason: collision with root package name */
        public long f15426j;
        @KeepForSdk

        /* renamed from: k  reason: collision with root package name */
        public String f15427k;
        @KeepForSdk

        /* renamed from: l  reason: collision with root package name */
        public Bundle f15428l;
        @KeepForSdk

        /* renamed from: m  reason: collision with root package name */
        public long f15429m;
        @KeepForSdk

        /* renamed from: n  reason: collision with root package name */
        public boolean f15430n;
        @KeepForSdk

        /* renamed from: o  reason: collision with root package name */
        public long f15431o;
    }

    @KeepForSdk
    void a(@NonNull ConditionalUserProperty conditionalUserProperty);

    @KeepForSdk
    void b(@NonNull String str, @NonNull String str2, Bundle bundle);

    @KeepForSdk
    void c(@NonNull String str, @NonNull String str2, @NonNull Object obj);

    @KeepForSdk
    void clearConditionalUserProperty(@NonNull String str, String str2, Bundle bundle);

    @NonNull
    @KeepForSdk
    Map<String, Object> d(boolean z7);

    @KeepForSdk
    int e(@NonNull String str);

    @NonNull
    @KeepForSdk
    List<ConditionalUserProperty> f(@NonNull String str, String str2);

    @KeepForSdk
    AnalyticsConnectorHandle g(@NonNull String str, @NonNull AnalyticsConnectorListener analyticsConnectorListener);
}
