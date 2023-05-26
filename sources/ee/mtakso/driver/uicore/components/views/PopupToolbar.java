package ee.mtakso.driver.uicore.components.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.TextViewCompat;
import ee.mtakso.driver.uicore.R$drawable;
import ee.mtakso.driver.uicore.R$layout;
import ee.mtakso.driver.uicore.R$styleable;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.Dimens;
import ee.mtakso.driver.uikit.utils.Image;
import ee.mtakso.driver.uikit.utils.ImageKt;
import ee.mtakso.driver.uikit.utils.ImageViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupToolbar.kt */
/* loaded from: classes5.dex */
public final class PopupToolbar extends Toolbar {

    /* renamed from: k0  reason: collision with root package name */
    public static final Companion f35460k0 = new Companion(null);

    /* renamed from: c0  reason: collision with root package name */
    private AppCompatTextView f35461c0;

    /* renamed from: d0  reason: collision with root package name */
    private AppCompatTextView f35462d0;

    /* renamed from: e0  reason: collision with root package name */
    private AppCompatImageButton f35463e0;

    /* renamed from: f0  reason: collision with root package name */
    private CharSequence f35464f0;

    /* renamed from: g0  reason: collision with root package name */
    private int f35465g0;

    /* renamed from: h0  reason: collision with root package name */
    private int f35466h0;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f35467i0;

    /* renamed from: j0  reason: collision with root package name */
    public Map<Integer, View> f35468j0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PopupToolbar.kt */
    /* loaded from: classes5.dex */
    public enum BackIcon {
        CLOSE(R$drawable.ic_popup_close),
        BACK(R$drawable.ic_popup_back);
        

        /* renamed from: f  reason: collision with root package name */
        private final int f35472f;

        BackIcon(int i8) {
            this.f35472f = i8;
        }

        public final int c() {
            return this.f35472f;
        }
    }

    /* compiled from: PopupToolbar.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BackIcon b(int i8) {
            if (i8 != 0) {
                if (i8 == 1) {
                    return BackIcon.BACK;
                }
                throw new IllegalArgumentException("There are no suitable enum for value " + i8);
            }
            return BackIcon.CLOSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PopupToolbar.kt */
    /* loaded from: classes5.dex */
    public enum IconType {
        NAVIGATION,
        ACTION_ICON
    }

