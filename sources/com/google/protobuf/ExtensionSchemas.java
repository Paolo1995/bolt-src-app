package com.google.protobuf;

/* loaded from: classes3.dex */
final class ExtensionSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final ExtensionSchema<?> f17333a = new ExtensionSchemaLite();

    /* renamed from: b  reason: collision with root package name */
    private static final ExtensionSchema<?> f17334b = c();

    ExtensionSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExtensionSchema<?> a() {
        ExtensionSchema<?> extensionSchema = f17334b;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExtensionSchema<?> b() {
        return f17333a;
    }

    private static ExtensionSchema<?> c() {
        try {
            return (ExtensionSchema) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
