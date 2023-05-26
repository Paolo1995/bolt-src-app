package ee.mtakso.driver.uicore.components.views.swipe.states;

import android.animation.Animator;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisclaimerViewState.kt */
/* loaded from: classes5.dex */
public final class DisclaimerViewState extends ViewState {

    /* renamed from: f  reason: collision with root package name */
    private final TextView f35697f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DisclaimerViewState(Context context, ViewGroup parent) {
        super(context, parent, R$layout.content_swipe_button_disclaimer_state);
        Intrinsics.f(context, "context");
        Intrinsics.f(parent, "parent");
        this.f35697f = (TextView) parent.findViewById(R$id.swipeButtonDisclaimerText);
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator d() {
        TextView textView = this.f35697f;
        Intrinsics.e(textView, "textView");
        ViewExtKt.e(textView, false, 0, 2, null);
        return null;
    }

    @Override // ee.mtakso.driver.uicore.components.views.swipe.states.ViewState
    protected Animator j() {
        TextView textView = this.f35697f;
        Intrinsics.e(textView, "textView");
        ViewExtKt.e(textView, false, 0, 3, null);
        return null;
    }

    public final void k(CharSequence text) {
        Intrinsics.f(text, "text");
        this.f35697f.setText(text);
    }
}
