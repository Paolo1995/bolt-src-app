package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MonthAdapter extends BaseAdapter {

    /* renamed from: l  reason: collision with root package name */
    static final int f13359l = UtcDates.k().getMaximum(4);

    /* renamed from: m  reason: collision with root package name */
    private static final int f13360m = (UtcDates.k().getMaximum(5) + UtcDates.k().getMaximum(7)) - 1;

    /* renamed from: f  reason: collision with root package name */
    final Month f13361f;

    /* renamed from: g  reason: collision with root package name */
    final DateSelector<?> f13362g;

    /* renamed from: h  reason: collision with root package name */
    private Collection<Long> f13363h;

    /* renamed from: i  reason: collision with root package name */
    CalendarStyle f13364i;

    /* renamed from: j  reason: collision with root package name */
    final CalendarConstraints f13365j;

    /* renamed from: k  reason: collision with root package name */
    final DayViewDecorator f13366k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.f13361f = month;
        this.f13362g = dateSelector;
        this.f13365j = calendarConstraints;
        this.f13366k = dayViewDecorator;
        this.f13363h = dateSelector.W0();
    }

    private String c(Context context, long j8) {
        return DateStrings.a(context, j8, l(j8), k(j8), g(j8));
    }

    private void f(Context context) {
        if (this.f13364i == null) {
            this.f13364i = new CalendarStyle(context);
        }
    }

    private boolean j(long j8) {
        Iterator<Long> it = this.f13362g.W0().iterator();
        while (it.hasNext()) {
            if (UtcDates.a(j8) == UtcDates.a(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean l(long j8) {
        if (UtcDates.i().getTimeInMillis() == j8) {
            return true;
        }
        return false;
    }

    private void o(TextView textView, long j8, int i8) {
        CalendarItemStyle calendarItemStyle;
        boolean z7;
        CalendarItemStyle calendarItemStyle2;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String c8 = c(context, j8);
        textView.setContentDescription(c8);
        boolean X = this.f13365j.g().X(j8);
        if (X) {
            textView.setEnabled(true);
            boolean j9 = j(j8);
            textView.setSelected(j9);
            if (j9) {
                calendarItemStyle2 = this.f13364i.f13266b;
            } else if (l(j8)) {
                calendarItemStyle2 = this.f13364i.f13267c;
            } else {
                calendarItemStyle2 = this.f13364i.f13265a;
            }
            calendarItemStyle = calendarItemStyle2;
            z7 = j9;
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.f13364i.f13271g;
            z7 = false;
        }
        DayViewDecorator dayViewDecorator = this.f13366k;
        if (dayViewDecorator != null && i8 != -1) {
            Month month = this.f13361f;
            int i9 = month.f13354h;
            int i10 = month.f13353g;
            boolean z8 = z7;
            calendarItemStyle.e(textView, dayViewDecorator.a(context, i9, i10, i8, X, z8));
            Drawable c9 = this.f13366k.c(context, i9, i10, i8, X, z8);
            Drawable e8 = this.f13366k.e(context, i9, i10, i8, X, z8);
            Drawable d8 = this.f13366k.d(context, i9, i10, i8, X, z7);
            boolean z9 = z7;
            textView.setCompoundDrawables(c9, e8, d8, this.f13366k.b(context, i9, i10, i8, X, z9));
            textView.setContentDescription(this.f13366k.f(context, i9, i10, i8, X, z9, c8));
            return;
        }
        calendarItemStyle.d(textView);
    }

    private void p(MaterialCalendarGridView materialCalendarGridView, long j8) {
        if (Month.e(j8).equals(this.f13361f)) {
            int l8 = this.f13361f.l(j8);
            o((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter2().a(l8) - materialCalendarGridView.getFirstVisiblePosition()), j8, l8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i8) {
        return b() + (i8 - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f13361f.h(this.f13365j.i());
    }

    @Override // android.widget.Adapter
    /* renamed from: d */
    public Long getItem(int i8) {
        if (i8 >= b() && i8 <= m()) {
            return Long.valueOf(this.f13361f.j(n(i8)));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    @Override // android.widget.Adapter
    @androidx.annotation.NonNull
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.widget.TextView getView(int r6, android.view.View r7, @androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.f(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R$layout.mtrl_calendar_day
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            r8 = -1
            if (r7 < 0) goto L56
            com.google.android.material.datepicker.Month r2 = r5.f13361f
            int r3 = r2.f13356j
            if (r7 < r3) goto L2e
            goto L56
        L2e:
            r8 = 1
            int r7 = r7 + r8
            r0.setTag(r2)
            android.content.res.Resources r2 = r0.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            java.util.Locale r2 = r2.locale
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)
            r3[r1] = r4
            java.lang.String r4 = "%d"
            java.lang.String r2 = java.lang.String.format(r2, r4, r3)
            r0.setText(r2)
            r0.setVisibility(r1)
            r0.setEnabled(r8)
            r8 = r7
            goto L5e
        L56:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L5e:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L65
            return r0
        L65:
            long r6 = r6.longValue()
            r5.o(r0, r6, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    boolean g(long j8) {
        for (Pair<Long, Long> pair : this.f13362g.k0()) {
            Long l8 = pair.f5909b;
            if (l8 != null && l8.longValue() == j8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f13360m;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i8) {
        return i8 / this.f13361f.f13355i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(int i8) {
        if (i8 % this.f13361f.f13355i == 0) {
            return true;
        }
        return false;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i8) {
        if ((i8 + 1) % this.f13361f.f13355i == 0) {
            return true;
        }
        return false;
    }

    boolean k(long j8) {
        for (Pair<Long, Long> pair : this.f13362g.k0()) {
            Long l8 = pair.f5908a;
            if (l8 != null && l8.longValue() == j8) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m() {
        return (b() + this.f13361f.f13356j) - 1;
    }

    int n(int i8) {
        return (i8 - b()) + 1;
    }

    public void q(MaterialCalendarGridView materialCalendarGridView) {
        for (Long l8 : this.f13363h) {
            p(materialCalendarGridView, l8.longValue());
        }
        DateSelector<?> dateSelector = this.f13362g;
        if (dateSelector != null) {
            for (Long l9 : dateSelector.W0()) {
                p(materialCalendarGridView, l9.longValue());
            }
            this.f13363h = this.f13362g.W0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i8) {
        if (i8 >= b() && i8 <= m()) {
            return true;
        }
        return false;
    }
}
