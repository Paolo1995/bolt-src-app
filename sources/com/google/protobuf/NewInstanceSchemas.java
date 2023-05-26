package com.google.protobuf;

/* loaded from: classes3.dex */
final class NewInstanceSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final NewInstanceSchema f17540a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final NewInstanceSchema f17541b = new NewInstanceSchemaLite();

    NewInstanceSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NewInstanceSchema a() {
        return f17540a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NewInstanceSchema b() {
        return f17541b;
    }

    private static NewInstanceSchema c() {
        try {
            return (NewInstanceSchema) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
