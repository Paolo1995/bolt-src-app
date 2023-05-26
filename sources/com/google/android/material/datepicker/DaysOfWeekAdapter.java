package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes.dex */
class DaysOfWeekAdapter extends BaseAdapter {

    /* renamed from: i  reason: collision with root package name */
    private static final int f13274i;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final Calendar f13275f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13276g;

    /* renamed from: h  reason: collision with root package name */
    private final int f13277h;

    static {
        int i8;
        if (Build.VERSION.SDK_INT >= 26) {
            i8 = 4;
        } else {
            i8 = 1;
        }
        f13274i = i8;
    }

    public DaysOfWeekAdapter() {
        Calendar k8 = UtcDates.k();
        this.f13275f = k8;
        this.f13276g = k8.getMaximum(7);
        this.f13277h = k8.getFirstDayOfWeek();
    }

    private int b(int i8) {
        int i9 = i8 + this.f13277h;
        int i10 = this.f13276g;
        if (i9 > i10) {
            return i9 - i10;
        }
        return i9;
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public Integer getItem(int i8) {
        if (i8 >= this.f13276g) {
            return null;
        }
        return Integer.valueOf(b(i8));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13276g;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i8) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i8, View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f13275f.set(7, b(i8));
        textView.setText(this.f13275f.getDisplayName(7, f13274i, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.f13275f.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public DaysOfWeekAdapter(int i8) {
        Calendar k8 = UtcDates.k();
        this.f13275f = k8;
        this.f13276g = k8.getMaximum(7);
        this.f13277h = i8;
    }
}
