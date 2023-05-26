package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public class MapEntryLite<K, V> {

    /* loaded from: classes.dex */
    static class Metadata<K, V> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int b(Metadata<K, V> metadata, K k8, V v7) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void d(CodedOutputStream codedOutputStream, Metadata<K, V> metadata, K k8, V v7) throws IOException {
        throw null;
    }

    public int a(int i8, K k8, V v7) {
        return CodedOutputStream.U(i8) + CodedOutputStream.C(b(null, k8, v7));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata<K, V> c() {
        return null;
    }
}
