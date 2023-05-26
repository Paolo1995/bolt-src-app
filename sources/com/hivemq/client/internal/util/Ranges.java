package com.hivemq.client.internal.util;

/* loaded from: classes3.dex */
public class Ranges {

    /* renamed from: a  reason: collision with root package name */
    private Range f18669a;

    public Ranges(int i8, int i9) {
        this.f18669a = new Range(i8, i9 + 1);
    }

    private Range c(Range range, int i8) {
        Range range2 = range.f18672c;
        if (i8 == range.f18670a - 1) {
            range.f18670a = i8;
            return null;
        }
        int i9 = range.f18671b;
        if (i8 >= i9) {
            if (i8 == i9) {
                if (range2 != null) {
                    int i10 = i9 + 1;
                    range.f18671b = i10;
                    if (i10 == range2.f18670a) {
                        range.f18671b = range2.f18671b;
                        range.f18672c = range2.f18672c;
                    }
                    return null;
                }
                throw new IllegalStateException("The id is greater than maxId. This must not happen and is a bug.");
            } else if (range2 != null) {
                return range2;
            } else {
                throw new IllegalStateException("The id is greater than maxId. This must not happen and is a bug.");
            }
        }
        throw new IllegalStateException("The id was already returned. This must not happen and is a bug.");
    }

    public int a() {
        Range range;
        Range range2 = this.f18669a;
        int i8 = range2.f18670a;
        int i9 = range2.f18671b;
        if (i8 == i9) {
            return -1;
        }
        int i10 = i8 + 1;
        range2.f18670a = i10;
        if (i10 == i9 && (range = range2.f18672c) != null) {
            this.f18669a = range;
        }
        return i8;
    }

    public int b(int i8) {
        Range range = this.f18669a;
        while (true) {
            int i9 = 0;
            if (range.f18671b <= i8) {
                Range range2 = range.f18672c;
                if (range2 == null) {
                    range.f18671b = i8 + 1;
                    return 0;
                }
                range = range2;
            } else {
                int i10 = i8 + 1;
                int i11 = range.f18670a - i10;
                if (i11 >= 0) {
                    i9 = i11;
                }
                while (true) {
                    Range range3 = range.f18672c;
                    if (range3 == null) {
                        break;
                    }
                    i9 += range3.f18670a - range.f18671b;
                    range = range3;
                }
                if (i9 == 0) {
                    range.f18671b = i10;
                }
                return i9;
            }
        }
    }

    public void d(int i8) {
        Range range = this.f18669a;
        if (i8 < range.f18670a - 1) {
            this.f18669a = new Range(i8, i8 + 1, range);
            return;
        }
        Range c8 = c(range, i8);
        while (true) {
            Range range2 = c8;
            Range range3 = range;
            range = range2;
            if (range != null) {
                if (i8 < range.f18670a - 1) {
                    range3.f18672c = new Range(i8, i8 + 1, range);
                    return;
                }
                c8 = c(range, i8);
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Range {

        /* renamed from: a  reason: collision with root package name */
        int f18670a;

        /* renamed from: b  reason: collision with root package name */
        int f18671b;

        /* renamed from: c  reason: collision with root package name */
        Range f18672c;

        Range(int i8, int i9) {
            this.f18670a = i8;
            this.f18671b = i9;
        }

        Range(int i8, int i9, Range range) {
            this.f18670a = i8;
            this.f18671b = i9;
            this.f18672c = range;
        }
    }
}
