package com.example.gerardo.project6_fragments;

/**
 * Created by Gerardo on 29/02/2016.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TopSectionFragment extends Fragment {

    //3. Al hacer la instancia a la clase, se crean los EditText
    private static EditText topTextInput;
    private static EditText bottomTextInput;

    //4. Se crea un activityComander que será del tipo TopSectionListener (interface)
    TopSectionListener activityComander;

    //5. Se crea la interfaz TopSectionListener con un método createMeme() que aceptará dos String para editar los TextView de la imagen
    public interface TopSectionListener {
        void createMeme(String top, String bottom);
    }

    //6. Se hace una sobrecarga al método onAttach para agregar el listener al MainActivity (?)
    //   Se hace esto para evitar en la medida de lo posible que los fragments se comuniquen directamente
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            activityComander = (TopSectionListener) context;
        } catch(ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    //7. Se crea la vista (el fragment) junto con los widgets y el listener del boton, el cuál llamará al método buttonClicked()
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment,container,false);

        topTextInput = (EditText) view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button = (Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buttonClicked(v);
                    }
                }
        );

        return view;
    }

    //8. En caso de que se realice el click en el botón, se llamará al método createMeme() DESDE la MainActivity (por el activityComander)
    //   (volver a la MainActivity)
    public void buttonClicked(View view) {
        activityComander.createMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }
}
