package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class Q2 extends AbstractC0181e implements Consumer, Iterable {

    /* renamed from: e  reason: collision with root package name */
    protected Object[] f50467e = new Object[1 << 4];

    /* renamed from: f  reason: collision with root package name */
    protected Object[][] f50468f;

    @Override // j$.util.function.Consumer
    public void accept(Object obj) {
        long length;
        int i8 = this.f50567b;
        Object[] objArr = this.f50467e;
        if (i8 == objArr.length) {
            if (this.f50468f == null) {
                Object[][] objArr2 = new Object[8];
                this.f50468f = objArr2;
                this.f50569d = new long[8];
                objArr2[0] = objArr;
            }
            int i9 = this.f50568c;
            int i10 = i9 + 1;
            Object[][] objArr3 = this.f50468f;
            if (i10 >= objArr3.length || objArr3[i10] == null) {
                if (i9 == 0) {
                    length = objArr.length;
                } else {
                    length = objArr3[i9].length + this.f50569d[i9];
                }
                r(length + 1);
            }
            this.f50567b = 0;
            int i11 = this.f50568c + 1;
            this.f50568c = i11;
            this.f50467e = this.f50468f[i11];
        }
        Object[] objArr4 = this.f50467e;
        int i12 = this.f50567b;
        this.f50567b = i12 + 1;
        objArr4[i12] = obj;
    }

    @Override // j$.util.function.Consumer
    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.stream.AbstractC0181e
    public final void clear() {
        Object[][] objArr = this.f50468f;
        if (objArr != null) {
            this.f50467e = objArr[0];
            int i8 = 0;
            while (true) {
                Object[] objArr2 = this.f50467e;
                if (i8 >= objArr2.length) {
                    break;
                }
                objArr2[i8] = null;
                i8++;
            }
            this.f50468f = null;
            this.f50569d = null;
        } else {
            for (int i9 = 0; i9 < this.f50567b; i9++) {
                this.f50467e[i9] = null;
            }
        }
        this.f50567b = 0;
        this.f50568c = 0;
    }

    public void forEach(Consumer consumer) {
        for (int i8 = 0; i8 < this.f50568c; i8++) {
            for (Object obj : this.f50468f[i8]) {
                consumer.accept(obj);
            }
        }
        for (int i9 = 0; i9 < this.f50567b; i9++) {
            consumer.accept(this.f50467e[i9]);
        }
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ void forEach(java.util.function.Consumer consumer) {
        forEach(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return Spliterators.i(spliterator());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void r(long j8) {
        Object[][] objArr;
        int i8;
        int i9 = this.f50568c;
        long length = i9 == 0 ? this.f50467e.length : this.f50468f[i9].length + this.f50569d[i9];
        if (j8 <= length) {
            return;
        }
        if (this.f50468f == null) {
            Object[][] objArr2 = new Object[8];
            this.f50468f = objArr2;
            this.f50569d = new long[8];
            objArr2[0] = this.f50467e;
        }
        while (true) {
            i9++;
            if (j8 <= length) {
                return;
            }
            Object[][] objArr3 = this.f50468f;
            if (i9 >= objArr3.length) {
                int length2 = objArr3.length * 2;
                this.f50468f = (Object[][]) Arrays.copyOf(objArr3, length2);
                this.f50569d = Arrays.copyOf(this.f50569d, length2);
            }
            int min = 1 << ((i9 == 0 || i9 == 1) ? this.f50566a : Math.min((this.f50566a + i9) - 1, 30));
            this.f50468f[i9] = new Object[min];
            long[] jArr = this.f50569d;
            jArr[i9] = jArr[i9 - 1] + objArr[i8].length;
            length += min;
        }
    }

    @Override // java.lang.Iterable
    public Spliterator spliterator() {
        return new H2(this, 0, this.f50568c, 0, this.f50567b);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(spliterator());
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        forEach(new C0161a(8, arrayList));
        StringBuilder a8 = j$.time.b.a("SpinedBuffer:");
        a8.append(arrayList.toString());
        return a8.toString();
    }
}
