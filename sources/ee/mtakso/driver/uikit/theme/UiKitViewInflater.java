package ee.mtakso.driver.uikit.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import com.google.android.material.theme.MaterialComponentsViewInflater;
import eu.bolt.android.engine.html.view.DesignHtmlTextView;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UiKitViewInflater.kt */
@Keep
/* loaded from: classes5.dex */
public class UiKitViewInflater extends MaterialComponentsViewInflater {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.theme.MaterialComponentsViewInflater, androidx.appcompat.app.AppCompatViewInflater
    public DesignHtmlTextView createTextView(Context context, AttributeSet attributeSet) {
        Intrinsics.f(context, "context");
        return new DesignHtmlTextView(context, attributeSet, 0, 4, null);
    }
}
