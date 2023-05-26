package ee.mtakso.driver.uicore.components.views.destination;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import ee.mtakso.driver.uicore.R$color;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uicore.components.views.destination.DestinationButton;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DestinationButton.kt */
/* loaded from: classes5.dex */
public final class DestinationButton extends ConstraintLayout {
    public static final Companion V = new Companion(null);
    private static final InputFilter.LengthFilter W = new InputFilter.LengthFilter(45);
    private View E;
    private AppCompatImageView F;
    private TextView G;
    private TextView H;
    private AppCompatImageView I;
    private AppCompatImageView J;
    private AppCompatEditText K;
    private TextView L;
    private State M;
    private Drawable N;
    private Drawable O;
    private OnNameChangedListener P;
    private OnDestinationCanceledListener Q;
    private OnStateChangeListener R;
    private OnEditActionClickListener S;
    private boolean T;
    public Map<Integer, View> U;

    /* compiled from: DestinationButton.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: DestinationButton.kt */
    /* loaded from: classes5.dex */
    public interface OnDestinationCanceledListener {
        boolean a();
    }

    /* compiled from: DestinationButton.kt */
    /* loaded from: classes5.dex */
    public interface OnEditActionClickListener {
        boolean a();
    }

    /* compiled from: DestinationButton.kt */
    /* loaded from: classes5.dex */
    public interface OnNameChangedListener {
        void a(CharSequence charSequence);
    }

    /* compiled from: DestinationButton.kt */
    /* loaded from: classes5.dex */
    public interface OnStateChangeListener {
        void a(State state, State state2);
    }

    /* compiled from: DestinationButton.kt */
    /* loaded from: classes5.dex */
    public enum State {
        NORMAL,
        ACTIVE,
        EDITABLE,
        BEFORE_EDITING,
        EDITING
    }

