package ee.mtakso.driver.uikit.widgets.gridlayout;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapter;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpanMarginDecoration.kt */
/* loaded from: classes5.dex */
public final class SpanMarginDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f36240a;

    public SpanMarginDecoration(int i8) {
        this.f36240a = i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void g(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        GridLayoutManager.LayoutParams layoutParams;
        DiffAdapter diffAdapter;
        ListModel listModel;
        boolean z7;
        boolean z8;
        boolean z9;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        Intrinsics.f(outRect, "outRect");
        Intrinsics.f(view, "view");
        Intrinsics.f(parent, "parent");
        Intrinsics.f(state, "state");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        SpanModel spanModel = null;
        if (layoutParams2 instanceof GridLayoutManager.LayoutParams) {
            layoutParams = (GridLayoutManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter instanceof DiffAdapter) {
            diffAdapter = (DiffAdapter) adapter;
        } else {
            diffAdapter = null;
        }
        RecyclerView.ViewHolder j02 = parent.j0(view);
        if (diffAdapter != null) {
            listModel = diffAdapter.R(j02.j());
        } else {
            listModel = null;
        }
        if (listModel instanceof SpanModel) {
            spanModel = (SpanModel) listModel;
        }
        int i21 = 0;
        if (layoutParams != null && layoutParams.f() == this.f36240a) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            if (layoutParams != null && layoutParams.e() == 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (parent.getLayoutDirection() == 1) {
                    if (spanModel != null) {
                        i19 = spanModel.h();
                    } else {
                        i19 = 0;
                    }
                    outRect.left = i19;
                    if (spanModel != null) {
                        i20 = spanModel.c();
                    } else {
                        i20 = 0;
                    }
                    outRect.right = i20;
                } else {
                    if (spanModel != null) {
                        i16 = spanModel.c();
                    } else {
                        i16 = 0;
                    }
                    outRect.left = i16;
                    if (spanModel != null) {
                        i17 = spanModel.h();
                    } else {
                        i17 = 0;
                    }
                    outRect.right = i17;
                }
                if (spanModel != null) {
                    i18 = spanModel.b();
                } else {
                    i18 = 0;
                }
                outRect.top = i18;
                if (spanModel != null) {
                    i21 = spanModel.b();
                }
                outRect.bottom = i21;
                return;
            }
            if (layoutParams != null && layoutParams.e() == this.f36240a - 1) {
                z9 = true;
            } else {
                z9 = false;
            }
            if (z9) {
                if (parent.getLayoutDirection() == 1) {
                    if (spanModel != null) {
                        i14 = spanModel.c();
                    } else {
                        i14 = 0;
                    }
                    outRect.left = i14;
                    if (spanModel != null) {
                        i15 = spanModel.h();
                    } else {
                        i15 = 0;
                    }
                    outRect.right = i15;
                } else {
                    if (spanModel != null) {
                        i11 = spanModel.h();
                    } else {
                        i11 = 0;
                    }
                    outRect.left = i11;
                    if (spanModel != null) {
                        i12 = spanModel.c();
                    } else {
                        i12 = 0;
                    }
                    outRect.right = i12;
                }
                if (spanModel != null) {
                    i13 = spanModel.b();
                } else {
                    i13 = 0;
                }
                outRect.top = i13;
                if (spanModel != null) {
                    i21 = spanModel.b();
                }
                outRect.bottom = i21;
                return;
            }
            if (spanModel != null) {
                i8 = spanModel.h();
            } else {
                i8 = 0;
            }
            outRect.left = i8;
            if (spanModel != null) {
                i9 = spanModel.h();
            } else {
                i9 = 0;
            }
            outRect.right = i9;
            if (spanModel != null) {
                i10 = spanModel.b();
            } else {
                i10 = 0;
            }
            outRect.top = i10;
            if (spanModel != null) {
                i21 = spanModel.b();
            }
            outRect.bottom = i21;
        }
    }
}
