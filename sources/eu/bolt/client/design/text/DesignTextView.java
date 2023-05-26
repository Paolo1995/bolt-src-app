package eu.bolt.client.design.text;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.emoji.widget.EmojiTextViewHelper;
import eu.bolt.android.engine.html.view.DesignHtmlTextView;
import eu.bolt.verification.R$attr;
import eu.bolt.verification.R$color;
import eu.bolt.verification.R$id;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.a6;
import eu.bolt.verification.sdk.internal.f2;
import eu.bolt.verification.sdk.internal.g5;
import eu.bolt.verification.sdk.internal.ol;
import eu.bolt.verification.sdk.internal.t4;
import eu.bolt.verification.sdk.internal.u4;
import eu.bolt.verification.sdk.internal.uq;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* loaded from: classes5.dex */
public class DesignTextView extends DesignHtmlTextView {

    /* renamed from: r  reason: collision with root package name */
    public static final b f40226r = new b(null);

    /* renamed from: s  reason: collision with root package name */
    private static final int[] f40227s = {R$attr.clickableInDisabledMode};

    /* renamed from: t  reason: collision with root package name */
    private static final Regex f40228t = new Regex("\n+");

    /* renamed from: u  reason: collision with root package name */
    private static final AtomicBoolean f40229u = new AtomicBoolean();

    /* renamed from: m  reason: collision with root package name */
    private boolean f40230m;

    /* renamed from: n  reason: collision with root package name */
    private EmojiTextViewHelper f40231n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f40232o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f40233p;

