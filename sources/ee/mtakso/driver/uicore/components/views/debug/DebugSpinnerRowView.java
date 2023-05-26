package ee.mtakso.driver.uicore.components.views.debug;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import ee.mtakso.driver.uicore.R$id;
import ee.mtakso.driver.uicore.R$layout;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DebugSpinnerRowView.kt */
/* loaded from: classes5.dex */
public final class DebugSpinnerRowView extends LinearLayoutCompat implements AdapterView.OnItemSelectedListener {

    /* renamed from: x  reason: collision with root package name */
    private static final Companion f35571x = new Companion(null);

    /* renamed from: u  reason: collision with root package name */
    private Function1<? super String, Unit> f35572u;

    /* renamed from: v  reason: collision with root package name */
    private int f35573v;

    /* renamed from: w  reason: collision with root package name */
    public Map<Integer, View> f35574w;

    /* compiled from: DebugSpinnerRowView.kt */
    /* loaded from: classes5.dex */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Function1<String, Unit> getOnItemClickListener() {
        return this.f35572u;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i8, long j8) {
        if (this.f35573v != i8) {
            SpinnerAdapter adapter = ((AppCompatSpinner) z(R$id.spinner)).getAdapter();
            Intrinsics.d(adapter, "null cannot be cast to non-null type android.widget.ArrayAdapter<kotlin.String>");
            String str = (String) ((ArrayAdapter) adapter).getItem(i8);
            if (str == null) {
                return;
            }
            Function1<? super String, Unit> function1 = this.f35572u;
            if (function1 != null) {
                function1.invoke(str);
            }
        }
        this.f35573v = i8;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void setOnItemClickListener(Function1<? super String, Unit> function1) {
        this.f35572u = function1;
    }

    public final void setTitle(CharSequence charSequence) {
        ((AppCompatTextView) z(R$id.D0)).setText(charSequence);
    }

    public final void setValues(String[] values) {
        Intrinsics.f(values, "values");
        ((AppCompatSpinner) z(R$id.spinner)).setAdapter((SpinnerAdapter) new ArrayAdapter(getContext(), R$layout.content_debug_spinner_item, values));
    }

    public View z(int i8) {
        Map<Integer, View> map = this.f35574w;
        View view = map.get(Integer.valueOf(i8));
        if (view == null) {
            View findViewById = findViewById(i8);
            if (findViewById != null) {
                map.put(Integer.valueOf(i8), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }
}
