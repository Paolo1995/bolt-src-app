package eu.bolt.android.engine.html.span;

import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import eu.bolt.android.engine.html.view.DesignHtmlTextView;
import eu.bolt.android.engine.html.view.OnUrlClickListener;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickableUrlSpan.kt */
/* loaded from: classes5.dex */
public final class ClickableUrlSpan extends URLSpan implements ViewBoundSpan {

    /* renamed from: f  reason: collision with root package name */
    private MovementMethodBackup f36880f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36881g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f36882h;

    /* compiled from: ClickableUrlSpan.kt */
    /* loaded from: classes5.dex */
    private static final class MovementMethodBackup {

        /* renamed from: a  reason: collision with root package name */
        private final MovementMethod f36883a;

        public MovementMethodBackup(MovementMethod movementMethod) {
            this.f36883a = movementMethod;
        }

        public final MovementMethod a() {
            return this.f36883a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableUrlSpan(String url) {
        super(url);
        Intrinsics.f(url, "url");
        this.f36881g = true;
    }

    @Override // eu.bolt.android.engine.html.span.ViewBoundSpan
    public void a(TextView textView) {
        Intrinsics.f(textView, "textView");
        MovementMethodBackup movementMethodBackup = this.f36880f;
        if (movementMethodBackup != null) {
            textView.setMovementMethod(movementMethodBackup.a());
        }
    }

    @Override // eu.bolt.android.engine.html.span.ViewBoundSpan
    public void b(TextView textView) {
        Intrinsics.f(textView, "textView");
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            this.f36880f = new MovementMethodBackup(textView.getMovementMethod());
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (textView instanceof DesignHtmlTextView) {
            DesignHtmlTextView designHtmlTextView = (DesignHtmlTextView) textView;
            this.f36881g = designHtmlTextView.getUnderlineLinks();
            this.f36882h = designHtmlTextView.getLinkColor();
        }
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        DesignHtmlTextView designHtmlTextView;
        Intrinsics.f(widget, "widget");
        OnUrlClickListener onUrlClickListener = null;
        if (widget instanceof DesignHtmlTextView) {
            designHtmlTextView = (DesignHtmlTextView) widget;
        } else {
            designHtmlTextView = null;
        }
        if (designHtmlTextView != null) {
            onUrlClickListener = designHtmlTextView.getOnUrlClickListener();
        }
        if (getURL() != null) {
            boolean z7 = false;
            if (onUrlClickListener != null) {
                String url = getURL();
                Intrinsics.e(url, "url");
                if (onUrlClickListener.a(url)) {
                    z7 = true;
                }
            }
            if (z7) {
                return;
            }
        }
        super.onClick(widget);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        boolean z7;
        Intrinsics.f(ds, "ds");
        Integer num = this.f36882h;
        if (num != null) {
            ds.linkColor = num.intValue();
        }
        boolean isUnderlineText = ds.isUnderlineText();
        super.updateDrawState(ds);
        if (!isUnderlineText && !this.f36881g) {
            z7 = false;
        } else {
            z7 = true;
        }
        ds.setUnderlineText(z7);
    }
}
