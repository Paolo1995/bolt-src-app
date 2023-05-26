package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.ArrayDecoders;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface Schema<T> {
    void a(T t7, T t8);

    void b(T t7);

    boolean c(T t7);

    int d(T t7);

    T e();

    boolean equals(T t7, T t8);

    void f(T t7, byte[] bArr, int i8, int i9, ArrayDecoders.Registers registers) throws IOException;

    void g(T t7, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    void h(T t7, Writer writer) throws IOException;

    int hashCode(T t7);
}
