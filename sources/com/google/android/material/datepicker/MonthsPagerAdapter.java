package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final CalendarConstraints f13367d;

    /* renamed from: e  reason: collision with root package name */
    private final DateSelector<?> f13368e;

    /* renamed from: f  reason: collision with root package name */
    private final DayViewDecorator f13369f;

    /* renamed from: g  reason: collision with root package name */
    private final MaterialCalendar.OnDayClickListener f13370g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13371h;

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        final TextView f13374u;

        /* renamed from: v  reason: collision with root package name */
        final MaterialCalendarGridView f13375v;

        ViewHolder(@NonNull LinearLayout linearLayout, boolean z7) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
            this.f13374u = textView;
            ViewCompat.t0(textView, true);
            this.f13375v = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
            if (!z7) {
                textView.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.OnDayClickListener onDayClickListener) {
        int i8;
        Month n8 = calendarConstraints.n();
        Month h8 = calendarConstraints.h();
        Month l8 = calendarConstraints.l();
        if (n8.compareTo(l8) <= 0) {
            if (l8.compareTo(h8) <= 0) {
                int S = MonthAdapter.f13359l * MaterialCalendar.S(context);
                if (MaterialDatePicker.U(context)) {
                    i8 = MaterialCalendar.S(context);
                } else {
                    i8 = 0;
                }
                this.f13371h = S + i8;
                this.f13367d = calendarConstraints;
                this.f13368e = dateSelector;
                this.f13369f = dayViewDecorator;
                this.f13370g = onDayClickListener;
                N(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public Month Q(int i8) {
        return this.f13367d.n().r(i8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CharSequence R(int i8) {
        return Q(i8).p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int S(@NonNull Month month) {
        return this.f13367d.n().s(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: T */
    public void E(@NonNull ViewHolder viewHolder, int i8) {
        Month r7 = this.f13367d.n().r(i8);
        viewHolder.f13374u.setText(r7.p());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.f13375v.findViewById(R$id.month_grid);
        if (materialCalendarGridView.getAdapter2() != null && r7.equals(materialCalendarGridView.getAdapter2().f13361f)) {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter2().q(materialCalendarGridView);
        } else {
            MonthAdapter monthAdapter = new MonthAdapter(r7, this.f13368e, this.f13367d, this.f13369f);
            materialCalendarGridView.setNumColumns(r7.f13355i);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i9, long j8) {
                if (materialCalendarGridView.getAdapter2().r(i9)) {
                    MonthsPagerAdapter.this.f13370g.a(materialCalendarGridView.getAdapter2().getItem(i9).longValue());
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: U */
    public ViewHolder G(@NonNull ViewGroup viewGroup, int i8) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.U(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f13371h));
            return new ViewHolder(linearLayout, true);
        }
        return new ViewHolder(linearLayout, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f13367d.j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long s(int i8) {
        return this.f13367d.n().r(i8).q();
    }
}
