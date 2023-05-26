package com.russhwolf.settings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharedPreferencesSettings.kt */
/* loaded from: classes3.dex */
public final class SharedPreferencesSettings implements Settings {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f19595a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f19596b;

    public SharedPreferencesSettings(SharedPreferences delegate, boolean z7) {
        Intrinsics.f(delegate, "delegate");
        this.f19595a = delegate;
        this.f19596b = z7;
    }

    @Override // com.russhwolf.settings.Settings
    public Boolean a(String key) {
        Intrinsics.f(key, "key");
        if (this.f19595a.contains(key)) {
            return Boolean.valueOf(this.f19595a.getBoolean(key, false));
        }
        return null;
    }

    @Override // com.russhwolf.settings.Settings
    public Float b(String key) {
        Intrinsics.f(key, "key");
        if (this.f19595a.contains(key)) {
            return Float.valueOf(this.f19595a.getFloat(key, 0.0f));
        }
        return null;
    }

    @Override // com.russhwolf.settings.Settings
    public String c(String key) {
        Intrinsics.f(key, "key");
        if (this.f19595a.contains(key)) {
            return this.f19595a.getString(key, "");
        }
        return null;
    }

    @Override // com.russhwolf.settings.Settings
    public Long d(String key) {
        Intrinsics.f(key, "key");
        if (this.f19595a.contains(key)) {
            return Long.valueOf(this.f19595a.getLong(key, 0L));
        }
        return null;
    }

    @Override // com.russhwolf.settings.Settings
    public Integer e(String key) {
        Intrinsics.f(key, "key");
        if (this.f19595a.contains(key)) {
            return Integer.valueOf(this.f19595a.getInt(key, 0));
        }
        return null;
    }

    @Override // com.russhwolf.settings.Settings
    public Double f(String key) {
        Intrinsics.f(key, "key");
        if (this.f19595a.contains(key)) {
            DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.f51004a;
            return Double.valueOf(Double.longBitsToDouble(this.f19595a.getLong(key, Double.doubleToRawLongBits(0.0d))));
        }
        return null;
    }

    @Override // com.russhwolf.settings.Settings
    @SuppressLint({"CommitPrefEdits"})
    public void putString(String key, String value) {
        Intrinsics.f(key, "key");
        Intrinsics.f(value, "value");
        SharedPreferences.Editor putString = this.f19595a.edit().putString(key, value);
        Intrinsics.e(putString, "delegate.edit().putString(key, value)");
        if (this.f19596b) {
            putString.commit();
        } else {
            putString.apply();
        }
    }

    public /* synthetic */ SharedPreferencesSettings(SharedPreferences sharedPreferences, boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i8 & 2) != 0 ? false : z7);
    }
}
