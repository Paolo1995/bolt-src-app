package eu.bolt.client.design.input;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentTransaction;
import com.jakewharton.rxrelay2.PublishRelay;
import eu.bolt.verification.R$dimen;
import eu.bolt.verification.R$string;
import eu.bolt.verification.sdk.internal.p4;
import eu.bolt.verification.sdk.internal.pr;
import eu.bolt.verification.sdk.internal.tb;
import eu.bolt.verification.sdk.internal.ug;
import eu.bolt.verification.sdk.internal.uq;
import io.reactivex.Observable;
import j$.util.DesugarTimeZone;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* loaded from: classes5.dex */
public final class DesignDateInputView extends LinearLayout {

    /* renamed from: o  reason: collision with root package name */
    private static final a f40043o = new a(null);
    @Deprecated

    /* renamed from: p  reason: collision with root package name */
    private static final Set<Integer> f40044p;

    /* renamed from: f  reason: collision with root package name */
    private pr f40045f;

    /* renamed from: g  reason: collision with root package name */
    private final PublishRelay<Integer> f40046g;

    /* renamed from: h  reason: collision with root package name */
    private final PublishRelay<Integer> f40047h;

    /* renamed from: i  reason: collision with root package name */
    private final PublishRelay<Integer> f40048i;

    /* renamed from: j  reason: collision with root package name */
    private final Map<Integer, View> f40049j;

    /* renamed from: k  reason: collision with root package name */
    private final DesignTextfieldView f40050k;

    /* renamed from: l  reason: collision with root package name */
    private final DesignTextfieldView f40051l;

    /* renamed from: m  reason: collision with root package name */
    private final DesignTextfieldView f40052m;

    /* renamed from: n  reason: collision with root package name */
    private b f40053n;

    /* loaded from: classes5.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(Date date);
    }

    /* loaded from: classes5.dex */
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40054a;