    /* compiled from: DestinationButton.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35590a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.EDITABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[State.BEFORE_EDITING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[State.EDITING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f35590a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DestinationButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.f(context, "context");
        Intrinsics.f(attrs, "attrs");
        this.U = new LinkedHashMap();
        this.M = State.NORMAL;
        F(attrs);
    }

    private final void E() {
        int i8;
        L();
        K();
        int i9 = WhenMappings.f35590a[this.M.ordinal()];
        AppCompatImageView appCompatImageView = null;
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 != 4) {
                        View view = this.E;
                        if (view == null) {
                            Intrinsics.w("rootContainer");
                            view = null;
                        }
                        view.setBackground(this.O);
                        AppCompatImageView appCompatImageView2 = this.I;
                        if (appCompatImageView2 == null) {
                            Intrinsics.w("imageChevron");
                            appCompatImageView2 = null;
                        }
                        appCompatImageView2.setVisibility(0);
                        AppCompatEditText appCompatEditText = this.K;
                        if (appCompatEditText == null) {
                            Intrinsics.w("editName");
                            appCompatEditText = null;
                        }
                        appCompatEditText.setVisibility(8);
                        TextView textView = this.L;
                        if (textView == null) {
                            Intrinsics.w("buttonEditName");
                            textView = null;
                        }
                        textView.setVisibility(8);
                        AppCompatImageView appCompatImageView3 = this.J;
                        if (appCompatImageView3 == null) {
                            Intrinsics.w("imageCancel");
                        } else {
                            appCompatImageView = appCompatImageView3;
                        }
                        appCompatImageView.setVisibility(8);
                        return;
                    }
                    View view2 = this.E;
                    if (view2 == null) {
                        Intrinsics.w("rootContainer");
                        view2 = null;
                    }
                    view2.setBackground(this.O);
                    AppCompatImageView appCompatImageView4 = this.I;
                    if (appCompatImageView4 == null) {
                        Intrinsics.w("imageChevron");
                        appCompatImageView4 = null;
                    }
                    appCompatImageView4.setVisibility(8);
                    AppCompatEditText appCompatEditText2 = this.K;
                    if (appCompatEditText2 == null) {
                        Intrinsics.w("editName");
                        appCompatEditText2 = null;
                    }
                    appCompatEditText2.setVisibility(0);
                    AppCompatEditText appCompatEditText3 = this.K;
                    if (appCompatEditText3 == null) {
                        Intrinsics.w("editName");
                        appCompatEditText3 = null;
                    }
                    AppCompatEditText appCompatEditText4 = this.K;
                    if (appCompatEditText4 == null) {
                        Intrinsics.w("editName");
                        appCompatEditText4 = null;
                    }
                    Editable text = appCompatEditText4.getText();
                    if (text != null) {
                        i8 = text.length();
                    } else {
                        i8 = 0;
                    }
                    appCompatEditText3.setSelection(i8);
                    requestFocus();
                    TextView textView2 = this.L;
                    if (textView2 == null) {
                        Intrinsics.w("buttonEditName");
                        textView2 = null;
                    }
                    textView2.setVisibility(0);
                    AppCompatImageView appCompatImageView5 = this.J;
                    if (appCompatImageView5 == null) {
                        Intrinsics.w("imageCancel");
                    } else {
                        appCompatImageView = appCompatImageView5;
                    }
                    appCompatImageView.setVisibility(8);
                    return;
                }
                View view3 = this.E;
                if (view3 == null) {
                    Intrinsics.w("rootContainer");
                    view3 = null;
                }
                view3.setBackground(this.O);
                AppCompatImageView appCompatImageView6 = this.I;
                if (appCompatImageView6 == null) {
                    Intrinsics.w("imageChevron");
                    appCompatImageView6 = null;
                }
                appCompatImageView6.setVisibility(8);
                AppCompatEditText appCompatEditText5 = this.K;
                if (appCompatEditText5 == null) {
                    Intrinsics.w("editName");
                    appCompatEditText5 = null;
                }
                appCompatEditText5.setVisibility(8);
                TextView textView3 = this.L;
                if (textView3 == null) {
                    Intrinsics.w("buttonEditName");
                    textView3 = null;
                }
                textView3.setVisibility(0);
                AppCompatImageView appCompatImageView7 = this.J;
                if (appCompatImageView7 == null) {
                    Intrinsics.w("imageCancel");
                } else {
                    appCompatImageView = appCompatImageView7;
                }
                appCompatImageView.setVisibility(8);
                return;
            }
            View view4 = this.E;
            if (view4 == null) {
                Intrinsics.w("rootContainer");
                view4 = null;
            }
            view4.setBackground(this.O);
            AppCompatImageView appCompatImageView8 = this.I;
            if (appCompatImageView8 == null) {
                Intrinsics.w("imageChevron");
                appCompatImageView8 = null;
            }
            appCompatImageView8.setVisibility(8);
            AppCompatEditText appCompatEditText6 = this.K;
            if (appCompatEditText6 == null) {
                Intrinsics.w("editName");
                appCompatEditText6 = null;
            }
            appCompatEditText6.setVisibility(8);
            TextView textView4 = this.L;
            if (textView4 == null) {
                Intrinsics.w("buttonEditName");
                textView4 = null;
            }
            textView4.setVisibility(0);
            AppCompatImageView appCompatImageView9 = this.J;
            if (appCompatImageView9 == null) {
                Intrinsics.w("imageCancel");
            } else {
                appCompatImageView = appCompatImageView9;
            }
            appCompatImageView.setVisibility(8);
            return;
        }
        View view5 = this.E;
        if (view5 == null) {
            Intrinsics.w("rootContainer");
            view5 = null;
        }
        view5.setBackground(this.N);
        AppCompatImageView appCompatImageView10 = this.I;
        if (appCompatImageView10 == null) {
            Intrinsics.w("imageChevron");
            appCompatImageView10 = null;
        }
        appCompatImageView10.setVisibility(8);
        AppCompatEditText appCompatEditText7 = this.K;
        if (appCompatEditText7 == null) {
            Intrinsics.w("editName");
            appCompatEditText7 = null;
        }
        appCompatEditText7.setVisibility(8);
        TextView textView5 = this.L;
        if (textView5 == null) {
            Intrinsics.w("buttonEditName");
            textView5 = null;
        }
        textView5.setVisibility(8);
        AppCompatImageView appCompatImageView11 = this.J;
        if (appCompatImageView11 == null) {
            Intrinsics.w("imageCancel");
        } else {
            appCompatImageView = appCompatImageView11;
        }
        appCompatImageView.setVisibility(0);
    }

    private final void F(AttributeSet attributeSet) {
        View.inflate(getContext(), R$layout.destination_button, this);
        setClickable(true);
        this.N = ContextCompat.getDrawable(getContext(), R$color.yellow900);
        this.O = ContextCompat.getDrawable(getContext(), R$color.neutral700);
        View findViewById = findViewById(R$id.image_destination_icon);
        Intrinsics.e(findViewById, "findViewById(R.id.image_destination_icon)");
        this.F = (AppCompatImageView) findViewById;
        View findViewById2 = findViewById(R$id.text_destination_name);
        Intrinsics.e(findViewById2, "findViewById(R.id.text_destination_name)");
        this.G = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.text_destination_address);
        Intrinsics.e(findViewById3, "findViewById(R.id.text_destination_address)");
        this.H = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.image_destination_chevron);
        Intrinsics.e(findViewById4, "findViewById(R.id.image_destination_chevron)");
        this.I = (AppCompatImageView) findViewById4;
        View findViewById5 = findViewById(R$id.image_destination_cancel);
        Intrinsics.e(findViewById5, "findViewById(R.id.image_destination_cancel)");
        this.J = (AppCompatImageView) findViewById5;
        View findViewById6 = findViewById(R$id.edit_destination_name);
        Intrinsics.e(findViewById6, "findViewById(R.id.edit_destination_name)");
        this.K = (AppCompatEditText) findViewById6;
        View findViewById7 = findViewById(R$id.button_destination_edit_name);
        Intrinsics.e(findViewById7, "findViewById(R.id.button_destination_edit_name)");
        this.L = (TextView) findViewById7;
        View findViewById8 = findViewById(R$id.container_destination);
        Intrinsics.e(findViewById8, "findViewById(R.id.container_destination)");
        this.E = findViewById8;
        int[] DestinationButton = R$styleable.U0;
        Intrinsics.e(DestinationButton, "DestinationButton");
        J(attributeSet, DestinationButton);
        if (isInEditMode()) {
            J(attributeSet, new int[]{16843087, 16842754});
        }
        AppCompatEditText appCompatEditText = this.K;
        AppCompatImageView appCompatImageView = null;
        if (appCompatEditText == null) {
            Intrinsics.w("editName");
            appCompatEditText = null;
        }
        appCompatEditText.setFilters(new InputFilter.LengthFilter[]{W});
        AppCompatEditText appCompatEditText2 = this.K;
        if (appCompatEditText2 == null) {
            Intrinsics.w("editName");
            appCompatEditText2 = null;
        }
        appCompatEditText2.setImeOptions(6);
        AppCompatEditText appCompatEditText3 = this.K;
        if (appCompatEditText3 == null) {
            Intrinsics.w("editName");
            appCompatEditText3 = null;
        }
        appCompatEditText3.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: w5.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i8, KeyEvent keyEvent) {
                boolean G;
                G = DestinationButton.G(DestinationButton.this, textView, i8, keyEvent);
                return G;
            }
        });
        TextView textView = this.L;
        if (textView == null) {
            Intrinsics.w("buttonEditName");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: w5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DestinationButton.H(DestinationButton.this, view);
            }
        });
        AppCompatImageView appCompatImageView2 = this.J;
        if (appCompatImageView2 == null) {
            Intrinsics.w("imageCancel");
        } else {
            appCompatImageView = appCompatImageView2;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: w5.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DestinationButton.I(DestinationButton.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean G(DestinationButton this$0, TextView textView, int i8, KeyEvent keyEvent) {
        boolean z7;
        Intrinsics.f(this$0, "this$0");
        if (i8 != 6) {
            if (keyEvent != null && keyEvent.getAction() == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (!z7 || keyEvent.getKeyCode() != 66) {
                return false;
            }
        }
        TextView textView2 = this$0.L;
        if (textView2 == null) {
            Intrinsics.w("buttonEditName");
            textView2 = null;
        }
        textView2.performClick();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r4.a() != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void H(ee.mtakso.driver.uicore.components.views.destination.DestinationButton r3, android.view.View r4) {
        /*
            java.lang.String r4 = "this$0"
            kotlin.jvm.internal.Intrinsics.f(r3, r4)
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r4 = r3.M
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r0 = ee.mtakso.driver.uicore.components.views.destination.DestinationButton.State.EDITING
            if (r4 != r0) goto L58
            androidx.appcompat.widget.AppCompatEditText r4 = r3.K
            r0 = 0
            java.lang.String r1 = "editName"
            if (r4 != 0) goto L16
            kotlin.jvm.internal.Intrinsics.w(r1)
            r4 = r0
        L16:
            android.text.Editable r4 = r4.getText()
            if (r4 == 0) goto L25
            boolean r4 = kotlin.text.StringsKt.y(r4)
            if (r4 == 0) goto L23
            goto L25
        L23:
            r4 = 0
            goto L26
        L25:
            r4 = 1
        L26:
            if (r4 != 0) goto L52
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$OnNameChangedListener r4 = r3.P
            if (r4 == 0) goto L3e
            kotlin.jvm.internal.Intrinsics.c(r4)
            androidx.appcompat.widget.AppCompatEditText r2 = r3.K
            if (r2 != 0) goto L37
            kotlin.jvm.internal.Intrinsics.w(r1)
            r2 = r0
        L37:
            android.text.Editable r2 = r2.getText()
            r4.a(r2)
        L3e:
            androidx.appcompat.widget.AppCompatEditText r4 = r3.K
            if (r4 != 0) goto L46
            kotlin.jvm.internal.Intrinsics.w(r1)
            goto L47
        L46:
            r0 = r4
        L47:
            android.text.Editable r4 = r0.getText()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.setName(r4)
        L52:
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r4 = ee.mtakso.driver.uicore.components.views.destination.DestinationButton.State.BEFORE_EDITING
            r3.setState(r4)
            goto L83
        L58:
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r1 = ee.mtakso.driver.uicore.components.views.destination.DestinationButton.State.BEFORE_EDITING
            if (r4 != r1) goto L6d
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$OnEditActionClickListener r4 = r3.S
            if (r4 == 0) goto L69
            kotlin.jvm.internal.Intrinsics.c(r4)
            boolean r4 = r4.a()
            if (r4 == 0) goto L6d
        L69:
            r3.setState(r0)
            goto L83
        L6d:
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r4 = r3.M
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r0 = ee.mtakso.driver.uicore.components.views.destination.DestinationButton.State.EDITABLE
            if (r4 != r0) goto L83
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$OnEditActionClickListener r4 = r3.S
            if (r4 == 0) goto L80
            kotlin.jvm.internal.Intrinsics.c(r4)
            boolean r4 = r4.a()
            if (r4 == 0) goto L83
        L80:
            r3.setState(r1)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.views.destination.DestinationButton.H(ee.mtakso.driver.uicore.components.views.destination.DestinationButton, android.view.View):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(DestinationButton this$0, View view) {
        Intrinsics.f(this$0, "this$0");
        OnDestinationCanceledListener onDestinationCanceledListener = this$0.Q;
        if (onDestinationCanceledListener != null) {
            Intrinsics.c(onDestinationCanceledListener);
            if (!onDestinationCanceledListener.a()) {
                return;
            }
        }
        this$0.setState(State.NORMAL);
    }

    private final void J(AttributeSet attributeSet, int[] iArr) {
        boolean z7;
        boolean z8;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttributes(set, attrs)");
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i8 = 0; i8 < indexCount; i8++) {
            int index = obtainStyledAttributes.getIndex(i8);
            int i9 = R$styleable.Y0;
            boolean z9 = true;
            if (index == i9 || index == 16842754) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                setIcon(obtainStyledAttributes.getDrawable(i9));
            } else {
                int i10 = R$styleable.Z0;
                if (index == i10) {
                    setName(obtainStyledAttributes.getString(i10));
                } else {
                    int i11 = R$styleable.W0;
                    if (index == i11 || index == 16843087) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        setAddress(obtainStyledAttributes.getString(i11));
                    } else {
                        int i12 = R$styleable.X0;
                        if (index != i12 && index != 16843088) {
                            z9 = false;
                        }
                        if (z9) {
                            setHint(obtainStyledAttributes.getString(i12));
                        } else {
                            int i13 = R$styleable.f34614b1;
                            if (index == i13) {
                                setState(State.values()[obtainStyledAttributes.getInt(i13, 0)]);
                            } else {
                                int i14 = R$styleable.f34609a1;
                                if (index == i14) {
                                    setNormalStateIcon(obtainStyledAttributes.getDrawable(i14));
                                } else {
                                    int i15 = R$styleable.V0;
                                    if (index == i15) {
                                        setActiveStateIcon(obtainStyledAttributes.getDrawable(i15));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void K() {
        /*
            r4 = this;
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r0 = r4.M
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r1 = ee.mtakso.driver.uicore.components.views.destination.DestinationButton.State.EDITING
            r2 = 0
            java.lang.String r3 = "textAddress"
            if (r0 == r1) goto L31
            android.widget.TextView r0 = r4.H
            if (r0 != 0) goto L11
            kotlin.jvm.internal.Intrinsics.w(r3)
            r0 = r2
        L11:
            java.lang.CharSequence r0 = r0.getText()
            r1 = 0
            if (r0 == 0) goto L21
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L1f
            goto L21
        L1f:
            r0 = 0
            goto L22
        L21:
            r0 = 1
        L22:
            if (r0 != 0) goto L31
            android.widget.TextView r0 = r4.H
            if (r0 != 0) goto L2c
            kotlin.jvm.internal.Intrinsics.w(r3)
            goto L2d
        L2c:
            r2 = r0
        L2d:
            r2.setVisibility(r1)
            goto L3f
        L31:
            android.widget.TextView r0 = r4.H
            if (r0 != 0) goto L39
            kotlin.jvm.internal.Intrinsics.w(r3)
            goto L3a
        L39:
            r2 = r0
        L3a:
            r0 = 8
            r2.setVisibility(r0)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.views.destination.DestinationButton.K():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void L() {
        /*
            r4 = this;
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r0 = r4.M
            ee.mtakso.driver.uicore.components.views.destination.DestinationButton$State r1 = ee.mtakso.driver.uicore.components.views.destination.DestinationButton.State.EDITING
            r2 = 0
            java.lang.String r3 = "textName"
            if (r0 == r1) goto L31
            android.widget.TextView r0 = r4.G
            if (r0 != 0) goto L11
            kotlin.jvm.internal.Intrinsics.w(r3)
            r0 = r2
        L11:
            java.lang.CharSequence r0 = r0.getText()
            r1 = 0
            if (r0 == 0) goto L21
            boolean r0 = kotlin.text.StringsKt.y(r0)
            if (r0 == 0) goto L1f
            goto L21
        L1f:
            r0 = 0
            goto L22
        L21:
            r0 = 1
        L22:
            if (r0 != 0) goto L31
            android.widget.TextView r0 = r4.G
            if (r0 != 0) goto L2c
            kotlin.jvm.internal.Intrinsics.w(r3)
            goto L2d
        L2c:
            r2 = r0
        L2d:
            r2.setVisibility(r1)
            goto L3f
        L31:
            android.widget.TextView r0 = r4.G
            if (r0 != 0) goto L39
            kotlin.jvm.internal.Intrinsics.w(r3)
            goto L3a
        L39:
            r2 = r0
        L3a:
            r0 = 8
            r2.setVisibility(r0)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ee.mtakso.driver.uicore.components.views.destination.DestinationButton.L():void");
    }

    public final State getState() {
        return this.M;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i8, Rect rect) {
        AppCompatEditText appCompatEditText = this.K;
        if (appCompatEditText == null) {
            Intrinsics.w("editName");
            appCompatEditText = null;
        }
        return appCompatEditText.requestFocus();
    }

    public final void setActionText(String str) {
        TextView textView = this.L;
        if (textView == null) {
            Intrinsics.w("buttonEditName");
            textView = null;
        }
        textView.setText(str);
    }

    public final void setActiveStateIcon(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.J;
        if (appCompatImageView == null) {
            Intrinsics.w("imageCancel");
            appCompatImageView = null;
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void setAddress(String str) {
        TextView textView = this.H;
        if (textView == null) {
            Intrinsics.w("textAddress");
            textView = null;
        }
        textView.setText(str);
        K();
    }

    public final void setHint(String str) {
        AppCompatEditText appCompatEditText = this.K;
        if (appCompatEditText == null) {
            Intrinsics.w("editName");
            appCompatEditText = null;
        }
        appCompatEditText.setHint(str);
    }

    public final void setIcon(int i8) {
        setIcon(ContextCompat.getDrawable(getContext(), i8));
    }

    public final void setName(String str) {
        TextView textView = this.G;
        AppCompatEditText appCompatEditText = null;
        if (textView == null) {
            Intrinsics.w("textName");
            textView = null;
        }
        textView.setText(str);
        if (!this.T) {
            AppCompatEditText appCompatEditText2 = this.K;
            if (appCompatEditText2 == null) {
                Intrinsics.w("editName");
            } else {
                appCompatEditText = appCompatEditText2;
            }
            appCompatEditText.setText(str);
        } else {
            AppCompatEditText appCompatEditText3 = this.K;
            if (appCompatEditText3 == null) {
                Intrinsics.w("editName");
            } else {
                appCompatEditText = appCompatEditText3;
            }
            appCompatEditText.setText("");
        }
        L();
    }

    public final void setNormalStateIcon(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.I;
        if (appCompatImageView == null) {
            Intrinsics.w("imageChevron");
            appCompatImageView = null;
        }
        appCompatImageView.setImageDrawable(drawable);
    }

    public final void setOnCancelClickListener(OnDestinationCanceledListener onDestinationCanceledListener) {
        this.Q = onDestinationCanceledListener;
    }

    public final void setOnEditActionClickListener(OnEditActionClickListener onEditActionClickListener) {
        this.S = onEditActionClickListener;
    }

    public final void setOnNameChangedListener(OnNameChangedListener onNameChangedListener) {
        this.P = onNameChangedListener;
    }

    public final void setOnStateChangeListener(OnStateChangeListener onStateChangeListener) {
        this.R = onStateChangeListener;
    }

    public final void setPreventAutoFillOnEditingState(boolean z7) {
        this.T = z7;
    }

    public final void setState(State newState) {
        Intrinsics.f(newState, "newState");
        if (this.M != newState) {
            OnStateChangeListener onStateChangeListener = this.R;
            if (onStateChangeListener != null) {
                Intrinsics.c(onStateChangeListener);
                onStateChangeListener.a(this.M, newState);
            }
            this.M = newState;
            E();
        }
    }

    public final void setIcon(Drawable drawable) {
        AppCompatImageView appCompatImageView = this.F;
        if (appCompatImageView == null) {
            Intrinsics.w("imageIcon");
            appCompatImageView = null;
        }
        appCompatImageView.setImageDrawable(drawable);
    }
}
