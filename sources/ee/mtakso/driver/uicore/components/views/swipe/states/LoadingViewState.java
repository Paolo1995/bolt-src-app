package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.components.views.IndeterminateProgressView;
import ee.mtakso.driver.uicore.utils.AlphaAnimatorHelper;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingViewState.kt */
/* loaded from: classes5.dex */
public final class LoadingViewState extends ViewState {

    /* renamed from: f  reason: collision with root package name */
    private final IndeterminateProgressView f35700f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingViewState(Context context, ViewGroup parent) {
        super(context, parent, R$layout.content_swipe_button_loading_state);
        Intrinsics.f(context, "context");
        Intrinsics.f(parent, "parent");
        View findViewById = parent.findViewById(R$id.loadingProgressView);
        Intrinsics.e(findViewById, "parent.findViewById(R.id.loadingProgressView)");
        this.f35700f = (IndeterminateProgressView) findViewById;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator d() {
        this.f35700f.setVisibility(8);
        return AlphaAnimatorHelper.f35720a.d(this.f35700f);
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator j() {
        return AlphaAnimatorHelper.f35720a.c(this.f35700f);
    }

    public final void k(float f8, float f9) {
        this.f35700f.getLayoutParams().width = (int) f8;
        this.f35700f.getLayoutParams().height = (int) f9;
    }

    public final void l(int i8) {
        this.f35700f.setColor(i8);
    }
}
