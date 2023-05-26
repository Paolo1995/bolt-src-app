package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import java.util.Collection;

/* loaded from: classes.dex */
public interface DateSelector<S> extends Parcelable {
    @NonNull
    String I(@NonNull Context context);

    @NonNull
    View I0(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, @NonNull CalendarConstraints calendarConstraints, @NonNull OnSelectionChangedListener<S> onSelectionChangedListener);

    int O(Context context);

    boolean R0();

    @NonNull
    Collection<Long> W0();

    S b1();

    @NonNull
    String f0(Context context);

    String getError();

    void h1(long j8);

    @NonNull
    Collection<Pair<Long, Long>> k0();
}
