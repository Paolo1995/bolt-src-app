package com.google.crypto.tink.shaded.protobuf;

/* loaded from: classes.dex */
final class ExtensionRegistryFactory {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f15032a = c();

    ExtensionRegistryFactory() {
    }

    public static ExtensionRegistryLite a() {
        ExtensionRegistryLite b8 = b("getEmptyRegistry");
        if (b8 == null) {
            return ExtensionRegistryLite.f15035d;
        }
        return b8;
    }

    private static final ExtensionRegistryLite b(String str) {
        Class<?> cls = f15032a;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
