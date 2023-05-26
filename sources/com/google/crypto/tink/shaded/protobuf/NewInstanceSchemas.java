package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
final class NewInstanceSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final NewInstanceSchema f15182a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final NewInstanceSchema f15183b = new NewInstanceSchemaLite();

    NewInstanceSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NewInstanceSchema a() {
        return f15182a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NewInstanceSchema b() {
        return f15183b;
    }

    private static NewInstanceSchema c() {
        try {
            return (NewInstanceSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
