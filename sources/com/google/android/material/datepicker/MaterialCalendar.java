package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$integer;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {

    /* renamed from: t  reason: collision with root package name */
    static final Object f13278t = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: u  reason: collision with root package name */
    static final Object f13279u = "NAVIGATION_PREV_TAG";

    /* renamed from: v  reason: collision with root package name */
    static final Object f13280v = "NAVIGATION_NEXT_TAG";

    /* renamed from: w  reason: collision with root package name */
    static final Object f13281w = "SELECTOR_TOGGLE_TAG";

    /* renamed from: g  reason: collision with root package name */
    private int f13282g;

    /* renamed from: h  reason: collision with root package name */
    private DateSelector<S> f13283h;

    /* renamed from: i  reason: collision with root package name */
    private CalendarConstraints f13284i;

    /* renamed from: j  reason: collision with root package name */
    private DayViewDecorator f13285j;

    /* renamed from: k  reason: collision with root package name */
    private Month f13286k;

    /* renamed from: l  reason: collision with root package name */
    private CalendarSelector f13287l;

    /* renamed from: m  reason: collision with root package name */
    private CalendarStyle f13288m;

    /* renamed from: n  reason: collision with root package name */
    private RecyclerView f13289n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerView f13290o;

    /* renamed from: p  reason: collision with root package name */
    private View f13291p;

    /* renamed from: q  reason: collision with root package name */
    private View f13292q;

    /* renamed from: r  reason: collision with root package name */
    private View f13293r;

    /* renamed from: s  reason: collision with root package name */
    private View f13294s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OnDayClickListener {
        void a(long j8);
    }

    private void M(@NonNull View view, @NonNull final MonthsPagerAdapter monthsPagerAdapter) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.month_navigation_fragment_toggle);
        materialButton.setTag(f13281w);
        ViewCompat.s0(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                String string;
                super.g(view2, accessibilityNodeInfoCompat);
                if (MaterialCalendar.this.f13294s.getVisibility() == 0) {
                    string = MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_year_selection);
                } else {
                    string = MaterialCalendar.this.getString(R$string.mtrl_picker_toggle_to_day_selection);
                }
                accessibilityNodeInfoCompat.j0(string);
            }
        });
        View findViewById = view.findViewById(R$id.month_navigation_previous);
        this.f13291p = findViewById;
        findViewById.setTag(f13279u);
        View findViewById2 = view.findViewById(R$id.month_navigation_next);
        this.f13292q = findViewById2;
        findViewById2.setTag(f13280v);
        this.f13293r = view.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f13294s = view.findViewById(R$id.mtrl_calendar_day_selector_frame);
        Y(CalendarSelector.DAY);
        materialButton.setText(this.f13286k.p());
        this.f13290o.l(new RecyclerView.OnScrollListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void a(@NonNull RecyclerView recyclerView, int i8) {
                if (i8 == 0) {
                    recyclerView.announceForAccessibility(materialButton.getText());
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void b(@NonNull RecyclerView recyclerView, int i8, int i9) {
                int n22;
                if (i8 < 0) {
                    n22 = MaterialCalendar.this.U().k2();
                } else {
                    n22 = MaterialCalendar.this.U().n2();
                }
                MaterialCalendar.this.f13286k = monthsPagerAdapter.Q(n22);
                materialButton.setText(monthsPagerAdapter.R(n22));
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MaterialCalendar.this.a0();
            }
        });
        this.f13292q.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int k22 = MaterialCalendar.this.U().k2() + 1;
                if (k22 < MaterialCalendar.this.f13290o.getAdapter().r()) {
                    MaterialCalendar.this.X(monthsPagerAdapter.Q(k22));
                }
            }
        });
        this.f13291p.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int n22 = MaterialCalendar.this.U().n2() - 1;
                if (n22 >= 0) {
                    MaterialCalendar.this.X(monthsPagerAdapter.Q(n22));
                }
            }
        });
    }

    @NonNull
    private RecyclerView.ItemDecoration N() {
        return new RecyclerView.ItemDecoration() { // from class: com.google.android.material.datepicker.MaterialCalendar.5

            /* renamed from: a  reason: collision with root package name */
            private final Calendar f13302a = UtcDates.k();

            /* renamed from: b  reason: collision with root package name */
            private final Calendar f13303b = UtcDates.k();

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void i(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
                int i8;
                int width;
                if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView.getAdapter();
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    for (Pair<Long, Long> pair : MaterialCalendar.this.f13283h.k0()) {
                        Long l8 = pair.f5908a;
                        if (l8 != null && pair.f5909b != null) {
                            this.f13302a.setTimeInMillis(l8.longValue());
                            this.f13303b.setTimeInMillis(pair.f5909b.longValue());
                            int R = yearGridAdapter.R(this.f13302a.get(1));
                            int R2 = yearGridAdapter.R(this.f13303b.get(1));
                            View N = gridLayoutManager.N(R);
                            View N2 = gridLayoutManager.N(R2);
                            int h32 = R / gridLayoutManager.h3();
                            int h33 = R2 / gridLayoutManager.h3();
                            for (int i9 = h32; i9 <= h33; i9++) {
                                View N3 = gridLayoutManager.N(gridLayoutManager.h3() * i9);
                                if (N3 != null) {
                                    int top = N3.getTop() + MaterialCalendar.this.f13288m.f13268d.c();
                                    int bottom = N3.getBottom() - MaterialCalendar.this.f13288m.f13268d.b();
                                    if (i9 == h32) {
                                        i8 = N.getLeft() + (N.getWidth() / 2);
                                    } else {
                                        i8 = 0;
                                    }
                                    if (i9 == h33) {
                                        width = N2.getLeft() + (N2.getWidth() / 2);
                                    } else {
                                        width = recyclerView.getWidth();
                                    }
                                    canvas.drawRect(i8, top, width, bottom, MaterialCalendar.this.f13288m.f13272h);
                                }
                            }
                        }
                    }
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int S(@NonNull Context context) {
        return context.getResources().getDimensionPixelSize(R$dimen.mtrl_calendar_day_height);
    }

    private static int T(@NonNull Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.mtrl_calendar_days_of_week_height);
        int i8 = MonthAdapter.f13359l;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(R$dimen.mtrl_calendar_day_height) * i8) + ((i8 - 1) * resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R$dimen.mtrl_calendar_bottom_padding);
    }

    @NonNull
    public static <T> MaterialCalendar<T> V(@NonNull DateSelector<T> dateSelector, int i8, @NonNull CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i8);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", dayViewDecorator);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.l());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void W(final int i8) {
        this.f13290o.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.11
            @Override // java.lang.Runnable
            public void run() {
                MaterialCalendar.this.f13290o.x1(i8);
            }
        });
    }

    private void Z() {
        ViewCompat.s0(this.f13290o, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.4
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.s0(false);
            }
        });
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean D(@NonNull OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.D(onSelectionChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarConstraints O() {
        return this.f13284i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarStyle P() {
        return this.f13288m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month Q() {
        return this.f13286k;
    }

    public DateSelector<S> R() {
        return this.f13283h;
    }

    @NonNull
    LinearLayoutManager U() {
        return (LinearLayoutManager) this.f13290o.getLayoutManager();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(Month month) {
        boolean z7;
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.f13290o.getAdapter();
        int S = monthsPagerAdapter.S(month);
        int S2 = S - monthsPagerAdapter.S(this.f13286k);
        boolean z8 = true;
        if (Math.abs(S2) > 3) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (S2 <= 0) {
            z8 = false;
        }
        this.f13286k = month;
        if (z7 && z8) {
            this.f13290o.p1(S - 3);
            W(S);
        } else if (z7) {
            this.f13290o.p1(S + 3);
            W(S);
        } else {
            W(S);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y(CalendarSelector calendarSelector) {
        this.f13287l = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f13289n.getLayoutManager().H1(((YearGridAdapter) this.f13289n.getAdapter()).R(this.f13286k.f13354h));
            this.f13293r.setVisibility(0);
            this.f13294s.setVisibility(8);
            this.f13291p.setVisibility(8);
            this.f13292q.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.f13293r.setVisibility(8);
            this.f13294s.setVisibility(0);
            this.f13291p.setVisibility(0);
            this.f13292q.setVisibility(0);
            X(this.f13286k);
        }
    }

    void a0() {
        CalendarSelector calendarSelector = this.f13287l;
        CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
        if (calendarSelector == calendarSelector2) {
            Y(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            Y(calendarSelector2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f13282g = bundle.getInt("THEME_RES_ID_KEY");
        this.f13283h = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f13284i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f13285j = (DayViewDecorator) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f13286k = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i8;
        final int i9;
        DaysOfWeekAdapter daysOfWeekAdapter;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f13282g);
        this.f13288m = new CalendarStyle(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month n8 = this.f13284i.n();
        if (MaterialDatePicker.U(contextThemeWrapper)) {
            i8 = R$layout.mtrl_calendar_vertical;
            i9 = 1;
        } else {
            i8 = R$layout.mtrl_calendar_horizontal;
            i9 = 0;
        }
        View inflate = cloneInContext.inflate(i8, viewGroup, false);
        inflate.setMinimumHeight(T(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(R$id.mtrl_calendar_days_of_week);
        ViewCompat.s0(gridView, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.a0(null);
            }
        });
        int i10 = this.f13284i.i();
        if (i10 > 0) {
            daysOfWeekAdapter = new DaysOfWeekAdapter(i10);
        } else {
            daysOfWeekAdapter = new DaysOfWeekAdapter();
        }
        gridView.setAdapter((ListAdapter) daysOfWeekAdapter);
        gridView.setNumColumns(n8.f13355i);
        gridView.setEnabled(false);
        this.f13290o = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_months);
        this.f13290o.setLayoutManager(new SmoothCalendarLayoutManager(getContext(), i9, false) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public void X1(@NonNull RecyclerView.State state, @NonNull int[] iArr) {
                if (i9 == 0) {
                    iArr[0] = MaterialCalendar.this.f13290o.getWidth();
                    iArr[1] = MaterialCalendar.this.f13290o.getWidth();
                    return;
                }
                iArr[0] = MaterialCalendar.this.f13290o.getHeight();
                iArr[1] = MaterialCalendar.this.f13290o.getHeight();
            }
        });
        this.f13290o.setTag(f13278t);
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.f13283h, this.f13284i, this.f13285j, new OnDayClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.3
            @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
            public void a(long j8) {
                if (MaterialCalendar.this.f13284i.g().X(j8)) {
                    MaterialCalendar.this.f13283h.h1(j8);
                    Iterator<OnSelectionChangedListener<S>> it = MaterialCalendar.this.f13376f.iterator();
                    while (it.hasNext()) {
                        it.next().a((S) MaterialCalendar.this.f13283h.b1());
                    }
                    MaterialCalendar.this.f13290o.getAdapter().w();
                    if (MaterialCalendar.this.f13289n != null) {
                        MaterialCalendar.this.f13289n.getAdapter().w();
                    }
                }
            }
        });
        this.f13290o.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R$integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.mtrl_calendar_year_selector_frame);
        this.f13289n = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f13289n.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f13289n.setAdapter(new YearGridAdapter(this));
            this.f13289n.h(N());
        }
        if (inflate.findViewById(R$id.month_navigation_fragment_toggle) != null) {
            M(inflate, monthsPagerAdapter);
        }
        if (!MaterialDatePicker.U(contextThemeWrapper)) {
            new PagerSnapHelper().b(this.f13290o);
        }
        this.f13290o.p1(monthsPagerAdapter.S(this.f13286k));
        Z();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f13282g);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f13283h);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f13284i);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f13285j);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f13286k);
    }
}
