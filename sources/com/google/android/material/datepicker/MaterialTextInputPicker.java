package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {

    /* renamed from: g  reason: collision with root package name */
    private int f13348g;

    /* renamed from: h  reason: collision with root package name */
    private DateSelector<S> f13349h;

    /* renamed from: i  reason: collision with root package name */
    private CalendarConstraints f13350i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static <T> MaterialTextInputPicker<T> F(DateSelector<T> dateSelector, int i8, @NonNull CalendarConstraints calendarConstraints) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i8);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f13348g = bundle.getInt("THEME_RES_ID_KEY");
        this.f13349h = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f13350i = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f13349h.I0(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f13348g)), viewGroup, bundle, this.f13350i, new OnSelectionChangedListener<S>() { // from class: com.google.android.material.datepicker.MaterialTextInputPicker.1
            @Override // com.google.android.material.datepicker.OnSelectionChangedListener
            public void a(S s7) {
                Iterator<OnSelectionChangedListener<S>> it = MaterialTextInputPicker.this.f13376f.iterator();
                while (it.hasNext()) {
                    it.next().a(s7);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f13348g);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f13349h);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f13350i);
    }
}
