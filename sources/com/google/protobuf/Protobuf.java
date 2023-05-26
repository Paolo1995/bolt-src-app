package com.google.protobuf;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class Protobuf {

    /* renamed from: c  reason: collision with root package name */
    private static final Protobuf f17552c = new Protobuf();

    /* renamed from: b  reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Schema<?>> f17554b = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    private final SchemaFactory f17553a = new ManifestSchemaFactory();

    private Protobuf() {
    }

    public static Protobuf a() {
        return f17552c;
    }

    public <T> void b(T t7, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        e(t7).g(t7, reader, extensionRegistryLite);
    }

    public Schema<?> c(Class<?> cls, Schema<?> schema) {
        Internal.b(cls, "messageType");
        Internal.b(schema, "schema");
        return this.f17554b.putIfAbsent(cls, schema);
    }

    public <T> Schema<T> d(Class<T> cls) {
        Internal.b(cls, "messageType");
        Schema<T> schema = (Schema<T>) this.f17554b.get(cls);
        if (schema == null) {
            Schema<T> a8 = this.f17553a.a(cls);
            Schema<T> schema2 = (Schema<T>) c(cls, a8);
            if (schema2 != null) {
                return schema2;
            }
            return a8;
        }
        return schema;
    }

    public <T> Schema<T> e(T t7) {
        return d(t7.getClass());
    }
}
