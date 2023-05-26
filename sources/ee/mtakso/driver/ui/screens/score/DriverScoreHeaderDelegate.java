package ee.mtakso.driver.ui.screens.score;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.widget.ImageViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.uicore.utils.ViewExtKt;
import ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate;
import ee.mtakso.driver.uikit.recyclerview.ListModel;
import ee.mtakso.driver.uikit.utils.Color;
import ee.mtakso.driver.uikit.utils.ColorKt;
import ee.mtakso.driver.uikit.utils.ProgressBarExtKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jctools.util.Pow2;

/* compiled from: DriverScoreHeaderDelegate.kt */
/* loaded from: classes3.dex */
public final class DriverScoreHeaderDelegate extends DiffAdapterDelegate<ViewHolder, Model> {

    /* renamed from: b  reason: collision with root package name */
    private final int f32915b = R.layout.delegate_item_driver_score_header;

    /* compiled from: DriverScoreHeaderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Model extends ListModel {

        /* renamed from: a  reason: collision with root package name */
        private final String f32916a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32917b;

        /* renamed from: c  reason: collision with root package name */
        private final String f32918c;

        /* renamed from: d  reason: collision with root package name */
        private final double f32919d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f32920e;

        /* renamed from: f  reason: collision with root package name */
        private final List<Threshold> f32921f;

        public Model(String listId, String scoreValue, String scoreUnit, double d8, Color progressColor, List<Threshold> thresholds) {
            Intrinsics.f(listId, "listId");
            Intrinsics.f(scoreValue, "scoreValue");
            Intrinsics.f(scoreUnit, "scoreUnit");
            Intrinsics.f(progressColor, "progressColor");
            Intrinsics.f(thresholds, "thresholds");
            this.f32916a = listId;
            this.f32917b = scoreValue;
            this.f32918c = scoreUnit;
            this.f32919d = d8;
            this.f32920e = progressColor;
            this.f32921f = thresholds;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return Intrinsics.a(m(), model.m()) && Intrinsics.a(this.f32917b, model.f32917b) && Intrinsics.a(this.f32918c, model.f32918c) && Double.compare(this.f32919d, model.f32919d) == 0 && Intrinsics.a(this.f32920e, model.f32920e) && Intrinsics.a(this.f32921f, model.f32921f);
            }
            return false;
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public int hashCode() {
            return (((((((((m().hashCode() * 31) + this.f32917b.hashCode()) * 31) + this.f32918c.hashCode()) * 31) + q1.a.a(this.f32919d)) * 31) + this.f32920e.hashCode()) * 31) + this.f32921f.hashCode();
        }

        @Override // ee.mtakso.driver.uikit.recyclerview.ListModel
        public String m() {
            return this.f32916a;
        }

        public final double n() {
            return this.f32919d;
        }

        public final Color o() {
            return this.f32920e;
        }

        public final String p() {
            return this.f32918c;
        }

        public final String q() {
            return this.f32917b;
        }

        public final List<Threshold> r() {
            return this.f32921f;
        }

