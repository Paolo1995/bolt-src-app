package ee.mtakso.driver.ui.screens.order.arrived;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LinkTouchMovementMethod.kt */
/* loaded from: classes3.dex */
public final class LinkTouchMovementMethod extends LinkMovementMethod {

    /* renamed from: a  reason: collision with root package name */
    private TouchableSpan f31063a;

    private final TouchableSpan a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int x7 = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
        Layout layout = textView.getLayout();
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical((((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY()), x7);
        TouchableSpan[] links = (TouchableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, TouchableSpan.class);
        Intrinsics.e(links, "links");
        for (TouchableSpan link : links) {
            Intrinsics.e(link, "link");
            if (b(offsetForHorizontal, spannable, link)) {
                return link;
            }
        }
        return null;
    }

    private final boolean b(int i8, Spannable spannable, Object obj) {
        if (i8 >= spannable.getSpanStart(obj) && i8 <= spannable.getSpanEnd(obj)) {
            return true;
        }
        return false;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent event) {
        Intrinsics.f(textView, "textView");
        Intrinsics.f(spannable, "spannable");
        Intrinsics.f(event, "event");
        if (event.getAction() == 0) {
            TouchableSpan a8 = a(textView, spannable, event);
            this.f31063a = a8;
            if (a8 != null) {
                if (a8 != null) {
                    a8.b(true);
                }
                Selection.setSelection(spannable, spannable.getSpanStart(this.f31063a), spannable.getSpanEnd(this.f31063a));
            }
        } else if (event.getAction() == 2) {
            TouchableSpan a9 = a(textView, spannable, event);
            TouchableSpan touchableSpan = this.f31063a;
            if (touchableSpan != null && a9 != touchableSpan) {
                if (touchableSpan != null) {
                    touchableSpan.b(false);
                }
                this.f31063a = null;
                Selection.removeSelection(spannable);
            }
        } else {
            TouchableSpan touchableSpan2 = this.f31063a;
            if (touchableSpan2 != null) {
                if (touchableSpan2 != null) {
                    touchableSpan2.b(false);
                }
                super.onTouchEvent(textView, spannable, event);
            }
            this.f31063a = null;
            Selection.removeSelection(spannable);
        }
        return true;
    }
}
