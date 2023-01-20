package com.example.quizapp

object Constants {
    fun getQuestions():ArrayList<Question>{
        var questionList:ArrayList<Question> = arrayListOf()
        //1
        val qs1:Question= Question(
            1,"What country does this flag belong to?",R.drawable.ic_india,
            "Argentina","India","Brazil",
            "New Zealand",2)
        questionList.add(qs1)

        //2
        val qs2:Question= Question(
            3,"What country does this flag belong to?",R.drawable.australia,
            "Argentina","Austria","Brazil",
            "Australia",4)
        questionList.add(qs2)

        //3
        val qs3:Question= Question(
            4,"What country does this flag belong to?",R.drawable.brazil,
            "Argentina","India","Brazil",
            "New Zealand",3)
        questionList.add(qs3)

        //4
        val qs4:Question= Question(
            4,"What country does this flag belong to?",R.drawable.ic_austria,
            "Austria","India","Australia",
            "New Zealand",1)
        questionList.add(qs4)

        //5
        val qs5:Question= Question(
            5,"What country does this flag belong to?",R.drawable.colombia,
            "Argentina","India","Colombia",
            "New Zealand",3)
        questionList.add(qs5)

        //6
        val qs6:Question= Question(
            6,"What country does this flag belong to?",R.drawable.den_mark,
            "Argentina","Den Mark","Brazil",
            "New Zealand",2)
        questionList.add(qs6)

        //7
        val qs7:Question= Question(
            7,"What country does this flag belong to?",R.drawable.france,
            "Argentina","France","Brazil",
            "New Zealand",2)
        questionList.add(qs7)

        //8
        val qs8:Question= Question(
            8,"What country does this flag belong to?",R.drawable.russia,
            "Russia","India","Brazil",
            "New Zealand",1)
        questionList.add(qs8)

        //9
        val qs9:Question= Question(
            9,"What country does this flag belong to?",R.drawable.south_africa,
            "Argentina","South Africa","Brazil",
            "New Zealand",2)
        questionList.add(qs9)

        //10
        val qs10:Question= Question(
            10,"What country does this flag belong to?",R.drawable.argentina,
            "Russia","Argentina","Brazil",
            "New Zealand",2)
        questionList.add(qs10)
        return questionList
    }
}