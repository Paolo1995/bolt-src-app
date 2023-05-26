package ee.mtakso.driver.uicore.components.views.input;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import ee.mtakso.driver.uicore.R$attr;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$drawable;
import ee.mtakso.driver.uicore.R$font;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.components.views.input.TextInputView;
import ee.mtakso.driver.uicore.utils.Dimens;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.utils.TextViewExtKt;
import eu.bolt.kalev.Kalev;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: TextInputView.kt */
/* loaded from: classes5.dex */
public final class TextInputView extends FrameLayout {

    /* renamed from: z  reason: collision with root package name */
    private static final Companion f35603z = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final int f35604f;

    /* renamed from: g  reason: collision with root package name */
    private final int f35605g;

    /* renamed from: h  reason: collision with root package name */
    private Function1<? super String, Unit> f35606h;

    /* renamed from: i  reason: collision with root package name */
    private Function2<? super Integer, ? super KeyEvent, Boolean> f35607i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f35608j;

    /* renamed from: k  reason: collision with root package name */
    private String f35609k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f35610l;

    /* renamed from: m  reason: collision with root package name */
    private int f35611m;

    /* renamed from: n  reason: collision with root package name */
    private int f35612n;

    /* renamed from: o  reason: collision with root package name */
    private int f35613o;

    /* renamed from: p  reason: collision with root package name */
    private int f35614p;

    /* renamed from: q  reason: collision with root package name */
    private int f35615q;

    /* renamed from: r  reason: collision with root package name */
    private int f35616r;

    /* renamed from: s  reason: collision with root package name */
    private Animator f35617s;

    /* renamed from: t  reason: collision with root package name */
    private float f35618t;

    /* renamed from: u  reason: collision with root package name */
    private float f35619u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f35620v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f35621w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f35622x;

    /* renamed from: y  reason: collision with root package name */
    public Map<Integer, View> f35623y;

