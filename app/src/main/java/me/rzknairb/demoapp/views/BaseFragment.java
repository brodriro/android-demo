package me.rzknairb.demoapp.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleScopeProvider;

import dagger.android.support.DaggerFragment;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public abstract class BaseFragment extends DaggerFragment implements LifecycleScopeProvider<BaseFragment.FragmentEvent> {
    public enum FragmentEvent {
        CREATE,
        START,
        RESUME,
        PAUSE,
        STOP,
        DESTROY
    }

    private static final CorrespondingEventsFunction<BaseFragment.FragmentEvent> CORRESPONDING_EVENTS = fragmentEvent -> {
        switch (fragmentEvent) {
            case CREATE:
                return BaseFragment.FragmentEvent.DESTROY;
            case START:
                return BaseFragment.FragmentEvent.STOP;
            case RESUME:
                return BaseFragment.FragmentEvent.PAUSE;
            case PAUSE:
                return BaseFragment.FragmentEvent.STOP;
            case STOP:
                return BaseFragment.FragmentEvent.DESTROY;
            default:
                throw new LifecycleEndedException("Cannot bind to Fragment lifecycle after destroy.");
        }
    };

    private final BehaviorSubject<BaseFragment.FragmentEvent> lifecycleEvents = BehaviorSubject.create();

    @Override
    public Observable<FragmentEvent> lifecycle() {
        return lifecycleEvents.hide();
    }

    @Override
    public CorrespondingEventsFunction<FragmentEvent> correspondingEvents() {
        return CORRESPONDING_EVENTS;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycleEvents.onNext(FragmentEvent.CREATE);
    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycleEvents.onNext(FragmentEvent.START);
    }

    @Override
    public void onResume() {
        super.onResume();
        lifecycleEvents.onNext(FragmentEvent.RESUME);
    }

    @Override
    public void onPause() {
        super.onPause();
        lifecycleEvents.onNext(FragmentEvent.PAUSE);
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycleEvents.onNext(FragmentEvent.STOP);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycleEvents.onNext(FragmentEvent.DESTROY);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override
    public FragmentEvent peekLifecycle() {
        return lifecycleEvents.getValue();
    }
}
