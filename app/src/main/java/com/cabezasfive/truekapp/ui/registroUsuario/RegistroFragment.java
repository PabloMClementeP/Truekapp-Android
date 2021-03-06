package com.cabezasfive.truekapp.ui.registroUsuario;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cabezasfive.truekapp.R;
import com.cabezasfive.truekapp.models.Usuario;
import com.google.firebase.auth.FirebaseUser;

import java.util.Date;


public class RegistroFragment extends Fragment {

    private EditText editTextnombre;
    private EditText editTextapellido;
    private EditText editTextnick;
    private Button btnContinuar;



    private RegistroViewModel registroViewModel;

    // Variables de los datos que se van a registrar
    private String nombre = "";
    private String apellido = "";
    private String nick = "" ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        registroViewModel = new ViewModelProvider(this).get(RegistroViewModel.class);
        registroViewModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if(firebaseUser != null){
                    Toast.makeText(getContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(getView()).navigate(R.id.homeFragment);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_registro01, container, false);

        editTextnombre = view.findViewById(R.id.et_Registro_Nombre);
        editTextapellido = view.findViewById(R.id.et_Registro_Apellido);
        editTextnick = view.findViewById(R.id.et_Registro_NickName);
        btnContinuar = view.findViewById(R.id.btn_GoForm2Registro);

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nombre = editTextnombre.getText().toString();
                apellido = editTextapellido.getText().toString();
                nick = editTextnick.getText().toString();


                if (validarTextos()){
                    String fecha = new Date().toString();
                    Usuario usuario = new Usuario(nombre, apellido, nick, fecha);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("usuario", usuario);
                    Navigation.findNavController(view).navigate(R.id.registroFragment02, bundle);
                }
            }
        });

        return view;
    }

    private boolean validarTextos() {
        if(!nombre.isEmpty() && !apellido.isEmpty() && !nick.isEmpty()){
            return true;
        }else {
            Toast.makeText(getContext(), "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}





















//
//
//
//
//
//
//package com.cabezasfive.truekapp.ui.registroUsuario;
//
//        import android.os.AsyncTask;
//        import android.os.Bundle;
//
//        import androidx.fragment.app.Fragment;
//        import androidx.lifecycle.Observer;
//        import androidx.lifecycle.ViewModelProvider;
//        import androidx.navigation.Navigation;
//
//        import android.util.Log;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.Toast;
//
//        import com.cabezasfive.truekapp.R;
//        import com.cabezasfive.truekapp.models.Usuario;
//        import com.google.firebase.auth.FirebaseUser;
//
//        import java.util.Date;
//
//
//public class RegistroFragment extends Fragment {
//
//    private EditText editTextnombre;
//    private EditText editTextapellido;
//    private EditText editTextdireccion;
//    private EditText editTexttelefono;
//    private EditText editTextnick;
//    private EditText editTextemail;
//    private EditText editTextpassword;
//    private Button btnRegistrar;
//
//    private RegistroViewModel registroViewModel;
//
//    // Variables de los datos que se van a registrar
//    private String nombre = "";
//    private String apellido = "";
//    private String direccion = "";
//    private String telefono = "";
//    private String email = "";
//    private String nick = "" ;
//    private String password = "";
//
//    Usuario user;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        user = new Usuario();
//
//        registroViewModel = new ViewModelProvider(this).get(RegistroViewModel.class);
//        registroViewModel.getUserMutableLiveData().observe(this, new Observer<FirebaseUser>() {
//            @Override
//            public void onChanged(FirebaseUser firebaseUser) {
//                if(firebaseUser != null){
//                    Toast.makeText(getContext(), "Usuario registrado", Toast.LENGTH_SHORT).show();
//                    Navigation.findNavController(getView()).navigate(R.id.homeFragment);
//                }
//            }
//        });
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view=  inflater.inflate(R.layout.fragment_registro01, container, false);
//
//        editTextnombre = view.findViewById(R.id.et_Registro_Nombre);
//        editTextapellido = view.findViewById(R.id.et_Registro_Apellido);
//        editTextdireccion = view.findViewById(R.id.et_Registro_Direccion);
//        editTexttelefono = view.findViewById(R.id.et_Registro_Telefono);
//        editTextnick = view.findViewById(R.id.et_Registro_NickName);
//        editTextemail = view.findViewById(R.id.et_Registro_Email);
//        editTextpassword = view.findViewById(R.id.et_Registro_Password);
//        btnRegistrar = view.findViewById(R.id.btn_RegistroUsuario);
//
//        btnRegistrar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                nombre = editTextnombre.getText().toString();
//                apellido = editTextapellido.getText().toString();
//                direccion = editTextdireccion.getText().toString();
//                telefono = editTexttelefono.getText().toString();
//                nick = editTextnick.getText().toString();
//                email = editTextemail.getText().toString();
//                password = editTextpassword.getText().toString();
//
//                if (validarTextos()){
//
//                    String fecha = new Date().toString();
//                    user = new Usuario(nombre, apellido, direccion, telefono, email, nick, fecha);
//
//                    TareaAsyncTask tareaAsyncTask = new TareaAsyncTask();
//                    tareaAsyncTask.execute();
//
//                }
//            }
//        });
//
//        return view;
//    }
//
//    private boolean validarTextos() {
//        if(!nombre.isEmpty() && !apellido.isEmpty() && !direccion.isEmpty() && !nombre.isEmpty()
//                && !email.isEmpty() && !password.isEmpty() && !nick.isEmpty()){
//            if (password.length() >= 6){
//                return true;
//            }else{
//                Toast.makeText(getContext(), "El password debe tener como minimo 6 caracteres", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        }else {
//            Toast.makeText(getContext(), "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//    }
//
//    private class TareaAsyncTask extends AsyncTask<Void, Integer, Boolean>{
//        @Override
//        protected void onPreExecute(){
//
//        }
//
//        @Override
//        protected Boolean doInBackground(Void... voids) {
//            Boolean resultado = registroViewModel.existNick(nick);
//            return resultado;
//        }
//
//        @Override
//        protected void onProgressUpdate(Integer... values){
//
//        }
//
//        @Override
//        protected void onPostExecute(Boolean exist){
//            if(exist){
//                Log.d("RESULTADO", "Existe el usuario");
//            }else {
//                Log.d("RESULTADO", "No existe se va a guardar");
//                registroViewModel.registrar(email, password, user);
//            }
//        }
//    }
//
//}