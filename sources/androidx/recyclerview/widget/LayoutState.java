package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
class LayoutState {

    /* renamed from: b  reason: collision with root package name */
    int f7123b;

    /* renamed from: c  reason: collision with root package name */
    int f7124c;

    /* renamed from: d  reason: collision with root package name */
    int f7125d;

    /* renamed from: e  reason: collision with root package name */
    int f7126e;

    /* renamed from: h  reason: collision with root package name */
    boolean f7129h;

    /* renamed from: i  reason: collision with root package name */
    boolean f7130i;

    /* renamed from: a  reason: collision with root package name */
    boolean f7122a = true;

    /* renamed from: f  reason: collision with root package name */
    int f7127f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f7128g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(RecyclerView.State state) {
        int i8 = this.f7124c;
        if (i8 >= 0 && i8 < state.b()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View b(RecyclerView.Recycler recycler) {
        View o8 = recycler.o(this.f7124c);
        this.f7124c += this.f7125d;
        return o8;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f7123b + ", mCurrentPosition=" + this.f7124c + ", mItemDirection=" + this.f7125d + ", mLayoutDirection=" + this.f7126e + ", mStartLine=" + this.f7127f + ", mEndLine=" + this.f7128g + '}';
    }
}
