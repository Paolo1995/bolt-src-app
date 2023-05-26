package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<Intent> f5667f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private final Context f5668g;

    /* loaded from: classes.dex */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    private TaskStackBuilder(Context context) {
        this.f5668g = context;
    }

    @NonNull
    public static TaskStackBuilder g(@NonNull Context context) {
        return new TaskStackBuilder(context);
    }

    @NonNull
    public TaskStackBuilder b(@NonNull Intent intent) {
        this.f5667f.add(intent);
        return this;
    }

    @NonNull
    public TaskStackBuilder d(@NonNull Activity activity) {
        Intent intent;
        if (activity instanceof SupportParentable) {
            intent = ((SupportParentable) activity).getSupportParentActivityIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = NavUtils.a(activity);
        }
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(this.f5668g.getPackageManager());
            }
            f(component);
            b(intent);
        }
        return this;
    }

    @NonNull
    public TaskStackBuilder f(@NonNull ComponentName componentName) {
        int size = this.f5667f.size();
        try {
            Intent b8 = NavUtils.b(this.f5668g, componentName);
            while (b8 != null) {
                this.f5667f.add(size, b8);
                b8 = NavUtils.b(this.f5668g, b8.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e8) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e8);
        }
    }

    public void i() {
        k(null);
    }

    @Override // java.lang.Iterable
    @NonNull
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f5667f.iterator();
    }

    public void k(Bundle bundle) {
        if (!this.f5667f.isEmpty()) {
            Intent[] intentArr = (Intent[]) this.f5667f.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (!ContextCompat.startActivities(this.f5668g, intentArr, bundle)) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(268435456);
                this.f5668g.startActivity(intent);
                return;
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
