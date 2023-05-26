package com.google.protobuf;

import com.google.protobuf.WireFormat;
import java.io.IOException;

/* loaded from: classes3.dex */
public class MapEntryLite<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Metadata<K, V> f17503a;

    /* renamed from: b  reason: collision with root package name */
    private final K f17504b;

    /* renamed from: c  reason: collision with root package name */
    private final V f17505c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Metadata<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final WireFormat.FieldType f17506a;

        /* renamed from: b  reason: collision with root package name */
        public final K f17507b;

        /* renamed from: c  reason: collision with root package name */
        public final WireFormat.FieldType f17508c;

        /* renamed from: d  reason: collision with root package name */
        public final V f17509d;

        public Metadata(WireFormat.FieldType fieldType, K k8, WireFormat.FieldType fieldType2, V v7) {
            this.f17506a = fieldType;
            this.f17507b = k8;
            this.f17508c = fieldType2;
            this.f17509d = v7;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k8, WireFormat.FieldType fieldType2, V v7) {
        this.f17503a = new Metadata<>(fieldType, k8, fieldType2, v7);
        this.f17504b = k8;
        this.f17505c = v7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int b(Metadata<K, V> metadata, K k8, V v7) {
        return FieldSet.d(metadata.f17506a, 1, k8) + FieldSet.d(metadata.f17508c, 2, v7);
    }

    public static <K, V> MapEntryLite<K, V> d(WireFormat.FieldType fieldType, K k8, WireFormat.FieldType fieldType2, V v7) {
        return new MapEntryLite<>(fieldType, k8, fieldType2, v7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void e(CodedOutputStream codedOutputStream, Metadata<K, V> metadata, K k8, V v7) throws IOException {
        FieldSet.E(codedOutputStream, metadata.f17506a, 1, k8);
        FieldSet.E(codedOutputStream, metadata.f17508c, 2, v7);
    }

    public int a(int i8, K k8, V v7) {
        return CodedOutputStream.V(i8) + CodedOutputStream.D(b(this.f17503a, k8, v7));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata<K, V> c() {
        return this.f17503a;
    }
}
