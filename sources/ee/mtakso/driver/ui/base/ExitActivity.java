package ee.mtakso.driver.ui.base;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExitActivity.kt */
/* loaded from: classes3.dex */
public final class ExitActivity extends AppCompatActivity {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f26230g = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    public Map<Integer, View> f26231f = new LinkedHashMap();

    /* compiled from: ExitActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        finishAndRemoveTask();
    }
}
