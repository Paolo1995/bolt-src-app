package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class RecyclerViewAccessibilityDelegate extends AccessibilityDelegateCompat {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f7351d;

    /* renamed from: e  reason: collision with root package name */
    private final ItemDelegate f7352e;

    /* loaded from: classes.dex */
    public static class ItemDelegate extends AccessibilityDelegateCompat {

        /* renamed from: d  reason: collision with root package name */
        final RecyclerViewAccessibilityDelegate f7353d;

        /* renamed from: e  reason: collision with root package name */
        private Map<View, AccessibilityDelegateCompat> f7354e = new WeakHashMap();

        public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate recyclerViewAccessibilityDelegate) {
            this.f7353d = recyclerViewAccessibilityDelegate;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean a(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.a(view, accessibilityEvent);
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public AccessibilityNodeProviderCompat b(@NonNull View view) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.b(view);
            }
            return super.b(view);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void f(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!this.f7353d.o() && this.f7353d.f7351d.getLayoutManager() != null) {
                this.f7353d.f7351d.getLayoutManager().X0(view, accessibilityNodeInfoCompat);
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
                if (accessibilityDelegateCompat != null) {
                    accessibilityDelegateCompat.g(view, accessibilityNodeInfoCompat);
                    return;
                } else {
                    super.g(view, accessibilityNodeInfoCompat);
                    return;
                }
            }
            super.g(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void h(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean i(@NonNull ViewGroup viewGroup, @NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(viewGroup);
            if (accessibilityDelegateCompat != null) {
                return accessibilityDelegateCompat.i(viewGroup, view, accessibilityEvent);
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean j(View view, int i8, Bundle bundle) {
            if (!this.f7353d.o() && this.f7353d.f7351d.getLayoutManager() != null) {
                AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
                if (accessibilityDelegateCompat != null) {
                    if (accessibilityDelegateCompat.j(view, i8, bundle)) {
                        return true;
                    }
                } else if (super.j(view, i8, bundle)) {
                    return true;
                }
                return this.f7353d.f7351d.getLayoutManager().r1(view, i8, bundle);
            }
            return super.j(view, i8, bundle);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void l(@NonNull View view, int i8) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.l(view, i8);
            } else {
                super.l(view, i8);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void m(@NonNull View view, @NonNull AccessibilityEvent accessibilityEvent) {
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.f7354e.get(view);
            if (accessibilityDelegateCompat != null) {
                accessibilityDelegateCompat.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public AccessibilityDelegateCompat n(View view) {
            return this.f7354e.remove(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(View view) {
            AccessibilityDelegateCompat n8 = ViewCompat.n(view);
            if (n8 != null && n8 != this) {
                this.f7354e.put(view, n8);
            }
        }
    }

    public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView recyclerView) {
        this.f7351d = recyclerView;
        AccessibilityDelegateCompat n8 = n();
        if (n8 != null && (n8 instanceof ItemDelegate)) {
            this.f7352e = (ItemDelegate) n8;
        } else {
            this.f7352e = new ItemDelegate(this);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !o()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().T0(accessibilityEvent);
            }
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.g(view, accessibilityNodeInfoCompat);
        if (!o() && this.f7351d.getLayoutManager() != null) {
            this.f7351d.getLayoutManager().V0(accessibilityNodeInfoCompat);
        }
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public boolean j(View view, int i8, Bundle bundle) {
        if (super.j(view, i8, bundle)) {
            return true;
        }
        if (!o() && this.f7351d.getLayoutManager() != null) {
            return this.f7351d.getLayoutManager().p1(i8, bundle);
        }
        return false;
    }

    @NonNull
    public AccessibilityDelegateCompat n() {
        return this.f7352e;
    }

    boolean o() {
        return this.f7351d.r0();
    }
}
