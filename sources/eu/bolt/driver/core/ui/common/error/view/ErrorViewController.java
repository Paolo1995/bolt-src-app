package eu.bolt.driver.core.ui.common.error.view;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.widgets.RoundButton;
import eu.bolt.driver.core.R$id;
import eu.bolt.driver.core.ui.common.error.view.ErrorViewController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorViewController.kt */
/* loaded from: classes5.dex */
public final class ErrorViewController {

    /* renamed from: a  reason: collision with root package name */
    private final View f41107a;

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, View> f41108b;

    public ErrorViewController(View containerView) {
        Intrinsics.f(containerView, "containerView");
        this.f41108b = new LinkedHashMap();
        this.f41107a = containerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function0 retryAction, View view) {
        Intrinsics.f(retryAction, "$retryAction");
        retryAction.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 onCancelClick, View view) {
        Intrinsics.f(onCancelClick, "$onCancelClick");
        onCancelClick.invoke();
    }

    public View c(int i8) {
        View findViewById;
        Map<Integer, View> map = this.f41108b;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View d8 = d();
            if (d8 == null || (findViewById = d8.findViewById(i8)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i8), findViewById);
            return findViewById;
        }
        return view;
    }

    public View d() {
        return this.f41107a;
    }

    public final void e(int i8, String title, String text, String buttonText, final Function0<Unit> retryAction, final Function0<Unit> onCancelClick) {
        Intrinsics.f(title, "title");
        Intrinsics.f(text, "text");
        Intrinsics.f(buttonText, "buttonText");
        Intrinsics.f(retryAction, "retryAction");
        Intrinsics.f(onCancelClick, "onCancelClick");
        ViewExtKt.e(d(), false, 0, 3, null);
        ((AppCompatImageView) c(R$id.f40768g)).setImageResource(i8);
        ((TextView) c(R$id.f40770i)).setText(title);
        ((TextView) c(R$id.f40769h)).setText(text);
        int i9 = R$id.f40771j;
        ((RoundButton) c(i9)).setText(buttonText);
        ((RoundButton) c(i9)).setOnClickListener(new View.OnClickListener() { // from class: g7.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorViewController.f(Function0.this, view);
            }
        });
        ((AppCompatImageView) c(R$id.f40767f)).setOnClickListener(new View.OnClickListener() { // from class: g7.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ErrorViewController.g(Function0.this, view);
            }
        });
    }
}
