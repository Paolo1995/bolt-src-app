package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MenuHostHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f5943a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<MenuProvider> f5944b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<MenuProvider, LifecycleContainer> f5945c = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LifecycleContainer {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f5946a;

        /* renamed from: b  reason: collision with root package name */
        private LifecycleEventObserver f5947b;

        LifecycleContainer(@NonNull Lifecycle lifecycle, @NonNull LifecycleEventObserver lifecycleEventObserver) {
            this.f5946a = lifecycle;
            this.f5947b = lifecycleEventObserver;
            lifecycle.a(lifecycleEventObserver);
        }

        void a() {
            this.f5946a.c(this.f5947b);
            this.f5947b = null;
        }
    }

    public MenuHostHelper(@NonNull Runnable runnable) {
        this.f5943a = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Lifecycle.State state, MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.f(state)) {
            c(menuProvider);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            l(menuProvider);
        } else if (event == Lifecycle.Event.a(state)) {
            this.f5944b.remove(menuProvider);
            this.f5943a.run();
        }
    }

    public void c(@NonNull MenuProvider menuProvider) {
        this.f5944b.add(menuProvider);
        this.f5943a.run();
    }

    public void d(@NonNull final MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner) {
        c(menuProvider);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.f5945c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f5945c.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.this.f(menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    @SuppressLint({"LambdaLast"})
    public void e(@NonNull final MenuProvider menuProvider, @NonNull LifecycleOwner lifecycleOwner, @NonNull final Lifecycle.State state) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        LifecycleContainer remove = this.f5945c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f5945c.put(menuProvider, new LifecycleContainer(lifecycle, new LifecycleEventObserver() { // from class: androidx.core.view.b
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                MenuHostHelper.this.g(state, menuProvider, lifecycleOwner2, event);
            }
        }));
    }

    public void h(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        Iterator<MenuProvider> it = this.f5944b.iterator();
        while (it.hasNext()) {
            it.next().onCreateMenu(menu, menuInflater);
        }
    }

    public void i(@NonNull Menu menu) {
        Iterator<MenuProvider> it = this.f5944b.iterator();
        while (it.hasNext()) {
            it.next().onMenuClosed(menu);
        }
    }

    public boolean j(@NonNull MenuItem menuItem) {
        Iterator<MenuProvider> it = this.f5944b.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void k(@NonNull Menu menu) {
        Iterator<MenuProvider> it = this.f5944b.iterator();
        while (it.hasNext()) {
            it.next().onPrepareMenu(menu);
        }
    }

    public void l(@NonNull MenuProvider menuProvider) {
        this.f5944b.remove(menuProvider);
        LifecycleContainer remove = this.f5945c.remove(menuProvider);
        if (remove != null) {
            remove.a();
        }
        this.f5943a.run();
    }
}
