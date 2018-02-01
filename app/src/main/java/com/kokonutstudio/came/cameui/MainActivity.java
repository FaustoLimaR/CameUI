package com.kokonutstudio.came.cameui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kokonutstudio.came.cameui.customView.ExpandableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

   /* @BindView(R.id.layoutHeaderDetalleSocio)
    View headerDetalleSocio;
    @BindView(R.id.expandable_layout)
    ExpandableLayout expandableLayout;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informacion_grupo_item);
        ButterKnife.bind(this);
        // headerDetalleSocio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
     /*   if (expandableLayout.isExpanded()) {
            expandableLayout.collapse();
        } else {
            expandableLayout.expand();
        }*/
    }
}
