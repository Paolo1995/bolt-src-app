package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* renamed from: com.google.protobuf.ExtensionSchemaLite$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17332a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f17332a = iArr;
            try {
                iArr[WireFormat.FieldType.f17672h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17332a[WireFormat.FieldType.f17673i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17332a[WireFormat.FieldType.f17674j.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17332a[WireFormat.FieldType.f17675k.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17332a[WireFormat.FieldType.f17676l.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17332a[WireFormat.FieldType.f17677m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17332a[WireFormat.FieldType.f17678n.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17332a[WireFormat.FieldType.f17679o.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17332a[WireFormat.FieldType.f17684t.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17332a[WireFormat.FieldType.f17686v.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17332a[WireFormat.FieldType.f17687w.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17332a[WireFormat.FieldType.f17688x.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17332a[WireFormat.FieldType.f17689y.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17332a[WireFormat.FieldType.f17685u.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17332a[WireFormat.FieldType.f17683s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f17332a[WireFormat.FieldType.f17680p.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17332a[WireFormat.FieldType.f17681q.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f17332a[WireFormat.FieldType.f17682r.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.ExtensionDescriptor) entry.getKey()).getNumber();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public Object b(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i8) {
        return extensionRegistryLite.a(messageLite, i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> c(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> d(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).ensureExtensionsAreMutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public boolean e(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public void f(Object obj) {
        c(obj).x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public <UT, UB> UB g(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) throws IOException {
        Object i8;
        ArrayList arrayList;
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        int f8 = generatedExtension.f();
        if (generatedExtension.f17435d.b() && generatedExtension.f17435d.i()) {
            switch (AnonymousClass1.f17332a[generatedExtension.d().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    reader.G(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    reader.C(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    reader.i(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    reader.g(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    reader.w(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    reader.q(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    reader.x(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    reader.m(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    reader.t(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    reader.c(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    reader.v(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    reader.r(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    reader.d(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    reader.j(arrayList);
                    ub = (UB) SchemaUtil.z(f8, arrayList, generatedExtension.f17435d.c(), ub, unknownFieldSchema);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f17435d.d());
            }
            fieldSet.C(generatedExtension.f17435d, arrayList);
        } else {
            Object obj2 = null;
            if (generatedExtension.d() == WireFormat.FieldType.f17685u) {
                int p8 = reader.p();
                if (generatedExtension.f17435d.c().a(p8) == null) {
                    return (UB) SchemaUtil.L(f8, p8, ub, unknownFieldSchema);
                }
                obj2 = Integer.valueOf(p8);
            } else {
                switch (AnonymousClass1.f17332a[generatedExtension.d().ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(reader.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(reader.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(reader.H());
                        break;
                    case 4:
                        obj2 = Long.valueOf(reader.s());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(reader.p());
                        break;
                    case 6:
                        obj2 = Long.valueOf(reader.b());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(reader.u());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(reader.e());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(reader.h());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(reader.E());
                        break;
                    case 11:
                        obj2 = Long.valueOf(reader.f());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(reader.l());
                        break;
                    case 13:
                        obj2 = Long.valueOf(reader.y());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = reader.o();
                        break;
                    case 16:
                        obj2 = reader.z();
                        break;
                    case 17:
                        obj2 = reader.L(generatedExtension.e().getClass(), extensionRegistryLite);
                        break;
                    case 18:
                        obj2 = reader.N(generatedExtension.e().getClass(), extensionRegistryLite);
                        break;
                }
            }
            if (generatedExtension.g()) {
                fieldSet.a(generatedExtension.f17435d, obj2);
            } else {
                int i9 = AnonymousClass1.f17332a[generatedExtension.d().ordinal()];
                if ((i9 == 17 || i9 == 18) && (i8 = fieldSet.i(generatedExtension.f17435d)) != null) {
                    obj2 = Internal.h(i8, obj2);
                }
                fieldSet.C(generatedExtension.f17435d, obj2);
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public void h(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.C(generatedExtension.f17435d, reader.N(generatedExtension.e().getClass(), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public void i(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        MessageLite g8 = generatedExtension.e().newBuilderForType().g();
        BinaryReader Q = BinaryReader.Q(ByteBuffer.wrap(byteString.H()), true);
        Protobuf.a().b(g8, Q, extensionRegistryLite);
        fieldSet.C(generatedExtension.f17435d, g8);
        if (Q.A() == Integer.MAX_VALUE) {
            return;
        }
        throw InvalidProtocolBufferException.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor) entry.getKey();
        if (extensionDescriptor.b()) {
            switch (AnonymousClass1.f17332a[extensionDescriptor.d().ordinal()]) {
                case 1:
                    SchemaUtil.P(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 2:
                    SchemaUtil.T(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 3:
                    SchemaUtil.W(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 4:
                    SchemaUtil.e0(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 5:
                    SchemaUtil.V(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 6:
                    SchemaUtil.S(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 7:
                    SchemaUtil.R(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 8:
                    SchemaUtil.N(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 9:
                    SchemaUtil.d0(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 10:
                    SchemaUtil.Y(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 11:
                    SchemaUtil.Z(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 12:
                    SchemaUtil.a0(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 13:
                    SchemaUtil.b0(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 14:
                    SchemaUtil.V(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, extensionDescriptor.i());
                    return;
                case 15:
                    SchemaUtil.O(extensionDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 16:
                    SchemaUtil.c0(extensionDescriptor.getNumber(), (List) entry.getValue(), writer);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        SchemaUtil.U(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, Protobuf.a().d(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        SchemaUtil.X(extensionDescriptor.getNumber(), (List) entry.getValue(), writer, Protobuf.a().d(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        switch (AnonymousClass1.f17332a[extensionDescriptor.d().ordinal()]) {
            case 1:
                writer.p(extensionDescriptor.getNumber(), ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                writer.B(extensionDescriptor.getNumber(), ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                writer.u(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 4:
                writer.f(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 5:
                writer.h(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                writer.s(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 7:
                writer.c(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                writer.v(extensionDescriptor.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                writer.o(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                writer.w(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                writer.i(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 12:
                writer.H(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                writer.m(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                return;
            case 14:
                writer.h(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                writer.L(extensionDescriptor.getNumber(), (ByteString) entry.getValue());
                return;
            case 16:
                writer.e(extensionDescriptor.getNumber(), (String) entry.getValue());
                return;
            case 17:
                writer.K(extensionDescriptor.getNumber(), entry.getValue(), Protobuf.a().d(entry.getValue().getClass()));
                return;
            case 18:
                writer.N(extensionDescriptor.getNumber(), entry.getValue(), Protobuf.a().d(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }
}