    /* renamed from: q  reason: collision with root package name */
    private Integer f40234q;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<String, Unit> {
        a() {
            super(1);
        }

        public final void b(String it) {
            Intrinsics.f(it, "it");
            DesignTextView.this.setText(it);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            b(str);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class c extends Lambda implements Function1<MatchResult, IntRange> {

        /* renamed from: f  reason: collision with root package name */
        public static final c f40236f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final IntRange invoke(MatchResult matchResult) {
            Object X;
            Intrinsics.f(matchResult, "matchResult");
            X = CollectionsKt___CollectionsKt.X(matchResult.a());
            MatchGroup matchGroup = (MatchGroup) X;
            if (matchGroup != null) {
                return matchGroup.a();
            }
            return null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignTextView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Drawable[] f8;
        Intrinsics.f(context, "context");
        setUnderlineLinks(false);
        u();
        if (attributeSet == null) {
            g5.a.c(g5.f43099d, context, 0, 0, 6, null).b(this);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f41747b2);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…styleable.DesignTextView)");
        uq.w(this, attributeSet, "text", new a());
        s(obtainStyledAttributes).b(this);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R$styleable.f41796i2);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.f41789h2);
        drawable = drawable == null ? ol.h(this) : drawable;
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.f41782g2);
        drawable2 = drawable2 == null ? ol.g(this) : drawable2;
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R$styleable.f41775f2);
        drawable3 = drawable3 == null ? ol.a(this) : drawable3;
        Drawable drawable4 = obtainStyledAttributes.getDrawable(R$styleable.f41803j2);
        drawable4 = drawable4 == null ? ol.j(this) : drawable4;
        ol.c(this, drawable != null ? a6.b(drawable, colorStateList) : null, drawable2 != null ? a6.b(drawable2, colorStateList) : null, drawable4 != null ? a6.b(drawable4, colorStateList) : null, drawable3 != null ? a6.b(drawable3, colorStateList) : null, false, 16, null);
        boolean z7 = obtainStyledAttributes.getBoolean(R$styleable.f41768e2, true);
        for (Drawable drawable5 : ol.f(this)) {
            if (drawable5 != null) {
                drawable5.setAutoMirrored(z7);
            }
        }
        w(isEnabled(), obtainStyledAttributes.getBoolean(R$styleable.f41754c2, false));
        int i9 = R$styleable.f41817l2;
        if (obtainStyledAttributes.hasValue(i9)) {
            setParagraphSpacing(Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(i9, 0)));
        }
        obtainStyledAttributes.recycle();
    }

    public /* synthetic */ DesignTextView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final EmojiTextViewHelper getEmojiTextViewHelper() {
        EmojiTextViewHelper emojiTextViewHelper = this.f40231n;
        if (emojiTextViewHelper == null) {
            EmojiTextViewHelper emojiTextViewHelper2 = new EmojiTextViewHelper(this);
            this.f40231n = emojiTextViewHelper2;
            return emojiTextViewHelper2;
        }
        return emojiTextViewHelper;
    }

    private final g5 s(TypedArray typedArray) {
        g5.a aVar = g5.f43099d;
        Context context = getContext();
        int i8 = typedArray.getInt(R$styleable.f41761d2, -1);
        int i9 = typedArray.getInt(R$styleable.f41810k2, aVar.a());
        Intrinsics.e(context, "context");
        return aVar.b(context, i9, i8);
    }

    private final CharSequence t(CharSequence charSequence, int i8) {
        Sequence w7;
        List<IntRange> D;
        int b8;
        int Q;
        SpannableStringBuilder spannableStringBuilder = charSequence instanceof SpannableStringBuilder ? (SpannableStringBuilder) charSequence : new SpannableStringBuilder(charSequence);
        int i9 = 0;
        w7 = SequencesKt___SequencesKt.w(Regex.d(f40228t, spannableStringBuilder, 0, 2, null), c.f40236f);
        D = SequencesKt___SequencesKt.D(w7);
        for (IntRange intRange : D) {
            spannableStringBuilder.replace(intRange.g() + i9, intRange.i() + i9 + 1, (CharSequence) "\n\n");
            int g8 = intRange.g() + i9 + 1;
            b8 = MathKt__MathJVMKt.b(getLineSpacingExtra());
            spannableStringBuilder.setSpan(new eu.bolt.verification.sdk.internal.b(i8 - b8), g8, g8 + 1, 33);
            Q = CollectionsKt___CollectionsKt.Q(intRange);
            i9 += 2 - Q;
        }
        return spannableStringBuilder;
    }

    private final void u() {
        if (getLinkColor() == null) {
            setLinkColor(Integer.valueOf(uq.d(this, R$color.green_700)));
        }
    }

    public final u4 getFontStyle() {
        Object tag = getTag(R$id.designFontStyle);
        if (tag instanceof u4) {
            return (u4) tag;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int[] drawableState = super.onCreateDrawableState(i8 + 1);
        if (this.f40230m) {
            View.mergeDrawableStates(drawableState, f40227s);
        }
        Intrinsics.e(drawableState, "drawableState");
        return drawableState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // eu.bolt.android.engine.html.view.DesignHtmlTextView
    public CharSequence r(CharSequence charSequence) {
        CharSequence r7 = super.r(charSequence);
        if (r7 == null) {
            return null;
        }
        Integer num = this.f40234q;
        return (!f40229u.get() || num == null) ? r7 : t(r7, num.intValue());
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setAllCaps(boolean z7) {
        super.setAllCaps(z7);
        getEmojiTextViewHelper().b(z7);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z7) {
        w(z7, false);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setFilters(InputFilter[] filters) {
        Intrinsics.f(filters, "filters");
        super.setFilters(getEmojiTextViewHelper().a(filters));
    }

    public final void setFont(t4 font) {
        Intrinsics.f(font, "font");
        Context context = getContext();
        Intrinsics.e(context, "context");
        new g5(context, font, null, 4, null).b(this);
        v(this.f40232o);
    }

    public final void setFontStyle(u4 designFontStyle) {
        Intrinsics.f(designFontStyle, "designFontStyle");
        Context context = getContext();
        Intrinsics.e(context, "context");
        new g5(context, designFontStyle.c(), designFontStyle).b(this);
        v(this.f40232o);
    }

    public final void setParagraphSpacing(Integer num) {
        this.f40234q = num;
        setText(this.f40233p);
    }

    @Override // eu.bolt.android.engine.html.view.DesignHtmlTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.f40233p = charSequence;
    }

    public final void v(boolean z7) {
        int i8;
        this.f40232o = z7;
        u4 fontStyle = getFontStyle();
        if (!z7 || fontStyle == null) {
            i8 = 0;
        } else {
            Context context = getContext();
            Intrinsics.e(context, "context");
            i8 = (int) f2.m(context, fontStyle.h() + fontStyle.f());
        }
        setMinHeight(i8);
    }

    public final void w(boolean z7, boolean z8) {
        boolean z9;
        if (z7 || !z8) {
            super.setEnabled(z7);
            z9 = false;
        } else {
            z9 = true;
            super.setEnabled(true);
        }
        this.f40230m = z9;
        refreshDrawableState();
    }
}
