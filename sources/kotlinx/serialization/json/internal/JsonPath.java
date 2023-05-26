package kotlinx.serialization.json.internal;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;

/* compiled from: JsonPath.kt */
/* loaded from: classes5.dex */
public final class JsonPath {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f52389a = new Object[8];

    /* renamed from: b  reason: collision with root package name */
    private int[] f52390b;

    /* renamed from: c  reason: collision with root package name */
    private int f52391c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonPath.kt */
    /* loaded from: classes5.dex */
    public static final class Tombstone {

        /* renamed from: a  reason: collision with root package name */
        public static final Tombstone f52392a = new Tombstone();

        private Tombstone() {
        }
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i8 = 0; i8 < 8; i8++) {
            iArr[i8] = -1;
        }
        this.f52390b = iArr;
        this.f52391c = -1;
    }

    private final void e() {
        int i8 = this.f52391c * 2;
        Object[] copyOf = Arrays.copyOf(this.f52389a, i8);
        Intrinsics.e(copyOf, "copyOf(this, newSize)");
        this.f52389a = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.f52390b, i8);
        Intrinsics.e(copyOf2, "copyOf(this, newSize)");
        this.f52390b = copyOf2;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i8 = this.f52391c + 1;
        for (int i9 = 0; i9 < i8; i9++) {
            Object obj = this.f52389a[i9];
            if (obj instanceof SerialDescriptor) {
                SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
                if (Intrinsics.a(serialDescriptor.d(), StructureKind.LIST.f52125a)) {
                    if (this.f52390b[i9] != -1) {
                        sb.append("[");
                        sb.append(this.f52390b[i9]);
                        sb.append("]");
                    }
                } else {
                    int i10 = this.f52390b[i9];
                    if (i10 >= 0) {
                        sb.append(".");
                        sb.append(serialDescriptor.f(i10));
                    }
                }
            } else if (obj != Tombstone.f52392a) {
                sb.append("[");
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append("]");
            }
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void b() {
        int i8 = this.f52391c;
        int[] iArr = this.f52390b;
        if (iArr[i8] == -2) {
            iArr[i8] = -1;
            this.f52391c = i8 - 1;
        }
        int i9 = this.f52391c;
        if (i9 != -1) {
            this.f52391c = i9 - 1;
        }
    }

    public final void c(SerialDescriptor sd) {
        Intrinsics.f(sd, "sd");
        int i8 = this.f52391c + 1;
        this.f52391c = i8;
        if (i8 == this.f52389a.length) {
            e();
        }
        this.f52389a[i8] = sd;
    }

    public final void d() {
        int[] iArr = this.f52390b;
        int i8 = this.f52391c;
        if (iArr[i8] == -2) {
            this.f52389a[i8] = Tombstone.f52392a;
        }
    }

    public final void f(Object obj) {
        int[] iArr = this.f52390b;
        int i8 = this.f52391c;
        if (iArr[i8] != -2) {
            int i9 = i8 + 1;
            this.f52391c = i9;
            if (i9 == this.f52389a.length) {
                e();
            }
        }
        Object[] objArr = this.f52389a;
        int i10 = this.f52391c;
        objArr[i10] = obj;
        this.f52390b[i10] = -2;
    }

    public final void g(int i8) {
        this.f52390b[this.f52391c] = i8;
    }

    public String toString() {
        return a();
    }
}
