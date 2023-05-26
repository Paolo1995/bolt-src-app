package com.google.protobuf;

import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final FieldSet f17366d = new FieldSet(true);

    /* renamed from: a  reason: collision with root package name */
    private final SmallSortedMap<T, Object> f17367a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17368b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17369c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.FieldSet$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17370a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f17371b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f17371b = iArr;
            try {
                iArr[WireFormat.FieldType.f17672h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17371b[WireFormat.FieldType.f17673i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17371b[WireFormat.FieldType.f17674j.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17371b[WireFormat.FieldType.f17675k.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17371b[WireFormat.FieldType.f17676l.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17371b[WireFormat.FieldType.f17677m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17371b[WireFormat.FieldType.f17678n.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17371b[WireFormat.FieldType.f17679o.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17371b[WireFormat.FieldType.f17681q.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17371b[WireFormat.FieldType.f17682r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17371b[WireFormat.FieldType.f17680p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f17371b[WireFormat.FieldType.f17683s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f17371b[WireFormat.FieldType.f17684t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f17371b[WireFormat.FieldType.f17686v.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f17371b[WireFormat.FieldType.f17687w.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f17371b[WireFormat.FieldType.f17688x.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f17371b[WireFormat.FieldType.f17689y.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f17371b[WireFormat.FieldType.f17685u.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f17370a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f17370a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f17370a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f17370a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f17370a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f17370a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f17370a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f17370a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f17370a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        boolean b();

        WireFormat.FieldType d();

        WireFormat.JavaType g();

        int getNumber();

        boolean i();

        MessageLite.Builder n(MessageLite.Builder builder, MessageLite messageLite);
    }

    private FieldSet() {
        this.f17367a = SmallSortedMap.r(16);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> A() {
        return new FieldSet<>();
    }

    public static Object B(CodedInputStream codedInputStream, WireFormat.FieldType fieldType, boolean z7) throws IOException {
        if (z7) {
            return WireFormat.d(codedInputStream, fieldType, WireFormat.Utf8Validation.STRICT);
        }
        return WireFormat.d(codedInputStream, fieldType, WireFormat.Utf8Validation.LOOSE);
    }

    private void D(T t7, Object obj) {
        if (v(t7.d(), obj)) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t7.getNumber()), t7.d().a(), obj.getClass().getName()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void E(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i8, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.f17681q) {
            codedOutputStream.A0(i8, (MessageLite) obj);
            return;
        }
        codedOutputStream.W0(i8, o(fieldType, false));
        F(codedOutputStream, fieldType, obj);
    }

    static void F(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (AnonymousClass1.f17371b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.r0(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.z0(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.H0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.a1(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.F0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.x0(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.v0(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.l0(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.C0((MessageLite) obj);
                return;
            case 10:
                codedOutputStream.J0((MessageLite) obj);
                return;
            case 11:
                if (obj instanceof ByteString) {
                    codedOutputStream.p0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.V0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof ByteString) {
                    codedOutputStream.p0((ByteString) obj);
                    return;
                } else {
                    codedOutputStream.m0((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.Y0(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.N0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.P0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.R0(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.T0(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    codedOutputStream.t0(((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    codedOutputStream.t0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private static Object c(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(WireFormat.FieldType fieldType, int i8, Object obj) {
        int V = CodedOutputStream.V(i8);
        if (fieldType == WireFormat.FieldType.f17681q) {
            V *= 2;
        }
        return V + e(fieldType, obj);
    }

    static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f17371b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.k(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.s(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.z(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Z(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.o(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.f(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.u((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.C((LazyField) obj);
                }
                return CodedOutputStream.H((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.U((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.i((ByteString) obj);
                }
                return CodedOutputStream.g((byte[]) obj);
            case 13:
                return CodedOutputStream.X(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.M(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.O(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.Q(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.S(((Long) obj).longValue());
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.m(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        WireFormat.FieldType d8 = fieldDescriptorLite.d();
        int number = fieldDescriptorLite.getNumber();
        if (fieldDescriptorLite.b()) {
            int i8 = 0;
            if (fieldDescriptorLite.i()) {
                for (Object obj2 : (List) obj) {
                    i8 += e(d8, obj2);
                }
                return CodedOutputStream.V(number) + i8 + CodedOutputStream.X(i8);
            }
            for (Object obj3 : (List) obj) {
                i8 += d(d8, number, obj3);
            }
            return i8;
        }
        return d(d8, number, obj);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> h() {
        return f17366d;
    }

    private int k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.g() == WireFormat.JavaType.MESSAGE && !key.b() && !key.i()) {
            if (value instanceof LazyField) {
                return CodedOutputStream.A(entry.getKey().getNumber(), (LazyField) value);
            }
            return CodedOutputStream.E(entry.getKey().getNumber(), (MessageLite) value);
        }
        return f(key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(WireFormat.FieldType fieldType, boolean z7) {
        if (z7) {
            return 2;
        }
        return fieldType.c();
    }

    private static <T extends FieldDescriptorLite<T>> boolean t(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.g() == WireFormat.JavaType.MESSAGE) {
            if (key.b()) {
                for (Object obj : (List) entry.getValue()) {
                    if (!u(obj)) {
                        return false;
                    }
                }
                return true;
            }
            return u(entry.getValue());
        }
        return true;
    }

    private static boolean u(Object obj) {
        if (obj instanceof MessageLiteOrBuilder) {
            return ((MessageLiteOrBuilder) obj).isInitialized();
        }
        if (obj instanceof LazyField) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean v(WireFormat.FieldType fieldType, Object obj) {
        Internal.a(obj);
        switch (AnonymousClass1.f17370a[fieldType.a().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                    return true;
                }
                return false;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof Internal.EnumLite)) {
                    return true;
                }
                return false;
            case 9:
                if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    private void z(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof LazyField) {
            value = ((LazyField) value).f();
        }
        if (key.b()) {
            Object i8 = i(key);
            if (i8 == null) {
                i8 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) i8).add(c(obj));
            }
            this.f17367a.put(key, i8);
        } else if (key.g() == WireFormat.JavaType.MESSAGE) {
            Object i9 = i(key);
            if (i9 == null) {
                this.f17367a.put(key, c(value));
                return;
            }
            this.f17367a.put(key, key.n(((MessageLite) i9).toBuilder(), (MessageLite) value).build());
        } else {
            this.f17367a.put(key, c(value));
        }
    }

    public void C(T t7, Object obj) {
        if (t7.b()) {
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    D(t7, obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            D(t7, obj);
        }
        if (obj instanceof LazyField) {
            this.f17369c = true;
        }
        this.f17367a.put(t7, obj);
    }

    public void a(T t7, Object obj) {
        List list;
        if (t7.b()) {
            D(t7, obj);
            Object i8 = i(t7);
            if (i8 == null) {
                list = new ArrayList();
                this.f17367a.put(t7, list);
            } else {
                list = (List) i8;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b */
    public FieldSet<T> clone() {
        FieldSet<T> A = A();
        for (int i8 = 0; i8 < this.f17367a.l(); i8++) {
            Map.Entry<T, Object> k8 = this.f17367a.k(i8);
            A.C(k8.getKey(), k8.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f17367a.n()) {
            A.C(entry.getKey(), entry.getValue());
        }
        A.f17369c = this.f17369c;
        return A;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.f17367a.equals(((FieldSet) obj).f17367a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> g() {
        if (this.f17369c) {
            return new LazyField.LazyIterator(this.f17367a.i().iterator());
        }
        return this.f17367a.i().iterator();
    }

    public int hashCode() {
        return this.f17367a.hashCode();
    }

    public Object i(T t7) {
        Object obj = this.f17367a.get(t7);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).f();
        }
        return obj;
    }

    public int j() {
        int i8 = 0;
        for (int i9 = 0; i9 < this.f17367a.l(); i9++) {
            i8 += k(this.f17367a.k(i9));
        }
        for (Map.Entry<T, Object> entry : this.f17367a.n()) {
            i8 += k(entry);
        }
        return i8;
    }

    public Object l(T t7, int i8) {
        if (t7.b()) {
            Object i9 = i(t7);
            if (i9 != null) {
                return ((List) i9).get(i8);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int m(T t7) {
        if (t7.b()) {
            Object i8 = i(t7);
            if (i8 == null) {
                return 0;
            }
            return ((List) i8).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int n() {
        int i8 = 0;
        for (int i9 = 0; i9 < this.f17367a.l(); i9++) {
            Map.Entry<T, Object> k8 = this.f17367a.k(i9);
            i8 += f(k8.getKey(), k8.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f17367a.n()) {
            i8 += f(entry.getKey(), entry.getValue());
        }
        return i8;
    }

    public boolean p(T t7) {
        if (!t7.b()) {
            if (this.f17367a.get(t7) != null) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return this.f17367a.isEmpty();
    }

    public boolean r() {
        return this.f17368b;
    }

    public boolean s() {
        for (int i8 = 0; i8 < this.f17367a.l(); i8++) {
            if (!t(this.f17367a.k(i8))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f17367a.n()) {
            if (!t(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> w() {
        if (this.f17369c) {
            return new LazyField.LazyIterator(this.f17367a.entrySet().iterator());
        }
        return this.f17367a.entrySet().iterator();
    }

    public void x() {
        if (this.f17368b) {
            return;
        }
        this.f17367a.q();
        this.f17368b = true;
    }

    public void y(FieldSet<T> fieldSet) {
        for (int i8 = 0; i8 < fieldSet.f17367a.l(); i8++) {
            z(fieldSet.f17367a.k(i8));
        }
        for (Map.Entry<T, Object> entry : fieldSet.f17367a.n()) {
            z(entry);
        }
    }

    private FieldSet(boolean z7) {
        this(SmallSortedMap.r(0));
        x();
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.f17367a = smallSortedMap;
        x();
    }
}
