package com.androidtutz.anushka.findtheday.components;

import com.androidtutz.anushka.findtheday.DayFragment;
import com.androidtutz.anushka.findtheday.modules.ChooserModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = ChooserModule.class)
public interface ApplicationComponent {

    void inject(DayFragment dayFragment);
}
