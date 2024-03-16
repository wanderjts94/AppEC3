package pe.edu.idat.appec3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Toast
import pe.edu.idat.appec3.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Listener para el botón de login
        binding.btnLogin.setOnClickListener {
            val nombreGrupo = binding.etNombre.text.toString()
            val contrasena = binding.etPassword.text.toString()

            // Verificación de credenciales
            if (nombreGrupo == "Lewis-Group" && contrasena == "SYS123") {
                redireccionamain()
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        // Listener para el botón del ojo
        binding.btnShowPassword.setOnClickListener {
            togglePasswordVisibility()
        }
    }

    // Función para redireccionar a la actividad principal
    private fun redireccionamain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    // Función para alternar la visibilidad de la contraseña
    private fun togglePasswordVisibility() {
        val isVisible = binding.etPassword.transformationMethod == null
        if (isVisible) {
            // Ocultar contraseña
            binding.etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.btnShowPassword.setImageResource(R.drawable.baseline_remove_red_eye_24)
        } else {
            // Mostrar contraseña
            binding.etPassword.transformationMethod = null
            binding.btnShowPassword.setImageResource(R.drawable.baseline_remove_red_eye_24)
        }
    }
}