        static {
            int[] iArr = new int[tb.a.values().length];
            try {
                iArr[tb.a.YMD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[tb.a.DMY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[tb.a.MDY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f40054a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements TextWatcher {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f40055f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ DesignTextfieldView f40056g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ PublishRelay f40057h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ DesignDateInputView f40058i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f40059j;

        public d(String str, DesignTextfieldView designTextfieldView, PublishRelay publishRelay, DesignDateInputView designDateInputView, String str2) {
            this.f40055f = str;
            this.f40056g = designTextfieldView;
            this.f40057h = publishRelay;
            this.f40058i = designDateInputView;
            this.f40059j = str2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Integer m8;
            if (new Regex(this.f40055f).f(String.valueOf(editable))) {
                this.f40056g.setError(false);
                this.f40057h.accept(Integer.valueOf(Integer.parseInt(String.valueOf(editable))));
                View view = (View) this.f40058i.f40049j.get(Integer.valueOf(this.f40056g.getId()));
                if (view != null) {
                    view.requestFocus();
                    return;
                }
                return;
            }
            if (this.f40059j != null && new Regex(this.f40059j).f(String.valueOf(editable))) {
                this.f40056g.setError(false);
                this.f40057h.accept(Integer.valueOf(Integer.parseInt(String.valueOf(editable))));
                return;
            }
            m8 = StringsKt__StringNumberConversionsKt.m(String.valueOf(editable));
            if (m8 != null) {
                this.f40057h.accept(Integer.valueOf(m8.intValue()));
            }
            this.f40056g.setError(true);
            b bVar = this.f40058i.f40053n;
            if (bVar != null) {
                bVar.a(null);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e extends Lambda implements Function3<Integer, Integer, Integer, eu.bolt.client.design.input.a> {
        e() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: b */
        public final eu.bolt.client.design.input.a l(Integer day, Integer month, Integer year) {
            Intrinsics.f(day, "day");
            Intrinsics.f(month, "month");
            Intrinsics.f(year, "year");
            return DesignDateInputView.this.e(day.intValue(), month.intValue(), year.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class f extends Lambda implements Function1<eu.bolt.client.design.input.a, Unit> {
        f() {
            super(1);
        }

        public final void b(eu.bolt.client.design.input.a aVar) {
            b bVar;
            if (!aVar.b() || (bVar = DesignDateInputView.this.f40053n) == null) {
                return;
            }
            bVar.a(aVar.a());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(eu.bolt.client.design.input.a aVar) {
            b(aVar);
            return Unit.f50853a;
        }
    }

    static {
        Set<Integer> f8;
        f8 = SetsKt__SetsKt.f(2, 4, 6, 9, 11);
        f40044p = f8;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DesignDateInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignDateInputView(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        Intrinsics.f(context, "context");
        PublishRelay<Integer> e8 = PublishRelay.e();
        Intrinsics.e(e8, "create<Int>()");
        this.f40046g = e8;
        PublishRelay<Integer> e9 = PublishRelay.e();
        Intrinsics.e(e9, "create<Int>()");
        this.f40047h = e9;
        PublishRelay<Integer> e10 = PublishRelay.e();
        Intrinsics.e(e10, "create<Int>()");
        this.f40048i = e10;
        this.f40049j = new LinkedHashMap();
        DesignTextfieldView k8 = k();
        this.f40050k = k8;
        DesignTextfieldView i9 = i();
        this.f40051l = i9;
        DesignTextfieldView c8 = c();
        this.f40052m = c8;
        setOrientation(0);
        h(c8, i9, k8);
        l();
    }

    public /* synthetic */ DesignDateInputView(Context context, AttributeSet attributeSet, int i8, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i9 & 2) != 0 ? null : attributeSet, (i9 & 4) != 0 ? 0 : i8);
    }

    private final DesignTextfieldView c() {
        return d(R$string.design_date_input_hint_day, 2, this.f40046g, "([4-9]|0[1-9]|[12][0-9]|3[01])", "([1-3])");
    }

    private final DesignTextfieldView d(int i8, int i9, PublishRelay<Integer> publishRelay, String str, String str2) {
        DesignTextfieldView root = p4.b(uq.Y(this), this, false).getRoot();
        Intrinsics.e(root, "inflate(inflater(), this, false).root");
        root.setId(View.generateViewId());
        root.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        root.setHint(root.getResources().getString(i8));
        root.getInputView().setInputType(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        root.getInputView().setImeOptions(6);
        root.getInputView().setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(i9)});
        root.getInputView().addTextChangedListener(new d(str, root, publishRelay, this, str2));
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final eu.bolt.client.design.input.a e(int i8, int i9, int i10) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        pr prVar = this.f40045f;
        if (prVar != null) {
            if (i10 > prVar.a() || i10 < prVar.b()) {
                this.f40050k.setError(true);
                return new eu.bolt.client.design.input.a(new Date(), false);
            }
            this.f40050k.setError(false);
        }
        if ((f40044p.contains(Integer.valueOf(i9)) && i8 > 30) || ((i9 == 2 && i8 > 29) || (i9 == 2 && i8 > 28 && !gregorianCalendar.isLeapYear(i10)))) {
            this.f40052m.setError(true);
            b bVar = this.f40053n;
            if (bVar != null) {
                bVar.a(null);
            }
            return new eu.bolt.client.design.input.a(new Date(), false);
        }
        this.f40052m.setError(false);
        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("GMT"));
        calendar.setTime(new Date(0L));
        calendar.set(5, i8);
        calendar.set(2, i9 - 1);
        calendar.set(1, i10);
        Date date = calendar.getTime();
        Intrinsics.e(date, "date");
        return new eu.bolt.client.design.input.a(date, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final eu.bolt.client.design.input.a g(Function3 tmp0, Object obj, Object obj2, Object obj3) {
        Intrinsics.f(tmp0, "$tmp0");
        return (eu.bolt.client.design.input.a) tmp0.l(obj, obj2, obj3);
    }

    private final void h(DesignTextfieldView designTextfieldView, DesignTextfieldView designTextfieldView2, DesignTextfieldView designTextfieldView3) {
        View[] viewArr;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.big_margin);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R$dimen.small_side_margin);
        removeAllViews();
        tb.a a8 = tb.a(tb.f45154a, null, 1, null);
        int i8 = a8 == null ? -1 : c.f40054a[a8.ordinal()];
        if (i8 == -1) {
            viewArr = new DesignTextfieldView[]{designTextfieldView2, designTextfieldView, designTextfieldView3};
        } else if (i8 == 1) {
            viewArr = new DesignTextfieldView[]{designTextfieldView3, designTextfieldView2, designTextfieldView};
        } else if (i8 == 2) {
            viewArr = new DesignTextfieldView[]{designTextfieldView, designTextfieldView2, designTextfieldView3};
        } else if (i8 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            viewArr = new DesignTextfieldView[]{designTextfieldView2, designTextfieldView, designTextfieldView3};
        }
        View view = viewArr[0];
        this.f40049j.put(Integer.valueOf(view.getId()), viewArr[1].getInputView());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMarginStart(dimensionPixelSize);
        addView(view);
        DesignTextfieldView designTextfieldView4 = viewArr[1];
        this.f40049j.put(Integer.valueOf(designTextfieldView4.getId()), viewArr[2].getInputView());
        ViewGroup.LayoutParams layoutParams2 = designTextfieldView4.getLayoutParams();
        Intrinsics.d(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams2).setMarginStart(dimensionPixelSize2);
        addView(designTextfieldView4);
        DesignTextfieldView designTextfieldView5 = viewArr[2];
        this.f40049j.remove(Integer.valueOf(designTextfieldView5.getId()));
        ViewGroup.LayoutParams layoutParams3 = designTextfieldView5.getLayoutParams();
        Intrinsics.d(layoutParams3, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) layoutParams3;
        layoutParams4.setMarginStart(dimensionPixelSize2);
        layoutParams4.setMarginEnd(dimensionPixelSize);
        addView(designTextfieldView5);
    }

    private final DesignTextfieldView i() {
        return d(R$string.design_date_input_hint_month, 2, this.f40047h, "([2-9]|0[1-9]|1[012])", "(1)");
    }

    private final DesignTextfieldView k() {
        return d(R$string.design_date_input_hint_year, 4, this.f40048i, "^(19|20)\\d{2}$", null);
    }

    private final void l() {
        PublishRelay<Integer> publishRelay = this.f40046g;
        PublishRelay<Integer> publishRelay2 = this.f40047h;
        PublishRelay<Integer> publishRelay3 = this.f40048i;
        final e eVar = new e();
        Observable combineLatest = Observable.combineLatest(publishRelay, publishRelay2, publishRelay3, new io.reactivex.functions.Function3() { // from class: eu.bolt.client.design.input.b
            @Override // io.reactivex.functions.Function3
            public final Object a(Object obj, Object obj2, Object obj3) {
                a g8;
                g8 = DesignDateInputView.g(Function3.this, obj, obj2, obj3);
                return g8;
            }
        });
        Intrinsics.e(combineLatest, "private fun observeInput…   }\n            })\n    }");
        ug.r(combineLatest, new f(), null, null, null, null, 30, null);
    }

    public final void setDate(Date date) {
        if (date == null) {
            this.f40052m.setText("");
            this.f40051l.setText("");
            this.f40050k.setText("");
            this.f40052m.setError(false);
            this.f40051l.setError(false);
            this.f40050k.setError(false);
            return;
        }
        Calendar calendar = Calendar.getInstance(DesugarTimeZone.getTimeZone("GMT"));
        calendar.setTime(date);
        DesignTextfieldView designTextfieldView = this.f40052m;
        StringCompanionObject stringCompanionObject = StringCompanionObject.f51021a;
        String format = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(calendar.get(5))}, 1));
        Intrinsics.e(format, "format(format, *args)");
        designTextfieldView.setText(format);
        DesignTextfieldView designTextfieldView2 = this.f40051l;
        String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Integer.valueOf(calendar.get(2) + 1)}, 1));
        Intrinsics.e(format2, "format(format, *args)");
        designTextfieldView2.setText(format2);
        this.f40050k.setText(String.valueOf(calendar.get(1)));
    }

    public final void setListener(b bVar) {
        this.f40053n = bVar;
    }

    public final void setYearRange(pr prVar) {
        this.f40045f = prVar;
    }
}
