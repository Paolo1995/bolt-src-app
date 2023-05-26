package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    private final MaterialCalendar<?> f13382d;

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: u  reason: collision with root package name */
        final TextView f13385u;

        ViewHolder(TextView textView) {
            super(textView);
            this.f13385u = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.f13382d = materialCalendar;
    }

    @NonNull
    private View.OnClickListener Q(final int i8) {
        return new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YearGridAdapter.this.f13382d.X(YearGridAdapter.this.f13382d.O().f(Month.c(i8, YearGridAdapter.this.f13382d.Q().f13353g)));
                YearGridAdapter.this.f13382d.Y(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int R(int i8) {
        return i8 - this.f13382d.O().n().f13354h;
    }

    int S(int i8) {
        return this.f13382d.O().n().f13354h + i8;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: T */
    public void E(@NonNull ViewHolder viewHolder, int i8) {
        CalendarItemStyle calendarItemStyle;
        int S = S(i8);
        viewHolder.f13385u.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(S)));
        TextView textView = viewHolder.f13385u;
        textView.setContentDescription(DateStrings.e(textView.getContext(), S));
        CalendarStyle P = this.f13382d.P();
        Calendar i9 = UtcDates.i();
        if (i9.get(1) == S) {
            calendarItemStyle = P.f13270f;
        } else {
            calendarItemStyle = P.f13268d;
        }
        for (Long l8 : this.f13382d.R().W0()) {
            i9.setTimeInMillis(l8.longValue());
            if (i9.get(1) == S) {
                calendarItemStyle = P.f13269e;
            }
        }
        calendarItemStyle.d(viewHolder.f13385u);
        viewHolder.f13385u.setOnClickListener(Q(S));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: U */
    public ViewHolder G(@NonNull ViewGroup viewGroup, int i8) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int r() {
        return this.f13382d.O().o();
    }
}
