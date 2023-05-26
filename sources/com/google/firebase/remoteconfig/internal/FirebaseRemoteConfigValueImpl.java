package com.google.firebase.remoteconfig.internal;

import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;

/* loaded from: classes3.dex */
public class FirebaseRemoteConfigValueImpl implements FirebaseRemoteConfigValue {

    /* renamed from: a  reason: collision with root package name */
    private final String f17133a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17134b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfigValueImpl(String str, int i8) {
        this.f17133a = str;
        this.f17134b = i8;
    }

    private String e() {
        return a().trim();
    }

    private void f() {
        if (this.f17133a != null) {
            return;
        }
        throw new IllegalArgumentException("Value is null, and cannot be converted to the desired type.");
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public String a() {
        if (this.f17134b == 0) {
            return "";
        }
        f();
        return this.f17133a;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public long b() {
        if (this.f17134b == 0) {
            return 0L;
        }
        String e8 = e();
        try {
            return Long.valueOf(e8).longValue();
        } catch (NumberFormatException e9) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", e8, "long"), e9);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public double c() {
        if (this.f17134b == 0) {
            return 0.0d;
        }
        String e8 = e();
        try {
            return Double.valueOf(e8).doubleValue();
        } catch (NumberFormatException e9) {
            throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", e8, "double"), e9);
        }
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public boolean d() throws IllegalArgumentException {
        if (this.f17134b == 0) {
            return false;
        }
        String e8 = e();
        if (ConfigGetParameterHandler.f17108f.matcher(e8).matches()) {
            return true;
        }
        if (ConfigGetParameterHandler.f17109g.matcher(e8).matches()) {
            return false;
        }
        throw new IllegalArgumentException(String.format("[Value: %s] cannot be converted to a %s.", e8, "boolean"));
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
    public int getSource() {
        return this.f17134b;
    }
}
