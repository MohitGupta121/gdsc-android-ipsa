package com.finite.gdscphcet


import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.finite.gdscphcet.databinding.ActivityCertificateBinding
import com.finite.gdscphcet.ui.CertificateViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CertificateActivity : AppCompatActivity() {

    private val viewModel : CertificateViewModel by viewModels()
    private lateinit var database : DatabaseReference
    lateinit var progress_bar:ProgressBar
    lateinit var p_bar_layout:RelativeLayout
    lateinit var et_code:TextInputEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityCertificateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.status_bar)

        progress_bar=findViewById(R.id.progress_Bar)
        p_bar_layout=findViewById(R.id.p_bar_layout)
        et_code=findViewById(R.id.codeEditText)

        binding?.apply {
            certificateVm = viewModel
            certificateActivity = this@CertificateActivity



        }

        et_code.setOnClickListener {
            binding.codeTextField.setError(null)
        }

        et_code.doAfterTextChanged {
            binding.codeTextField.setError(null)
            binding.certstatus.text = ""
        }

//fix #76 : Added poster image to firebase storage and linked them with realtime database
        binding.verifyButton.setOnClickListener{
            var text: String = binding.codeEditText.text.toString().trim()

            if (text.isEmpty()) {
                binding.codeTextField.setError("Error! Enter the Code!")
            }
            else {
                text = text.uppercase()

                closeKeyBoard()
                et_code.onEditorAction(EditorInfo.IME_ACTION_DONE)
                progress_bar.visibility=View.VISIBLE
                p_bar_layout.visibility=View.VISIBLE
                et_code.setFocusable(false)

                database = FirebaseDatabase.getInstance().getReference("certificates")
                database.child(text).get().addOnSuccessListener {


                    if (it.exists()) { // Real Certificate

                        var mydialog = DialogueboxFragment()
                        mydialog.show(supportFragmentManager, "customDialogue")
                        mydialog.setCancelable(true)



                        progress_bar.visibility=View.GONE
                        p_bar_layout.visibility=View.GONE
                        et_code.setFocusableInTouchMode(true)

                        binding.codeTextField.setError(null)
                        binding.certstatus.text = "Status : Verified Certificate"
                        binding.certissuedto.text = "Issued To :  " + it.child("issuedTo").value.toString()
                        binding.certissuedby.text = "Signed By :  " + it.child("issuedBy").value.toString()
                        binding.certissuedate.text ="Issued Date :  " +  it.child("issueDate").value.toString()
                        binding.certeventname.text ="Event Name :  " +  it.child("eventName").value.toString()
                        binding.certtype.text = "Certificate Type :  " + it.child("type").value.toString()

                        Toast.makeText(this, "Verification Successful!",Toast.LENGTH_SHORT).show()


                    } else {
                        // Fake Certificate
                        progress_bar.visibility=View.GONE
                        p_bar_layout.visibility=View.GONE
                        et_code.setFocusableInTouchMode(true)



                        binding.codeTextField.setError("Invalid Code")

                        Toast.makeText(this, "InvalidCode : $text",Toast.LENGTH_SHORT).show()

                        binding.certstatus.text = "Status : Invalid Certificate Code"
                        binding.certissuedto.text = ""
                        binding.certissuedby.text = ""
                        binding.certissuedate.text = ""
                        binding.certeventname.text = ""
                        binding.certtype.text = ""
                    }


                }.addOnFailureListener {

                    progress_bar.visibility=View.GONE
                    p_bar_layout.visibility=View.GONE
                    et_code.setFocusableInTouchMode(true)

                    Toast.makeText(this, "No Internet Connection!Please check your network connectivity.",Toast.LENGTH_LONG).show()

                }

            }

        }




    }



    private fun closeKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }







}
