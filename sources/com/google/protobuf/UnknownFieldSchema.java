package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class UnknownFieldSchema<T, B> {
    abstract void a(B b8, int i8, int i9);

    abstract void b(B b8, int i8, long j8);

    abstract void c(B b8, int i8, T t7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(B b8, int i8, ByteString byteString);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(B b8, int i8, long j8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h(T t7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i(T t7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T k(T t7, T t8);

    final void l(B b8, Reader reader) throws IOException {
        while (reader.A() != Integer.MAX_VALUE && m(b8, reader)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(B b8, Reader reader) throws IOException {
        int a8 = reader.a();
        int a9 = WireFormat.a(a8);
        int b9 = WireFormat.b(a8);
        if (b9 != 0) {
            if (b9 != 1) {
                if (b9 != 2) {
                    if (b9 != 3) {
                        if (b9 != 4) {
                            if (b9 == 5) {
                                a(b8, a9, reader.u());
                                return true;
                            }
                            throw InvalidProtocolBufferException.e();
                        }
                        return false;
                    }
                    B n8 = n();
                    int c8 = WireFormat.c(a9, 4);
                    l(n8, reader);
                    if (c8 == reader.a()) {
                        c(b8, a9, r(n8));
                        return true;
                    }
                    throw InvalidProtocolBufferException.b();
                }
                d(b8, a9, reader.o());
                return true;
            }
            b(b8, a9, reader.b());
            return true;
        }
        e(b8, a9, reader.H());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, B b8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, T t7);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(Reader reader);

    abstract T r(B b8);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(T t7, Writer writer) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(T t7, Writer writer) throws IOException;
}
