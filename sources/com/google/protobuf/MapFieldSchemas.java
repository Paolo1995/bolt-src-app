package com.google.protobuf;

/* loaded from: classes3.dex */
final class MapFieldSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final MapFieldSchema f17512a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final MapFieldSchema f17513b = new MapFieldSchemaLite();

    MapFieldSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema a() {
        return f17512a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MapFieldSchema b() {
        return f17513b;
    }

    private static MapFieldSchema c() {
        try {
            return (MapFieldSchema) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
