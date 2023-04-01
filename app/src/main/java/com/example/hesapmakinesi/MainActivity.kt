package com.example.hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hesapmakinesi.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
        btn0.setOnClickListener { appendOnClick(true,"0") }
        btn1.setOnClickListener { appendOnClick(true,"1") }
        btn2.setOnClickListener { appendOnClick(true,"2") }
        btn3.setOnClickListener { appendOnClick(true,"3") }
        btn4.setOnClickListener { appendOnClick(true,"4") }
        btn5.setOnClickListener { appendOnClick(true,"5") }
        btn6.setOnClickListener { appendOnClick(true,"6") }
        btn7.setOnClickListener { appendOnClick(true,"7") }
        btn8.setOnClickListener { appendOnClick(true,"8") }
        btn9.setOnClickListener { appendOnClick(true,"9") }
        btn00.setOnClickListener { appendOnClick(true,"00") }
        btnNokta.setOnClickListener { appendOnClick(true,".") }
        btnToplama.setOnClickListener { appendOnClick(false,"+") }
        btnCikarma.setOnClickListener { appendOnClick(false,"-") }
        btnCarpma.setOnClickListener { appendOnClick(false,"*") }
        btnBolme.setOnClickListener { appendOnClick(false,"/") }
        btnSagPrn.setOnClickListener { appendOnClick(true,")") }
        btnSolPrn.setOnClickListener { appendOnClick(true,"(") }
        btnSifirla.setOnClickListener { clear() }
        btnEsittir.setOnClickListener { calculate() }
    }}

    var operator = false

    private fun appendOnClick (isNumber:Boolean,inputValue: String){

            binding.tvInput.append(inputValue)

        if (operator && !isNumber){
            binding.tvInput.setText(binding.tvOutput.text.toString())
            binding.tvInput.append(inputValue)}
        else if(operator && isNumber){
            binding.tvOutput.setText("")
            binding.tvInput.setText(inputValue)
            }
        operator=false
    }
    private fun clear(){
        binding.tvInput.setText("")
        binding.tvOutput.setText("")
    }
    private fun calculate(){
        try {
            val input=ExpressionBuilder(binding.tvInput.text.toString()).build()
            val output=input.evaluate()
            val longOutput=output.toLong()
            if (output==longOutput.toDouble()){
                binding.tvOutput.setText(longOutput.toString())
            }else {binding.tvOutput.setText(output.toString())}
            operator=true
        }catch (e:Exception){
            Toast.makeText(this,"Hatalı işlem",Toast.LENGTH_LONG).show()
        }
    }

}