    /* compiled from: TextInputView.kt */
    /* renamed from: ee.mtakso.driver.uicore.components.views.input.TextInputView$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass2 implements TextWatcher {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(TextInputView this$0) {
            Intrinsics.f(this$0, "this$0");
            this$0.y();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s7) {
            Intrinsics.f(s7, "s");
            TextInputView.this.getOnTextChangeListener().invoke(s7.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s7, int i8, int i9, int i10) {
            boolean z7;
            Intrinsics.f(s7, "s");
            boolean z8 = true;
            TextInputView.this.f35621w = true;
            ImageView tivClear = (ImageView) TextInputView.this.h(R$id.tivClear);
            Intrinsics.e(tivClear, "tivClear");
            if (s7.length() > 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            ViewExtKt.e(tivClear, (z7 && TextInputView.this.s()) ? false : false, 0, 2, null);
            final TextInputView textInputView = TextInputView.this;
            textInputView.post(new Runnable() { // from class: ee.mtakso.driver.uicore.components.views.input.h
                @Override // java.lang.Runnable
                public final void run() {
                    TextInputView.AnonymousClass2.b(TextInputView.this);
                }
            });
        }
    }

    /* compiled from: TextInputView.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextInputView(final Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        String string;
        List C0;
        Intrinsics.f(context, "context");
        this.f35623y = new LinkedHashMap();
        this.f35604f = 8;
        this.f35605g = 56;
        this.f35606h = new Function1<String, Unit>() { // from class: ee.mtakso.driver.uicore.components.views.input.TextInputView$onTextChangeListener$1
            public final void b(String it) {
                Intrinsics.f(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                b(str);
                return Unit.f50853a;
            }
        };
        this.f35607i = new Function2<Integer, KeyEvent, Boolean>() { // from class: ee.mtakso.driver.uicore.components.views.input.TextInputView$onEditorAction$1
            public final Boolean b(int i9, KeyEvent keyEvent) {
                return Boolean.FALSE;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean s(Integer num, KeyEvent keyEvent) {
                return b(num.intValue(), keyEvent);
            }
        };
        this.f35609k = "";
        this.f35611m = ContextCompat.getColor(context, R$color.neutral900);
        int i9 = R$color.neutral600;
        this.f35612n = ContextCompat.getColor(context, i9);
        this.f35613o = ContextCompat.getColor(context, i9);
        this.f35614p = ContextCompat.getColor(context, R$color.neutral500);
        this.f35615q = ContextCompat.getColor(context, i9);
        this.f35616r = ContextCompat.getColor(context, R$color.red700);
        this.f35619u = 1.0f;
        this.f35620v = getVisibility() == 0;
        View.inflate(context, R$layout.view_text_input, this);
        this.f35622x = false;
        setAddStatesFromChildren(true);
        setPadding(Dimens.d(8), 0, Dimens.d(8), 0);
        int i10 = R$id.tivEdit;
        this.f35618t = ((AppCompatEditText) h(i10)).getTranslationY();
        this.f35619u = ((TextView) h(R$id.tivHint)).getAlpha();
        setMinimumHeight(Dimens.d(56));
        setFocusable(true);
        setClickable(true);
        setFocusableInTouchMode(true);
        setDescendantFocusability(262144);
        setPaddingRelative(Dimens.d(16), 0, Dimens.d(8), 0);
        ((AppCompatEditText) h(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: ee.mtakso.driver.uicore.components.views.input.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z7) {
                TextInputView.i(TextInputView.this, view, z7);
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.C3);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr….styleable.TextInputView)");
        String string2 = obtainStyledAttributes.getString(R$styleable.E3);
        setHint(string2 == null ? this.f35609k : string2);
        setInputType(obtainStyledAttributes.getInt(R$styleable.F3, getInputType()));
        setImeOptions(obtainStyledAttributes.getInt(R$styleable.G3, getImeOptions()));
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.D3);
        setTextInputBg(drawable == null ? AppCompatResources.b(context, R$drawable.text_input_bg) : drawable);
        setTextColor(obtainStyledAttributes.getColor(R$styleable.L3, this.f35611m));
        setTextDisabledColor(obtainStyledAttributes.getColor(R$styleable.I3, this.f35612n));
        setLableColor(obtainStyledAttributes.getColor(R$styleable.K3, this.f35615q));
        setLableErrorColor(obtainStyledAttributes.getColor(R$styleable.J3, this.f35616r));
        if (Build.VERSION.SDK_INT >= 26 && (string = obtainStyledAttributes.getString(R$styleable.H3)) != null) {
            C0 = StringsKt__StringsKt.C0(string, new String[]{","}, false, 0, 6, null);
            setAutoFillHint((String[]) C0.toArray(new String[0]));
        }
        obtainStyledAttributes.recycle();
        ((AppCompatEditText) h(i10)).addTextChangedListener(new AnonymousClass2());
        ((AppCompatEditText) h(i10)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: ee.mtakso.driver.uicore.components.views.input.b
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                boolean j8;
                j8 = TextInputView.j(TextInputView.this, textView, i11, keyEvent);
                return j8;
            }
        });
        ((ImageView) h(R$id.tivClear)).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.views.input.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextInputView.k(TextInputView.this, view);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.views.input.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextInputView.l(context, this, view);
            }
        });
        int i11 = R$id.tivTogglePassword;
        AppCompatCheckBox tivTogglePassword = (AppCompatCheckBox) h(i11);
        Intrinsics.e(tivTogglePassword, "tivTogglePassword");
        tivTogglePassword.setVisibility(t(getInputType()) ? 0 : 8);
        ((AppCompatCheckBox) h(i11)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ee.mtakso.driver.uicore.components.views.input.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z7) {
                TextInputView.m(TextInputView.this, compoundButton, z7);
            }
        });
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: ee.mtakso.driver.uicore.components.views.input.f
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
                TextInputView.n(TextInputView.this, view, i12, i13, i14, i15, i16, i17, i18, i19);
            }
        });
    }

    private final int getImeOptions() {
        return ((AppCompatEditText) h(R$id.tivEdit)).getImeOptions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r1 == true) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(final ee.mtakso.driver.uicore.components.views.input.TextInputView r4, android.view.View r5, boolean r6) {
        /*
            java.lang.String r5 = "this$0"
            kotlin.jvm.internal.Intrinsics.f(r4, r5)
            r5 = 0
            r0 = 2
            java.lang.String r1 = "tivClear"
            r2 = 0
            if (r6 == 0) goto L37
            int r6 = ee.mtakso.driver.uicore.R$id.tivClear
            android.view.View r6 = r4.h(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            kotlin.jvm.internal.Intrinsics.e(r6, r1)
            int r1 = ee.mtakso.driver.uicore.R$id.tivEdit
            android.view.View r1 = r4.h(r1)
            androidx.appcompat.widget.AppCompatEditText r1 = (androidx.appcompat.widget.AppCompatEditText) r1
            android.text.Editable r1 = r1.getText()
            r3 = 1
            if (r1 == 0) goto L32
            int r1 = r1.length()
            if (r1 <= 0) goto L2e
            r1 = 1
            goto L2f
        L2e:
            r1 = 0
        L2f:
            if (r1 != r3) goto L32
            goto L33
        L32:
            r3 = 0
        L33:
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r6, r3, r2, r0, r5)
            goto L45
        L37:
            int r6 = ee.mtakso.driver.uicore.R$id.tivClear
            android.view.View r6 = r4.h(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            kotlin.jvm.internal.Intrinsics.e(r6, r1)
            ee.mtakso.driver.uicore.utils.ViewExtKt.e(r6, r2, r2, r0, r5)
        L45:
            ee.mtakso.driver.uicore.components.views.input.g r5 = new ee.mtakso.driver.uicore.components.views.input.g
            r5.<init>()
            r4.post(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.views.input.TextInputView.i(ee.mtakso.driver.uicore.components.views.input.TextInputView, android.view.View, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean j(TextInputView this$0, TextView textView, int i8, KeyEvent keyEvent) {
        Intrinsics.f(this$0, "this$0");
        return this$0.f35607i.s(Integer.valueOf(i8), keyEvent).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(TextInputView this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        if (this$0.isEnabled()) {
            ((AppCompatEditText) this$0.h(R$id.tivEdit)).setText((CharSequence) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Context context, TextInputView this$0, View view) {
        Intrinsics.f(context, "$context");
        Intrinsics.f(this$0, "this$0");
        Object systemService = context.getSystemService("input_method");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput((AppCompatEditText) this$0.h(R$id.tivEdit), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(TextInputView this$0, CompoundButton compoundButton, boolean z7) {
        PasswordTransformationMethod passwordTransformationMethod;
        int i8;
        Intrinsics.f(this$0, "this$0");
        int i9 = R$id.tivEdit;
        AppCompatEditText appCompatEditText = (AppCompatEditText) this$0.h(i9);
        if (z7) {
            passwordTransformationMethod = PasswordTransformationMethod.getInstance();
        } else {
            passwordTransformationMethod = null;
        }
        appCompatEditText.setTransformationMethod(passwordTransformationMethod);
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) this$0.h(i9);
        Editable text = ((AppCompatEditText) this$0.h(i9)).getText();
        if (text != null) {
            i8 = text.length();
        } else {
            i8 = 0;
        }
        appCompatEditText2.setSelection(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(TextInputView this$0, View view, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        if (String.valueOf(((AppCompatEditText) this$0.h(R$id.tivEdit)).getText()).length() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        this$0.z(z7);
    }

    private final float r() {
        return ((TextView) h(R$id.tivHint)).getBottom() - ((AppCompatEditText) h(R$id.tivEdit)).getTop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s() {
        if (isFocused()) {
            return true;
        }
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            if (getChildAt(i8).isFocused()) {
                return true;
            }
        }
        return false;
    }

    private final void setImeOptions(int i8) {
        ((AppCompatEditText) h(R$id.tivEdit)).setImeOptions(i8);
    }

    private final boolean t(int i8) {
        return i8 == 129;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(TextInputView this$0) {
        Intrinsics.f(this$0, "this$0");
        this$0.y();
    }

    private final void v() {
        int i8;
        int i9 = R$id.tivEdit;
        AppCompatEditText appCompatEditText = (AppCompatEditText) h(i9);
        if (((AppCompatEditText) h(i9)).isEnabled()) {
            i8 = this.f35613o;
        } else {
            i8 = this.f35614p;
        }
        appCompatEditText.setHintTextColor(i8);
    }

    private final void w() {
        int i8;
        TextView textView = (TextView) h(R$id.tivHint);
        if (this.f35608j) {
            i8 = this.f35616r;
        } else {
            i8 = this.f35615q;
        }
        textView.setTextColor(i8);
    }

    private final void x() {
        int i8;
        int i9 = R$id.tivEdit;
        AppCompatEditText appCompatEditText = (AppCompatEditText) h(i9);
        if (((AppCompatEditText) h(i9)).isEnabled()) {
            i8 = this.f35611m;
        } else {
            i8 = this.f35612n;
        }
        appCompatEditText.setTextColor(i8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        int i8;
        int i9 = R$id.iconContainer;
        int measuredWidth = ((LinearLayout) h(i9)).getMeasuredWidth();
        LinearLayout iconContainer = (LinearLayout) h(i9);
        Intrinsics.e(iconContainer, "iconContainer");
        ViewGroup.LayoutParams layoutParams = iconContainer.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            i8 = MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) layoutParams);
        } else {
            i8 = 0;
        }
        int i10 = measuredWidth + i8;
        if (ViewCompat.E(this) == 1) {
            AppCompatEditText tivEdit = (AppCompatEditText) h(R$id.tivEdit);
            Intrinsics.e(tivEdit, "tivEdit");
            ee.mtakso.driver.uikit.utils.ViewExtKt.h(tivEdit, null, null, Integer.valueOf(i10), null, 11, null);
            return;
        }
        AppCompatEditText tivEdit2 = (AppCompatEditText) h(R$id.tivEdit);
        Intrinsics.e(tivEdit2, "tivEdit");
        ee.mtakso.driver.uikit.utils.ViewExtKt.h(tivEdit2, Integer.valueOf(i10), null, null, null, 14, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0094 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void z(boolean r8) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.views.input.TextInputView.z(boolean):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Object obj;
        SparseArray<Parcelable> sparseParcelableArray;
        Bundle bundle = null;
        if (sparseArray != null) {
            obj = (Parcelable) sparseArray.get(getId());
        } else {
            obj = null;
        }
        if (obj instanceof Bundle) {
            bundle = (Bundle) obj;
        }
        if (bundle == null || (sparseParcelableArray = bundle.getSparseParcelableArray("state_child_states")) == null) {
            return;
        }
        super.dispatchRestoreInstanceState(sparseParcelableArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        SparseArray<Parcelable> sparseArray2 = new SparseArray<>(getChildCount());
        super.dispatchSaveInstanceState(sparseArray2);
        Bundle bundle = new Bundle();
        bundle.putSparseParcelableArray("state_child_states", sparseArray2);
        if (sparseArray != null) {
            sparseArray.put(getId(), bundle);
        }
    }

    public final String[] getAutoFillHint() {
        return ((AppCompatEditText) h(R$id.tivEdit)).getAutofillHints();
    }

    public final String getHint() {
        return this.f35609k;
    }

    public final int getInputType() {
        return ((AppCompatEditText) h(R$id.tivEdit)).getInputType();
    }

    public final int getLableColor() {
        return this.f35615q;
    }

    public final int getLableErrorColor() {
        return this.f35616r;
    }

    public final Function2<Integer, KeyEvent, Boolean> getOnEditorAction() {
        return this.f35607i;
    }

    public final Function1<String, Unit> getOnTextChangeListener() {
        return this.f35606h;
    }

    public final IntRange getSelection() {
        int i8 = R$id.tivEdit;
        IntRange intRange = new IntRange(((AppCompatEditText) h(i8)).getSelectionEnd(), ((AppCompatEditText) h(i8)).getSelectionStart());
        Kalev.b("get selection = " + intRange);
        return intRange;
    }

    public final int getSelectionEnd() {
        return ((AppCompatEditText) h(R$id.tivEdit)).getSelectionEnd();
    }

    public final int getSelectionStart() {
        return ((AppCompatEditText) h(R$id.tivEdit)).getSelectionStart();
    }

    public final String getText() {
        return String.valueOf(((AppCompatEditText) h(R$id.tivEdit)).getText());
    }

    public final int getTextColor() {
        return this.f35611m;
    }

    public final int getTextDisabledColor() {
        return this.f35612n;
    }

    public final int getTextHintColor() {
        return this.f35613o;
    }

    public final int getTextHintDisabledColor() {
        return this.f35614p;
    }

    public final Drawable getTextInputBg() {
        return this.f35610l;
    }

    public final TransformationMethod getTransformationMethod() {
        return ((AppCompatEditText) h(R$id.tivEdit)).getTransformationMethod();
    }

    public View h(int i8) {
        Map<Integer, View> map = this.f35623y;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i8) {
        int i9;
        Boolean bool = null;
        boolean z7 = false;
        int[] iArr = this.f35608j ? new int[]{R$attr.f34581l} : null;
        if (iArr != null) {
            i9 = iArr.length;
        } else {
            i9 = 0;
        }
        int[] baseState = super.onCreateDrawableState(i8 + i9);
        if (iArr != null) {
            if (iArr.length == 0) {
                z7 = true;
            }
            bool = Boolean.valueOf(!z7);
        }
        if (Intrinsics.a(bool, Boolean.TRUE)) {
            int[] mergeDrawableStates = View.mergeDrawableStates(baseState, iArr);
            Intrinsics.e(mergeDrawableStates, "mergeDrawableStates(baseState, extraStates)");
            return mergeDrawableStates;
        }
        Intrinsics.e(baseState, "baseState");
        return baseState;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i8, Rect rect) {
        return ((AppCompatEditText) h(R$id.tivEdit)).requestFocus();
    }

    public final void setAutoFillHint(String[] strArr) {
        if (strArr == null) {
            ((AppCompatEditText) h(R$id.tivEdit)).setAutofillHints(new String[]{null});
        } else {
            ((AppCompatEditText) h(R$id.tivEdit)).setAutofillHints((String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    public final void setCompoundDrawablePadding(int i8) {
        ((AppCompatEditText) h(R$id.tivEdit)).setCompoundDrawablePadding(i8);
    }

    @Override // android.view.View
    public void setEnabled(boolean z7) {
        super.setEnabled(z7);
        ((AppCompatEditText) h(R$id.tivEdit)).setEnabled(z7);
        x();
        v();
        ((AppCompatCheckBox) h(R$id.tivTogglePassword)).setEnabled(z7);
    }

    public final void setError(boolean z7) {
        if (this.f35608j != z7) {
            this.f35608j = z7;
            w();
            refreshDrawableState();
        }
    }

    public final void setHint(String value) {
        Intrinsics.f(value, "value");
        this.f35609k = value;
        ((TextView) h(R$id.tivHint)).setText(value);
        ((AppCompatEditText) h(R$id.tivEdit)).setHint(value);
    }

    public final void setInputType(int i8) {
        int i9 = R$id.tivEdit;
        ((AppCompatEditText) h(i9)).setInputType(i8);
        ((AppCompatEditText) h(i9)).setTypeface(ResourcesCompat.h(getContext(), R$font.f34590c));
    }

    public final void setLableColor(int i8) {
        this.f35615q = i8;
        w();
    }

    public final void setLableErrorColor(int i8) {
        this.f35616r = i8;
        w();
    }

    public final void setOnEditorAction(Function2<? super Integer, ? super KeyEvent, Boolean> function2) {
        Intrinsics.f(function2, "<set-?>");
        this.f35607i = function2;
    }

    public final void setOnTextChangeListener(Function1<? super String, Unit> function1) {
        Intrinsics.f(function1, "<set-?>");
        this.f35606h = function1;
    }

    public final void setSelection(IntRange value) {
        Intrinsics.f(value, "value");
        ((AppCompatEditText) h(R$id.tivEdit)).setSelection(value.g(), value.i());
        Unit unit = Unit.f50853a;
        Kalev.b("set selection = " + value);
    }

    public final void setStartDrawableWithIntrinsicBounds(int i8) {
        AppCompatEditText tivEdit = (AppCompatEditText) h(R$id.tivEdit);
        Intrinsics.e(tivEdit, "tivEdit");
        TextViewExtKt.g(tivEdit, i8);
    }

    public final void setText(String value) {
        Intrinsics.f(value, "value");
        this.f35621w = true;
        ((AppCompatEditText) h(R$id.tivEdit)).setText(value);
    }

    public final void setTextColor(int i8) {
        this.f35611m = i8;
        x();
    }

    public final void setTextDisabledColor(int i8) {
        this.f35612n = i8;
        x();
    }

    public final void setTextHintColor(int i8) {
        this.f35613o = i8;
        v();
    }

    public final void setTextHintDisabledColor(int i8) {
        this.f35614p = i8;
        v();
    }

    public final void setTextInputBg(Drawable drawable) {
        this.f35610l = drawable;
        setBackground(drawable);
    }

    public final void setTransformationMethod(TransformationMethod transformationMethod) {
        ((AppCompatEditText) h(R$id.tivEdit)).setTransformationMethod(transformationMethod);
    }

    public final void setSelection(int i8) {
        ((AppCompatEditText) h(R$id.tivEdit)).setSelection(i8);
    }

    public /* synthetic */ TextInputView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }
}
