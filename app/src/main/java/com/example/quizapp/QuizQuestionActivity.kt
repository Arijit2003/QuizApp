package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import android.provider.Settings.System.getString
import android.telephony.mbms.StreamingServiceInfo
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.TypedArrayUtils.getString
import org.w3c.dom.Text

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    // creating reference variables of all views
    private var questionList:ArrayList<Question>?=null

    // mCurrentPosition=my current question position
    private var mCurrentPosition:Int=1
    private var selectedOption:Int=0
    private var score:Int=0

    private var question:TextView?=null
    private var flagImg:ImageView?=null
    private var progressBar:ProgressBar?=null
    private var tvProgress:TextView?=null
    private var optionOneTv:TextView?=null
    private var optionTwoTv:TextView?=null
    private var optionThreeTv:TextView?=null
    private var optionFourTv:TextView?=null
    private var button:Button?=null

    private var name:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)
        //assigning all the view
        question=findViewById(R.id.qs)
        flagImg=findViewById(R.id.flagImg)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.tvProgress)
        optionOneTv=findViewById(R.id.optionOne)
        optionTwoTv=findViewById(R.id.optionTwo)
        optionThreeTv=findViewById(R.id.optionThree)
        optionFourTv=findViewById(R.id.optionFour)
        button=findViewById(R.id.button)

        questionList = Constants.getQuestions()
        val newBundle:Bundle=intent.extras!!
        name=newBundle.getString("name")

        // Here we are loading or binding the data to all the views
        setContentOfAllViews()
        // Here we are setting the default text view(options) style
        defaultTextViewStyle()
        optionOneTv?.setOnClickListener(this)
        optionTwoTv?.setOnClickListener(this)
        optionThreeTv?.setOnClickListener(this)
        optionFourTv?.setOnClickListener(this)
        button?.setOnClickListener(this)
        





    }



    private fun setContentOfAllViews() {
        defaultTextViewStyle()
        val newQuestion: Question = questionList!![mCurrentPosition - 1]
        question?.text = newQuestion.question
        flagImg?.setImageResource(newQuestion.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "${mCurrentPosition}/${progressBar!!.max}"
        optionOneTv?.text = newQuestion.optionOne
        optionTwoTv?.text = newQuestion.optionTwo
        optionThreeTv?.text = newQuestion.optionThree
        optionFourTv?.text = newQuestion.optionFour
        if(mCurrentPosition==questionList!!.size){
            button?.text="FINISH"
        }
        else{
            button?.text= "SUBMIT"
        }
    }
    private fun defaultTextViewStyle() {
        var options:ArrayList<TextView> = arrayListOf()
        optionOneTv?.let {
            options.add(0,it)
        }
        optionTwoTv?.let {
            options.add(1,it)
        }
        optionThreeTv?.let {
            options.add(2,it)
        }
        optionFourTv?.let {
            options.add(3,it)
        }
        for( i in options){
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(this,R.drawable.default_text_view_background)
        }
    }

    private fun selectedOption(view:TextView?,selectOpt:Int){
        defaultTextViewStyle()
        selectedOption=selectOpt
        view?.setTextColor(Color.parseColor("#363A43"))
        view?.setTypeface(view.typeface,Typeface.BOLD)
        view?.background=ContextCompat.getDrawable(this,R.drawable.selected_text_view)


    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne->{
                selectedOption(optionOneTv,1)
            }
            R.id.optionTwo->{
                selectedOption(optionTwoTv,2)
            }
            R.id.optionThree->{
                selectedOption(optionThreeTv,3)
            }
            R.id.optionFour->{
                selectedOption(optionFourTv,4)
            }
            R.id.button->{
                if(selectedOption==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=questionList!!.size->{
                            setContentOfAllViews()
                        }
                        else->{
                            Toast.makeText(this,"This is your end of your quiz",Toast.LENGTH_SHORT).show()
                            val intent:Intent=Intent(this@QuizQuestionActivity,ResultScreen::class.java)
                            intent.putExtra("name",name).putExtra("score",score)
                            startActivity(intent)
                            finish()

                        }
                    }
                }
                else{
                    val newQuestion:Question=questionList!![mCurrentPosition-1]
                    if(newQuestion.correctAns!=selectedOption){
                        changingCorrectAndWrongAnswerView(selectedOption,R.drawable.wrong_answer_background)
                    }
                    else if(newQuestion.correctAns==selectedOption){
                        score++
                    }
                    changingCorrectAndWrongAnswerView(newQuestion.correctAns,R.drawable.correct_answer_background)

                    if(mCurrentPosition==questionList!!.size){
                        button?.text="FINISH"
                    }
                    else{
                        button?.text="GO TO NEXT QUESTION"
                    }
                    selectedOption=0
                }


            }
        }
    }
    private fun changingCorrectAndWrongAnswerView(mSelectedOption:Int,resource:Int){
        when(mSelectedOption){
            1->{
                optionOneTv?.background=ContextCompat.getDrawable(this@QuizQuestionActivity,resource)
            }
            2->{
                optionTwoTv?.background=ContextCompat.getDrawable(this@QuizQuestionActivity,resource)
            }
            3->{
                optionThreeTv?.background=ContextCompat.getDrawable(this@QuizQuestionActivity,resource)
            }
            4->{
                optionFourTv?.background=ContextCompat.getDrawable(this@QuizQuestionActivity,resource)
            }
        }

    }

}