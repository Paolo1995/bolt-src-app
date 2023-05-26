package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class CustomTabsServiceConnection implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private Context f2364a;

    public abstract void a(@NonNull ComponentName componentName, @NonNull CustomTabsClient customTabsClient);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@NonNull Context context) {
        this.f2364a = context;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(@NonNull ComponentName componentName, @NonNull IBinder iBinder) {
        if (this.f2364a != null) {
            a(componentName, new CustomTabsClient(ICustomTabsService.Stub.y(iBinder), componentName, this.f2364a) { // from class: androidx.browser.customtabs.CustomTabsServiceConnection.1
            });
            return;
        }
        throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
    }
}
