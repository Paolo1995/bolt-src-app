package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* loaded from: classes.dex */
public final class BadgeState {

    /* renamed from: a  reason: collision with root package name */
    private final State f12880a;

    /* renamed from: b  reason: collision with root package name */
    private final State f12881b;

    /* renamed from: c  reason: collision with root package name */
    final float f12882c;

    /* renamed from: d  reason: collision with root package name */
    final float f12883d;

    /* renamed from: e  reason: collision with root package name */
    final float f12884e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeState(Context context, int i8, int i9, int i10, State state) {
        int i11;
        CharSequence charSequence;
        int i12;
        int i13;
        boolean z7;
        int i14;
        int intValue;
        int intValue2;
        int intValue3;
        int intValue4;
        int intValue5;
        int intValue6;
        int intValue7;
        Locale locale;
        State state2 = new State();
        this.f12881b = state2;
        state = state == null ? new State() : state;
        if (i8 != 0) {
            state.f12885f = i8;
        }
        TypedArray a8 = a(context, state.f12885f, i9, i10);
        Resources resources = context.getResources();
        this.f12882c = a8.getDimensionPixelSize(R$styleable.I, resources.getDimensionPixelSize(R$dimen.mtrl_badge_radius));
        this.f12884e = a8.getDimensionPixelSize(R$styleable.K, resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding));
        this.f12883d = a8.getDimensionPixelSize(R$styleable.L, resources.getDimensionPixelSize(R$dimen.mtrl_badge_with_text_radius));
        if (state.f12888i != -2) {
            i11 = state.f12888i;
        } else {
            i11 = 255;
        }
        state2.f12888i = i11;
        if (state.f12892m != null) {
            charSequence = state.f12892m;
        } else {
            charSequence = context.getString(R$string.mtrl_badge_numberless_content_description);
        }
        state2.f12892m = charSequence;
        if (state.f12893n != 0) {
            i12 = state.f12893n;
        } else {
            i12 = R$plurals.mtrl_badge_content_description;
        }
        state2.f12893n = i12;
        if (state.f12894o != 0) {
            i13 = state.f12894o;
        } else {
            i13 = R$string.mtrl_exceed_max_badge_number_content_description;
        }
        state2.f12894o = i13;
        if (state.f12896q != null && !state.f12896q.booleanValue()) {
            z7 = false;
        } else {
            z7 = true;
        }
        state2.f12896q = Boolean.valueOf(z7);
        if (state.f12890k != -2) {
            i14 = state.f12890k;
        } else {
            i14 = a8.getInt(R$styleable.O, 4);
        }
        state2.f12890k = i14;
        if (state.f12889j != -2) {
            state2.f12889j = state.f12889j;
        } else {
            int i15 = R$styleable.P;
            if (a8.hasValue(i15)) {
                state2.f12889j = a8.getInt(i15, 0);
            } else {
                state2.f12889j = -1;
            }
        }
        if (state.f12886g == null) {
            intValue = t(context, a8, R$styleable.G);
        } else {
            intValue = state.f12886g.intValue();
        }
        state2.f12886g = Integer.valueOf(intValue);
        if (state.f12887h != null) {
            state2.f12887h = state.f12887h;
        } else {
            int i16 = R$styleable.J;
            if (a8.hasValue(i16)) {
                state2.f12887h = Integer.valueOf(t(context, a8, i16));
            } else {
                state2.f12887h = Integer.valueOf(new TextAppearance(context, R$style.TextAppearance_MaterialComponents_Badge).i().getDefaultColor());
            }
        }
        if (state.f12895p == null) {
            intValue2 = a8.getInt(R$styleable.H, 8388661);
        } else {
            intValue2 = state.f12895p.intValue();
        }
        state2.f12895p = Integer.valueOf(intValue2);
        if (state.f12897r == null) {
            intValue3 = a8.getDimensionPixelOffset(R$styleable.M, 0);
        } else {
            intValue3 = state.f12897r.intValue();
        }
        state2.f12897r = Integer.valueOf(intValue3);
        if (state.f12898s == null) {
            intValue4 = a8.getDimensionPixelOffset(R$styleable.Q, 0);
        } else {
            intValue4 = state.f12898s.intValue();
        }
        state2.f12898s = Integer.valueOf(intValue4);
        if (state.f12899t == null) {
            intValue5 = a8.getDimensionPixelOffset(R$styleable.N, state2.f12897r.intValue());
        } else {
            intValue5 = state.f12899t.intValue();
        }
        state2.f12899t = Integer.valueOf(intValue5);
        if (state.f12900u == null) {
            intValue6 = a8.getDimensionPixelOffset(R$styleable.R, state2.f12898s.intValue());
        } else {
            intValue6 = state.f12900u.intValue();
        }
        state2.f12900u = Integer.valueOf(intValue6);
        if (state.f12901v == null) {
            intValue7 = 0;
        } else {
            intValue7 = state.f12901v.intValue();
        }
        state2.f12901v = Integer.valueOf(intValue7);
        state2.f12902w = Integer.valueOf(state.f12902w != null ? state.f12902w.intValue() : 0);
        a8.recycle();
        if (state.f12891l != null) {
            state2.f12891l = state.f12891l;
        } else {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Locale.getDefault(Locale.Category.FORMAT);
            } else {
                locale = Locale.getDefault();
            }
            state2.f12891l = locale;
        }
        this.f12880a = state;
    }

    private TypedArray a(Context context, int i8, int i9, int i10) {
        AttributeSet attributeSet;
        int i11;
        int i12;
        if (i8 != 0) {
            AttributeSet e8 = DrawableUtils.e(context, i8, "badge");
            i11 = e8.getStyleAttribute();
            attributeSet = e8;
        } else {
            attributeSet = null;
            i11 = 0;
        }
        if (i11 == 0) {
            i12 = i10;
        } else {
            i12 = i11;
        }
        return ThemeEnforcement.i(context, attributeSet, R$styleable.F, i9, i12, new int[0]);
    }

    private static int t(Context context, @NonNull TypedArray typedArray, int i8) {
        return MaterialResources.a(context, typedArray, i8).getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f12881b.f12901v.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f12881b.f12902w.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f12881b.f12888i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f12881b.f12886g.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f12881b.f12895p.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f12881b.f12887h.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f12881b.f12894o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i() {
        return this.f12881b.f12892m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f12881b.f12893n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f12881b.f12899t.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l() {
        return this.f12881b.f12897r.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return this.f12881b.f12890k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.f12881b.f12889j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Locale o() {
        return this.f12881b.f12891l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int p() {
        return this.f12881b.f12900u.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f12881b.f12898s.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        if (this.f12881b.f12889j != -1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        return this.f12881b.f12896q.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i8) {
        this.f12880a.f12888i = i8;
        this.f12881b.f12888i = i8;
    }

    /* loaded from: classes.dex */
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() { // from class: com.google.android.material.badge.BadgeState.State.1
            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: a */
            public State createFromParcel(@NonNull Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: b */
            public State[] newArray(int i8) {
                return new State[i8];
            }
        };

        /* renamed from: f  reason: collision with root package name */
        private int f12885f;

        /* renamed from: g  reason: collision with root package name */
        private Integer f12886g;

        /* renamed from: h  reason: collision with root package name */
        private Integer f12887h;

        /* renamed from: i  reason: collision with root package name */
        private int f12888i;

        /* renamed from: j  reason: collision with root package name */
        private int f12889j;

        /* renamed from: k  reason: collision with root package name */
        private int f12890k;

        /* renamed from: l  reason: collision with root package name */
        private Locale f12891l;

        /* renamed from: m  reason: collision with root package name */
        private CharSequence f12892m;

        /* renamed from: n  reason: collision with root package name */
        private int f12893n;

        /* renamed from: o  reason: collision with root package name */
        private int f12894o;

        /* renamed from: p  reason: collision with root package name */
        private Integer f12895p;

        /* renamed from: q  reason: collision with root package name */
        private Boolean f12896q;

        /* renamed from: r  reason: collision with root package name */
        private Integer f12897r;

        /* renamed from: s  reason: collision with root package name */
        private Integer f12898s;

        /* renamed from: t  reason: collision with root package name */
        private Integer f12899t;

        /* renamed from: u  reason: collision with root package name */
        private Integer f12900u;

        /* renamed from: v  reason: collision with root package name */
        private Integer f12901v;

        /* renamed from: w  reason: collision with root package name */
        private Integer f12902w;

        public State() {
            this.f12888i = 255;
            this.f12889j = -2;
            this.f12890k = -2;
            this.f12896q = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i8) {
            String charSequence;
            parcel.writeInt(this.f12885f);
            parcel.writeSerializable(this.f12886g);
            parcel.writeSerializable(this.f12887h);
            parcel.writeInt(this.f12888i);
            parcel.writeInt(this.f12889j);
            parcel.writeInt(this.f12890k);
            CharSequence charSequence2 = this.f12892m;
            if (charSequence2 == null) {
                charSequence = null;
            } else {
                charSequence = charSequence2.toString();
            }
            parcel.writeString(charSequence);
            parcel.writeInt(this.f12893n);
            parcel.writeSerializable(this.f12895p);
            parcel.writeSerializable(this.f12897r);
            parcel.writeSerializable(this.f12898s);
            parcel.writeSerializable(this.f12899t);
            parcel.writeSerializable(this.f12900u);
            parcel.writeSerializable(this.f12901v);
            parcel.writeSerializable(this.f12902w);
            parcel.writeSerializable(this.f12896q);
            parcel.writeSerializable(this.f12891l);
        }

        State(@NonNull Parcel parcel) {
            this.f12888i = 255;
            this.f12889j = -2;
            this.f12890k = -2;
            this.f12896q = Boolean.TRUE;
            this.f12885f = parcel.readInt();
            this.f12886g = (Integer) parcel.readSerializable();
            this.f12887h = (Integer) parcel.readSerializable();
            this.f12888i = parcel.readInt();
            this.f12889j = parcel.readInt();
            this.f12890k = parcel.readInt();
            this.f12892m = parcel.readString();
            this.f12893n = parcel.readInt();
            this.f12895p = (Integer) parcel.readSerializable();
            this.f12897r = (Integer) parcel.readSerializable();
            this.f12898s = (Integer) parcel.readSerializable();
            this.f12899t = (Integer) parcel.readSerializable();
            this.f12900u = (Integer) parcel.readSerializable();
            this.f12901v = (Integer) parcel.readSerializable();
            this.f12902w = (Integer) parcel.readSerializable();
            this.f12896q = (Boolean) parcel.readSerializable();
            this.f12891l = (Locale) parcel.readSerializable();
        }
    }
}
