package ee.mtakso.driver.ui.screens.documents_scanner.source;

import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import ee.mtakso.driver.routing.command.NavigationCommand;
import io.reactivex.Observable;
import io.reactivex.Single;

/* compiled from: SourceController.kt */
/* loaded from: classes3.dex */
public interface SourceController {
    Observable<Uri> a();

    Single<NavigationCommand<Fragment>> b();

    boolean c(int i8, int i9, Intent intent);
}
