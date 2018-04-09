package vinova.henry.com.phuongtrinhbac2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.sqrt

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var a: Double = 0.0
    var b: Double = 0.0
    var c: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_calcu.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if  (!edt_a.text.equals("") && !edt_b.text.equals("") && !edt_c.text.equals("")){
            try {
                a = edt_a.text.toString().toDouble()
                b = edt_b.text.toString().toDouble()
                c = edt_c.text.toString().toDouble()
                calCu(a, b, c)
            } catch (e: Exception){
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun calCu(a: Double, b: Double, c: Double){
        var delta = b * b - 4 * a * c
        var result: Double
        var result2: Double

        when (a){
            0.0 -> if(b != 0.0){
                result = -c / b
                tv_result.text = "Nghiệm: $result"
            } else{
                when (c){
                    0.0 -> tv_result.text = "Phương Trình Vô Số Nghiệm"

                    else -> tv_result.text = "Phương Trình Vô Nghiệm"
                }
            }

            else -> if  (delta < 0.0){
                tv_result.text = "Phương Trình Vô Nghiệm"
            }else if (delta == 0.0){
                result = -b / 2 / a
                tv_result.text = "Nghiệm: $result"
            } else{
                result = (-b + sqrt(delta)) / 2 / a
                result2 = (-b - sqrt(delta)) / 2 / a
                tv_result.text = "Nghiệm 1: $result \nNghiệm 2: $result2"
            }
        }

    }
}
