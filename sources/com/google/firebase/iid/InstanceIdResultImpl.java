package com.google.firebase.iid;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes3.dex */
final class InstanceIdResultImpl implements InstanceIdResult {

    /* renamed from: a  reason: collision with root package name */
    private final String f16314a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16315b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstanceIdResultImpl(String str, String str2) {
        this.f16314a = str;
        this.f16315b = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String a() {
        return this.f16315b;
    }
}
