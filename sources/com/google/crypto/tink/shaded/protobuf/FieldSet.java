package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import com.google.crypto.tink.shaded.protobuf.Internal;
import com.google.crypto.tink.shaded.protobuf.LazyField;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.shaded.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final FieldSet f15042d = new FieldSet(true);

    /* renamed from: a  reason: collision with root package name */
    private final SmallSortedMap<T, Object> f15043a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15044b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f15045c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.crypto.tink.shaded.protobuf.FieldSet$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15046a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f15047b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f15047b = iArr;
            try {
                iArr[WireFormat.FieldType.f15271h.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15047b[WireFormat.FieldType.f15272i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15047b[WireFormat.FieldType.f15273j.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15047b[WireFormat.FieldType.f15274k.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15047b[WireFormat.FieldType.f15275l.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15047b[WireFormat.FieldType.f15276m.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15047b[WireFormat.FieldType.f15277n.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15047b[WireFormat.FieldType.f15278o.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15047b[WireFormat.FieldType.f15280q.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f15047b[WireFormat.FieldType.f15281r.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f15047b[WireFormat.FieldType.f15279p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f15047b[WireFormat.FieldType.f15282s.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f15047b[WireFormat.FieldType.f15283t.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f15047b[WireFormat.FieldType.f15285v.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f15047b[WireFormat.FieldType.f15286w.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f15047b[WireFormat.FieldType.f15287x.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f15047b[WireFormat.FieldType.f15288y.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f15047b[WireFormat.FieldType.f15284u.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f15046a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f15046a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f15046a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f15046a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f15046a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f15046a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f15046a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f15046a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f15046a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        boolean b();

        WireFormat.FieldType d();

        WireFormat.JavaType g();

        int getNumber();

        boolean i();

        MessageLite.Builder o(MessageLite.Builder builder, MessageLite messageLite);
    }

    private FieldSet() {
        this.f15043a = SmallSortedMap.r(16);
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

    static int d(WireFormat.FieldType fieldType, int i8, Object obj) {
        int U = CodedOutputStream.U(i8);
        if (fieldType == WireFormat.FieldType.f15280q) {
            U *= 2;
        }
        return U + e(fieldType, obj);
    }

    static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (AnonymousClass1.f15047b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.j(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.r(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Y(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.w(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.p(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.n(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.e(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.t((MessageLite) obj);
            case 10:
                if (obj instanceof LazyField) {
                    return CodedOutputStream.B((LazyField) obj);
                }
                return CodedOutputStream.G((MessageLite) obj);
            case 11:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.h((ByteString) obj);
                }
                return CodedOutputStream.T((String) obj);
            case 12:
                if (obj instanceof ByteString) {
                    return CodedOutputStream.h((ByteString) obj);
                }
                return CodedOutputStream.f((byte[]) obj);
            case 13:
                return CodedOutputStream.W(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.L(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.N(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.P(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.R(((Long) obj).longValue());
            case 18:
                if (obj instanceof Internal.EnumLite) {
                    return CodedOutputStream.l(((Internal.EnumLite) obj).getNumber());
                }
                return CodedOutputStream.l(((Integer) obj).intValue());
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
                return CodedOutputStream.U(number) + i8 + CodedOutputStream.J(i8);
            }
            for (Object obj3 : (List) obj) {
                i8 += d(d8, number, obj3);
            }
            return i8;
        }
        return d(d8, number, obj);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> h() {
        return f15042d;
    }

    private int k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.g() == WireFormat.JavaType.MESSAGE && !key.b() && !key.i()) {
            if (value instanceof LazyField) {
                return CodedOutputStream.z(entry.getKey().getNumber(), (LazyField) value);
            }
            return CodedOutputStream.D(entry.getKey().getNumber(), (MessageLite) value);
        }
        return f(key, value);
    }

    private static <T extends FieldDescriptorLite<T>> boolean p(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.g() == WireFormat.JavaType.MESSAGE) {
            if (key.b()) {
                for (MessageLite messageLite : (List) entry.getValue()) {
                    if (!messageLite.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof MessageLite) {
                    if (!((MessageLite) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof LazyField) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static boolean q(WireFormat.FieldType fieldType, Object obj) {
        Internal.a(obj);
        switch (AnonymousClass1.f15046a[fieldType.a().ordinal()]) {
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

    private void u(Map.Entry<T, Object> entry) {
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
            this.f15043a.put(key, i8);
        } else if (key.g() == WireFormat.JavaType.MESSAGE) {
            Object i9 = i(key);
            if (i9 == null) {
                this.f15043a.put(key, c(value));
                return;
            }
            this.f15043a.put(key, key.o(((MessageLite) i9).toBuilder(), (MessageLite) value).build());
        } else {
            this.f15043a.put(key, c(value));
        }
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> v() {
        return new FieldSet<>();
    }

    private void x(WireFormat.FieldType fieldType, Object obj) {
        if (q(fieldType, obj)) {
            return;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    public void a(T t7, Object obj) {
        List list;
        if (t7.b()) {
            x(t7.d(), obj);
            Object i8 = i(t7);
            if (i8 == null) {
                list = new ArrayList();
                this.f15043a.put(t7, list);
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
        FieldSet<T> v7 = v();
        for (int i8 = 0; i8 < this.f15043a.l(); i8++) {
            Map.Entry<T, Object> k8 = this.f15043a.k(i8);
            v7.w(k8.getKey(), k8.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f15043a.n()) {
            v7.w(entry.getKey(), entry.getValue());
        }
        v7.f15045c = this.f15045c;
        return v7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldSet)) {
            return false;
        }
        return this.f15043a.equals(((FieldSet) obj).f15043a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> g() {
        if (this.f15045c) {
            return new LazyField.LazyIterator(this.f15043a.i().iterator());
        }
        return this.f15043a.i().iterator();
    }

    public int hashCode() {
        return this.f15043a.hashCode();
    }

    public Object i(T t7) {
        Object obj = this.f15043a.get(t7);
        if (obj instanceof LazyField) {
            return ((LazyField) obj).f();
        }
        return obj;
    }

    public int j() {
        int i8 = 0;
        for (int i9 = 0; i9 < this.f15043a.l(); i9++) {
            i8 += k(this.f15043a.k(i9));
        }
        for (Map.Entry<T, Object> entry : this.f15043a.n()) {
            i8 += k(entry);
        }
        return i8;
    }

    public int l() {
        int i8 = 0;
        for (int i9 = 0; i9 < this.f15043a.l(); i9++) {
            Map.Entry<T, Object> k8 = this.f15043a.k(i9);
            i8 += f(k8.getKey(), k8.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f15043a.n()) {
            i8 += f(entry.getKey(), entry.getValue());
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.f15043a.isEmpty();
    }

    public boolean n() {
        return this.f15044b;
    }

    public boolean o() {
        for (int i8 = 0; i8 < this.f15043a.l(); i8++) {
            if (!p(this.f15043a.k(i8))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f15043a.n()) {
            if (!p(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> r() {
        if (this.f15045c) {
            return new LazyField.LazyIterator(this.f15043a.entrySet().iterator());
        }
        return this.f15043a.entrySet().iterator();
    }

    public void s() {
        if (this.f15044b) {
            return;
        }
        this.f15043a.q();
        this.f15044b = true;
    }

    public void t(FieldSet<T> fieldSet) {
        for (int i8 = 0; i8 < fieldSet.f15043a.l(); i8++) {
            u(fieldSet.f15043a.k(i8));
        }
        for (Map.Entry<T, Object> entry : fieldSet.f15043a.n()) {
            u(entry);
        }
    }

    public void w(T t7, Object obj) {
        if (t7.b()) {
            if (obj instanceof List) {
                ArrayList<Object> arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                for (Object obj2 : arrayList) {
                    x(t7.d(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            x(t7.d(), obj);
        }
        if (obj instanceof LazyField) {
            this.f15045c = true;
        }
        this.f15043a.put(t7, obj);
    }

    private FieldSet(boolean z7) {
        this(SmallSortedMap.r(0));
        s();
    }

    private FieldSet(SmallSortedMap<T, Object> smallSortedMap) {
        this.f15043a = smallSortedMap;
        s();
    }
}
