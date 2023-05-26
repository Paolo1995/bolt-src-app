package eu.bolt.verification.sdk.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import eu.bolt.client.design.input.DesignTextfieldView;
import eu.bolt.client.design.text.DesignTextView;
import eu.bolt.client.design.toolbar.DesignToolbarView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class y2 extends CoordinatorLayout {
    private final fg E;
    private final DesignToolbarView F;
    private final DesignTextView G;
    private final RecyclerView H;
    private final DesignTextfieldView I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y2(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        fg a8 = fg.a(uq.Y(this), this);
        Intrinsics.e(a8, "inflate(inflater(), this)");
        this.E = a8;
        DesignToolbarView designToolbarView = a8.f42990f;
        Intrinsics.e(designToolbarView, "viewBinding.toolbar");
        this.F = designToolbarView;
        DesignTextView designTextView = a8.f42988d;
        Intrinsics.e(designTextView, "viewBinding.countryNotFound");
        this.G = designTextView;
        RecyclerView recyclerView = a8.f42987c;
        Intrinsics.e(recyclerView, "viewBinding.countryList");
        this.H = recyclerView;
        DesignTextfieldView designTextfieldView = a8.f42989e;
        Intrinsics.e(designTextfieldView, "viewBinding.searchField");
        this.I = designTextfieldView;
        setBackgroundColor(-1);
        a8.f42986b.setBackgroundColor(-1);
        uq.d0(this);
        uq.L(this);
    }

    public /* synthetic */ y2(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    public final DesignTextView getCountryNotFound() {
        return this.G;
    }

    public final RecyclerView getCountryRecycler() {
        return this.H;
    }

    public final DesignTextfieldView getSearchField() {
        return this.I;
    }

    public final DesignToolbarView getToolbar() {
        return this.F;
    }
}
