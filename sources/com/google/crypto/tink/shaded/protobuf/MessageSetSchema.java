package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet;
import com.google.crypto.tink.shaded.protobuf.LazyField;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class MessageSetSchema<T> implements Schema<T> {

    /* renamed from: a  reason: collision with root package name */
    private final MessageLite f15178a;

    /* renamed from: b  reason: collision with root package name */
    private final UnknownFieldSchema<?, ?> f15179b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f15180c;

    /* renamed from: d  reason: collision with root package name */
    private final ExtensionSchema<?> f15181d;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        this.f15179b = unknownFieldSchema;
        this.f15180c = extensionSchema.e(messageLite);
        this.f15181d = extensionSchema;
        this.f15178a = messageLite;
    }

    private <UT, UB> int i(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t7) {
        return unknownFieldSchema.i(unknownFieldSchema.g(t7));
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void j(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t7, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        UB f8 = unknownFieldSchema.f(t7);
        FieldSet<ET> d8 = extensionSchema.d(t7);
        do {
            try {
                if (reader.A() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                unknownFieldSchema.o(t7, f8);
            }
        } while (l(reader, extensionRegistryLite, extensionSchema, d8, unknownFieldSchema, f8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSetSchema<T> k(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean l(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB ub) throws IOException {
        int a8 = reader.a();
        if (a8 != WireFormat.f15267a) {
            if (WireFormat.b(a8) == 2) {
                Object b8 = extensionSchema.b(extensionRegistryLite, this.f15178a, WireFormat.a(a8));
                if (b8 != null) {
                    extensionSchema.h(reader, b8, extensionRegistryLite, fieldSet);
                    return true;
                }
                return unknownFieldSchema.m(ub, reader);
            }
            return reader.D();
        }
        int i8 = 0;
        Object obj = null;
        ByteString byteString = null;
        while (reader.A() != Integer.MAX_VALUE) {
            int a9 = reader.a();
            if (a9 == WireFormat.f15269c) {
                i8 = reader.h();
                obj = extensionSchema.b(extensionRegistryLite, this.f15178a, i8);
            } else if (a9 == WireFormat.f15270d) {
                if (obj != null) {
                    extensionSchema.h(reader, obj, extensionRegistryLite, fieldSet);
                } else {
                    byteString = reader.o();
                }
            } else if (!reader.D()) {
                break;
            }
        }
        if (reader.a() == WireFormat.f15268b) {
            if (byteString != null) {
                if (obj != null) {
                    extensionSchema.i(byteString, obj, extensionRegistryLite, fieldSet);
                } else {
                    unknownFieldSchema.d(ub, i8, byteString);
                }
            }
            return true;
        }
        throw InvalidProtocolBufferException.a();
    }

    private <UT, UB> void m(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t7, Writer writer) throws IOException {
        unknownFieldSchema.s(unknownFieldSchema.g(t7), writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void a(T t7, T t8) {
        SchemaUtil.G(this.f15179b, t7, t8);
        if (this.f15180c) {
            SchemaUtil.E(this.f15181d, t7, t8);
        }
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void b(T t7) {
        this.f15179b.j(t7);
        this.f15181d.f(t7);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public final boolean c(T t7) {
        return this.f15181d.c(t7).o();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int d(T t7) {
        int i8 = i(this.f15179b, t7) + 0;
        if (this.f15180c) {
            return i8 + this.f15181d.c(t7).j();
        }
        return i8;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public T e() {
        return (T) this.f15178a.newBuilderForType().g();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public boolean equals(T t7, T t8) {
        if (!this.f15179b.g(t7).equals(this.f15179b.g(t8))) {
            return false;
        }
        if (this.f15180c) {
            return this.f15181d.c(t7).equals(this.f15181d.c(t8));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00cb A[EDGE_INSN: B:57:0x00cb->B:34:0x00cb ?: BREAK  , SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(T r11, byte[] r12, int r13, int r14, com.google.crypto.tink.shaded.protobuf.ArrayDecoders.Registers r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite r0 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite) r0
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r2 = com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite.e()
            if (r1 != r2) goto L11
            com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite r1 = com.google.crypto.tink.shaded.protobuf.UnknownFieldSetLite.l()
            r0.unknownFields = r1
        L11:
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$ExtendableMessage r11 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.ExtendableMessage) r11
            com.google.crypto.tink.shaded.protobuf.FieldSet r11 = r11.E()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Ld7
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.I(r12, r13, r15)
            int r13 = r15.f14975a
            int r3 = com.google.crypto.tink.shaded.protobuf.WireFormat.f15267a
            r5 = 2
            if (r13 == r3) goto L6b
            int r3 = com.google.crypto.tink.shaded.protobuf.WireFormat.b(r13)
            if (r3 != r5) goto L66
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r2 = r10.f15181d
            com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r3 = r15.f14978d
            com.google.crypto.tink.shaded.protobuf.MessageLite r5 = r10.f15178a
            int r6 = com.google.crypto.tink.shaded.protobuf.WireFormat.a(r13)
            java.lang.Object r2 = r2.b(r3, r5, r6)
            r8 = r2
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L5b
            com.google.crypto.tink.shaded.protobuf.Protobuf r13 = com.google.crypto.tink.shaded.protobuf.Protobuf.a()
            com.google.crypto.tink.shaded.protobuf.MessageLite r2 = r8.b()
            java.lang.Class r2 = r2.getClass()
            com.google.crypto.tink.shaded.protobuf.Schema r13 = r13.d(r2)
            int r13 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.p(r13, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$ExtensionDescriptor r2 = r8.f15103b
            java.lang.Object r3 = r15.f14977c
            r11.w(r2, r3)
            goto L64
        L5b:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.G(r2, r3, r4, r5, r6, r7)
        L64:
            r2 = r8
            goto L19
        L66:
            int r13 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.N(r13, r12, r4, r14, r15)
            goto L19
        L6b:
            r13 = 0
            r3 = r0
        L6d:
            if (r4 >= r14) goto Lcb
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r6 = r15.f14975a
            int r7 = com.google.crypto.tink.shaded.protobuf.WireFormat.a(r6)
            int r8 = com.google.crypto.tink.shaded.protobuf.WireFormat.b(r6)
            if (r7 == r5) goto Lac
            r9 = 3
            if (r7 == r9) goto L83
            goto Lc1
        L83:
            if (r2 == 0) goto La1
            com.google.crypto.tink.shaded.protobuf.Protobuf r6 = com.google.crypto.tink.shaded.protobuf.Protobuf.a()
            com.google.crypto.tink.shaded.protobuf.MessageLite r7 = r2.b()
            java.lang.Class r7 = r7.getClass()
            com.google.crypto.tink.shaded.protobuf.Schema r6 = r6.d(r7)
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.p(r6, r12, r4, r14, r15)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$ExtensionDescriptor r6 = r2.f15103b
            java.lang.Object r7 = r15.f14977c
            r11.w(r6, r7)
            goto L6d
        La1:
            if (r8 != r5) goto Lc1
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.b(r12, r4, r15)
            java.lang.Object r3 = r15.f14977c
            com.google.crypto.tink.shaded.protobuf.ByteString r3 = (com.google.crypto.tink.shaded.protobuf.ByteString) r3
            goto L6d
        Lac:
            if (r8 != 0) goto Lc1
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.I(r12, r4, r15)
            int r13 = r15.f14975a
            com.google.crypto.tink.shaded.protobuf.ExtensionSchema<?> r2 = r10.f15181d
            com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite r6 = r15.f14978d
            com.google.crypto.tink.shaded.protobuf.MessageLite r7 = r10.f15178a
            java.lang.Object r2 = r2.b(r6, r7, r13)
            com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L6d
        Lc1:
            int r7 = com.google.crypto.tink.shaded.protobuf.WireFormat.f15268b
            if (r6 != r7) goto Lc6
            goto Lcb
        Lc6:
            int r4 = com.google.crypto.tink.shaded.protobuf.ArrayDecoders.N(r6, r12, r4, r14, r15)
            goto L6d
        Lcb:
            if (r3 == 0) goto Ld4
            int r13 = com.google.crypto.tink.shaded.protobuf.WireFormat.c(r13, r5)
            r1.n(r13, r3)
        Ld4:
            r13 = r4
            goto L19
        Ld7:
            if (r13 != r14) goto Lda
            return
        Lda:
            com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException r11 = com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException.g()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.MessageSetSchema.f(java.lang.Object, byte[], int, int, com.google.crypto.tink.shaded.protobuf.ArrayDecoders$Registers):void");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void g(T t7, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        j(this.f15179b, this.f15181d, t7, reader, extensionRegistryLite);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public void h(T t7, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> r7 = this.f15181d.c(t7).r();
        while (r7.hasNext()) {
            Map.Entry<?, Object> next = r7.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.g() == WireFormat.JavaType.MESSAGE && !fieldDescriptorLite.b() && !fieldDescriptorLite.i()) {
                if (next instanceof LazyField.LazyEntry) {
                    writer.b(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry) next).a().e());
                } else {
                    writer.b(fieldDescriptorLite.getNumber(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        m(this.f15179b, t7, writer);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Schema
    public int hashCode(T t7) {
        int hashCode = this.f15179b.g(t7).hashCode();
        if (this.f15180c) {
            return (hashCode * 53) + this.f15181d.c(t7).hashCode();
        }
        return hashCode;
    }
}