        public String toString() {
            String m8 = m();
            String str = this.f32917b;
            String str2 = this.f32918c;
            double d8 = this.f32919d;
            Color color = this.f32920e;
            List<Threshold> list = this.f32921f;
            return "Model(listId=" + m8 + ", scoreValue=" + str + ", scoreUnit=" + str2 + ", progress=" + d8 + ", progressColor=" + color + ", thresholds=" + list + ")";
        }
    }

    /* compiled from: DriverScoreHeaderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class Threshold {

        /* renamed from: a  reason: collision with root package name */
        private final String f32922a;

        /* renamed from: b  reason: collision with root package name */
        private final String f32923b;

        /* renamed from: c  reason: collision with root package name */
        private final double f32924c;

        /* renamed from: d  reason: collision with root package name */
        private final double f32925d;

        /* renamed from: e  reason: collision with root package name */
        private final Color f32926e;

        /* renamed from: f  reason: collision with root package name */
        private final Color f32927f;

        public Threshold(String title, String formattedValue, double d8, double d9, Color color, Color textColor) {
            Intrinsics.f(title, "title");
            Intrinsics.f(formattedValue, "formattedValue");
            Intrinsics.f(color, "color");
            Intrinsics.f(textColor, "textColor");
            this.f32922a = title;
            this.f32923b = formattedValue;
            this.f32924c = d8;
            this.f32925d = d9;
            this.f32926e = color;
            this.f32927f = textColor;
        }

        public final Color a() {
            return this.f32926e;
        }

        public final String b() {
            return this.f32923b;
        }

        public final double c() {
            return this.f32924c;
        }

        public final double d() {
            return this.f32925d;
        }

        public final Color e() {
            return this.f32927f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Threshold) {
                Threshold threshold = (Threshold) obj;
                return Intrinsics.a(this.f32922a, threshold.f32922a) && Intrinsics.a(this.f32923b, threshold.f32923b) && Double.compare(this.f32924c, threshold.f32924c) == 0 && Double.compare(this.f32925d, threshold.f32925d) == 0 && Intrinsics.a(this.f32926e, threshold.f32926e) && Intrinsics.a(this.f32927f, threshold.f32927f);
            }
            return false;
        }

        public final String f() {
            return this.f32922a;
        }

        public int hashCode() {
            return (((((((((this.f32922a.hashCode() * 31) + this.f32923b.hashCode()) * 31) + q1.a.a(this.f32924c)) * 31) + q1.a.a(this.f32925d)) * 31) + this.f32926e.hashCode()) * 31) + this.f32927f.hashCode();
        }

        public String toString() {
            String str = this.f32922a;
            String str2 = this.f32923b;
            double d8 = this.f32924c;
            double d9 = this.f32925d;
            Color color = this.f32926e;
            Color color2 = this.f32927f;
            return "Threshold(title=" + str + ", formattedValue=" + str2 + ", relativePosition=" + d8 + ", relativeWidth=" + d9 + ", color=" + color + ", textColor=" + color2 + ")";
        }
    }

    /* compiled from: DriverScoreHeaderDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        private final View f32928u;

        /* renamed from: v  reason: collision with root package name */
        public Map<Integer, View> f32929v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View containerView) {
            super(containerView);
            Intrinsics.f(containerView, "containerView");
            this.f32929v = new LinkedHashMap();
            this.f32928u = containerView;
        }

        public View O(int i8) {
            View findViewById;
            Map<Integer, View> map = this.f32929v;
            View view = map.get(Integer.valueOf(i8));
            if (view == null) {
                View P = P();
                if (P == null || (findViewById = P.findViewById(i8)) == null) {
                    return null;
                }
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return view;
        }

        public View P() {
            return this.f32928u;
        }
    }

    private final void t(Threshold threshold, ImageView imageView, TextView textView, TextView textView2) {
        Color a8 = threshold.a();
        Context context = imageView.getContext();
        Intrinsics.e(context, "dash.context");
        int a9 = ColorKt.a(a8, context);
        Color e8 = threshold.e();
        Context context2 = imageView.getContext();
        Intrinsics.e(context2, "dash.context");
        int a10 = ColorKt.a(e8, context2);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams).G = (float) threshold.c();
        ImageViewCompat.c(imageView, ColorStateList.valueOf(a9));
        textView.setText(threshold.b());
        textView.setTextColor(a10);
        ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
        Intrinsics.d(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ConstraintLayout.LayoutParams) layoutParams2).V = (float) threshold.d();
        textView2.setText(threshold.f());
        textView2.setTextColor(a10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DriverScoreHeaderDelegate this$0, ViewHolder holder, Model model) {
        Intrinsics.f(this$0, "this$0");
        Intrinsics.f(holder, "$holder");
        Intrinsics.f(model, "$model");
        this$0.y(holder, model.r());
    }

    private final void x(TextView textView) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        if (layoutParams != null) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.f5032t = Integer.MIN_VALUE;
            layoutParams2.f5036v = Integer.MIN_VALUE;
            textView.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    }

    private final void y(ViewHolder viewHolder, List<Threshold> list) {
        String str;
        int i8;
        int i9;
        int i10;
        int i11;
        String str2;
        int i12;
        int i13;
        int i14;
        if (list.isEmpty()) {
            return;
        }
        int i15 = R.id.progressLayout;
        ((ConstraintLayout) viewHolder.O(i15)).measure(View.MeasureSpec.makeMeasureSpec(((ConstraintLayout) viewHolder.O(i15)).getWidth(), Pow2.MAX_POW2), 0);
        int measuredWidth = ((ConstraintLayout) viewHolder.O(i15)).getMeasuredWidth();
        if (list.size() == 1) {
            int i16 = R.id.threshold1Explanation;
            ((TextView) viewHolder.O(i16)).measure(View.MeasureSpec.makeMeasureSpec(((TextView) viewHolder.O(i16)).getWidth(), Pow2.MAX_POW2), 0);
            int i17 = R.id.threshold1Signature;
            ((TextView) viewHolder.O(i17)).measure(View.MeasureSpec.makeMeasureSpec(((TextView) viewHolder.O(i17)).getWidth(), Pow2.MAX_POW2), 0);
            int measuredWidth2 = ((TextView) viewHolder.O(i16)).getMeasuredWidth();
            int x7 = (int) ((TextView) viewHolder.O(i16)).getX();
            int i18 = measuredWidth2 + x7;
            if (x7 < 0) {
                int abs = Math.abs(x7);
                TextView textView = (TextView) viewHolder.O(i16);
                Intrinsics.e(textView, "holder.threshold1Explanation");
                x(textView);
                ((TextView) viewHolder.O(i16)).setTranslationX(abs);
            }
            if (i18 > measuredWidth) {
                TextView textView2 = (TextView) viewHolder.O(i16);
                Intrinsics.e(textView2, "holder.threshold1Explanation");
                x(textView2);
                ((TextView) viewHolder.O(i16)).setTranslationX(x7 - (i18 - measuredWidth));
            }
            int measuredWidth3 = ((TextView) viewHolder.O(i17)).getMeasuredWidth();
            int x8 = (int) ((TextView) viewHolder.O(i17)).getX();
            int i19 = measuredWidth3 + x8;
            if (x8 < 0) {
                int abs2 = Math.abs(x8);
                TextView textView3 = (TextView) viewHolder.O(i17);
                Intrinsics.e(textView3, "holder.threshold1Signature");
                x(textView3);
                ((TextView) viewHolder.O(i17)).setTranslationX(abs2);
            }
            if (i19 > measuredWidth) {
                int i20 = i19 - measuredWidth;
                TextView textView4 = (TextView) viewHolder.O(i17);
                Intrinsics.e(textView4, "holder.threshold1Signature");
                x(textView4);
                ((TextView) viewHolder.O(i17)).setTranslationX(x8 - i20);
            }
        } else if (list.size() > 1) {
            int i21 = R.id.threshold1Explanation;
            ((TextView) viewHolder.O(i21)).measure(View.MeasureSpec.makeMeasureSpec(((TextView) viewHolder.O(i21)).getWidth(), Pow2.MAX_POW2), 0);
            int i22 = R.id.threshold2Explanation;
            ((TextView) viewHolder.O(i22)).measure(View.MeasureSpec.makeMeasureSpec(((TextView) viewHolder.O(i22)).getWidth(), Pow2.MAX_POW2), 0);
            int i23 = R.id.threshold1Signature;
            ((TextView) viewHolder.O(i23)).measure(View.MeasureSpec.makeMeasureSpec(((TextView) viewHolder.O(i23)).getWidth(), Pow2.MAX_POW2), 0);
            int i24 = R.id.threshold2Signature;
            ((TextView) viewHolder.O(i24)).measure(View.MeasureSpec.makeMeasureSpec(((TextView) viewHolder.O(i24)).getWidth(), Pow2.MAX_POW2), 0);
            int measuredWidth4 = ((TextView) viewHolder.O(i21)).getMeasuredWidth();
            int measuredWidth5 = ((TextView) viewHolder.O(i22)).getMeasuredWidth();
            int measuredWidth6 = ((TextView) viewHolder.O(i23)).getMeasuredWidth();
            int measuredWidth7 = ((TextView) viewHolder.O(i24)).getMeasuredWidth();
            int x9 = (int) ((TextView) viewHolder.O(i21)).getX();
            int i25 = measuredWidth4 + x9;
            int x10 = (int) ((TextView) viewHolder.O(i22)).getX();
            int i26 = measuredWidth5 + x10;
            int x11 = (int) ((TextView) viewHolder.O(i23)).getX();
            int i27 = measuredWidth6 + x11;
            int x12 = (int) ((TextView) viewHolder.O(i24)).getX();
            int i28 = measuredWidth7 + x12;
            if (x9 >= 0) {
                str = "holder.threshold1Signature";
                i8 = x12;
                i9 = i27;
            } else {
                i8 = x12;
                int abs3 = Math.abs(x9);
                i9 = i27;
                TextView textView5 = (TextView) viewHolder.O(i21);
                Intrinsics.e(textView5, "holder.threshold1Explanation");
                x(textView5);
                str = "holder.threshold1Signature";
                ((TextView) viewHolder.O(i21)).setTranslationX(abs3);
                int i29 = abs3 + i25;
                if (x10 < i29) {
                    TextView textView6 = (TextView) viewHolder.O(i22);
                    Intrinsics.e(textView6, "holder.threshold2Explanation");
                    x(textView6);
                    ((TextView) viewHolder.O(i22)).setTranslationX((i29 - x10) + x10);
                }
            }
            if (i26 > measuredWidth) {
                TextView textView7 = (TextView) viewHolder.O(i22);
                Intrinsics.e(textView7, "holder.threshold2Explanation");
                x(textView7);
                int i30 = x10 - (i26 - measuredWidth);
                ((TextView) viewHolder.O(i22)).setTranslationX(i30);
                if (i30 < i25) {
                    TextView textView8 = (TextView) viewHolder.O(i21);
                    Intrinsics.e(textView8, "holder.threshold1Explanation");
                    x(textView8);
                    ((TextView) viewHolder.O(i21)).setTranslationX(x9 - (i25 - i30));
                }
            }
            if (x9 > 0 && i26 < measuredWidth && x10 < i25) {
                int i31 = i25 - x10;
                if (x9 - i31 > 0) {
                    int i32 = i31 / 2;
                    int i33 = x9 - i32;
                    if (i33 > 0 && (i14 = i32 + x10) < measuredWidth) {
                        TextView textView9 = (TextView) viewHolder.O(i21);
                        Intrinsics.e(textView9, "holder.threshold1Explanation");
                        x(textView9);
                        TextView textView10 = (TextView) viewHolder.O(i22);
                        Intrinsics.e(textView10, "holder.threshold2Explanation");
                        x(textView10);
                        ((TextView) viewHolder.O(i21)).setTranslationX(i33);
                        ((TextView) viewHolder.O(i22)).setTranslationX(i14);
                    } else {
                        TextView textView11 = (TextView) viewHolder.O(i22);
                        Intrinsics.e(textView11, "holder.threshold2Explanation");
                        x(textView11);
                        ((TextView) viewHolder.O(i22)).setTranslationX(i31 + x10);
                    }
                } else {
                    int i34 = i31 + x10;
                    if (i34 < measuredWidth) {
                        TextView textView12 = (TextView) viewHolder.O(i22);
                        Intrinsics.e(textView12, "holder.threshold2Explanation");
                        x(textView12);
                        ((TextView) viewHolder.O(i22)).setTranslationX(i34);
                    } else {
                        int i35 = measuredWidth - i26;
                        if (i31 < x9 && i31 < i35) {
                            TextView textView13 = (TextView) viewHolder.O(i22);
                            Intrinsics.e(textView13, "holder.threshold2Explanation");
                            x(textView13);
                            ((TextView) viewHolder.O(i22)).setTranslationX(i34);
                        } else if (i31 < i35 && i31 > x9) {
                            int i36 = i31 - x9;
                            TextView textView14 = (TextView) viewHolder.O(i21);
                            Intrinsics.e(textView14, "holder.threshold1Explanation");
                            x(textView14);
                            TextView textView15 = (TextView) viewHolder.O(i22);
                            Intrinsics.e(textView15, "holder.threshold2Explanation");
                            x(textView15);
                            ((TextView) viewHolder.O(i21)).setTranslationX(i36);
                            ((TextView) viewHolder.O(i22)).setTranslationX((i31 - i36) + x10);
                        } else if (i31 > i35 && i31 < x9) {
                            int i37 = i31 - x9;
                            TextView textView16 = (TextView) viewHolder.O(i21);
                            Intrinsics.e(textView16, "holder.threshold1Explanation");
                            x(textView16);
                            TextView textView17 = (TextView) viewHolder.O(i22);
                            Intrinsics.e(textView17, "holder.threshold2Explanation");
                            x(textView17);
                            ((TextView) viewHolder.O(i22)).setTranslationX(x10 - i37);
                            ((TextView) viewHolder.O(i21)).setTranslationX(x10 - (i31 - i37));
                        }
                    }
                }
            }
            if (x11 < 0) {
                int abs4 = Math.abs(x11);
                TextView textView18 = (TextView) viewHolder.O(i23);
                str2 = str;
                Intrinsics.e(textView18, str2);
                x(textView18);
                ((TextView) viewHolder.O(i23)).setTranslationX(abs4);
                int i38 = i9 + abs4;
                i11 = i8;
                if (i11 < i38) {
                    i10 = i24;
                    TextView textView19 = (TextView) viewHolder.O(i10);
                    Intrinsics.e(textView19, "holder.threshold2Signature");
                    x(textView19);
                    ((TextView) viewHolder.O(i10)).setTranslationX((i38 - i11) + i11);
                } else {
                    i10 = i24;
                }
            } else {
                i10 = i24;
                i11 = i8;
                str2 = str;
            }
            if (i28 > measuredWidth) {
                TextView textView20 = (TextView) viewHolder.O(i10);
                Intrinsics.e(textView20, "holder.threshold2Signature");
                x(textView20);
                int i39 = i11 - (i28 - measuredWidth);
                ((TextView) viewHolder.O(i10)).setTranslationX(i39);
                i12 = i9;
                if (i39 < i12) {
                    TextView textView21 = (TextView) viewHolder.O(i23);
                    Intrinsics.e(textView21, str2);
                    x(textView21);
                    ((TextView) viewHolder.O(i23)).setTranslationX(x11 - (i12 - i39));
                }
            } else {
                i12 = i9;
            }
            if (x11 > 0 && i28 < measuredWidth && i11 < i12) {
                int i40 = i12 - i11;
                if (x11 - i40 > 0) {
                    int i41 = i40 / 2;
                    int i42 = x11 - i41;
                    if (i42 > 0 && (i13 = i41 + i11) < measuredWidth) {
                        TextView textView22 = (TextView) viewHolder.O(i23);
                        Intrinsics.e(textView22, str2);
                        x(textView22);
                        TextView textView23 = (TextView) viewHolder.O(i10);
                        Intrinsics.e(textView23, "holder.threshold2Signature");
                        x(textView23);
                        ((TextView) viewHolder.O(i23)).setTranslationX(i42);
                        ((TextView) viewHolder.O(i10)).setTranslationX(i13);
                        return;
                    }
                    TextView textView24 = (TextView) viewHolder.O(i10);
                    Intrinsics.e(textView24, "holder.threshold2Signature");
                    x(textView24);
                    ((TextView) viewHolder.O(i10)).setTranslationX(i40 + i11);
                    return;
                }
                int i43 = i40 + i11;
                if (i43 < measuredWidth) {
                    TextView textView25 = (TextView) viewHolder.O(i10);
                    Intrinsics.e(textView25, "holder.threshold2Signature");
                    x(textView25);
                    ((TextView) viewHolder.O(i10)).setTranslationX(i43);
                    return;
                }
                int i44 = measuredWidth - i28;
                if (i40 < x11 && i40 < i44) {
                    TextView textView26 = (TextView) viewHolder.O(i10);
                    Intrinsics.e(textView26, "holder.threshold2Signature");
                    x(textView26);
                    ((TextView) viewHolder.O(i10)).setTranslationX(i43);
                } else if (i40 < i44 && i40 > x11) {
                    int i45 = i40 - x11;
                    TextView textView27 = (TextView) viewHolder.O(i23);
                    Intrinsics.e(textView27, str2);
                    x(textView27);
                    TextView textView28 = (TextView) viewHolder.O(i10);
                    Intrinsics.e(textView28, "holder.threshold2Signature");
                    x(textView28);
                    ((TextView) viewHolder.O(i23)).setTranslationX(i45);
                    ((TextView) viewHolder.O(i10)).setTranslationX((i40 - i45) + i11);
                } else if (i40 > i44 && i40 < x11) {
                    int i46 = i40 - x11;
                    TextView textView29 = (TextView) viewHolder.O(i23);
                    Intrinsics.e(textView29, str2);
                    x(textView29);
                    TextView textView30 = (TextView) viewHolder.O(i10);
                    Intrinsics.e(textView30, "holder.threshold2Signature");
                    x(textView30);
                    ((TextView) viewHolder.O(i10)).setTranslationX(i11 - i46);
                    ((TextView) viewHolder.O(i23)).setTranslationX(i11 - (i40 - i46));
                }
            }
        }
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public int e() {
        return this.f32915b;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public boolean f(ListModel model) {
        Intrinsics.f(model, "model");
        return model instanceof Model;
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    public RecyclerView.ViewHolder k(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.f(inflater, "inflater");
        Intrinsics.f(parent, "parent");
        View inflate = inflater.inflate(R.layout.delegate_item_driver_score_header, parent, false);
        Intrinsics.e(inflate, "inflater.inflate(\n      …      false\n            )");
        return new ViewHolder(inflate);
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: u */
    public void g(final ViewHolder holder, final Model model) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(model, "model");
        ((TextView) holder.O(R.id.scoreValue)).setText(model.q());
        ((TextView) holder.O(R.id.scoreUnit)).setText(model.p());
        int i8 = R.id.progressBar;
        ((ProgressBar) holder.O(i8)).setProgress((int) (model.n() * ((ProgressBar) holder.O(i8)).getMax()));
        ProgressBar progressBar = (ProgressBar) holder.O(i8);
        Intrinsics.e(progressBar, "holder.progressBar");
        Color o8 = model.o();
        Context context = ((ProgressBar) holder.O(i8)).getContext();
        Intrinsics.e(context, "holder.progressBar.context");
        ProgressBarExtKt.a(progressBar, ColorKt.a(o8, context));
        if (!model.r().isEmpty()) {
            Group group = (Group) holder.O(R.id.threshold1Group);
            Intrinsics.e(group, "holder.threshold1Group");
            ViewExtKt.e(group, true, 0, 2, null);
            ImageView imageView = (ImageView) holder.O(R.id.threshold1);
            Intrinsics.e(imageView, "holder.threshold1");
            TextView textView = (TextView) holder.O(R.id.threshold1Signature);
            Intrinsics.e(textView, "holder.threshold1Signature");
            TextView textView2 = (TextView) holder.O(R.id.threshold1Explanation);
            Intrinsics.e(textView2, "holder.threshold1Explanation");
            t(model.r().get(0), imageView, textView, textView2);
        } else {
            Group group2 = (Group) holder.O(R.id.threshold1Group);
            Intrinsics.e(group2, "holder.threshold1Group");
            ViewExtKt.e(group2, false, 0, 2, null);
        }
        if (model.r().size() > 1) {
            Group group3 = (Group) holder.O(R.id.threshold2Group);
            Intrinsics.e(group3, "holder.threshold2Group");
            ViewExtKt.e(group3, true, 0, 2, null);
            ImageView imageView2 = (ImageView) holder.O(R.id.threshold2);
            Intrinsics.e(imageView2, "holder.threshold2");
            TextView textView3 = (TextView) holder.O(R.id.threshold2Signature);
            Intrinsics.e(textView3, "holder.threshold2Signature");
            TextView textView4 = (TextView) holder.O(R.id.threshold2Explanation);
            Intrinsics.e(textView4, "holder.threshold2Explanation");
            t(model.r().get(1), imageView2, textView3, textView4);
        } else {
            Group group4 = (Group) holder.O(R.id.threshold2Group);
            Intrinsics.e(group4, "holder.threshold2Group");
            ViewExtKt.e(group4, false, 0, 2, null);
        }
        ((ConstraintLayout) holder.O(R.id.progressLayout)).post(new Runnable() { // from class: ee.mtakso.driver.ui.screens.score.h
            @Override // java.lang.Runnable
            public final void run() {
                DriverScoreHeaderDelegate.v(DriverScoreHeaderDelegate.this, holder, model);
            }
        });
    }

    @Override // ee.mtakso.driver.uikit.recyclerview.DiffAdapterDelegate
    /* renamed from: w */
    public void i(ViewHolder holder, List<? extends Object> payloads) {
        Intrinsics.f(holder, "holder");
        Intrinsics.f(payloads, "payloads");
    }
}
