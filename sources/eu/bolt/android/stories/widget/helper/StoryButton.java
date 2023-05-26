package eu.bolt.android.stories.widget.helper;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import eu.bolt.android.stories.R$attr;
import eu.bolt.android.stories.R$color;
import eu.bolt.android.stories.R$drawable;
import eu.bolt.android.stories.R$styleable;
import eu.bolt.android.stories.util.DimensKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoryButton.kt */
/* loaded from: classes5.dex */
public final class StoryButton extends AppCompatButton {

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f37626k = new Companion(null);

    /* renamed from: i  reason: collision with root package name */
    private ButtonStyle f37627i;

    /* renamed from: j  reason: collision with root package name */
    public Map<Integer, View> f37628j;

    /* compiled from: StoryButton.kt */
    /* loaded from: classes5.dex */
    public enum ButtonStyle {
        Primary,
        Secondary,
        Danger,
        Text
    }

    /* compiled from: StoryButton.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final StoryButton a(Context context, ButtonStyle style) {
            Intrinsics.f(context, "context");
            Intrinsics.f(style, "style");
            StoryButton storyButton = new StoryButton(context, null, 0, 6, null);
            storyButton.setStyle(style);
            return storyButton;
        }
    }

    /* compiled from: StoryButton.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37634a;

        static {
            int[] iArr = new int[ButtonStyle.values().length];
            try {
                iArr[ButtonStyle.Primary.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStyle.Secondary.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStyle.Danger.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStyle.Text.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f37634a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoryButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoryButton(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        this.f37628j = new LinkedHashMap();
        if (isInEditMode()) {
            b();
        }
        a(attributeSet);
        e(this, 0.0f, 1, null);
        c();
    }

    private final void a(AttributeSet attributeSet) {
        int i8 = 0;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R$styleable.A1, 0, 0);
        try {
            int i9 = R$styleable.B1;
            ButtonStyle buttonStyle = this.f37627i;
            if (buttonStyle != null) {
                i8 = buttonStyle.ordinal();
            }
            setStyle(ButtonStyle.values()[obtainStyledAttributes.getInteger(i9, i8)]);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private final void b() {
        int i8;
        ButtonStyle buttonStyle = this.f37627i;
        if (buttonStyle == null) {
            i8 = -1;
        } else {
            i8 = WhenMappings.f37634a[buttonStyle.ordinal()];
        }
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4) {
                        k();
                        return;
                    }
                    return;
                }
                h();
                return;
            }
            j();
            return;
        }
        i();
    }

    private final void c() {
        setMaxLines(1);
    }

    private final void d(float f8) {
        setMinHeight((int) DimensKt.a(f8));
    }

    static /* synthetic */ void e(StoryButton storyButton, float f8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            f8 = 56.0f;
        }
        storyButton.d(f8);
    }

    private final void f(int i8, ColorStateList colorStateList, Integer num) {
        StateListAnimator loadStateListAnimator;
        setAllCaps(false);
        setBackgroundResource(i8);
        setTextColor(colorStateList);
        if (Build.VERSION.SDK_INT >= 23) {
            if (num == null) {
                loadStateListAnimator = null;
            } else {
                loadStateListAnimator = AnimatorInflater.loadStateListAnimator(getContext(), num.intValue());
            }
            setStateListAnimator(loadStateListAnimator);
        }
        setGravity(17);
    }

    static /* synthetic */ void g(StoryButton storyButton, int i8, ColorStateList colorStateList, Integer num, int i9, Object obj) {
        if ((i9 & 4) != 0) {
            num = null;
        }
        storyButton.f(i8, colorStateList, num);
    }

    private final void h() {
        g(this, R$drawable.f37433a, ContextCompat.getColorStateList(getContext(), R$color.f37422c), null, 4, null);
    }

    private final void i() {
        g(this, R$drawable.f37434b, ContextCompat.getColorStateList(getContext(), R$color.f37422c), null, 4, null);
    }

    private final void j() {
        g(this, R$drawable.f37435c, ContextCompat.getColorStateList(getContext(), R$color.f37423d), null, 4, null);
    }

    private final void k() {
        g(this, R$drawable.f37436d, ContextCompat.getColorStateList(getContext(), R$color.f37425g), null, 4, null);
    }

    public final void setStyle(ButtonStyle value) {
        Intrinsics.f(value, "value");
        if (this.f37627i != value) {
            this.f37627i = value;
            b();
        }
    }

    public /* synthetic */ StoryButton(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? R$attr.f37419a : i8);
    }
}
