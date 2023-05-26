package eu.bolt.android.engine.html.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.textview.MaterialTextView;
import eu.bolt.android.engine.html.DesignHtmlSpanBuilder;
import eu.bolt.android.engine.html.HtmlEngine;
import eu.bolt.android.engine.html.R$styleable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DesignHtmlTextView.kt */
/* loaded from: classes5.dex */
public class DesignHtmlTextView extends MaterialTextView {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f36931k = new Companion(null);

    /* renamed from: l  reason: collision with root package name */
    private static HtmlEngine f36932l;

    /* renamed from: f  reason: collision with root package name */
    private boolean f36933f;

    /* renamed from: g  reason: collision with root package name */
    private Integer f36934g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36935h;

    /* renamed from: i  reason: collision with root package name */
    private OnUrlClickListener f36936i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f36937j;

    /* compiled from: DesignHtmlTextView.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(HtmlEngine converter) {
            Intrinsics.f(converter, "converter");
            DesignHtmlTextView.f36932l = converter;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignHtmlTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    public /* synthetic */ DesignHtmlTextView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final void l() {
        CharSequence charSequence = this.f36937j;
        if (charSequence != null && (charSequence instanceof DesignHtmlSpanBuilder)) {
            ((DesignHtmlSpanBuilder) charSequence).d(this);
        }
    }

    private final void m() {
        CharSequence charSequence = this.f36937j;
        if (charSequence != null && (charSequence instanceof DesignHtmlSpanBuilder)) {
            ((DesignHtmlSpanBuilder) charSequence).e();
        }
    }

    private final void n(TypedArray typedArray, Context context) {
        int resourceId = typedArray.getResourceId(R$styleable.R, -1);
        if (resourceId != -1) {
            this.f36934g = Integer.valueOf(ContextCompat.getColor(context, resourceId));
        }
    }

    private final void o(TypedArray typedArray) {
        this.f36935h = typedArray.getBoolean(R$styleable.S, true);
    }

    private final void p(TypedArray typedArray) {
        this.f36933f = typedArray.getBoolean(R$styleable.T, true);
    }

    public final Integer getLinkColor() {
        return this.f36934g;
    }

    public final OnUrlClickListener getOnUrlClickListener() {
        return this.f36936i;
    }

    public final boolean getParseHtml() {
        return this.f36935h;
    }

    public final boolean getUnderlineLinks() {
        return this.f36933f;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        m();
        super.onDetachedFromWindow();
    }

    public final float q(CharSequence text) {
        Intrinsics.f(text, "text");
        CharSequence r7 = r(text);
        if (r7 == null) {
            return 0.0f;
        }
        return getPaint().measureText(r7, 0, r7.length());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSequence r(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (!this.f36935h) {
            return charSequence;
        }
        if (charSequence instanceof DesignHtmlSpanBuilder) {
            return charSequence;
        }
        if (charSequence instanceof Spanned) {
            return charSequence;
        }
        HtmlEngine htmlEngine = f36932l;
        if (htmlEngine != null) {
            return htmlEngine.a(charSequence.toString());
        }
        return charSequence;
    }

    public final void setLinkColor(Integer num) {
        this.f36934g = num;
    }

    public final void setOnUrlClickListener(OnUrlClickListener onUrlClickListener) {
        this.f36936i = onUrlClickListener;
    }

    public final void setParseHtml(boolean z7) {
        this.f36935h = z7;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        CharSequence r7 = r(charSequence);
        m();
        if (r7 instanceof DesignHtmlSpanBuilder) {
            ((DesignHtmlSpanBuilder) r7).d(this);
        }
        this.f36937j = r7;
        super.setText(r7, bufferType);
    }

    public final void setUnderlineLinks(boolean z7) {
        this.f36933f = z7;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignHtmlTextView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f36933f = true;
        this.f36935h = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Q);
            Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…eable.DesignHtmlTextView)");
            p(obtainStyledAttributes);
            n(obtainStyledAttributes, context);
            o(obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }
    }
}
