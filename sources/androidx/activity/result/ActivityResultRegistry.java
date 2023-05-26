package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public abstract class ActivityResultRegistry {

    /* renamed from: a  reason: collision with root package name */
    private Random f782a = new Random();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, String> f783b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final Map<String, Integer> f784c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, LifecycleContainer> f785d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    ArrayList<String> f786e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    final transient Map<String, CallbackAndContract<?>> f787f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    final Map<String, Object> f788g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    final Bundle f789h = new Bundle();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CallbackAndContract<O> {

        /* renamed from: a  reason: collision with root package name */
        final ActivityResultCallback<O> f800a;

        /* renamed from: b  reason: collision with root package name */
        final ActivityResultContract<?, O> f801b;

        CallbackAndContract(ActivityResultCallback<O> activityResultCallback, ActivityResultContract<?, O> activityResultContract) {
            this.f800a = activityResultCallback;
            this.f801b = activityResultContract;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f802a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<LifecycleEventObserver> f803b = new ArrayList<>();

        LifecycleContainer(@NonNull Lifecycle lifecycle) {
            this.f802a = lifecycle;
        }

        void a(@NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.f802a.a(lifecycleEventObserver);
            this.f803b.add(lifecycleEventObserver);
        }

        void b() {
            Iterator<LifecycleEventObserver> it = this.f803b.iterator();
            while (it.hasNext()) {
                this.f802a.c(it.next());
            }
            this.f803b.clear();
        }
    }

    private void a(int i8, String str) {
        this.f783b.put(Integer.valueOf(i8), str);
        this.f784c.put(str, Integer.valueOf(i8));
    }

    private <O> void d(String str, int i8, Intent intent, CallbackAndContract<O> callbackAndContract) {
        if (callbackAndContract != null && callbackAndContract.f800a != null && this.f786e.contains(str)) {
            callbackAndContract.f800a.onActivityResult(callbackAndContract.f801b.parseResult(i8, intent));
            this.f786e.remove(str);
            return;
        }
        this.f788g.remove(str);
        this.f789h.putParcelable(str, new ActivityResult(i8, intent));
    }

    private int e() {
        int nextInt = this.f782a.nextInt(2147418112);
        while (true) {
            int i8 = nextInt + 65536;
            if (this.f783b.containsKey(Integer.valueOf(i8))) {
                nextInt = this.f782a.nextInt(2147418112);
            } else {
                return i8;
            }
        }
    }

    private void k(String str) {
        if (this.f784c.get(str) != null) {
            return;
        }
        a(e(), str);
    }

    public final boolean b(int i8, int i9, Intent intent) {
        String str = this.f783b.get(Integer.valueOf(i8));
        if (str == null) {
            return false;
        }
        d(str, i9, intent, this.f787f.get(str));
        return true;
    }

    public final <O> boolean c(int i8, @SuppressLint({"UnknownNullness"}) O o8) {
        ActivityResultCallback<?> activityResultCallback;
        String str = this.f783b.get(Integer.valueOf(i8));
        if (str == null) {
            return false;
        }
        CallbackAndContract<?> callbackAndContract = this.f787f.get(str);
        if (callbackAndContract != null && (activityResultCallback = callbackAndContract.f800a) != null) {
            if (this.f786e.remove(str)) {
                activityResultCallback.onActivityResult(o8);
                return true;
            }
            return true;
        }
        this.f789h.remove(str);
        this.f788g.put(str, o8);
        return true;
    }

    public abstract <I, O> void f(int i8, @NonNull ActivityResultContract<I, O> activityResultContract, @SuppressLint({"UnknownNullness"}) I i9, ActivityOptionsCompat activityOptionsCompat);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList != null && integerArrayList != null) {
            this.f786e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            this.f782a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
            this.f789h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            for (int i8 = 0; i8 < stringArrayList.size(); i8++) {
                String str = stringArrayList.get(i8);
                if (this.f784c.containsKey(str)) {
                    Integer remove = this.f784c.remove(str);
                    if (!this.f789h.containsKey(str)) {
                        this.f783b.remove(remove);
                    }
                }
                a(integerArrayList.get(i8).intValue(), stringArrayList.get(i8));
            }
        }
    }

    public final void h(@NonNull Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.f784c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.f784c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.f786e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f789h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f782a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    public final <I, O> ActivityResultLauncher<I> i(@NonNull final String str, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull ActivityResultCallback<O> activityResultCallback) {
        k(str);
        this.f787f.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
        if (this.f788g.containsKey(str)) {
            Object obj = this.f788g.get(str);
            this.f788g.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f789h.getParcelable(str);
        if (activityResult != null) {
            this.f789h.remove(str);
            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.b(), activityResult.a()));
        }
        return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.3
            @Override // androidx.activity.result.ActivityResultLauncher
            @NonNull
            public ActivityResultContract<I, ?> getContract() {
                return activityResultContract;
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void launch(I i8, ActivityOptionsCompat activityOptionsCompat) {
                Integer num = ActivityResultRegistry.this.f784c.get(str);
                if (num != null) {
                    ActivityResultRegistry.this.f786e.add(str);
                    try {
                        ActivityResultRegistry.this.f(num.intValue(), activityResultContract, i8, activityOptionsCompat);
                        return;
                    } catch (Exception e8) {
                        ActivityResultRegistry.this.f786e.remove(str);
                        throw e8;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + i8 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }

            @Override // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.l(str);
            }
        };
    }

    @NonNull
    public final <I, O> ActivityResultLauncher<I> j(@NonNull final String str, @NonNull LifecycleOwner lifecycleOwner, @NonNull final ActivityResultContract<I, O> activityResultContract, @NonNull final ActivityResultCallback<O> activityResultCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (!lifecycle.b().a(Lifecycle.State.STARTED)) {
            k(str);
            LifecycleContainer lifecycleContainer = this.f785d.get(str);
            if (lifecycleContainer == null) {
                lifecycleContainer = new LifecycleContainer(lifecycle);
            }
            lifecycleContainer.a(new LifecycleEventObserver() { // from class: androidx.activity.result.ActivityResultRegistry.1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner2, @NonNull Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_START.equals(event)) {
                        ActivityResultRegistry.this.f787f.put(str, new CallbackAndContract<>(activityResultCallback, activityResultContract));
                        if (ActivityResultRegistry.this.f788g.containsKey(str)) {
                            Object obj = ActivityResultRegistry.this.f788g.get(str);
                            ActivityResultRegistry.this.f788g.remove(str);
                            activityResultCallback.onActivityResult(obj);
                        }
                        ActivityResult activityResult = (ActivityResult) ActivityResultRegistry.this.f789h.getParcelable(str);
                        if (activityResult != null) {
                            ActivityResultRegistry.this.f789h.remove(str);
                            activityResultCallback.onActivityResult(activityResultContract.parseResult(activityResult.b(), activityResult.a()));
                        }
                    } else if (Lifecycle.Event.ON_STOP.equals(event)) {
                        ActivityResultRegistry.this.f787f.remove(str);
                    } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
                        ActivityResultRegistry.this.l(str);
                    }
                }
            });
            this.f785d.put(str, lifecycleContainer);
            return new ActivityResultLauncher<I>() { // from class: androidx.activity.result.ActivityResultRegistry.2
                @Override // androidx.activity.result.ActivityResultLauncher
                @NonNull
                public ActivityResultContract<I, ?> getContract() {
                    return activityResultContract;
                }

                @Override // androidx.activity.result.ActivityResultLauncher
                public void launch(I i8, ActivityOptionsCompat activityOptionsCompat) {
                    Integer num = ActivityResultRegistry.this.f784c.get(str);
                    if (num != null) {
                        ActivityResultRegistry.this.f786e.add(str);
                        try {
                            ActivityResultRegistry.this.f(num.intValue(), activityResultContract, i8, activityOptionsCompat);
                            return;
                        } catch (Exception e8) {
                            ActivityResultRegistry.this.f786e.remove(str);
                            throw e8;
                        }
                    }
                    throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + i8 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                }

                @Override // androidx.activity.result.ActivityResultLauncher
                public void unregister() {
                    ActivityResultRegistry.this.l(str);
                }
            };
        }
        throw new IllegalStateException("LifecycleOwner " + lifecycleOwner + " is attempting to register while current state is " + lifecycle.b() + ". LifecycleOwners must call register before they are STARTED.");
    }

    final void l(@NonNull String str) {
        Integer remove;
        if (!this.f786e.contains(str) && (remove = this.f784c.remove(str)) != null) {
            this.f783b.remove(remove);
        }
        this.f787f.remove(str);
        if (this.f788g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f788g.get(str));
            this.f788g.remove(str);
        }
        if (this.f789h.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f789h.getParcelable(str));
            this.f789h.remove(str);
        }
        LifecycleContainer lifecycleContainer = this.f785d.get(str);
        if (lifecycleContainer != null) {
            lifecycleContainer.b();
            this.f785d.remove(str);
        }
    }
}
