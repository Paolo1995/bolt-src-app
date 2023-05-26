package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class DiffUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<Diagonal> f6988a = new Comparator<Diagonal>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Diagonal diagonal, Diagonal diagonal2) {
            return diagonal.f6991a - diagonal2.f6991a;
        }
    };

    /* loaded from: classes.dex */
    public static abstract class Callback {
        public abstract boolean a(int i8, int i9);

        public abstract boolean b(int i8, int i9);

        public Object c(int i8, int i9) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CenteredArray {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f6989a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6990b;

        CenteredArray(int i8) {
            int[] iArr = new int[i8];
            this.f6989a = iArr;
            this.f6990b = iArr.length / 2;
        }

        int[] a() {
            return this.f6989a;
        }

        int b(int i8) {
            return this.f6989a[i8 + this.f6990b];
        }

        void c(int i8, int i9) {
            this.f6989a[i8 + this.f6990b] = i9;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Diagonal {

        /* renamed from: a  reason: collision with root package name */
        public final int f6991a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6992b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6993c;

        Diagonal(int i8, int i9, int i10) {
            this.f6991a = i8;
            this.f6992b = i9;
            this.f6993c = i10;
        }

        int a() {
            return this.f6991a + this.f6993c;
        }

        int b() {
            return this.f6992b + this.f6993c;
        }
    }

    /* loaded from: classes.dex */
    public static class DiffResult {

        /* renamed from: a  reason: collision with root package name */
        private final List<Diagonal> f6994a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f6995b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f6996c;

        /* renamed from: d  reason: collision with root package name */
        private final Callback f6997d;

        /* renamed from: e  reason: collision with root package name */
        private final int f6998e;

        /* renamed from: f  reason: collision with root package name */
        private final int f6999f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f7000g;

        DiffResult(Callback callback, List<Diagonal> list, int[] iArr, int[] iArr2, boolean z7) {
            this.f6994a = list;
            this.f6995b = iArr;
            this.f6996c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f6997d = callback;
            this.f6998e = callback.e();
            this.f6999f = callback.d();
            this.f7000g = z7;
            a();
            e();
        }

        private void a() {
            Diagonal diagonal;
            if (this.f6994a.isEmpty()) {
                diagonal = null;
            } else {
                diagonal = this.f6994a.get(0);
            }
            if (diagonal == null || diagonal.f6991a != 0 || diagonal.f6992b != 0) {
                this.f6994a.add(0, new Diagonal(0, 0, 0));
            }
            this.f6994a.add(new Diagonal(this.f6998e, this.f6999f, 0));
        }

        private void d(int i8) {
            int i9;
            int size = this.f6994a.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                Diagonal diagonal = this.f6994a.get(i11);
                while (i10 < diagonal.f6992b) {
                    if (this.f6996c[i10] == 0 && this.f6997d.b(i8, i10)) {
                        if (this.f6997d.a(i8, i10)) {
                            i9 = 8;
                        } else {
                            i9 = 4;
                        }
                        this.f6995b[i8] = (i10 << 4) | i9;
                        this.f6996c[i10] = (i8 << 4) | i9;
                        return;
                    }
                    i10++;
                }
                i10 = diagonal.b();
            }
        }

        private void e() {
            int i8;
            for (Diagonal diagonal : this.f6994a) {
                for (int i9 = 0; i9 < diagonal.f6993c; i9++) {
                    int i10 = diagonal.f6991a + i9;
                    int i11 = diagonal.f6992b + i9;
                    if (this.f6997d.a(i10, i11)) {
                        i8 = 1;
                    } else {
                        i8 = 2;
                    }
                    this.f6995b[i10] = (i11 << 4) | i8;
                    this.f6996c[i11] = (i10 << 4) | i8;
                }
            }
            if (this.f7000g) {
                f();
            }
        }

        private void f() {
            int i8 = 0;
            for (Diagonal diagonal : this.f6994a) {
                while (i8 < diagonal.f6991a) {
                    if (this.f6995b[i8] == 0) {
                        d(i8);
                    }
                    i8++;
                }
                i8 = diagonal.a();
            }
        }

        private static PostponedUpdate g(Collection<PostponedUpdate> collection, int i8, boolean z7) {
            PostponedUpdate postponedUpdate;
            Iterator<PostponedUpdate> it = collection.iterator();
            while (true) {
                if (it.hasNext()) {
                    postponedUpdate = it.next();
                    if (postponedUpdate.f7001a == i8 && postponedUpdate.f7003c == z7) {
                        it.remove();
                        break;
                    }
                } else {
                    postponedUpdate = null;
                    break;
                }
            }
            while (it.hasNext()) {
                PostponedUpdate next = it.next();
                if (z7) {
                    next.f7002b--;
                } else {
                    next.f7002b++;
                }
            }
            return postponedUpdate;
        }

        public void b(@NonNull ListUpdateCallback listUpdateCallback) {
            BatchingListUpdateCallback batchingListUpdateCallback;
            int i8;
            if (listUpdateCallback instanceof BatchingListUpdateCallback) {
                batchingListUpdateCallback = (BatchingListUpdateCallback) listUpdateCallback;
            } else {
                batchingListUpdateCallback = new BatchingListUpdateCallback(listUpdateCallback);
            }
            int i9 = this.f6998e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i10 = this.f6998e;
            int i11 = this.f6999f;
            for (int size = this.f6994a.size() - 1; size >= 0; size--) {
                Diagonal diagonal = this.f6994a.get(size);
                int a8 = diagonal.a();
                int b8 = diagonal.b();
                while (true) {
                    if (i10 <= a8) {
                        break;
                    }
                    i10--;
                    int i12 = this.f6995b[i10];
                    if ((i12 & 12) != 0) {
                        int i13 = i12 >> 4;
                        PostponedUpdate g8 = g(arrayDeque, i13, false);
                        if (g8 != null) {
                            int i14 = (i9 - g8.f7002b) - 1;
                            batchingListUpdateCallback.d(i10, i14);
                            if ((i12 & 4) != 0) {
                                batchingListUpdateCallback.c(i14, 1, this.f6997d.c(i10, i13));
                            }
                        } else {
                            arrayDeque.add(new PostponedUpdate(i10, (i9 - i10) - 1, true));
                        }
                    } else {
                        batchingListUpdateCallback.b(i10, 1);
                        i9--;
                    }
                }
                while (i11 > b8) {
                    i11--;
                    int i15 = this.f6996c[i11];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        PostponedUpdate g9 = g(arrayDeque, i16, true);
                        if (g9 == null) {
                            arrayDeque.add(new PostponedUpdate(i11, i9 - i10, false));
                        } else {
                            batchingListUpdateCallback.d((i9 - g9.f7002b) - 1, i10);
                            if ((i15 & 4) != 0) {
                                batchingListUpdateCallback.c(i10, 1, this.f6997d.c(i16, i11));
                            }
                        }
                    } else {
                        batchingListUpdateCallback.a(i10, 1);
                        i9++;
                    }
                }
                int i17 = diagonal.f6991a;
                int i18 = diagonal.f6992b;
                for (i8 = 0; i8 < diagonal.f6993c; i8++) {
                    if ((this.f6995b[i17] & 15) == 2) {
                        batchingListUpdateCallback.c(i17, 1, this.f6997d.c(i17, i18));
                    }
                    i17++;
                    i18++;
                }
                i10 = diagonal.f6991a;
                i11 = diagonal.f6992b;
            }
            batchingListUpdateCallback.e();
        }

        public void c(@NonNull RecyclerView.Adapter adapter) {
            b(new AdapterListUpdateCallback(adapter));
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ItemCallback<T> {
        public abstract boolean a(@NonNull T t7, @NonNull T t8);

        public abstract boolean b(@NonNull T t7, @NonNull T t8);

        public Object c(@NonNull T t7, @NonNull T t8) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class PostponedUpdate {

        /* renamed from: a  reason: collision with root package name */
        int f7001a;

        /* renamed from: b  reason: collision with root package name */
        int f7002b;

        /* renamed from: c  reason: collision with root package name */
        boolean f7003c;

        PostponedUpdate(int i8, int i9, boolean z7) {
            this.f7001a = i8;
            this.f7002b = i9;
            this.f7003c = z7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Range {

        /* renamed from: a  reason: collision with root package name */
        int f7004a;

        /* renamed from: b  reason: collision with root package name */
        int f7005b;

        /* renamed from: c  reason: collision with root package name */
        int f7006c;

        /* renamed from: d  reason: collision with root package name */
        int f7007d;

        public Range() {
        }

        int a() {
            return this.f7007d - this.f7006c;
        }

        int b() {
            return this.f7005b - this.f7004a;
        }

        public Range(int i8, int i9, int i10, int i11) {
            this.f7004a = i8;
            this.f7005b = i9;
            this.f7006c = i10;
            this.f7007d = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Snake {

        /* renamed from: a  reason: collision with root package name */
        public int f7008a;

        /* renamed from: b  reason: collision with root package name */
        public int f7009b;

        /* renamed from: c  reason: collision with root package name */
        public int f7010c;

        /* renamed from: d  reason: collision with root package name */
        public int f7011d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f7012e;

        Snake() {
        }

        int a() {
            return Math.min(this.f7010c - this.f7008a, this.f7011d - this.f7009b);
        }

        boolean b() {
            if (this.f7011d - this.f7009b != this.f7010c - this.f7008a) {
                return true;
            }
            return false;
        }

        boolean c() {
            if (this.f7011d - this.f7009b > this.f7010c - this.f7008a) {
                return true;
            }
            return false;
        }

        @NonNull
        Diagonal d() {
            if (b()) {
                if (this.f7012e) {
                    return new Diagonal(this.f7008a, this.f7009b, a());
                }
                if (c()) {
                    return new Diagonal(this.f7008a, this.f7009b + 1, a());
                }
                return new Diagonal(this.f7008a + 1, this.f7009b, a());
            }
            int i8 = this.f7008a;
            return new Diagonal(i8, this.f7009b, this.f7010c - i8);
        }
    }

    private DiffUtil() {
    }

    private static Snake a(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i8) {
        boolean z7;
        int b8;
        int i9;
        int i10;
        int i11;
        if ((range.b() - range.a()) % 2 == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        int b9 = range.b() - range.a();
        int i12 = -i8;
        for (int i13 = i12; i13 <= i8; i13 += 2) {
            if (i13 != i12 && (i13 == i8 || centeredArray2.b(i13 + 1) >= centeredArray2.b(i13 - 1))) {
                b8 = centeredArray2.b(i13 - 1);
                i9 = b8 - 1;
            } else {
                b8 = centeredArray2.b(i13 + 1);
                i9 = b8;
            }
            int i14 = range.f7007d - ((range.f7005b - i9) - i13);
            if (i8 != 0 && i9 == b8) {
                i10 = i14 + 1;
            } else {
                i10 = i14;
            }
            while (i9 > range.f7004a && i14 > range.f7006c && callback.b(i9 - 1, i14 - 1)) {
                i9--;
                i14--;
            }
            centeredArray2.c(i13, i9);
            if (z7 && (i11 = b9 - i13) >= i12 && i11 <= i8 && centeredArray.b(i11) >= i9) {
                Snake snake = new Snake();
                snake.f7008a = i9;
                snake.f7009b = i14;
                snake.f7010c = b8;
                snake.f7011d = i10;
                snake.f7012e = true;
                return snake;
            }
        }
        return null;
    }

    @NonNull
    public static DiffResult b(@NonNull Callback callback) {
        return c(callback, true);
    }

    @NonNull
    public static DiffResult c(@NonNull Callback callback, boolean z7) {
        Range range;
        int e8 = callback.e();
        int d8 = callback.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new Range(0, e8, 0, d8));
        int i8 = ((((e8 + d8) + 1) / 2) * 2) + 1;
        CenteredArray centeredArray = new CenteredArray(i8);
        CenteredArray centeredArray2 = new CenteredArray(i8);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            Range range2 = (Range) arrayList2.remove(arrayList2.size() - 1);
            Snake e9 = e(range2, callback, centeredArray, centeredArray2);
            if (e9 != null) {
                if (e9.a() > 0) {
                    arrayList.add(e9.d());
                }
                if (arrayList3.isEmpty()) {
                    range = new Range();
                } else {
                    range = (Range) arrayList3.remove(arrayList3.size() - 1);
                }
                range.f7004a = range2.f7004a;
                range.f7006c = range2.f7006c;
                range.f7005b = e9.f7008a;
                range.f7007d = e9.f7009b;
                arrayList2.add(range);
                range2.f7005b = range2.f7005b;
                range2.f7007d = range2.f7007d;
                range2.f7004a = e9.f7010c;
                range2.f7006c = e9.f7011d;
                arrayList2.add(range2);
            } else {
                arrayList3.add(range2);
            }
        }
        Collections.sort(arrayList, f6988a);
        return new DiffResult(callback, arrayList, centeredArray.a(), centeredArray2.a(), z7);
    }

    private static Snake d(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2, int i8) {
        int b8;
        int i9;
        int i10;
        boolean z7 = true;
        if (Math.abs(range.b() - range.a()) % 2 != 1) {
            z7 = false;
        }
        int b9 = range.b() - range.a();
        int i11 = -i8;
        for (int i12 = i11; i12 <= i8; i12 += 2) {
            if (i12 != i11 && (i12 == i8 || centeredArray.b(i12 + 1) <= centeredArray.b(i12 - 1))) {
                b8 = centeredArray.b(i12 - 1);
                i9 = b8 + 1;
            } else {
                b8 = centeredArray.b(i12 + 1);
                i9 = b8;
            }
            int i13 = (range.f7006c + (i9 - range.f7004a)) - i12;
            int i14 = (i8 != 0 && i9 == b8) ? i13 - 1 : i13;
            while (i9 < range.f7005b && i13 < range.f7007d && callback.b(i9, i13)) {
                i9++;
                i13++;
            }
            centeredArray.c(i12, i9);
            if (z7 && (i10 = b9 - i12) >= i11 + 1 && i10 <= i8 - 1 && centeredArray2.b(i10) <= i9) {
                Snake snake = new Snake();
                snake.f7008a = b8;
                snake.f7009b = i14;
                snake.f7010c = i9;
                snake.f7011d = i13;
                snake.f7012e = false;
                return snake;
            }
        }
        return null;
    }

    private static Snake e(Range range, Callback callback, CenteredArray centeredArray, CenteredArray centeredArray2) {
        if (range.b() >= 1 && range.a() >= 1) {
            int b8 = ((range.b() + range.a()) + 1) / 2;
            centeredArray.c(1, range.f7004a);
            centeredArray2.c(1, range.f7005b);
            for (int i8 = 0; i8 < b8; i8++) {
                Snake d8 = d(range, callback, centeredArray, centeredArray2, i8);
                if (d8 != null) {
                    return d8;
                }
                Snake a8 = a(range, callback, centeredArray, centeredArray2, i8);
                if (a8 != null) {
                    return a8;
                }
            }
        }
        return null;
    }
}
