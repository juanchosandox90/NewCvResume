package com.newcvresume.juansandoval.newcvresume.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.newcvresume.juansandoval.newcvresume.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mAuth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_email_sign_in.setOnClickListener(this)
        btn_email_create_account.setOnClickListener(this)

        mAuth = FirebaseAuth.getInstance()
    }

    override fun onClick(view: View?) {
        val i = view!!.id
        if (i == R.id.btn_email_create_account) {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        } else if (i == R.id.btn_email_sign_in) {
            signIn(edtEmail.text.toString(), edtPassword.text.toString())
        }
    }

    private fun signIn(email: String, password: String) {
        if (!validateForm(email, password)) {
            return
        }
        mAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(applicationContext, getString(R.string.success), Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, TabsActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(applicationContext, getString(R.string.failed), Toast.LENGTH_SHORT).show()
                    }

                    if (!task.isSuccessful) {
                        Toast.makeText(applicationContext, getString(R.string.failed), Toast.LENGTH_SHORT).show()
                    }

                }
    }

    private fun validateForm(email: String, password: String): Boolean {

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(applicationContext, getString(R.string.enter_email_address), Toast.LENGTH_SHORT).show()
            return false
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(applicationContext, getString(R.string.enter_password), Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.length < 6) {
            Toast.makeText(applicationContext, getString(R.string.password_short), Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
