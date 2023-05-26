package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.R$styleable;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    final FragmentManager mFragmentManager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        final FragmentStateManager createOrGetFragmentStateManager;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.mFragmentManager);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, Name.LABEL);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f6630a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(R$styleable.f6631b);
            }
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.f6632c, -1);
            String string = obtainStyledAttributes.getString(R$styleable.f6633d);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            Fragment findFragmentById = resourceId != -1 ? this.mFragmentManager.findFragmentById(resourceId) : null;
            if (findFragmentById == null && string != null) {
                findFragmentById = this.mFragmentManager.findFragmentByTag(string);
            }
            if (findFragmentById == null && id != -1) {
                findFragmentById = this.mFragmentManager.findFragmentById(id);
            }
            if (findFragmentById == null) {
                findFragmentById = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
                findFragmentById.mFromLayout = true;
                findFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
                findFragmentById.mContainerId = id;
                findFragmentById.mTag = string;
                findFragmentById.mInLayout = true;
                FragmentManager fragmentManager = this.mFragmentManager;
                findFragmentById.mFragmentManager = fragmentManager;
                findFragmentById.mHost = fragmentManager.getHost();
                findFragmentById.onInflate(this.mFragmentManager.getHost().getContext(), attributeSet, findFragmentById.mSavedFragmentState);
                createOrGetFragmentStateManager = this.mFragmentManager.addFragment(findFragmentById);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Fragment " + findFragmentById + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                }
            } else if (!findFragmentById.mInLayout) {
                findFragmentById.mInLayout = true;
                FragmentManager fragmentManager2 = this.mFragmentManager;
                findFragmentById.mFragmentManager = fragmentManager2;
                findFragmentById.mHost = fragmentManager2.getHost();
                findFragmentById.onInflate(this.mFragmentManager.getHost().getContext(), attributeSet, findFragmentById.mSavedFragmentState);
                createOrGetFragmentStateManager = this.mFragmentManager.createOrGetFragmentStateManager(findFragmentById);
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "Retained Fragment " + findFragmentById + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                }
            } else {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            ViewGroup viewGroup = (ViewGroup) view;
            FragmentStrictMode.onFragmentTagUsage(findFragmentById, viewGroup);
            findFragmentById.mContainer = viewGroup;
            createOrGetFragmentStateManager.moveToExpectedState();
            createOrGetFragmentStateManager.ensureInflatedView();
            View view2 = findFragmentById.mView;
            if (view2 != null) {
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (findFragmentById.mView.getTag() == null) {
                    findFragmentById.mView.setTag(string);
                }
                findFragmentById.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view3) {
                        Fragment fragment = createOrGetFragmentStateManager.getFragment();
                        createOrGetFragmentStateManager.moveToExpectedState();
                        SpecialEffectsController.getOrCreateController((ViewGroup) fragment.mView.getParent(), FragmentLayoutInflaterFactory.this.mFragmentManager).forceCompleteAllOperations();
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view3) {
                    }
                });
                return findFragmentById.mView;
            }
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        return null;
    }
}
