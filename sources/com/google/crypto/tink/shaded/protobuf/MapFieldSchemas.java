package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
final class MapFieldSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final MapFieldSchema f15157a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final MapFieldSchema f15158b = new MapFieldSchemaLite();

    MapFieldSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema a() {
        return f15157a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema b() {
        return f15158b;
    }

    private static MapFieldSchema c() {
        try {
            return (MapFieldSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
