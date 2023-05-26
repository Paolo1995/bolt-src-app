package ee.mtakso.driver.ui.base.statistics;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;

/* loaded from: classes3.dex */
public abstract class BaseStatisticsFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    private boolean f26333f;

    protected abstract void D();

    public void E(boolean z7) {
        this.f26333f = z7;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        D();
    }
}
