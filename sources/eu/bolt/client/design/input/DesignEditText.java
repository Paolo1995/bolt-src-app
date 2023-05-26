package eu.bolt.client.design.input;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.autofill.AutofillValue;
import androidx.emoji.widget.EmojiAppCompatEditText;
import eu.bolt.verification.R$attr;
import eu.bolt.verification.R$styleable;
import eu.bolt.verification.sdk.internal.a6;
import eu.bolt.verification.sdk.internal.g5;
import eu.bolt.verification.sdk.internal.la;
import eu.bolt.verification.sdk.internal.ma;
import eu.bolt.verification.sdk.internal.ol;
import eu.bolt.verification.sdk.internal.uq;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public class DesignEditText extends EmojiAppCompatEditText {

    /* renamed from: q  reason: collision with root package name */
    public static final c f40062q = new c(null);

    /* renamed from: n  reason: collision with root package name */
    private Function1<? super AutofillValue, Unit> f40063n;

    /* renamed from: o  reason: collision with root package name */
    private Function0<Unit> f40064o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f40065p;

    /* loaded from: classes5.dex */
    static final class a extends Lambda implements Function1<String, Unit> {
        a() {
            super(1);
        }

        public final void b(String liveTranslation) {
            Intrinsics.f(liveTranslation, "liveTranslation");
            DesignEditText.this.setHint(liveTranslation);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            b(str);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    static final class b extends Lambda implements Function1<TypedArray, Unit> {
        b() {
            super(1);
        }

        public final void b(TypedArray it) {
            Drawable[] f8;
            Intrinsics.f(it, "it");
            DesignEditText.this.f(it).b(DesignEditText.this);
            ColorStateList colorStateList = it.getColorStateList(R$styleable.Q0);
            Drawable drawable = it.getDrawable(R$styleable.P0);
            if (drawable == null) {
                drawable = ol.h(DesignEditText.this);
            }
            Drawable drawable2 = it.getDrawable(R$styleable.O0);
            if (drawable2 == null) {
                drawable2 = ol.g(DesignEditText.this);
            }
            Drawable drawable3 = it.getDrawable(R$styleable.N0);
            if (drawable3 == null) {
                drawable3 = ol.a(DesignEditText.this);
            }
            Drawable drawable4 = it.getDrawable(R$styleable.R0);
            if (drawable4 == null) {
                drawable4 = ol.j(DesignEditText.this);
            }
            Integer valueOf = Integer.valueOf(it.getInt(R$styleable.K0, -1));
            if (!(valueOf.intValue() != -1)) {
                valueOf = null;
            }
            ol.c(DesignEditText.this, drawable != null ? a6.b(drawable, colorStateList) : null, drawable2 != null ? a6.b(drawable2, colorStateList) : null, drawable4 != null ? a6.b(drawable4, colorStateList) : null, drawable3 != null ? a6.b(drawable3, colorStateList) : null, false, 16, null);
            boolean z7 = it.getBoolean(R$styleable.M0, true);
            for (Drawable drawable5 : ol.f(DesignEditText.this)) {
                if (drawable5 != null) {
                    drawable5.setAutoMirrored(z7);
                }
            }
            if (valueOf != null) {
                DesignEditText.this.setRawInputType(valueOf.intValue());
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TypedArray typedArray) {
            b(typedArray);
            return Unit.f50853a;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignEditText(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        if (attributeSet != null) {
            uq.w(this, attributeSet, "hint", new a());
        }
        int[] DesignEditText = R$styleable.J0;
        Intrinsics.e(DesignEditText, "DesignEditText");
        uq.x(this, attributeSet, DesignEditText, new b());
    }

    public /* synthetic */ DesignEditText(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.f41691e : i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g5 f(TypedArray typedArray) {
        g5.a aVar = g5.f43099d;
        Context context = getContext();
        int i8 = typedArray.getInt(R$styleable.L0, -1);
        int i9 = typedArray.getInt(R$styleable.S0, aVar.a());
        Intrinsics.e(context, "context");
        return aVar.b(context, i9, i8);
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(AutofillValue value) {
        Intrinsics.f(value, "value");
        this.f40065p = true;
        Function1<? super AutofillValue, Unit> function1 = this.f40063n;
        if (function1 != null) {
            function1.invoke(value);
        } else {
            super.autofill(value);
        }
        Function0<Unit> function0 = this.f40064o;
        if (function0 != null) {
            function0.invoke();
        }
        this.f40065p = false;
    }

    public final Function1<AutofillValue, Unit> getAutofillHandler() {
        return this.f40063n;
    }

    public final Function0<Unit> getOnAutofilledListener() {
        return this.f40064o;
    }

    public final void setAutofillHandler(Function1<? super AutofillValue, Unit> function1) {
        this.f40063n = function1;
    }

    public final void setInputFilters(la... filterTypes) {
        Intrinsics.f(filterTypes, "filterTypes");
        ArrayList arrayList = new ArrayList(filterTypes.length);
        for (la laVar : filterTypes) {
            arrayList.add(ma.f44164a.b(laVar));
        }
        InputFilter[] inputFilterArr = (InputFilter[]) arrayList.toArray(new InputFilter[0]);
        setFilters((InputFilter[]) Arrays.copyOf(inputFilterArr, inputFilterArr.length));
    }

    @Override // android.widget.TextView
    public void setInputType(int i8) {
        super.setInputType(i8);
        setKeyListener(getKeyListener());
        setRawInputType(i8);
    }

    public final void setOnAutofilledListener(Function0<Unit> function0) {
        this.f40064o = function0;
    }
}
