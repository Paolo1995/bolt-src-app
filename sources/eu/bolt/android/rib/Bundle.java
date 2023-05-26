package eu.bolt.android.rib;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.io.Serializable;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public class Bundle {

    /* renamed from: b  reason: collision with root package name */
    private static Provider<Bundle> f37046b;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final android.os.Bundle f37047a;

    public Bundle(android.os.Bundle bundle) {
        if (bundle == null) {
            this.f37047a = new android.os.Bundle();
        } else {
            this.f37047a = bundle;
        }
    }

    public static Bundle a() {
        Provider<Bundle> provider = f37046b;
        if (provider != null) {
            return provider.get();
        }
        return new Bundle(null);
    }

    public boolean b(String str, boolean z7) {
        return this.f37047a.getBoolean(str, z7);
    }

    public Bundle c(String str) {
        Parcelable parcelable = this.f37047a.getParcelable(str);
        if (parcelable != null) {
            return new Bundle((android.os.Bundle) parcelable);
        }
        return null;
    }

    public String d(String str) {
        return this.f37047a.getString(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.os.Bundle e() {
        return this.f37047a;
    }

    public void f(String str, boolean z7) {
        this.f37047a.putBoolean(str, z7);
    }

    public void g(String str, Bundle bundle) {
        if (bundle != null) {
            this.f37047a.putParcelable(str, bundle.e());
        } else {
            this.f37047a.putParcelable(str, null);
        }
    }

    public void h(String str, Serializable serializable) {
        this.f37047a.putSerializable(str, serializable);
    }

    public void i(String str, String str2) {
        this.f37047a.putString(str, str2);
    }

    public void j(Bundle bundle) {
        this.f37047a.clear();
        this.f37047a.putAll(bundle.f37047a);
    }

    public String toString() {
        return String.valueOf(this.f37047a);
    }
}
