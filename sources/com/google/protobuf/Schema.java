package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public interface Schema<T> {
    void a(T t7, T t8);

    void b(T t7);

    boolean c(T t7);

    int d(T t7);

    T e();

    boolean equals(T t7, T t8);

    void f(T t7, Writer writer) throws IOException;

    void g(T t7, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void h(T t7, byte[] bArr, int i8, int i9, ArrayDecoders.Registers registers) throws IOException;

    int hashCode(T t7);
}
