package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.proto.Protobuf;
import java.lang.annotation.Annotation;

/* loaded from: classes3.dex */
public final class AtProtobuf {

    /* renamed from: a  reason: collision with root package name */
    private int f16224a;

    /* renamed from: b  reason: collision with root package name */
    private Protobuf.IntEncoding f16225b = Protobuf.IntEncoding.DEFAULT;

    /* loaded from: classes3.dex */
    private static final class ProtobufImpl implements Protobuf {

        /* renamed from: a  reason: collision with root package name */
        private final int f16226a;

        /* renamed from: b  reason: collision with root package name */
        private final Protobuf.IntEncoding f16227b;

        ProtobufImpl(int i8, Protobuf.IntEncoding intEncoding) {
            this.f16226a = i8;
            this.f16227b = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            if (this.f16226a == protobuf.tag() && this.f16227b.equals(protobuf.intEncoding())) {
                return true;
            }
            return false;
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (this.f16226a ^ 14552422) + (this.f16227b.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.f16227b;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.f16226a;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f16226a + "intEncoding=" + this.f16227b + ')';
        }
    }

    public static AtProtobuf b() {
        return new AtProtobuf();
    }

    public Protobuf a() {
        return new ProtobufImpl(this.f16224a, this.f16225b);
    }

    public AtProtobuf c(int i8) {
        this.f16224a = i8;
        return this;
    }
}
