package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
abstract class PickerFragment<S> extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    protected final LinkedHashSet<OnSelectionChangedListener<S>> f13376f = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return this.f13376f.add(onSelectionChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        this.f13376f.clear();
    }
}