    /* compiled from: PopupToolbar.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35476a;

        static {
            int[] iArr = new int[IconType.values().length];
            try {
                iArr[IconType.NAVIGATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IconType.ACTION_ICON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f35476a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PopupToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.f(context, "context");
        this.f35468j0 = new LinkedHashMap();
        this.f35467i0 = true;
        X(context, attributeSet);
    }

    private final AppCompatImageButton U() {
        return (AppCompatImageButton) LayoutInflater.from(getContext()).inflate(R$layout.popup_toolbar_end_action_image, (ViewGroup) this, false);
    }

    private final Toolbar.LayoutParams V(IconType iconType) {
        int i8;
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2);
        int W = W(12);
        int W2 = W(0);
        int W3 = W(26);
        int W4 = W(12);
        layoutParams.setMarginStart(W2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = W;
        layoutParams.setMarginEnd(W3);
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = W4;
        int i9 = WhenMappings.f35476a[iconType.ordinal()];
        if (i9 != 1) {
            if (i9 == 2) {
                layoutParams.f1086a = 8388613;
            }
        } else {
            if (this.f35467i0) {
                i8 = 17;
            } else {
                i8 = 8388611;
            }
            layoutParams.f1086a = i8;
        }
        return layoutParams;
    }

    private final int W(int i8) {
        return (int) TypedValue.applyDimension(1, i8, getResources().getDisplayMetrics());
    }

    private final void X(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.E2);
        Intrinsics.e(obtainStyledAttributes, "context.obtainStyledAttr…R.styleable.PopupToolbar)");
        this.f35465g0 = obtainStyledAttributes.getResourceId(R$styleable.I2, 0);
        this.f35466h0 = obtainStyledAttributes.getColor(R$styleable.J2, -1);
        setTitleInCenter(obtainStyledAttributes.getBoolean(R$styleable.G2, true));
        setTitle(obtainStyledAttributes.getString(R$styleable.H2));
        setBackIcon(obtainStyledAttributes.getInt(R$styleable.F2, 0));
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.setAutoMirrored(true);
        }
        Unit unit = Unit.f50853a;
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function0 listener, View view) {
        Intrinsics.f(listener, "$listener");
        listener.invoke();
    }

    private final void b0(AppCompatImageButton appCompatImageButton, Image image, Color.Attr attr, final Function0<Unit> function0) {
        if (appCompatImageButton != null) {
            ImageKt.b(image, appCompatImageButton, null, 2, null);
            ImageViewExtKt.a(appCompatImageButton, attr);
            Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -2, 8388613);
            layoutParams.setMarginEnd(Dimens.c(4));
            Unit unit = Unit.f50853a;
            addView(appCompatImageButton, layoutParams);
            appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.views.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopupToolbar.c0(Function0.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(Function0 onActionIconClicked, View view) {
        Intrinsics.f(onActionIconClicked, "$onActionIconClicked");
        onActionIconClicked.invoke();
    }

    public final void Y(Image image, Color.Attr attr, Function0<Unit> onActionIconClicked) {
        Intrinsics.f(onActionIconClicked, "onActionIconClicked");
        AppCompatImageButton appCompatImageButton = this.f35463e0;
        if (appCompatImageButton != null) {
            if (image == null) {
                removeView(appCompatImageButton);
                return;
            }
            removeView(appCompatImageButton);
            AppCompatImageButton U = U();
            this.f35463e0 = U;
            b0(U, image, attr, onActionIconClicked);
        } else if (image != null) {
            AppCompatImageButton U2 = U();
            this.f35463e0 = U2;
            b0(U2, image, attr, onActionIconClicked);
        }
    }

    public final void Z(CharSequence charSequence, final Function0<Unit> listener) {
        AppCompatTextView appCompatTextView;
        Intrinsics.f(listener, "listener");
        if (charSequence == null && (appCompatTextView = this.f35462d0) != null) {
            removeView(appCompatTextView);
        }
        if (charSequence != null && this.f35462d0 == null) {
            this.f35462d0 = (AppCompatTextView) LayoutInflater.from(getContext()).inflate(R$layout.popup_toolbar_end_action_text, (ViewGroup) this, false);
            addView(this.f35462d0, new Toolbar.LayoutParams(-2, -2, 8388613));
        }
        AppCompatTextView appCompatTextView2 = this.f35462d0;
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(charSequence);
        }
        AppCompatTextView appCompatTextView3 = this.f35462d0;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.uicore.components.views.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopupToolbar.a0(Function0.this, view);
                }
            });
        }
    }

    public final boolean getTitleInCenter() {
        return this.f35467i0;
    }

    public final void setBackIcon(int i8) {
        setNavigationIcon(f35460k0.b(i8).c());
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            navigationIcon.setAutoMirrored(true);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
        AppCompatTextView appCompatTextView;
        View view;
        this.f35464f0 = charSequence;
        if (charSequence == null && (view = this.f35461c0) != null) {
            removeView(view);
        }
        if (charSequence != null && this.f35461c0 == null) {
            AppCompatTextView appCompatTextView2 = new AppCompatTextView(getContext());
            appCompatTextView2.setSingleLine();
            appCompatTextView2.setEllipsize(TextUtils.TruncateAt.END);
            appCompatTextView2.setTextColor(this.f35466h0);
            int i8 = this.f35465g0;
            if (i8 != 0) {
                TextViewCompat.o(appCompatTextView2, i8);
            }
            appCompatTextView2.setText(charSequence);
            this.f35461c0 = appCompatTextView2;
            addView(appCompatTextView2, V(IconType.NAVIGATION));
        }
        if (charSequence != null && (appCompatTextView = this.f35461c0) != null) {
            if (appCompatTextView != null) {
                appCompatTextView.setText(charSequence);
            }
            AppCompatTextView appCompatTextView3 = this.f35461c0;
            if (appCompatTextView3 != null) {
                appCompatTextView3.setLayoutParams(V(IconType.NAVIGATION));
            }
        }
    }

    public final void setTitleInCenter(boolean z7) {
        this.f35467i0 = z7;
        setTitle(this.f35464f0);
    }
}
