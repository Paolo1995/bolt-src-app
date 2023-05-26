package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes3.dex */
public class Settings {

    /* renamed from: a  reason: collision with root package name */
    public final SessionData f16157a;

    /* renamed from: b  reason: collision with root package name */
    public final FeatureFlagData f16158b;

    /* renamed from: c  reason: collision with root package name */
    public final long f16159c;

    /* renamed from: d  reason: collision with root package name */
    public final int f16160d;

    /* renamed from: e  reason: collision with root package name */
    public final int f16161e;

    /* renamed from: f  reason: collision with root package name */
    public final double f16162f;

    /* renamed from: g  reason: collision with root package name */
    public final double f16163g;

    /* renamed from: h  reason: collision with root package name */
    public final int f16164h;

    /* loaded from: classes3.dex */
    public static class FeatureFlagData {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f16165a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f16166b;

        public FeatureFlagData(boolean z7, boolean z8) {
            this.f16165a = z7;
            this.f16166b = z8;
        }
    }

    /* loaded from: classes3.dex */
    public static class SessionData {

        /* renamed from: a  reason: collision with root package name */
        public final int f16167a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16168b;

        public SessionData(int i8, int i9) {
            this.f16167a = i8;
            this.f16168b = i9;
        }
    }

    public Settings(long j8, SessionData sessionData, FeatureFlagData featureFlagData, int i8, int i9, double d8, double d9, int i10) {
        this.f16159c = j8;
        this.f16157a = sessionData;
        this.f16158b = featureFlagData;
        this.f16160d = i8;
        this.f16161e = i9;
        this.f16162f = d8;
        this.f16163g = d9;
        this.f16164h = i10;
    }

    public boolean a(long j8) {
        if (this.f16159c < j8) {
            return true;
        }
        return false;
    }
}
