package com.google.protobuf;

/* loaded from: classes3.dex */
final class ExtensionRegistryFactory {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f17325a = c();

    ExtensionRegistryFactory() {
    }

    public static ExtensionRegistryLite a() {
        ExtensionRegistryLite b8 = b("getEmptyRegistry");
        if (b8 == null) {
            return ExtensionRegistryLite.f17328d;
        }
        return b8;
    }

    private static final ExtensionRegistryLite b(String str) {
        Class<?> cls = f17325a;
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
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
