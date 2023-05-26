package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.google.android.material.internal.MaterialCheckable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class CheckableGroup<T extends MaterialCheckable<T>> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, T> f13527a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f13528b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    private OnCheckedStateChangeListener f13529c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13530d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13531e;

    /* loaded from: classes.dex */
    public interface OnCheckedStateChangeListener {
        void a(@NonNull Set<Integer> set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(@NonNull MaterialCheckable<T> materialCheckable) {
        int id = materialCheckable.getId();
        if (this.f13528b.contains(Integer.valueOf(id))) {
            return false;
        }
        T t7 = this.f13527a.get(Integer.valueOf(k()));
        if (t7 != null) {
            r(t7, false);
        }
        boolean add = this.f13528b.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return add;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        OnCheckedStateChangeListener onCheckedStateChangeListener = this.f13529c;
        if (onCheckedStateChangeListener != null) {
            onCheckedStateChangeListener.a(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(@NonNull MaterialCheckable<T> materialCheckable, boolean z7) {
        int id = materialCheckable.getId();
        if (!this.f13528b.contains(Integer.valueOf(id))) {
            return false;
        }
        if (z7 && this.f13528b.size() == 1 && this.f13528b.contains(Integer.valueOf(id))) {
            materialCheckable.setChecked(true);
            return false;
        }
        boolean remove = this.f13528b.remove(Integer.valueOf(id));
        if (materialCheckable.isChecked()) {
            materialCheckable.setChecked(false);
        }
        return remove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e(T t7) {
        this.f13527a.put(Integer.valueOf(t7.getId()), t7);
        if (t7.isChecked()) {
            g(t7);
        }
        t7.setInternalOnCheckedChangeListener(new MaterialCheckable.OnCheckedChangeListener<T>() { // from class: com.google.android.material.internal.CheckableGroup.1
            @Override // com.google.android.material.internal.MaterialCheckable.OnCheckedChangeListener
            /* renamed from: b */
            public void a(T t8, boolean z7) {
                if (z7) {
                    if (!CheckableGroup.this.g(t8)) {
                        return;
                    }
                } else {
                    CheckableGroup checkableGroup = CheckableGroup.this;
                    if (!checkableGroup.r(t8, checkableGroup.f13531e)) {
                        return;
                    }
                }
                CheckableGroup.this.m();
            }
        });
    }

    public void f(int i8) {
        T t7 = this.f13527a.get(Integer.valueOf(i8));
        if (t7 != null && g(t7)) {
            m();
        }
    }

    public void h() {
        boolean z7 = !this.f13528b.isEmpty();
        for (T t7 : this.f13527a.values()) {
            r(t7, false);
        }
        if (z7) {
            m();
        }
    }

    @NonNull
    public Set<Integer> i() {
        return new HashSet(this.f13528b);
    }

    @NonNull
    public List<Integer> j(@NonNull ViewGroup viewGroup) {
        Set<Integer> i8 = i();
        ArrayList arrayList = new ArrayList();
        for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
            View childAt = viewGroup.getChildAt(i9);
            if ((childAt instanceof MaterialCheckable) && i8.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public int k() {
        if (this.f13530d && !this.f13528b.isEmpty()) {
            return this.f13528b.iterator().next().intValue();
        }
        return -1;
    }

    public boolean l() {
        return this.f13530d;
    }

    public void n(T t7) {
        t7.setInternalOnCheckedChangeListener(null);
        this.f13527a.remove(Integer.valueOf(t7.getId()));
        this.f13528b.remove(Integer.valueOf(t7.getId()));
    }

    public void o(OnCheckedStateChangeListener onCheckedStateChangeListener) {
        this.f13529c = onCheckedStateChangeListener;
    }

    public void p(boolean z7) {
        this.f13531e = z7;
    }

    public void q(boolean z7) {
        if (this.f13530d != z7) {
            this.f13530d = z7;
            h();
        }
    }
}
