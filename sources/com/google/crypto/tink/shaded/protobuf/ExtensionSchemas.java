package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
final class ExtensionSchemas {

    /* renamed from: a  reason: collision with root package name */
    private static final ExtensionSchema<?> f15040a = new ExtensionSchemaLite();

    /* renamed from: b  reason: collision with root package name */
    private static final ExtensionSchema<?> f15041b = c();

    ExtensionSchemas() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExtensionSchema<?> a() {
        ExtensionSchema<?> extensionSchema = f15041b;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ExtensionSchema<?> b() {
        return f15040a;
    }

    private static ExtensionSchema<?> c() {
        try {
            return (ExtensionSchema) Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
