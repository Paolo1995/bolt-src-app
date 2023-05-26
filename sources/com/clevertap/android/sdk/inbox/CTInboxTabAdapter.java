package com.clevertap.android.sdk.inbox;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CTInboxTabAdapter extends FragmentPagerAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment[] f11581a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f11582b;

    public CTInboxTabAdapter(FragmentManager fragmentManager, int i8) {
        super(fragmentManager);
        this.f11582b = new ArrayList();
        this.f11581a = new Fragment[i8];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, String str, int i8) {
        this.f11581a[i8] = fragment;
        this.f11582b.add(str);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.f11581a.length;
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NonNull
    public Fragment getItem(int i8) {
        return this.f11581a[i8];
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i8) {
        return this.f11582b.get(i8);
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i8) {
        Object instantiateItem = super.instantiateItem(viewGroup, i8);
        this.f11581a[i8] = (Fragment) instantiateItem;
        return instantiateItem;
    }
}
