package ee.mtakso.driver.ui.screens.order.arrived;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import ee.mtakso.driver.R;
import ee.mtakso.driver.ui.screens.sos.SosDialogFragment;
import ee.mtakso.driver.uikit.utils.ContextUtilsKt;
import ee.mtakso.driver.uikit.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import ee.mtakso.driver.utils.ext.FragmentFactoryUtils;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SosButtonDelegate.kt */
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes3.dex */
public final class SosButtonDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final RoundButton f31088a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentManager f31089b;

    /* renamed from: c  reason: collision with root package name */
    private final FragmentFactory f31090c;

    public SosButtonDelegate(RoundButton sosButton, FragmentManager fragmentManager, FragmentFactory fragmentFactory) {
        Intrinsics.f(sosButton, "sosButton");
        Intrinsics.f(fragmentManager, "fragmentManager");
        Intrinsics.f(fragmentFactory, "fragmentFactory");
        this.f31088a = sosButton;
        this.f31089b = fragmentManager;
        this.f31090c = fragmentFactory;
        sosButton.setOnTouchListener(new View.OnTouchListener() { // from class: ee.mtakso.driver.ui.screens.order.arrived.o
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean b8;
                b8 = SosButtonDelegate.b(SosButtonDelegate.this, view, motionEvent);
                return b8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(SosButtonDelegate this$0, View view, MotionEvent motionEvent) {
        Integer num;
        Intrinsics.f(this$0, "this$0");
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this$0.d(this$0.f31088a);
            return true;
        } else if (num != null && num.intValue() == 1) {
            this$0.c(this$0.f31088a);
            return true;
        } else {
            return false;
        }
    }

    private final void c(RoundButton roundButton) {
        Fragment findFragmentByTag = this.f31089b.findFragmentByTag("sosDialog");
        if (findFragmentByTag instanceof SosDialogFragment) {
            ((SosDialogFragment) findFragmentByTag).i0();
        }
        Context context = roundButton.getContext();
        Intrinsics.e(context, "sosButton.context");
        roundButton.setBgColor(ContextUtilsKt.b(context, R.attr.backSecondary));
    }

    private final void d(RoundButton roundButton) {
        FragmentFactory fragmentFactory = this.f31090c;
        Context context = roundButton.getContext();
        Intrinsics.e(context, "sosButton.context");
        ((SosDialogFragment) FragmentFactoryUtils.c(fragmentFactory, context, SosDialogFragment.class, null, 4, null)).show(this.f31089b, "sosDialog");
        Context context2 = roundButton.getContext();
        Intrinsics.e(context2, "sosButton.context");
        roundButton.setBgColor(ContextUtilsKt.b(context2, R.attr.accentRed));
    }

    public final void e(boolean z7) {
        ViewExtKt.d(this.f31088a, z7, 0, 2, null);
    }
}
