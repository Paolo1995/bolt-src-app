package ee.mtakso.driver.uicore.components.views.debug;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import ee.mtakso.driver.uicore.R$id;
import java.util.Map;

/* compiled from: DebugItemRowView.kt */
/* loaded from: classes5.dex */
public final class DebugItemRowView extends LinearLayoutCompat {

    /* renamed from: u  reason: collision with root package name */
    public Map<Integer, View> f35570u;

    public final CharSequence getValue() {
        return ((AppCompatTextView) z(R$id.f34599m)).getText();
    }

    public final void setTitle(CharSequence charSequence) {
        ((AppCompatTextView) z(R$id.D0)).setText(charSequence);
    }

    public final void setValue(CharSequence charSequence) {
        ((AppCompatTextView) z(R$id.f34599m)).setText(charSequence);
    }

    public View z(int i8) {
        Map<Integer, View> map = this.f35570u;
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
