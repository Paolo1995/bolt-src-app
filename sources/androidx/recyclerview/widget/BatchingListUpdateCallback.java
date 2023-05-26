package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class BatchingListUpdateCallback implements ListUpdateCallback {

    /* renamed from: a  reason: collision with root package name */
    final ListUpdateCallback f6927a;

    /* renamed from: b  reason: collision with root package name */
    int f6928b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f6929c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f6930d = -1;

    /* renamed from: e  reason: collision with root package name */
    Object f6931e = null;

    public BatchingListUpdateCallback(@NonNull ListUpdateCallback listUpdateCallback) {
        this.f6927a = listUpdateCallback;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void a(int i8, int i9) {
        int i10;
        if (this.f6928b == 1 && i8 >= (i10 = this.f6929c)) {
            int i11 = this.f6930d;
            if (i8 <= i10 + i11) {
                this.f6930d = i11 + i9;
                this.f6929c = Math.min(i8, i10);
                return;
            }
        }
        e();
        this.f6929c = i8;
        this.f6930d = i9;
        this.f6928b = 1;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void b(int i8, int i9) {
        int i10;
        if (this.f6928b == 2 && (i10 = this.f6929c) >= i8 && i10 <= i8 + i9) {
            this.f6930d += i9;
            this.f6929c = i8;
            return;
        }
        e();
        this.f6929c = i8;
        this.f6930d = i9;
        this.f6928b = 2;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void c(int i8, int i9, Object obj) {
        int i10;
        if (this.f6928b == 3) {
            int i11 = this.f6929c;
            int i12 = this.f6930d;
            if (i8 <= i11 + i12 && (i10 = i8 + i9) >= i11 && this.f6931e == obj) {
                this.f6929c = Math.min(i8, i11);
                this.f6930d = Math.max(i12 + i11, i10) - this.f6929c;
                return;
            }
        }
        e();
        this.f6929c = i8;
        this.f6930d = i9;
        this.f6931e = obj;
        this.f6928b = 3;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public void d(int i8, int i9) {
        e();
        this.f6927a.d(i8, i9);
    }

    public void e() {
        int i8 = this.f6928b;
        if (i8 == 0) {
            return;
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    this.f6927a.c(this.f6929c, this.f6930d, this.f6931e);
                }
            } else {
                this.f6927a.b(this.f6929c, this.f6930d);
            }
        } else {
            this.f6927a.a(this.f6929c, this.f6930d);
        }
        this.f6931e = null;
        this.f6928b = 0;
    }
}
