package ir.ahe.abbas.divar.Regester

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ir.ahe.abbas.divar.R

class RegesterActivity : AppCompatActivity() {
    lateinit var etxtName: EditText
    lateinit var etxtPhone: EditText
    lateinit var etxtPass: EditText
    lateinit var chbLaws: CheckBox
    var regesterViewModel = RegesterViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regester)

        setUpViews()
    }

    fun setUpViews() {
        val btnSumbit: Button = findViewById(R.id.btn_regester_sumbit)
        etxtName = findViewById(R.id.etxt_RegesterActivity_name)
        etxtPhone = findViewById(R.id.etxt_RegesterActivity_phone)
        etxtPass = findViewById(R.id.etxt_RegesterActivity_password)
        chbLaws = findViewById(R.id.chb_RegesterActivity_laws)

        chbLaws.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: CompoundButton?, isChecked: Boolean) {

                if (isChecked){

                    btnSumbit.setEnabled(true);

                }else{

                    btnSumbit.setEnabled(false);

                }
            }

        })

        btnSumbit.setOnClickListener {
            regesterViewModel.regster(
                etxtPhone.text.toString(),
                etxtName.text.toString(),
                etxtPass.text.toString()
            )!!.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ v ->

                    if (v.message.equals("BS")){
                        Toast.makeText(this@RegesterActivity,"این شماره قبلا ثبت شده است!",Toast.LENGTH_SHORT).show()


                    }else if(v.message.equals("S")){
                        Toast.makeText(this@RegesterActivity,"ثبت نام با موفقیت انجام شد!",Toast.LENGTH_SHORT).show()
                        regesterViewModel.saveUser(etxtPhone.text.toString(),etxtName.text.toString(),this@RegesterActivity)
                        var i= Intent()
                        startActivity(i)

                    }else if (v.message.equals("F")){

                        Toast.makeText(this@RegesterActivity,"مشکل ارتباط با سرور!",Toast.LENGTH_SHORT).show()

                    }

                }, { e ->

                    Toast.makeText(this@RegesterActivity,"مشکل ارتباط با سرور!",Toast.LENGTH_SHORT).show()

                    Log.e("ACE", "setUpViews: $e " )


                })

        }
    }
}