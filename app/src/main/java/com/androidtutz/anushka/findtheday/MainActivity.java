package com.androidtutz.anushka.findtheday;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidtutz.anushka.findtheday.app.MyApp;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements DayFragment.OnFragmentInteractionListener {

    private EditText enteredValue;
    private Button viewButton;
    private int input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredValue = (EditText) findViewById(R.id.etIndex);
        viewButton = (Button) findViewById(R.id.btnView);

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!enteredValue.getText().toString().equals("")) {

                    input = Integer.parseInt(enteredValue.getText().toString());
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    DayFragment dayFragment = DayFragment.newInstance(input);
                    dayFragment.show(fragmentManager, "Sample Fragment");
                }

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    /**
     * 1.Create Files, App, Component(Interface), Module
     * 2.ChooserModule:
     * -Module annotation
     * -Provide DayChooser Module, with PROVIDE ANNOTATION & SINGLETON (IF SAME OBJECT NEEDS to be used): provideDayChooser(new DayChoooser)
     * 3.ApplicationComponent::
     * -Annotation: SINGLETON & COMPONENT
     * -@Component; pass in all modules that will be linked to interface
     * -Create inject method which will need to have a parameter of the type of class where it will be injected
     * 2.MyApp: extends Application
     * -Create instance of MyApp & Component
     * -Create Getter for variables
     * -Implement onCreate method which is inherit by Application implementation
     * -assign myApp variable
     * -Create Dagger implementation:
     *      applicationComponent=DaggerApplicationComponent.builder()
                                .chooserModule(new ChooserModule())
                                .build();
     *3.Inject object into MainActivity(desired activity)
     * -Use Annotation @Inject
     * -DayChooser dayChooser;
     *4. Create instance of class to get the object which was created in the other classes
     * (App: static does not need to be instantiated)(get the component)(use inject method from interface)(pass the activity)
     * App.getApp().getMemberAppComponent().inject(this);
     *4. Everywhere you use dayChooser, it ill  use the same object and will not create a new instance
     */
}
